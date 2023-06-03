package io.payment.ua.data.payment.service;

import io.payment.ua.data.payment.models.Payment;
import io.payment.ua.data.payment.repository.PaymentRepository;
import io.payment.ua.data.users.repository.models.AbstractUserModel;
import io.payment.ua.data.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll(Pageable.ofSize(100)).getContent();
    }

    public List<Payment> getUserPayments() {
        Long userId = UserService.getIdOfCurrentlyAuthenticatedUser();
        return paymentRepository.findAllByUserId(userId, Pageable.ofSize(100));
    }

    public Payment addPayment(Payment payment) {
        AbstractUserModel abstractUserModel = UserService.getCurrentlyAuthenticatedUser();
        payment.setUser(abstractUserModel);
        return paymentRepository.save(payment);
    }
}
