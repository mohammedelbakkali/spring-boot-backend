package com.example.demo.Repository;

import com.example.demo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findAllByName(String name);
    List<Product> findAllByCode(Integer code);
    List<Product> findAllByUserId(Long id);

}
