package br.edu.infnet.appLocacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.appLocacao.model.negocio.Executivo;
import br.edu.infnet.appLocacao.model.service.ExecutivoService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/locacao/executivo")
public class ExecutivoController {

	@Autowired 
	private ExecutivoService executivoService;
	
	@ApiOperation(value = "Retornar uma lista de veiculos executivos")
	@GetMapping("/obter")
	public List<Executivo> obterLista(){		
		return executivoService.obterLista();
	}
	
	@ApiOperation(value = "Obter um veiculo executivo pela chave-primária")
	@GetMapping("/{id}")
	public Executivo obterPorId(
				@PathVariable Integer id
			) {
		return executivoService.obterPorId(id);
	}
}