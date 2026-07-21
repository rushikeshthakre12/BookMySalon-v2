package com.bookmysalon.backend.controller;

import com.bookmysalon.backend.entity.Salon;
import com.bookmysalon.backend.service.SalonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/salons")
@RequiredArgsConstructor
public class SalonController {

    private final SalonService salonService;

    @PostMapping
    public ResponseEntity<Salon> createSalon(@RequestBody Salon salon) {
        return ResponseEntity.ok(salonService.saveSalon(salon));
    }

    @GetMapping
    public ResponseEntity<List<Salon>> getAllSalons() {
        return ResponseEntity.ok(salonService.getAllSalons());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Salon> updateSalon(@PathVariable Long id, @RequestBody Salon salon) {
        return ResponseEntity.ok(salonService.updateSalon(id, salon));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSalon(@PathVariable Long id) {
        salonService.deleteSalon(id);
        return ResponseEntity.ok("Salon deleted successfully!");
    }
}