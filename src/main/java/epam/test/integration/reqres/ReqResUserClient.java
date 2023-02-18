package epam.test.integration.reqres;

import epam.test.integration.reqres.dto.PageableResponse;
import epam.test.integration.reqres.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "reqres", url = "https://reqres.in/api")
public interface ReqResUserClient {

    @GetMapping("/users")
    PageableResponse<User> getUsers();
}
