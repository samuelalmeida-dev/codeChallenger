package com.example.codeChallenger.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.codeChallenger.models.Pessoa;
import com.example.codeChallenger.services.PessoaService;

@RestController
@RequestMapping("/api")
public class PessoaResource {
	
	private PessoaService pessoaService;
	
	public PessoaResource(PessoaService pessoaService){
		this.pessoaService = pessoaService;
	}
	
	@PostMapping("/pessoas")
    public ResponseEntity<Pessoa> salvarPessoa(@RequestBody Pessoa pessoa) {
		try {
			Pessoa result = pessoaService.salvarPessoa(pessoa);
			return new ResponseEntity<Pessoa>(result, HttpStatus.CREATED);	
		} catch (Exception e) {
			return new ResponseEntity<Pessoa>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

    }
	
	@PutMapping("/pessoas")
    public ResponseEntity<Pessoa> atualizarPessoa(@RequestBody Pessoa pessoa) {
		try {
	        Pessoa result = pessoaService.atualizarPessoa(pessoa);
	        return new ResponseEntity<Pessoa>(result, HttpStatus.OK);	
		} catch (Exception e) {
			return new ResponseEntity<Pessoa>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
	
	@GetMapping("/pessoas")
	public ResponseEntity<List<Pessoa>> buscarTodasPessoas() {

		List<Pessoa> result = new ArrayList<Pessoa>();
		
		try {
			result = pessoaService.buscarTodasPessoas();
			return new ResponseEntity<List<Pessoa>>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Pessoa>>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		
	}
	
	@DeleteMapping("/pessoas/{id}")
	public ResponseEntity<Pessoa> deletarPessoaPorId(@PathVariable("id") long id) {
		
		try {
			pessoaService.deletarPessoaPorId(id);
			return new ResponseEntity<Pessoa>(HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<Pessoa>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	

}
