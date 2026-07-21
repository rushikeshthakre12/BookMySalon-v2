package com.bookmysalon.backend.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AppointmentRequest {
    private Long salonId;
    private LocalDateTime bookingTime;
}