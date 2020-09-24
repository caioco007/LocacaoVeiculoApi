package br.edu.infnet.appLocacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.appLocacao.model.negocio.Economico;
import br.edu.infnet.appLocacao.model.service.EconomicoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/locacao/economico")
public class EconomicoController {

	@Autowired 
	private EconomicoService economicoService;
	
	@ApiOperation(value = "Retornar uma lista de veiculos economicos")
	@GetMapping("/obter")
	public List<Economico> obterLista(){		
		return economicoService.obterLista();
	}
	
	@ApiResponses(value = {		
			@ApiResponse(code = 200, message = "Veiculo economico retornada com sucesso"),
			@ApiResponse(code = 400, message = "Erro na chamada da API"),
			@ApiResponse(code = 500, message = "Erro no processamento da chamada")
	})			
	@ApiOperation(value = "Obter um veiculo economico pela chave-primária")
	@GetMapping(value = "/{id}")
	public Economico obterPorId(
				@PathVariable Integer id
			) {
		return economicoService.obterPorId(id);
	}
}