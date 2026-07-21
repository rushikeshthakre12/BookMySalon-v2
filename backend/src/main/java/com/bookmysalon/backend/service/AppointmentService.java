package com.bookmysalon.backend.service;

import com.bookmysalon.backend.dto.AppointmentRequest;
import com.bookmysalon.backend.entity.Appointment;
import com.bookmysalon.backend.entity.Salon;
import com.bookmysalon.backend.entity.User;
import com.bookmysalon.backend.repository.AppointmentRepository;
import com.bookmysalon.backend.repository.SalonRepository;
import com.bookmysalon.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final SalonRepository salonRepository;
    private final UserRepository userRepository;

    public Appointment bookAppointment(String userEmail, AppointmentRequest request) {
        // 1. Find the user securely using the email from their JWT token
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found!"));

        // 2. Find the salon they want to visit
        Salon salon = salonRepository.findById(request.getSalonId())
                .orElseThrow(() -> new RuntimeException("Salon not found!"));

        // 3. Create the appointment linking both together
        Appointment appointment = Appointment.builder()
                .user(user)
                .salon(salon)
                .bookingDateTime(request.getBookingTime())
                .status("CONFIRMED")
                .build();

        // 4. Save to Supabase
        return appointmentRepository.save(appointment);
    }
}