package epam.test.service;

import epam.test.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> getUser(String email);

    User getFirstUser();
}
