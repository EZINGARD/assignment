package epam.test.service.impl;

import epam.test.model.Product;
import epam.test.repository.ProductRepository;
import epam.test.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ProductsServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public boolean productExists(Long id) {
        return productRepository.existsById(id);
    }
}
