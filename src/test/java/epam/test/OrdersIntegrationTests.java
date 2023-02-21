package epam.test;

import epam.test.exception.ProductNotFoundException;
import epam.test.exception.UserNotFoundException;
import epam.test.model.User;
import epam.test.service.OrderService;
import epam.test.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = TestApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-integrationtests.properties")
public class OrdersIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Before
    public void clearOrders() {
        orderService.clearOrders();
    }

    @Test
    public void getProducts_200() throws Exception {
        mockMvc.perform(get("/order/products")
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id", is(1)));
    }

    @Test
    public void createOrderUserNotFound_400() throws Exception {
        mockMvc.perform(post("/order/")
                        .param("email","invalid")
                        .param("productID", "1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof UserNotFoundException));
    }

    @Test
    public void createOrderProductNotFound_400() throws Exception {

        String exisingEmail = userService.getFirstUser().getEmail();

        mockMvc.perform(post("/order/")
                        .param("email",exisingEmail)
                        .param("productID", "0")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof ProductNotFoundException));
    }

    @Test
    public void createOrder_200() throws Exception {

        User user = userService.getFirstUser();

        Integer productId = 1;

        mockMvc.perform(post("/order/")
                        .param("email", user.getEmail())
                        .param("productID", productId.toString())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.orderID", is(1)))
                .andExpect(jsonPath("$.first_name", is(user.getFirstName())))
                .andExpect(jsonPath("$.last_name", is(user.getLastName())))
                .andExpect(jsonPath("$.productID", is(productId)))
                .andExpect(jsonPath("$.email", is(user.getEmail())));
    }

    @Test
    public void getOrders_200() throws Exception {

        User user = userService.getFirstUser();

        orderService.createOrder(user.getEmail(), 1L);
        orderService.createOrder(user.getEmail(), 2L);

        mockMvc.perform(get("/order/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)));
    }
}
