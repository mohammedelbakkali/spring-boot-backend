package com.example.demo.services.impl;

import com.example.demo.Repository.MPRepository;
import com.example.demo.dto.MPDto;
import com.example.demo.entities.MP;
import com.example.demo.services.MPService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class MPServiceImpl implements MPService {
    private MPRepository mpRepository;

    public MPServiceImpl(MPRepository mpRepository) {
        this.mpRepository = mpRepository;
    }

    @Override
    public Long save(MPDto dto) {
        MP mp = MPDto.toEntity(dto);
        return this.mpRepository.save(mp).getId();
    }

    @Override
    public List<MPDto> findAll() {
        return this.mpRepository
                .findAll().stream()
                .map(mp -> MPDto.toDto(mp))
                .collect(Collectors.toList());
    }

    @Override
    public MPDto findById(Long id) {
        return this.mpRepository.findById(id).map(mp -> MPDto.toDto(mp)).orElseThrow(()-> new EntityNotFoundException());
    }

    @Override
    public void delete(Long id) {
      // todo handler contrainte
        this.mpRepository.deleteById(id);
    }
}
