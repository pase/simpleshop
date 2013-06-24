package ch.eshop.dao;

import org.springframework.data.repository.CrudRepository;

import ch.eshop.domain.Order;

public interface OrderRepository extends CrudRepository<Order, Long>{

}
