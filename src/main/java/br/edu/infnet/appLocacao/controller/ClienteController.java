package br.edu.infnet.appLocacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.appLocacao.model.negocio.Cliente;
import br.edu.infnet.appLocacao.model.service.ClienteService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/locacao/cliente")
public class ClienteController {

	@Autowired 
	private ClienteService clienteService;
	
	@ApiOperation(value = "Retornar uma lista de clientes")
	@GetMapping("/obter")
	public List<Cliente> obterLista(){		
		return clienteService.obterLista();
	}

	@PostMapping(		
			value = "/incluir",
			produces = {"application/json", "application/xml"}
			)	
	@ApiOperation(value = "Cadastrar um cliente")
	public void incluir(
				@RequestBody Cliente cliente
			) {
		clienteService.incluir(cliente);
	}
	
	@ApiResponses(value = {		
			@ApiResponse(code = 200, message = "Cliente retornada com sucesso"),
			@ApiResponse(code = 400, message = "Erro na chamada da API"),
			@ApiResponse(code = 500, message = "Erro no processamento da chamada")
	})			
	@ApiOperation(value = "Obter um cliente pela chave-primária")
	@GetMapping(value = "/{id}")
	public Cliente obterPorId(
			@PathVariable Integer id
			) {
		return clienteService.obterPorId(id);
	}
	
	@ApiOperation(value = "Excluir um cliente")
	@GetMapping(value = "/{id}/excluir")
	public void excluir(
				@PathVariable Integer id
			) {
		clienteService.excluir(id);
	}
}