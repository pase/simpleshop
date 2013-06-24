package ch.pase.eshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.pase.eshop.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
