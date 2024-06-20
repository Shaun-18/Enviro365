package com.enviro.assessment.grad001.KagisoMolefe.Controller;



import com.enviro.assessment.grad001.KagisoMolefe.dto.DisposalGuidelineDTO;
import com.enviro.assessment.grad001.KagisoMolefe.service.DisposalGuidelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/disposal-guidelines")
public class DisposalGuidelineController {

    @Autowired
    private DisposalGuidelineService service;

    @GetMapping
    public List<DisposalGuidelineDTO> getAllGuidelines() {
        return service.getAllGuidelines();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisposalGuidelineDTO> getGuidelineById(@PathVariable Long id) {
        DisposalGuidelineDTO guideline = service.getGuidelineById(id);
        if (guideline == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(guideline, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DisposalGuidelineDTO> createGuideline(@Valid @RequestBody DisposalGuidelineDTO dto) {
        DisposalGuidelineDTO createdGuideline = service.saveGuideline(dto);
        return new ResponseEntity<>(createdGuideline, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuideline(@PathVariable Long id) {
        service.deleteGuideline(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
