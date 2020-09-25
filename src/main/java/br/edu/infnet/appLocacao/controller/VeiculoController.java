package br.edu.infnet.appLocacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.appLocacao.model.negocio.Veiculo;
import br.edu.infnet.appLocacao.model.service.VeiculoService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/locacao/veiculo")
public class VeiculoController {

	@Autowired 
	private VeiculoService veiculoService;
	
	@ApiOperation(value = "Retornar uma lista de veiculos")
	@GetMapping("/obter")
	public List<Veiculo> obterLista(){		
		return veiculoService.obterLista();
	}
	
	@ApiOperation(value = "Cadastrar um novo veiculo")
	@PostMapping(value = "/incluir")
	public void incluir(
				@RequestBody Veiculo veiculo
			) {
		veiculoService.incluir(veiculo);
	}
		
	@ApiOperation(value = "Obter um veiculo pela chave-primária")
	@GetMapping("/{id}")
	public Veiculo obterPorId(
				@PathVariable Integer id
			) {
		return veiculoService.obterPorId(id);
	}
	
	@ApiOperation(value = "Excluir uma veiculo")
	@GetMapping("/{id}/excluir")
	public void excluir(
				@PathVariable Integer id
			) {
		veiculoService.excluir(id);
	}
}