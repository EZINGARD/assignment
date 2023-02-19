package epam.test;

import epam.test.integration.reqres.ReqResUserClient;
import epam.test.integration.reqres.dto.PageableResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

@SpringBootTest
class TestApplicationTests {

    @Test
    void contextLoads(ApplicationContext context) {
        assertThat(context).isNotNull();
    }

    @Test
    void testReqResUserClient() {
        assertInstanceOf(PageableResponse.class, ReqResUserClient.getUsers());
    }
}
