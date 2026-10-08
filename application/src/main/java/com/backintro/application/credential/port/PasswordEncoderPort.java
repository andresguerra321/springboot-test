package com.backintro.application.credential.port;

public interface PasswordEncoderPort {
    boolean matches(String rawPassword, String encodedPassword);
}
