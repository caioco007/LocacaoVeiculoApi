package br.edu.infnet.appLocacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.appLocacao.model.negocio.Cadastro;
import br.edu.infnet.appLocacao.model.service.CadastroService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/locacao/cadastro")
public class CadastroController {
	
	@Autowired 
	private CadastroService cadastroService;
	
	@ApiOperation(value = "Cadastrar um novo usuário")
	@PostMapping("/incluir")
	public void incluir(@RequestBody Cadastro cadastro) {
		cadastroService.incluir(cadastro);
	}

	@ApiOperation(value = "Valida a autenticação do usuário")
	@PostMapping
	public boolean isValid(@RequestParam String login, @RequestParam String senha) {		
		return cadastroService.isValid(login, senha);
	}
	
	@ApiOperation(value = "Obter o usuário pelo login")
	@PostMapping("/{login}")
	public Cadastro userExist(@PathVariable String login) {
		return cadastroService.userExist(login);
	}
}
