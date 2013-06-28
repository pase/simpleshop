package ch.pase.eshop.server.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.pase.eshop.domain.Product;
/**
 * Repository to access {@link Product}s.
 */
public interface ProductRepository extends JpaRepository<Product, Long>{
}

