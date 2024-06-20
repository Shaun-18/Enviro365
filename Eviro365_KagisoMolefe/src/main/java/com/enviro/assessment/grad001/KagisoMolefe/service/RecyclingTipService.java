package com.enviro.assessment.grad001.KagisoMolefe.service;


import com.enviro.assessment.grad001.KagisoMolefe.dto.RecyclingTipDTO;
import com.enviro.assessment.grad001.KagisoMolefe.entity.RecyclingTip;
import com.enviro.assessment.grad001.KagisoMolefe.repository.RecyclingTipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecyclingTipService {

    @Autowired
    private RecyclingTipRepository repository;

    public List<RecyclingTipDTO> getAllTips() {
        return repository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public RecyclingTipDTO getTipById(Long id) {
        return repository.findById(id).map(this::convertToDTO).orElse(null);
    }

    public RecyclingTipDTO saveTip(RecyclingTipDTO dto) {
        RecyclingTip tip = convertToEntity(dto);
        RecyclingTip savedTip = repository.save(tip);
        return convertToDTO(savedTip);
    }

    public void deleteTip(Long id) {
        repository.deleteById(id);
    }

    private RecyclingTipDTO convertToDTO(RecyclingTip tip) {
        RecyclingTipDTO dto = new RecyclingTipDTO();
        dto.setId(tip.getId());
        dto.setTipText(tip.getTipText());
        return dto;
    }

    private RecyclingTip convertToEntity(RecyclingTipDTO dto) {
        RecyclingTip tip = new RecyclingTip();
        tip.setId(dto.getId());
        tip.setTipText(dto.getTipText());
        return tip;
    }
}
