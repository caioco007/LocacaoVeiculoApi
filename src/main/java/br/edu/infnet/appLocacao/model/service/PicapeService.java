package br.edu.infnet.appLocacao.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.appLocacao.model.negocio.Picape;
import br.edu.infnet.appLocacao.model.repository.IPicapeRepository;

@Service
public class PicapeService {
	
	@Autowired 
	private IPicapeRepository picapeRepository;
	
	public List<Picape> obterLista(){
		return (List<Picape>)picapeRepository.findAll(Sort.by(Sort.Direction.ASC, "modelo"));
	}
	
	public void incluir(Picape picape) {
		picapeRepository.save(picape);
	}

	public void excluir(Integer id) {
		picapeRepository.deleteById(id);		
	}

	public Picape obterPorId(Integer id) {
		return picapeRepository.findById(id).orElse(null);
	}
		
}
