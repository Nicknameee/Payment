package io.payment.ua.data.users.repository;

import io.payment.ua.data.users.repository.models.AbstractUserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryExtended {
    private final UserRepository userRepository;
    private final JdbcTemplate jdbcTemplate;

    public AbstractUserModel findAbstractUserModelByLogin(String login) {
        return userRepository.findAbstractUserModelByLogin(login);
    }

    public AbstractUserModel saveAbstractUserModel(AbstractUserModel abstractUserModel) {
        return userRepository.save(abstractUserModel);
    }
}
