package io.payment.ua.data.users.security;

import io.payment.ua.data.users.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserDetailsImplementationService implements UserDetailsService {
    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserDetails user = userService.findAbstractUserModelByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No users were found by following username: %s", login));
        }
        return user;
    }
}
