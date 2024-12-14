package com.codedsalis.ecom.user.services;

import com.codedsalis.ecom.auth.RegistrationRequest;
import com.codedsalis.ecom.user.entity.User;
import com.codedsalis.ecom.user.exception.UserCreationException;
import com.codedsalis.ecom.user.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Boolean userExists(String email) {
        return userRepository.existsByEmail(email);
    }

    public User create(RegistrationRequest data) throws UserCreationException {
        try {
            if (userRepository.existsByEmail(data.getEmail())) {
                throw new UserCreationException("This email address is already taken");
            }

            var hashedPassword = passwordEncoder.encode(data.getPassword());
            var user = User.builder()
                    .email(data.getEmail())
                    .name(data.getName())
                    .password(hashedPassword)
                    .build();

            return userRepository.save(user);
        } catch (DataAccessException ex) {
            log.debug(ex);
            throw new UserCreationException("Something went wrong, please try again", ex);
        }
    }
}
