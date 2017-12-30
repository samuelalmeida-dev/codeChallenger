package com.example.codeChallenger.servicesImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.codeChallenger.models.Pessoa;
import com.example.codeChallenger.repository.PessoaRepository;
import com.example.codeChallenger.services.PessoaService;

@Transactional
@Service
public class PessoaServiceImpl implements PessoaService{
	
	private PessoaRepository pessoaRepository;

	public PessoaServiceImpl(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}

	@Override
	public List<Pessoa> buscarTodasPessoas() {
		return pessoaRepository.findAll();
	}

	@Override
	public void deletarPessoaPorId(Long id) {
		pessoaRepository.delete(id);
	}

	@Override
	public Pessoa salvarPessoa(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	@Override
	public Pessoa atualizarPessoa(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	
}
