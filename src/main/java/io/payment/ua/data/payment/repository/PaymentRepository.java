package io.payment.ua.data.payment.repository;

import io.payment.ua.data.payment.models.Payment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findAllByUserId(Long userId, Pageable pageable);
}
