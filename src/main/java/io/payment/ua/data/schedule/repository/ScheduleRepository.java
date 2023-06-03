package io.payment.ua.data.schedule.repository;

import io.payment.ua.data.schedule.models.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
