package io.payment.ua.data.schedule.models;

import io.payment.ua.data.payment.attributes.TaxType;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "schedule")
@Entity
@Data
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date")
    private Date date;
    @Column(name = "tax_type")
    @Enumerated(EnumType.STRING)
    private TaxType taxType;
    @Column(name = "amount")
    private BigDecimal amount;
}
