package com.bookmysalon.backend.controller;

import com.bookmysalon.backend.dto.AppointmentRequest;
import com.bookmysalon.backend.entity.Appointment;
import com.bookmysalon.backend.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<Appointment> bookAppointment(
            @RequestBody AppointmentRequest request,
            Principal principal
    ) {
        // SECURITY MAGIC: principal.getName() grabs the email securely hidden inside the JWT token!
        // The user can't fake who they are.
        String userEmail = principal.getName();

        return ResponseEntity.ok(appointmentService.bookAppointment(userEmail, request));
    }
}