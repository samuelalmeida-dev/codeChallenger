package com.example.codeChallenger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.codeChallenger.models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
