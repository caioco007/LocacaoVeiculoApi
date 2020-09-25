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
		
	@ApiOperation(value = "Obter um veiculo economico pela chave-primária")
	@GetMapping(value = "/{id}")
	public Economico obterPorId(
				@PathVariable Integer id
			) {
		return economicoService.obterPorId(id);
	}
}