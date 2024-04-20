package com.example.demo.services.impl;

import com.example.demo.Repository.PhaseRepository;
import com.example.demo.dto.PhaseDto;
import com.example.demo.entities.Phase;
import com.example.demo.services.PhaseService;
import org.springframework.context.Phased;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhaseServiceImpl implements PhaseService {

    private PhaseRepository phaseRepository;

    public PhaseServiceImpl(PhaseRepository phaseRepository) {
        this.phaseRepository = phaseRepository;
    }

    @Override
    public Long save(PhaseDto dto) {
        Phase phase = PhaseDto.toEntity(dto);
        return this.phaseRepository.save(phase).getId();
    }

    @Override
    public List<PhaseDto> findAll() {
        return this.phaseRepository
                .findAll()
                .stream()
                .map(u->PhaseDto.toDto(u))
                .collect(Collectors.toList());
    }

    @Override
    public PhaseDto findById(Long id) {

        return this.phaseRepository.findById(id).map(ph->PhaseDto.toDto(ph)).orElseThrow(()->new RuntimeException());

    }

    @Override
    public void delete(Long id) {
        this.phaseRepository.deleteById(id);
    }
}
