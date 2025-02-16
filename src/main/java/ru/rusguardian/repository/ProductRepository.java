package ru.rusguardian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rusguardian.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
