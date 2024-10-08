package com.echainika.app.controller;

import com.echainika.app.model.dto.CandidateData;
import com.echainika.app.model.dto.response.AllCandidatesResponse;
import com.echainika.app.model.dto.response.BulkUploadResponse;
import com.echainika.app.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return new ResponseEntity<>("Welcome to Admin!", HttpStatus.OK);
    }

    @PostMapping(value = "/bulk", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<BulkUploadResponse> bulkUploadData(@RequestParam("file") MultipartFile file) {
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

    @DeleteMapping("/bulk")
    public ResponseEntity<String> bulkDelete() {
        return new ResponseEntity<>(adminService.bulkDelete(), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<AllCandidatesResponse> getAllCandidates(@RequestParam(defaultValue = "10") Integer entries, @RequestParam(defaultValue = "0") Integer page) {
        return new ResponseEntity<>(adminService.getAllCandidates(entries, page), HttpStatus.OK);
    }

   @GetMapping("/bulk")
   public ResponseEntity<byte[]> bulkDownloadData() {
        return new ResponseEntity<>(adminService.bulkDownloadData(), HttpStatus.OK);
   }
}
