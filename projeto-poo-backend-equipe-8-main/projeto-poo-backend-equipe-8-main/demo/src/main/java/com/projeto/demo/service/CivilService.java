package com.projeto.demo.service;

import com.projeto.demo.exception.CivilNotFoundException;
import com.projeto.demo.model.Civil;
import com.projeto.demo.repository.CivilRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 

import java.util.List;
import java.util.Optional;

@Service
public class CivilService {

    @Autowired
    private CivilRepository civilRepository;

     // metodo para achar civil pelo id
     public Civil getCivilById(Long id) throws CivilNotFoundException {
        Optional<Civil> civilOptional = civilRepository.findById(id);
        if (civilOptional.isPresent()) {
            return civilOptional.get();
        } else {
            throw new CivilNotFoundException("Civil não foi encontrado pelo id: " + id);
        }
    }

    // metodo para listar todos os civis 
    public List<Civil> getCivilList() {
        return civilRepository.findAll();
    }

    // metodo para salvar civil
    public Civil saveCivil(Civil civil) {
        return civilRepository.save(civil);
    }

    // metodo para deletar civil pelo id
    public void deleteCivil(Long id) {
        civilRepository.deleteById(id);
    }

    // metodo para atualizar civil pelo id
    public void updateCivilById(Long id, Civil civilDetails) throws CivilNotFoundException {
        Optional<Civil> civilOptional = civilRepository.findById(id);
        if (civilOptional.isPresent()) {
            Civil civil = civilOptional.get();
            civil.setNome(civilDetails.getNome());
            civil.setEmail(civilDetails.getEmail());
            civil.setContato(civilDetails.getContato());
            civilRepository.save(civil);  // Atualiza o civil no banco de dados
        } else {
            throw new CivilNotFoundException("Civil não foi encontrado pelo id: " + id);
        }
    }

    public Optional<Civil> findById(Long id) {
        
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    /* 
    // metodo para achar civil pelo nome
    public List<Civil> getCivilByNome(String nome) {
        return CivilRepository.findByNome(nome);
    }

    // metodo para achar civil pelo cpf
    public List<Civil> getCivilByCpf(String cpf) {
        return CivilRepository.findByCpf(cpf);
    }

    // metodo para deletar civil pelo cpf
    public void deleteCivilByCpf(String cpf) {
        CivilRepository.deleteByCpf(cpf);
    }

    // metodo para achar civil pelo email
    public List<Civil> getCivilByEmail(String email) {
        return CivilRepository.findByEmail(email);
    }

    // metodo para achar civil pelo contato
    public List<Civil> getCivilByContato(String contato) {
        return CivilRepository.findByContato(contato);
    }
    */
}