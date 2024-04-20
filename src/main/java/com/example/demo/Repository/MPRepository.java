package com.example.demo.Repository;

import com.example.demo.entities.MP;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MPRepository extends JpaRepository<MP,Long> {
    List<MP> findAllByName(String name);
    List<MP> findAllByNameContainingIgnoreCase(String name);
}
