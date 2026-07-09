package com.example.springlearn.service;

import com.example.springlearn.model.AuthRequest;
import com.example.springlearn.model.AuthResponse;

public interface AuthService {

    AuthResponse authenticate(AuthRequest authRequest);

    String registerUser(AuthRequest authRequest);
}