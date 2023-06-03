package io.payment.ua.data.users.repository;

import io.payment.ua.data.users.repository.models.AbstractUserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AbstractUserModel, Long> {
    AbstractUserModel findAbstractUserModelByLogin(String login);
}
