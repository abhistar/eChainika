package com.echainika.app.controller;

import com.echainika.app.model.dto.request.CandidateRequest;
import com.echainika.app.model.dto.response.BulkUploadResponse;
import com.echainika.app.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return new ResponseEntity<>("Welcome to Admin!", HttpStatus.OK);
    }

    @PostMapping("/bulkUpload")
    public ResponseEntity<BulkUploadResponse> bulkUploadData(@RequestParam MultipartFile file) {
        try {
            return new ResponseEntity<>(adminService.bulkUploadData(file), HttpStatus.OK);
        }
        catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/editCandidate")
    public ResponseEntity<String> editCandidate(@RequestBody CandidateRequest request) {
        return new ResponseEntity<>(adminService.editCandidate(request), HttpStatus.OK);
    }

    @DeleteMapping("/bulkDelete")
    public ResponseEntity<String> bulkDelete() {
        return new ResponseEntity<>(adminService.bulkDelete(), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAllCandidates(@RequestParam(defaultValue = "10") Integer entries, @RequestParam(defaultValue = "1") Integer page) {
        return new ResponseEntity<>(adminService.getAllCandidates(entries, page), HttpStatus.OK);
    }

   @GetMapping("/bulkDownload")
   public ResponseEntity<Object> bulkDownloadData() {
        return new ResponseEntity<>(adminService.bulkDownloadData(), HttpStatus.OK);
   }
}
