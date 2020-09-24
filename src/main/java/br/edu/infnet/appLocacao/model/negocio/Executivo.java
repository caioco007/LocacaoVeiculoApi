package br.edu.infnet.appLocacao.model.negocio;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "TExecutivo")
@PrimaryKeyJoinColumn(name = "idveiculo")
public class Executivo extends Veiculo {
	
	@ApiModelProperty(value = "Cambio automático do veiculo executivo")
	private Boolean automatico;

	public Boolean getAutomatico() {
		return automatico;
	}

	public void setAutomatico(Boolean automatico) {
		this.automatico = automatico;
	}
}
