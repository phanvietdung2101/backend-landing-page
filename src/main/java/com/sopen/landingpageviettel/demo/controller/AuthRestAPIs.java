package com.sopen.landingpageviettel.demo.controller;

import com.sopen.landingpageviettel.demo.config.jwt.JwtProvider;
import com.sopen.landingpageviettel.demo.message.request.LoginForm;
import com.sopen.landingpageviettel.demo.message.request.SignUpForm;
import com.sopen.landingpageviettel.demo.message.response.JwtResponse;
import com.sopen.landingpageviettel.demo.models.user.Role;
import com.sopen.landingpageviettel.demo.models.user.User;
import com.sopen.landingpageviettel.demo.repository.RoleRepository;
import com.sopen.landingpageviettel.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginForm loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), (Collection<GrantedAuthority>) userDetails.getAuthorities()));
    }

    @PostMapping("/signup")
    public ResponseEntity<Void> registerUser(@RequestBody SignUpForm signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        // Creating user's account
        User user = new User(signUpRequest.getUsername(), encoder.encode(signUpRequest.getPassword()));

        Role role_admin = roleRepository.findByName("ROLE_ADMIN");
        user.setRole(role_admin);
        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
