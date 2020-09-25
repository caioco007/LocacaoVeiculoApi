package br.edu.infnet.appLocacao.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.appLocacao.model.negocio.Locacao;
import br.edu.infnet.appLocacao.model.repository.ILocacaoRepository;

@Service
public class LocacaoService {

	@Autowired
	private ILocacaoRepository locacaoRepository;

	public List<Locacao> obterLista(){
		return (List<Locacao>)locacaoRepository.findAll(Sort.by(Sort.Direction.ASC, "dtDevolucao"));
	}
	
	public void incluir(Locacao locacao) {
		locacaoRepository.save(locacao);
	}
	
	public Locacao obterPorId(Integer id) {
		return locacaoRepository.findById(id).orElse(null);
	}
	
	public void excluir(Integer id) {
		locacaoRepository.deleteById(id);
	}
//	
//	public Float obterValorTotal(List<Locacao> lista) {
//		
//		Float valorTotal = 0F;
//		
//		for(Locacao locacao : lista) {
//			valorTotal = valorTotal + locacao.valorTotal2();
//		}
//		
//		return valorTotal;
//	}	
}
