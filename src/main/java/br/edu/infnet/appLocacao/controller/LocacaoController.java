package br.edu.infnet.appLocacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.appLocacao.model.negocio.Locacao;
import br.edu.infnet.appLocacao.model.service.LocacaoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/locacao")
public class LocacaoController {
	
	@Autowired 
	private LocacaoService locacaoService;
	
	@ApiOperation(value = "Retornar uma lista de locações")
	@GetMapping(value = "/obter")
	public List<Locacao> obterLista() {
		return locacaoService.obterLista();
	}
	
	@RequestMapping(		
			value = "/incluir",
			method = RequestMethod.POST,
			produces = {"application/json", "application/xml"}
			)	
	@ApiOperation(value = "Cadastrar uma locação")
	public void incluir(@RequestBody Locacao locacao) {
		locacaoService.incluir(locacao);
	}
	
	@ApiResponses(value = {		
			@ApiResponse(code = 200, message = "Cliente retornada com sucesso"),
			@ApiResponse(code = 400, message = "Erro na chamada da API"),
			@ApiResponse(code = 500, message = "Erro no processamento da chamada")
	})			
	@ApiOperation(value = "Obter uma locação pela chave-primária")
	@GetMapping(value = "/{id}")
	public Locacao obterPorId(
				@PathVariable Integer id
			) {
		return locacaoService.obterPorId(id);
	}
	
	@ApiOperation(value = "Consultar uma locação")
	@GetMapping(value = "/{id}/consultar")
	public Locacao consultar(@PathVariable Integer id) {
		return locacaoService.obterPorId(id);
	}
	
	@ApiOperation(value = "Excluir uma locação")
	@GetMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id) {
			locacaoService.excluir(id);
	}
}