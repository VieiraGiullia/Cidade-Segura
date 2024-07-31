package com.projeto.demo.model;

import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

//import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@EnableAutoConfiguration
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString


@Table(name = "incidentes")
public class Incidente {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tipoIncidente;

    @Column(length = 100, nullable = false)
    private String descricao;

    // procurar anotação SpringBoot para pegar a data automaticamente, ao ines de pedir ao usuario civil
    @Column(nullable = false)
    private String data;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = true)
    private String gravidade;

    @Column(nullable = true)
    private String status;

    @ElementCollection
    private List<String> imagens;


   @Column
    private Long civil;

    public Incidente(String tipoIncidente,
     String descricao, String data, String endereco, String gravidade, Long civil, String status) {
        this.tipoIncidente = tipoIncidente;
        this.descricao = descricao;
        this.data = data;
        this.endereco = endereco;
        this.gravidade = gravidade;
        this.civil = civil;
        this.status = status;
     }
    
}