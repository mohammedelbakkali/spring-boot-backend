package com.example.demo.services;

import com.example.demo.dto.ProductDto;
import com.example.demo.entities.Product;

import java.util.List;

public interface ProductService extends AbstractService<ProductDto>{
    List<ProductDto> findAllByUserId(Long id);
    List<ProductDto> findAllByName(String name);
    List<ProductDto> findAllByCode(Integer code);
}
