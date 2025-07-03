package com.smart.ourSite.controller;

import com.smart.ourSite.dto.response.MassageResponseDTO;
import com.smart.ourSite.service.MassageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/messages")
@RequiredArgsConstructor
public class MassageController {

    private final MassageService massageService;

    @GetMapping
    public ResponseEntity<List<MassageResponseDTO>> getAllMessages() {
        return ResponseEntity.ok(massageService.getAllMassages());
    }

    @GetMapping("/search")
    public ResponseEntity<List<MassageResponseDTO>> searchMessages(@RequestParam String name) {
        return ResponseEntity.ok(massageService.searchMessagesByName(name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMessage(@PathVariable Long id) {
        massageService.deleteMassage(id);
        return ResponseEntity.ok("Message deleted successfully.");
    }
}
