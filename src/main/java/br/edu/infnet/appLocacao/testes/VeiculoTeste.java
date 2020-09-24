package br.edu.infnet.appLocacao.testes;

import br.edu.infnet.appLocacao.controller.VeiculoController;

public class VeiculoTeste {

	public static void main(String[] args) {
		
		VeiculoController veiculoController = new VeiculoController();
		
		System.out.println(veiculoController.obterLista());
		
//		veiculoController.incluir("infnet");
//		
//		System.out.println(veiculoController.obterPorId(1));
//		
//		veiculoController.incluir(new Veiculo("Instituto Infnet"));
//
//		veiculoController.excluir(2);
//		
//		veiculoController.incluir(new Veiculo("Instituto"));
		
		System.out.println(veiculoController.obterLista());
	}
}