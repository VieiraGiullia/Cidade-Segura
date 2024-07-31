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

import com.projeto.demo.exception.CivilNotFoundException;
import com.projeto.demo.model.Civil;
import com.projeto.demo.service.CivilService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/civis")
public class CivilController {

    @Autowired
    private CivilService civilService;

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<Civil> saveCivil(@RequestBody Civil civil) throws CivilNotFoundException{
        Civil civilSave = civilService.saveCivil(civil);
        return new ResponseEntity<>(civilSave, HttpStatus.CREATED);
    }

    // pegar um civil pelo id pela rota /civis/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Civil> findById(@PathVariable Long id) {
        try{
          Civil civil = civilService.getCivilById(id);
            return new ResponseEntity<>(civil, HttpStatus.OK);
        } catch(CivilNotFoundException CivilNaoEncontrado) {
            return ResponseEntity.notFound().build();
        }
    }
    
    // listar todos os civis pela rota /civis/All
    @CrossOrigin(origins = "*")
    @GetMapping
    public List<Civil> getAll() {
        return civilService.getCivilList();
    }

    // salvando um novo civil
 

    // atualizar um civil pelo id
    @PutMapping("/{id}")
    public ResponseEntity<Civil> updateCivil(@PathVariable Long id, @RequestBody Civil civilDetails) {
        Optional<Civil> civilOptional = civilService.findById(id);
        if (civilOptional.isPresent()) {
            Civil civil = civilOptional.get();
            civil.setNome(civilDetails.getNome());
            civil.setEmail(civilDetails.getEmail());
            civil.setContato(civilDetails.getContato());
            return ResponseEntity.ok(civilService.saveCivil(civil));
            } else {
            return ResponseEntity.notFound().build();
        }
    }
    // deletando um civil pelo id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCivil(@PathVariable Long id) {
        civilService.deleteCivil(id);
        return ResponseEntity.noContent().build();
    }
}