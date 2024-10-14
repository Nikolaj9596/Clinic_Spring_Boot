package com.example.clinic.services;

import com.example.clinic.dto.auth.JwtAuthenticationResponse;
import com.example.clinic.dto.auth.SignInRequest;
import com.example.clinic.dto.auth.SignUpRequest;
import com.example.clinic.models.Role;
import com.example.clinic.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final UserService userService;
  private final JwtService jwtService;
  private final PasswordEncoder passwordEncoder;
  private final AuthenticationManager authenticationManager;

  public JwtAuthenticationResponse signUp(SignUpRequest request) {
    var user =
        User.builder()
            .name(request.getName())
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .role(Role.ADMIN)
            .build();
    userService.create(user);
    var jwt = jwtService.generateToken(user);
    return new JwtAuthenticationResponse(jwt);
  }

  public JwtAuthenticationResponse signIn(SignInRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
    var user = userService.userDetailsService().loadUserByUsername(request.getEmail());
    var jwt = jwtService.generateToken(user);
    return new JwtAuthenticationResponse(jwt);
  }
}
