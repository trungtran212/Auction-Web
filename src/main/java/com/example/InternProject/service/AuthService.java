package com.example.InternProject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.InternProject.dto.LoginRequest;
import com.example.InternProject.dto.LoginResponse;
import com.example.InternProject.dto.RegisterRequest;
import com.example.InternProject.exception.CustomException;
import com.example.InternProject.model.User;
import com.example.InternProject.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public String register(RegisterRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new CustomException("Email đã được sử dụng.");
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setName(request.getFullName());
        user.setRole("USER"); // luôn mặc định là USER

        userRepository.save(user);
        return "Đăng ký thành công!";
    }

    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new CustomException("Tài khoản không tồn tại."));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new CustomException("Sai mật khẩu.");
        }

        return new LoginResponse("Đăng nhập thành công!", user.getEmail(), user.getRole());
    }
}