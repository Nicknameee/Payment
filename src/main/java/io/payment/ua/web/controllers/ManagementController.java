package io.payment.ua.web.controllers;

import io.payment.ua.data.payment.models.Payment;
import io.payment.ua.data.payment.service.PaymentService;
import io.payment.ua.data.schedule.models.Schedule;
import io.payment.ua.data.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ManagementController {
    private final ScheduleService scheduleService;
    private final PaymentService paymentService;

    @GetMapping("/schedule")
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public ResponseEntity<?> getSchedule() {
        return ResponseEntity.ok(scheduleService.getSchedules());
    }

    @PostMapping("/schedule")
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public ResponseEntity<?> addSchedule(@RequestBody Schedule schedule) {
        return ResponseEntity.ok(scheduleService.saveSchedule(schedule));
    }

    @GetMapping("/payments")
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public ResponseEntity<?> getAllPayments() {
        return ResponseEntity.ok(paymentService.getAllPayments());
    }

    @GetMapping("/payments/user")
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public ResponseEntity<?> getAllUserPayments() {
        return ResponseEntity.ok(paymentService.getUserPayments());
    }

    @PostMapping("/payments/user")
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public ResponseEntity<?> addPayment(@RequestBody Payment payment) {
        return ResponseEntity.ok(paymentService.addPayment(payment));
    }
}
