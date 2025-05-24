package com.example.InternProject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

@RestController
@RequestMapping("/api/upload")
public class FileUploadController {

    private final String uploadDir = "src/main/resources/static/uploads/";

    @PostMapping
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            // Tạo folder nếu chưa tồn tại
            Files.createDirectories(Paths.get(uploadDir));

            // Lấy tên file
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());

            // Tạo path lưu file
            Path filePath = Paths.get(uploadDir + fileName);

            // Lưu file
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            // Trả về đường dẫn có thể truy cập từ trình duyệt
            String fileUrl = "/uploads/" + fileName;

            return ResponseEntity.ok(fileUrl);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Upload thất bại: " + e.getMessage());
        }
    }
}
