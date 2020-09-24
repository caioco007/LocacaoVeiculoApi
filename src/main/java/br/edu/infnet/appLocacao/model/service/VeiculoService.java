package br.edu.infnet.appLocacao.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.appLocacao.model.negocio.Veiculo;
import br.edu.infnet.appLocacao.model.repository.IVeiculoRepository;

@Service
public class VeiculoService {
	
	@Autowired
	private IVeiculoRepository veiculoRepository;
	
	public  List<Veiculo> obterLista() {
		return (List<Veiculo>)veiculoRepository.findAll(Sort.by(Sort.Direction.ASC, "modelo"));
	}
	
	public Veiculo obterPorId(Integer id) {
		return veiculoRepository.findById(id).orElse(null);
	}

	public void incluir(Veiculo veiculo) {
		veiculoRepository.save(veiculo);
	}
	
	public void excluir(Integer id) {
		veiculoRepository.deleteById(id);
	}
}
