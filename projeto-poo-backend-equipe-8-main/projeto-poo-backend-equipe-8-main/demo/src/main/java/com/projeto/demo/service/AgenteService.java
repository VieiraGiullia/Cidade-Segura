package com.projeto.demo.service;

import com.projeto.demo.model.Agente;
import com.projeto.demo.repository.AgenteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 

import java.util.List;
import java.util.Optional;

@Service
public class AgenteService {

    @Autowired
    private AgenteRepository agenteRepository;

   // método para salvar agente
    public Agente saveAgente(Agente agente) {
        return agenteRepository.save(agente);
    }

    // método para listar todos os agentes
    public List<Agente> getAgenteAll() {
        return agenteRepository.findAll();
    }

    // método para buscar agente por id
    public Optional<Agente> getAgenteById(Long id) {
        return agenteRepository.findById(id);
    }

    // método para deletar agente por id
    public void deleteAgenteById(Long id) {
        agenteRepository.deleteById(id);
    }

    /* 
    // método para buscar agente pela instituição 
    public List<Agente> getAgenteByInstituicao(String instituicao) {
        return agenteRepository.findByInstituicao(instituicao);
    }

    // método para buscar agente pelo nome
    public List<Agente> getAgenteByNome(String nome) {
        return agenteRepository.findByNome(nome);
    }

    // método para buscar agente pelo email
    public List<Agente> getAgenteByEmail(String email) {
        return agenteRepository.findByEmail(email);
    }

    // método para buscar agente pelo cpf
    public List<Agente> getAgenteByCpf(String cpf) {
        return agenteRepository.findByCpf(cpf);
    }

    // método para deletar agente pelo cpf
    public void deleteAgenteByCpf(String cpf) {
        agenteRepository.deleteByCpf(cpf);
    }
    */
}