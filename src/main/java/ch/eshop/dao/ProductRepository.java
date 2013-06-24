package ch.eshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.eshop.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
