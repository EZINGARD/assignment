package epam.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class OrderExistsException extends RuntimeException {

    public OrderExistsException(String email, Long productId) {
        super(String.format("Order exists for email=%s and ProductID=%s", email, productId));
    }
}
