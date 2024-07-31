package com.projeto.demo.controller;

import com.projeto.demo.exception.IncidenteNotFoundException;
import com.projeto.demo.model.Agente;
import com.projeto.demo.model.Incidente;
import com.projeto.demo.service.AgenteService;
import com.projeto.demo.service.IncidenteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//import javax.management.RuntimeErrorException;

@RestController
@RequestMapping("/incidentes")
public class IncidenteController {

    @Autowired
    private IncidenteService incidenteService;
    

    // metodo para salvar incidente
    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<Incidente> saveIncidente(@RequestBody Incidente incidente) {
       Incidente incidenteSalvo = incidenteService.saveIncidente(incidente);
        return new ResponseEntity<>(incidenteSalvo, HttpStatus.CREATED);
    }
    
    // metodo para listar incidentes
    @GetMapping
    public ResponseEntity<List<Incidente>> findAll() {
        List<Incidente> incidentes = incidenteService.getIncidenteList();
        return new ResponseEntity<>(incidentes, HttpStatus.OK);
    }

    // metodo para deletar incidente
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteIncidente(@PathVariable Long id) {
        incidenteService.deleteById(id);
        return null;
    }

    // metodo para buscar incidente pelo id
    @GetMapping("/{id}")
    public ResponseEntity<Incidente> findById(@PathVariable Long id) throws IncidenteNotFoundException {
           Optional<Incidente> incidenteOptional = incidenteService.getIncidenteById(id);
        return incidenteOptional.map(incidente -> new ResponseEntity<>(incidente, HttpStatus.OK))
                             .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /* 
    // metodo para atualizar incidente pelo id
    @PutMapping("/{id}")
    public ResponseEntity<Incidente> updateIncidente(@PathVariable Long id, @RequestBody Incidente incidenteDetails) {
        incidenteService.updateIncidenteById(id, incidenteDetails);
        return new ResponseEntity<>(incidenteDetails, HttpStatus.OK);
    }
    */

    // metodo para buscar incidente pela gravidade
    @GetMapping("/gravidade/{gravidade}")
    public ResponseEntity<List<Incidente>> findByGravidade(@PathVariable String gravidade) {
    List<Incidente> incidentes = incidenteService.getIncidenteByGravidade(gravidade);
    return new ResponseEntity<>(incidentes, HttpStatus.OK);
    }

    // metodo para buscar incidente por civil
    @GetMapping("/civil/{civil}")
    public List<Incidente> getIncidenteByCivil(@PathVariable String civil) {
        return incidenteService.getIncidenteByCivil(civil);
    }

    // metodo para buscar incidente por tipo de incidente
    @GetMapping("/tipoIncidente/{tipoIncidente}")
    public ResponseEntity<List<Incidente>> findByTipoIncidente(@PathVariable String tipoIncidente) {
        List<Incidente> incidentes = incidenteService.getIncidenteByTipoIncidente(tipoIncidente);
        return new ResponseEntity<>(incidentes, HttpStatus.OK);
    }

    // metodo para buscar incidente por status
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Incidente>> findByStatus(@PathVariable String status) {
        List<Incidente> incidentes = incidenteService.getIncidentesByStatus(status);
        return new ResponseEntity<>(incidentes, HttpStatus.OK);
    }
    
    // metodo para buscar incidente por data
    @GetMapping("/data/{data}")
    public ResponseEntity<List<Incidente>> findByData(@PathVariable String data) {
        List<Incidente> incidentes = incidenteService.getIncidenteByData(data);
        return new ResponseEntity<>(incidentes, HttpStatus.OK);
    }

    // metodo para buscar incidente por endereço
    @GetMapping("/endereco/{endereco}")
    public ResponseEntity<List<Incidente>> findByEndereco(@PathVariable String endereco) {
        List<Incidente> incidentes = incidenteService.getIncidenteByEndereco(endereco);
        return new ResponseEntity<>(incidentes, HttpStatus.OK);
    }

}  
