package epam.test.repository;

import epam.test.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    Order getByEmailAndAndProductId(String email, Long productId);
}
