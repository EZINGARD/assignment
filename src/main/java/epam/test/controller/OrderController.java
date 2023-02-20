package epam.test.controller;

import epam.test.model.Order;
import epam.test.model.Product;
import epam.test.service.OrderService;
import epam.test.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    //Not the best practice. Better be in a separate controller/MS. Added just for convenience.
    private final ProductService productService;

    @GetMapping("/")
    public ResponseEntity<Iterable<Order>> getOrders() {
        return ResponseEntity.ok(orderService.getOrders());
    }

    @GetMapping("/products")
    public ResponseEntity<Iterable<Product>> getProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping ("/")
    public ResponseEntity<Order> createOrder(@RequestParam(name = "email") String email, @RequestParam(name = "productID") Long productId) {
        return ResponseEntity.ok(orderService.createOrder(email, productId));
    }
}
