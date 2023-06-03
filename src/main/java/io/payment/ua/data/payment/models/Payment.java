package io.payment.ua.data.payment.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.payment.ua.data.payment.attributes.TaxType;
import io.payment.ua.data.users.repository.models.AbstractUserModel;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "payments")
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", name = "user_id")
    @JsonIgnore
    private AbstractUserModel user;
    @Column(name = "tax_type")
    @Enumerated(EnumType.STRING)
    private TaxType taxType;
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "issued_at")
    private Timestamp issuedAt = Timestamp.from(Instant.now());
}

