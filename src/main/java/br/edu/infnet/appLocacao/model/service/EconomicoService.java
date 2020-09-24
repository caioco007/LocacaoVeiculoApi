package br.edu.infnet.appLocacao.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.appLocacao.model.negocio.Economico;
import br.edu.infnet.appLocacao.model.repository.IEconomicoRepository;

@Service
public class EconomicoService {
	
	@Autowired 
	private IEconomicoRepository economicoRepository;
	
	public List<Economico> obterLista(){
		return (List<Economico>)economicoRepository.findAll(Sort.by(Sort.Direction.ASC, "modelo"));
	}
	
	public void incluir(Economico economico) {
		economicoRepository.save(economico);
	}

	public void excluir(Integer id) {
		economicoRepository.deleteById(id);		
	}

	public Economico obterPorId(Integer id) {
		return economicoRepository.findById(id).orElse(null);
	}
}
