package epam.test.integration.reqres;

import epam.test.integration.reqres.dto.PageableResponse;
import org.springframework.web.client.RestTemplate;

public class ReqResUserClient {

    private static final String BASE_URL = "https://reqres.in/api";

    private static final String USERS_PATH = "users";

    private ReqResUserClient() {
    }

    public static PageableResponse getUsers() {

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(String.format("%s/%s", BASE_URL, USERS_PATH), PageableResponse.class);
    }
}
