package com.example.clinic.controllers;

import com.example.clinic.dto.auth.JwtAuthenticationResponse;
import com.example.clinic.dto.auth.SignInRequest;
import com.example.clinic.dto.auth.SignUpRequest;
import com.example.clinic.services.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Аутентификация")
public class AuthController {
  private final AuthenticationService authenticationService;

  @Operation(summary = "Регистрация пользователя")
  @PostMapping("/sing-up")
  public JwtAuthenticationResponse signUp(@RequestBody SignUpRequest request) {
    return authenticationService.signUp(request);
  }

  @Operation(summary = "Авторизация пользователя")
  @PostMapping("/sign-in")
  public JwtAuthenticationResponse signIn(@RequestBody SignInRequest request) {
    return authenticationService.signIn(request);
  }
}
