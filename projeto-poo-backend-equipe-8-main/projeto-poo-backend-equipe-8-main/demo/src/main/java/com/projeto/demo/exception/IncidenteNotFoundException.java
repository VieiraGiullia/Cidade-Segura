package com.projeto.demo.exception;

public class IncidenteNotFoundException  extends Exception{
    public IncidenteNotFoundException(Long id){
        super("Incidente não encontrado: " + id);
    }
}