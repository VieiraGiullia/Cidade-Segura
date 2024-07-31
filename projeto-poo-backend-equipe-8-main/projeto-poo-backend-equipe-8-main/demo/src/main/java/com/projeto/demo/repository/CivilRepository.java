package com.projeto.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.demo.model.Civil;

import java.util.List;


@Repository
public interface CivilRepository extends JpaRepository<Civil,Long> {
 
}
