package epam.test.controller;

import epam.test.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/")
    public ResponseEntity<String> getOrders() {
        return ResponseEntity.ok("Hello World");
    }

    @PostMapping ("/")
    public ResponseEntity<String> createOrder() {
        return ResponseEntity.ok("Hello World");
    }
}
