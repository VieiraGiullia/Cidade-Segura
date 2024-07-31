package com.projeto.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.demo.model.Civil;
import com.projeto.demo.model.Incidente;

@Repository
public interface IncidenteRepository extends JpaRepository<Incidente, Long> {

    
    /*public Incidente getIncidenteById(Long id);

    public void deleteIncidenteById(Long id);

    public List<Incidente> getAll();/* */

    public List<Incidente> getIncidenteByCivil(Civil civil);
    
    //public void updateById(Long id);

    public List<Incidente> findByStatus(String status);

    public List<Incidente> findByCivil(Civil civil);    

    public List<Incidente> findByGravidade(String gravidade);

    public List<Incidente> findByTipoIncidente(String tipoIncidente);

    public List<Incidente> findByData(String data);

    public List<Incidente> findByEndereco(String endereco);
}

