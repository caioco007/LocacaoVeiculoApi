package br.edu.infnet.appLocacao.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.appLocacao.model.negocio.Cliente;
import br.edu.infnet.appLocacao.model.repository.IClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private IClienteRepository clienteRepository;
	
	public  List<Cliente> obterLista() {
		return (List<Cliente>)clienteRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
	}
	
	public Cliente obterPorId(Integer id) {
		return clienteRepository.findById(id).orElse(null);
	}

	public void incluir(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	public void excluir(Integer id) {
		clienteRepository.deleteById(id);
	}
}
