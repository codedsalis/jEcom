package com.codedsalis.ecom.user.services;


import com.codedsalis.ecom.auth.AuthenticationFailedException;
import com.codedsalis.ecom.user.entity.User;
import com.codedsalis.ecom.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws AuthenticationFailedException {

        User user = userRepository.findByEmail(userEmail);

        if (user == null) {
            throw new AuthenticationFailedException("Invalid credentials, please try again");
        }
        List<GrantedAuthority> auth = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE");

        String password = user.getPassword();
        return new org.springframework.security.core.userdetails.User(userEmail, password, auth);
    }
}
