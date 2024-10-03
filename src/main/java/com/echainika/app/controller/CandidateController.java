package com.echainika.app.controller;

import com.echainika.app.model.dto.CandidateData;
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

    @PostMapping("/")
    public ResponseEntity<String> createCandidate(@RequestBody CandidateData candidate) {
        try {
            return new ResponseEntity<>(candidateService.createCandidate(candidate), HttpStatus.OK);
        }
        catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CandidateEntity> getCandidate(@PathVariable Long id) {
        return new ResponseEntity<>(candidateService.getCandidateById(id), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateCandidate(@RequestBody CandidateData candidate) {
        return new ResponseEntity<>(candidateService.updateCandidate(candidate), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCandidate(@PathVariable Long id) {
        return new ResponseEntity<>(candidateService.deleteCandidate(id), HttpStatus.OK);
    }
}
