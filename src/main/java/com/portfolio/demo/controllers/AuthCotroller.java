package com.portfolio.demo.controllers;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.demo.Entities.User;
import com.portfolio.demo.Entities.UserRepository;
import com.portfolio.demo.dto.LoginRequestDTO;
import com.portfolio.demo.dto.RegisterRequestDTO;
import com.portfolio.demo.dto.ResponseDTO;
import com.portfolio.demo.infra.security.TokenService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthCotroller {
  private final UserRepository repository;
  private final PasswordEncoder passwordEncoder;
  private final TokenService tokenService;

  @PostMapping("/login")
  public ResponseEntity login(@RequestBody LoginRequestDTO body) {
    User user = this.repository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found."));
    if(passwordEncoder.matches(body.password(), user.getPassword())) {
      String token = this.tokenService.genereteToken(user);
      return ResponseEntity.ok(new ResponseDTO(user.getName(), token));
    }
    return ResponseEntity.badRequest().build();
  }

  @PostMapping("/register")
  public ResponseEntity register(@RequestBody RegisterRequestDTO body) {
    Optional<User> user = this.repository.findByEmail(body.email());

    if(user.isEmpty()){
      User newUser = new User();
      newUser.setPassword(passwordEncoder.encode(body.password()));
      newUser.setEmail(body.email());
      newUser.setName(body.name());
      this.repository.save(newUser);

        String token = this.tokenService.genereteToken(newUser);
        return ResponseEntity.ok(new ResponseDTO(newUser.getName(), token));
    }
    return ResponseEntity.badRequest().build();

  }
}

