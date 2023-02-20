package epam.test.service.impl;

import epam.test.integration.reqres.ReqResUserClient;
import epam.test.model.User;
import epam.test.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceReqResImpl implements UserService {

    @Override
    public Optional<User> getUser(String email) {

        epam.test.integration.reqres.dto.User dto = ReqResUserClient.getUsers().getData().stream().filter(user -> user.getEmail().equalsIgnoreCase(email)).findFirst().orElse(null);

        if(dto == null) {
            return Optional.empty();
        }

        return Optional.of(User.builder()
                .email(dto.getEmail())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName()).build());
    }
}
