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
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

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

	@PostMapping(		
			value = "/incluir",
			produces = {"application/json", "application/xml"}
			)	
	@ApiOperation(value = "Cadastrar um veiculo")
	public void incluir(
				@RequestBody Veiculo veiculo
			) {
		veiculoService.incluir(veiculo);
	}
	
	@ApiResponses(value = {		
			@ApiResponse(code = 200, message = "Veiculo retornada com sucesso"),
			@ApiResponse(code = 400, message = "Erro na chamada da API"),
			@ApiResponse(code = 500, message = "Erro no processamento da chamada")
	})			
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