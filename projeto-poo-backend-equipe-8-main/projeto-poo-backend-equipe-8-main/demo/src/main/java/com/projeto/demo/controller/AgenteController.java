package com.projeto.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.demo.model.Agente;
import com.projeto.demo.service.AgenteService;

@RestController
@RequestMapping("/agentes")
public class AgenteController {

    @Autowired
    private AgenteService AgenteService;

    // encontrando um objeto pelo id do tipo Agente
    @GetMapping("/{id}")
    public ResponseEntity<Agente> findById(@PathVariable Long id) {
        Optional<Agente> agenteOptional = AgenteService.getAgenteById(id);
        return agenteOptional.map(agente -> new ResponseEntity<>(agente, HttpStatus.OK))
                             .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // listando todos os agentes
    @GetMapping
    public List<Agente> getAll() {
        return AgenteService.getAgenteAll();
    }

    // salvando um novo agente
    @PostMapping
    @CrossOrigin(origins = "*")
    public ResponseEntity<Agente> createAgente(@RequestBody Agente agente) {
        Agente novoAgente = AgenteService.saveAgente(agente);
        return new ResponseEntity<>(novoAgente, HttpStatus.CREATED);

        
    }

    // atualizando um agente
    @PutMapping("/{id}")
    public ResponseEntity<Agente> updateAgente(@PathVariable Long id, @RequestBody Agente agenteDetails) {
        Optional<Agente> agenteOptional = AgenteService.getAgenteById(id);
        if (agenteOptional.isPresent()) {
            Agente updateAgente = agenteOptional.get();
            updateAgente.setNome(agenteDetails.getNome());
            updateAgente.setInstituicao(agenteDetails.getInstituicao());
            updateAgente.setEmail(agenteDetails.getEmail());
            Agente agenteAtualizado = AgenteService.saveAgente(updateAgente);
            return ResponseEntity.ok(agenteAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // deletando um agente pelo id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgente(@PathVariable Long id) {
        AgenteService.deleteAgenteById(id);
        return ResponseEntity.noContent().build();
    }
}