package epam.test.service.impl;

import epam.test.model.Order;
import epam.test.service.OrderService;
import epam.test.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final UserService userService;

    @Override
    public Order createOrder(String email, Long productId) {
        return null;
    }


}
