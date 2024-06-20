package com.enviro.assessment.grad001.KagisoMolefe.service;



import com.enviro.assessment.grad001.KagisoMolefe.dto.DisposalGuidelineDTO;
import com.enviro.assessment.grad001.KagisoMolefe.model.DisposalGuideline;
import com.enviro.assessment.grad001.KagisoMolefe.repository.DisposalGuidelineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DisposalGuidelineService {

    @Autowired
    private DisposalGuidelineRepository repository;

    public List<DisposalGuidelineDTO> getAllGuidelines() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private DisposalGuidelineDTO convertToDTO(DisposalGuideline guideline) {
        DisposalGuidelineDTO dto = new DisposalGuidelineDTO();
        dto.setId(guideline.getId());
        dto.setGuideline(guideline.getGuideline());
        return dto;
    }
}
