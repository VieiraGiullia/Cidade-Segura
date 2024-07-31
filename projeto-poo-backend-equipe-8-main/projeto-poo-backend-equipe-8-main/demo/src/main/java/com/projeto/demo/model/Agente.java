package com.projeto.demo.model;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EnableAutoConfiguration

public class Agente extends User {

    
    @Column(nullable = true, unique = false)
    private String instituicao;
 
    public void setInstituicao(String instituicao){
        this.instituicao = instituicao;
    }
 
}