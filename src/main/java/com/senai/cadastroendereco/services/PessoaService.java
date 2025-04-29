package com.senai.cadastroendereco.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.cadastroendereco.entities.Pessoa;
import com.senai.cadastroendereco.repositories.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	//Criar uma nova pessoa
	
	public Pessoa salvar(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	// Buscar uma pessoa pelo Id
	
	public Pessoa buscarPorId(Long id) {
		return pessoaRepository.findById(id).orElse(null);
			
		}
	
	//Listar todas as pessoas pelo 
	
	public List<Pessoa> ListarTodas(){
		return pessoaRepository.findAll();
		
		
	}
	
	//Excluir uma pessoa
	
	public void deletarPorId(Long id) {
		pessoaRepository.deleteById(id);
	}
	
	//Buscar pessoa por email
	
	public Pessoa buscarPorEmail (String email) {
		return pessoaRepository.FindByEmail(email);
	}
		
		
	// Verificar email e senha
		
		public Pessoa AutenticarPessoa(String email, String senha) {
			
			// verifica a existencia do email
			Pessoa pessoa = pessoaRepository.FindByEmail(email);
			
			if (pessoa != null && pessoa.getSenha().equals(senha)) {
				return pessoa;
			}else {
				return null;
			}
			
		
	}
		

}
