package br.edu.infnet.appLocacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.appLocacao.model.negocio.Locacao;
import br.edu.infnet.appLocacao.model.service.LocacaoService;

@RestController
@RequestMapping("/api/locacao")
public class LocacaoController {
	
	@Autowired 
	private LocacaoService locacaoService;
	
	@GetMapping(value = "/obter")
	public List<Locacao> obterLista() {
		return locacaoService.obterLista();
	}
	
	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody Locacao locacao) {
		locacaoService.incluir(locacao);
	}
	
			
	@GetMapping(value = "/{id}")
	public Locacao obterPorId(
				@PathVariable Integer id
			) {
		return locacaoService.obterPorId(id);
	}
	
	@GetMapping(value = "/{id}/consultar")
	public Locacao consultar(@PathVariable Integer id) {
		return locacaoService.obterPorId(id);
	}
	
	@GetMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id) {
		locacaoService.excluir(id);
	}
}