package io.payment.ua.data.users.service;

import io.payment.ua.data.users.repository.models.AbstractUserModel;
import io.payment.ua.data.users.repository.UserRepositoryExtended;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepositoryExtended userRepository;

    public static AbstractUserModel getCurrentlyAuthenticatedUser() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        if (securityContext != null) {
            Authentication authentication = securityContext.getAuthentication();
            if (authentication != null) {
                return (AbstractUserModel) authentication.getPrincipal();
            }
        }
        return null;
    }

    public static Long getIdOfCurrentlyAuthenticatedUser() {
        AbstractUserModel abstractUserModel = getCurrentlyAuthenticatedUser();
        if (abstractUserModel != null) {
            return abstractUserModel.getId();
        }
        return null;
    }

    public AbstractUserModel findAbstractUserModelByLogin(String login) {
        return userRepository.findAbstractUserModelByLogin(login);
    }

    public AbstractUserModel saveAbstractUserModel(AbstractUserModel abstractUserModel) {
        abstractUserModel.encryptUserPassword();
        return userRepository.saveAbstractUserModel(abstractUserModel);
    }
}
