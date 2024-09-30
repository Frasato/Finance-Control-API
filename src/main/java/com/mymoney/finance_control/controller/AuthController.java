package com.mymoney.finance_control.controller;

import com.mymoney.finance_control.dtos.LoginRequestDto;
import com.mymoney.finance_control.dtos.ResponseDto;
import com.mymoney.finance_control.dtos.RegisterRequestDto;
import com.mymoney.finance_control.models.User;
import com.mymoney.finance_control.repositories.UserRepository;
import com.mymoney.finance_control.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequestDto){
        User user = userRepository.findByEmail(loginRequestDto.email()).orElseThrow(() -> new RuntimeException("ERROR: User not found!"));

        if(passwordEncoder.matches(loginRequestDto.password(), user.getPassword())){
            String token = tokenService.generateToken(user);
            return ResponseEntity.ok().body(new ResponseDto(user.getUsername(), token));
        }

        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequestDto registerRequestDto){
        Optional<User> findedUser = userRepository.findByEmail(registerRequestDto.email());
        User user = new User();

        if(findedUser.isEmpty()){
            user.setPassword(passwordEncoder.encode(registerRequestDto.password()));
            user.setEmail(registerRequestDto.email());
            user.setUsername(registerRequestDto.username());

            userRepository.save(user);
            String token = tokenService.generateToken(user);

            return ResponseEntity.ok().body(new ResponseDto(user.getUsername(), token));
        }

        return ResponseEntity.badRequest().build();
    }

}
