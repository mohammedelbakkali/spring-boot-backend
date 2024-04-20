package com.example.demo.services.impl;

import com.example.demo.Repository.ProductRepository;
import com.example.demo.dto.ProductDto;
import com.example.demo.entities.Product;
import com.example.demo.services.ProductService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Long save(ProductDto dto) {
        Product product = ProductDto.toEntity(dto);
        return this.productRepository.save(product).getId();
    }

    @Override
    public List<ProductDto> findAll() {
        return this.productRepository
                .findAll()
                .stream()
                .map(p->ProductDto.toDto(p))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto findById(Long id) {
        return this.productRepository.findById(id).map(p->ProductDto.toDto(p)).orElseThrow(()->new EntityNotFoundException());
    }

    @Override
    public void delete(Long id) {
       this.productRepository.deleteById(id);
    }

    @Override
    public List<ProductDto> findAllByUserId(Long id) {
        return this.productRepository
                .findAllByUserId(id)
                .stream()
                .map(ProductDto::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> findAllByName(String name) {
      return     this.productRepository
                .findAllByName(name)
                .stream()
                .map(ProductDto::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> findAllByCode(Integer code) {
      return      this.productRepository
                .findAllByCode(code)
                .stream()
                .map(ProductDto::toDto)
                .collect(Collectors.toList());
    }
}
