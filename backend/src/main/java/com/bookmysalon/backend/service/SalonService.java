package com.bookmysalon.backend.service;

import com.bookmysalon.backend.entity.Salon;
import com.bookmysalon.backend.repository.SalonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalonService {

    private final SalonRepository salonRepository;

    // 1. CREATE - Save a new salon
    public Salon saveSalon(Salon salon) {
        return salonRepository.save(salon);
    }

    // 2. READ - Get all salons
    public List<Salon> getAllSalons() {
        return salonRepository.findAll();
    }

    // 3. UPDATE - Edit an existing salon
    public Salon updateSalon(Long id, Salon updatedSalonData) {
        Salon existingSalon = salonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Salon not found with id: " + id));

        existingSalon.setName(updatedSalonData.getName());
        existingSalon.setAddress(updatedSalonData.getAddress());
        existingSalon.setOwnerName(updatedSalonData.getOwnerName());
        existingSalon.setPhoneNumber(updatedSalonData.getPhoneNumber());

        return salonRepository.save(existingSalon);
    }

    // 4. DELETE - Remove a salon
    public void deleteSalon(Long id) {
        salonRepository.deleteById(id);
    }
}