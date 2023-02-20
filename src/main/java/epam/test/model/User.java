package epam.test.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private String email;

    private String firstName;

    private String lastName;
}
