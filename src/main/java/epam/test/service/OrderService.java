package epam.test.service;

import epam.test.model.Order;

public interface OrderService {

    Order createOrder(String email, Long productId);

    void clearOrders();

    Iterable<Order> getOrders();
}
