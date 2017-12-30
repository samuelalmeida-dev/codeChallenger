package com.example.codeChallenger.services;

import java.util.List;

import com.example.codeChallenger.models.Pessoa;

public interface PessoaService {

	List<Pessoa> buscarTodasPessoas();
	
	void deletarPessoaPorId(Long id);
	
	Pessoa salvarPessoa(Pessoa pessoa);
	
	Pessoa atualizarPessoa(Pessoa pessoa);
	
}
