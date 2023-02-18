package epam.test.service.impl;

import epam.test.integration.reqres.ReqResUserClient;
import epam.test.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceReqResImpl implements UserService {

    private final ReqResUserClient userClient;

    @Override
    public boolean userExists(String email) {

        return userClient.getUsers().getData().stream().anyMatch(user -> user.getEmail().equalsIgnoreCase(email));
    }
}
