package br.edu.infnet.appLocacao.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.appLocacao.model.negocio.Executivo;
import br.edu.infnet.appLocacao.model.repository.IExecutivoRepository;

@Service
public class ExecutivoService {
	
	@Autowired 
	private IExecutivoRepository executivoRepository;
	
	public List<Executivo> obterLista(){
		return (List<Executivo>)executivoRepository.findAll(Sort.by(Sort.Direction.ASC, "modelo"));
	}
	
	public void incluir(Executivo executivo) {
		executivoRepository.save(executivo);
	}

	public void excluir(Integer id) {
		executivoRepository.deleteById(id);		
	}

	public Executivo obterPorId(Integer id) {
		return executivoRepository.findById(id).orElse(null);
	}
}
