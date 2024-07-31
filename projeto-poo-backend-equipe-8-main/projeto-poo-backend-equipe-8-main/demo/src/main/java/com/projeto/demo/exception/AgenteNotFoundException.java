package com.projeto.demo.exception;

public class AgenteNotFoundException extends Exception {
    public AgenteNotFoundException(String id) {
        super("Usuário - Agente não encontrado: " + id);
    }
}
