package epam.test.service.impl;

import epam.test.exception.OrderExistsException;
import epam.test.exception.ProductNotFoundException;
import epam.test.exception.UserNotFoundException;
import epam.test.model.Order;
import epam.test.model.User;
import epam.test.repository.OrderRepository;
import epam.test.repository.ProductRepository;
import epam.test.service.OrderService;
import epam.test.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final UserService userService;

    private final OrderRepository orderRepository;

    // Not the best practice. Should be Service instead
    private final ProductRepository productRepository;

    @Override
    public Order createOrder(String email, Long productId) {

        User user = userService.getUser(email).orElseThrow(UserNotFoundException::new);

        if(orderRepository.getByEmailAndAndProductId(user.getEmail(), productId) != null) {
            throw new OrderExistsException();
        }

        if(!productRepository.existsById(productId)) {
            throw new ProductNotFoundException();
        }

        Order order = new Order();

        order.setEmail(user.getEmail());
        order.setFirstName(user.getFirstName());
        order.setLastName(user.getLastName());
        order.setProductId(productId);

        return orderRepository.save(order);
    }

    @Override
    public Iterable<Order> getOrders() {
        return orderRepository.findAll();
    }
}
