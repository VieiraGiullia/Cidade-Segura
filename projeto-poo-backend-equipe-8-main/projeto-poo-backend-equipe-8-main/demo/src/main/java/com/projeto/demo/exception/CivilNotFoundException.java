package com.projeto.demo.exception;

public class CivilNotFoundException extends Exception {
    public CivilNotFoundException(String id) {
        super("Usuário - Civil não encontrado: " + id);
    }
}