package com.enviro.assessment.grad001.KagisoMolefe.service;


import com.enviro.assessment.grad001.KagisoMolefe.dto.WasteCategoryDTO;
import com.enviro.assessment.grad001.KagisoMolefe.entity.WasteCategory;
import com.enviro.assessment.grad001.KagisoMolefe.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WasteCategoryService {
 @Autowired
 private WasteCategoryRepository repository;

 public List<WasteCategoryDTO> getAllCategories() {
     return repository.findAll().stream()
         .map(this::convertToDTO)
         .collect(Collectors.toList());
 }

 public WasteCategoryDTO getCategoryById(Long id) {
     return repository.findById(id)
         .map(this::convertToDTO)
         .orElse(null);
 }

 public WasteCategoryDTO saveCategory(WasteCategoryDTO dto) {
     WasteCategory category = new WasteCategory();
     category.setName(dto.getName());
     category.setDescription(dto.getDescription());
     category = repository.save(category);
     return convertToDTO(category);
 }

 public void deleteCategory(Long id) {
     repository.deleteById(id);
 }

 private WasteCategoryDTO convertToDTO(WasteCategory category) {
     WasteCategoryDTO dto = new WasteCategoryDTO();
     dto.setId(category.getId());
     dto.setName(category.getName());
     dto.setDescription(category.getDescription());
     return dto;
 }
}
