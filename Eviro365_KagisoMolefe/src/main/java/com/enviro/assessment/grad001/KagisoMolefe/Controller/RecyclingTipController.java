package com.enviro.assessment.grad001.KagisoMolefe.Controller;



import com.enviro.assessment.grad001.KagisoMolefe.dto.RecyclingTipDTO;
import com.enviro.assessment.grad001.KagisoMolefe.service.RecyclingTipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/recycling-tips")
public class RecyclingTipController {

    @Autowired
    private RecyclingTipService service;

    @GetMapping
    public List<RecyclingTipDTO> getAllTips() {
        return service.getAllTips();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecyclingTipDTO> getTipById(@PathVariable Long id) {
        RecyclingTipDTO tip = service.getTipById(id);
        if (tip == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tip, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RecyclingTipDTO> createTip(@Valid @RequestBody RecyclingTipDTO dto) {
        RecyclingTipDTO createdTip = service.saveTip(dto);
        return new ResponseEntity<>(createdTip, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTip(@PathVariable Long id) {
        service.deleteTip(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
