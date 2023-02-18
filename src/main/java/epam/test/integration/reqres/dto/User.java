package epam.test.integration.reqres.dto;

import lombok.Data;

@Data
public class User {

    private Long id;

    private String email;

    private String firstName;

    private String lastName;

    private String avatar;
}
