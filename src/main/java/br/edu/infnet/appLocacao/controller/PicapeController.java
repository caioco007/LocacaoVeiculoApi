package br.edu.infnet.appLocacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.appLocacao.model.negocio.Picape;
import br.edu.infnet.appLocacao.model.service.PicapeService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/locacao/picape")
public class PicapeController {

	@Autowired 
	private PicapeService picapeService;
	
	@ApiOperation(value = "Retornar uma lista de veiculos picapes")
	@GetMapping("/obter")
	public List<Picape> obterLista(){		
		return picapeService.obterLista();
	}
	
	@ApiOperation(value = "Obter um veiculo picape pela chave-primária")
	@GetMapping(value = "/{id}")
	public Picape obterPorId(
			@PathVariable Integer id
			) {
		return picapeService.obterPorId(id);
	}
}