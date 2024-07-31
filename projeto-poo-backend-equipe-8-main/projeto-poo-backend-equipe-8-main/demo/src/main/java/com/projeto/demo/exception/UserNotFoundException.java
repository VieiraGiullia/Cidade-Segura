package com.projeto.demo.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(Long id) {
        super("Usuario não encontrado: " + id);
    }
}
