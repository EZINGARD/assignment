package epam.test.service.impl;

import epam.test.integration.reqres.ReqResUserClient;
import epam.test.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceReqResImpl implements UserService {

    @Override
    public boolean userExists(String email) {

        return ReqResUserClient.getUsers().getData().stream().anyMatch(user -> user.getEmail().equalsIgnoreCase(email));
    }
}
