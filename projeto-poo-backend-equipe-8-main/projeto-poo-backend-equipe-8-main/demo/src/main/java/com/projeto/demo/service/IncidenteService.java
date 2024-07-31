package com.projeto.demo.service;

import com.projeto.demo.exception.IncidenteNotFoundException;
import com.projeto.demo.model.Civil;
import com.projeto.demo.model.Incidente;
import com.projeto.demo.repository.IncidenteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 
import java.util.List;
import java.util.Optional;


@Service
public class IncidenteService {

    @Autowired
    private IncidenteRepository incidenteRepository;
    
    // metodo para salvar incidente
    public Incidente saveIncidente(Incidente incidente) {
        return incidenteRepository.save(incidente);
    }

     // metodo para listar todos os incidentes
     public List<Incidente> getIncidenteList() {
        return incidenteRepository.findAll();
    }

    

    // metodo para busccar incidente pelo id
    public Optional <Incidente> getIncidenteById(Long id) {
        return incidenteRepository.findById(id);
    }

    // metodo para atualizar incidente pelo id
    public void updateIncidenteById(Long id, Incidente incidenteAtualizado) {
      
      Optional <Incidente> newIncidenteOptional = incidenteRepository.findById(id);
      if(newIncidenteOptional.isPresent()){
       Incidente newIncidente = newIncidenteOptional.get();
       newIncidente.setDescricao(incidenteAtualizado.getDescricao());
       incidenteRepository.save(newIncidente);
       
      }

    }


    // metodo para buscar incidente por civil
    public List<Incidente> getIncidenteByCivil(Civil civil) {
        return incidenteRepository.findByCivil(civil);
    }

    // metodo para buscar incidente pela gravidade
    public List<Incidente> getIncidenteByGravidade(String gravidade) {
        return incidenteRepository.findByGravidade(gravidade);
    }

    // metodo para buscar incidente pelo tipo de incidente
    public List<Incidente> getIncidenteByTipoIncidente(String tipoIncidente) {
        return incidenteRepository.findByTipoIncidente(tipoIncidente);
    }

    public List<Incidente> getIncidentesByStatus(String status) {
        return incidenteRepository.findByStatus(status);
    }
    // metodo para buscar incidente pela data
    public List<Incidente> getIncidenteByData(String data) {
        return incidenteRepository.findByData(data);
    }

    // metodo para achar incidente pelo endereço
    public List<Incidente> getIncidenteByEndereco(String endereco) {
        return incidenteRepository.findByEndereco(endereco);
    }

    public void deleteById(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    public List<Incidente> getIncidenteByCivil(String civil) {
        
        throw new UnsupportedOperationException("Unimplemented method 'getIncidenteByCivil'");
    }
}
