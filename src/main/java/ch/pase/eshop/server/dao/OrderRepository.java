package ch.pase.eshop.server.dao;

import org.springframework.data.repository.CrudRepository;

import ch.pase.eshop.domain.Order;

public interface OrderRepository extends CrudRepository<Order, Long>{

}
