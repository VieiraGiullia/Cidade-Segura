package com.projeto.demo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

@Table(name = "civis")
public class Civil extends User {

    @Column(length = 11, nullable = true, unique = true)
    private String contato;


    @OneToMany(mappedBy = "civil")
    private List<Incidente> incidentes = new ArrayList<>();

  
    public void setContato(String contato){
        this.contato = contato;
    }


    public void descreverIncidente(){
        Scanner s = new Scanner(System.in);

        System.out.println("Tipo de incidente: ");
        String tipoIncidente = s.nextLine();

        System.out.println("Descreva o incidente: ");
        String descricao = s.nextLine();

        System.out.println("Data do incidente: ");
        String data = s.nextLine();

        System.out.println("Endereço onde ocorreu: ");
        String endereco = s.nextLine();

        System.out.println("Gravidade do incidente: ");
        String gravidade = s.nextLine();
        System.out.println("Status do incidente");
        String status = s.nextLine();
        s.close();

        

        Incidente incidente1 = new Incidente(tipoIncidente, descricao, data, endereco, gravidade, this.getId(),status);
        incidente1.setCivil(this.getId()); // Associa o incidente ao civil atual
        incidentes.add(incidente1);
    }

    public void visualizarHistorico() {
        if (incidentes.isEmpty()) {
            System.out.println("Não há incidentes registrados.");
        } else {
            System.out.println("Histórico de Incidentes:");
            for (Incidente incidente : incidentes) {
                System.out.println(incidente);
            }
        }
    }
    
}
