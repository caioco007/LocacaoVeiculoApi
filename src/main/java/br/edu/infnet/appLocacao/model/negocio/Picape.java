package br.edu.infnet.appLocacao.model.negocio;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "TPicape")
@PrimaryKeyJoinColumn(name = "idveiculo")
public class Picape extends Veiculo {
	
	@ApiModelProperty(value = "Peso suportado do veiculo picape")
	private Float peso;
	
	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}
}
