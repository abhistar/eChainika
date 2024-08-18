package com.echainika.app.controller;

import com.echainika.app.model.entity.CandidateEntity;
import com.echainika.app.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidate")
@RequiredArgsConstructor
public class CandidateController {
    private final CandidateService candidateService;

    @PostMapping("/create")
    public ResponseEntity<String> createCandidate(@RequestBody CandidateEntity candidate) {
        try {
            return new ResponseEntity<>(candidateService.createCandidateEntity(candidate), HttpStatus.OK);
        }
        catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CandidateEntity> getCandidate(@PathVariable Long id) {
        return new ResponseEntity<>(candidateService.getCandidateEntityById(id), HttpStatus.OK);
    }

    @PatchMapping("/update")
    public ResponseEntity<String> updateCandidate(@RequestBody CandidateEntity candidate) {
        return new ResponseEntity<>(candidateService.updateCandidateEntity(candidate), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCandidate(@PathVariable Long id) {
        return new ResponseEntity<>(candidateService.deleteCandidateEntity(id), HttpStatus.OK);
    }
}
