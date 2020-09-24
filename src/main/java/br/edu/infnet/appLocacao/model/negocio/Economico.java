package br.edu.infnet.appLocacao.model.negocio;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "TEconomico")
@PrimaryKeyJoinColumn(name = "idveiculo")
public class Economico extends Veiculo{
	
	@ApiModelProperty(value = "Vidro manual do veiculo econômico")
	private Boolean vidroManu;
	
	public Boolean getVidroManu() {
		return vidroManu;
	}

	public void setVidroManu(Boolean vidroManu) {
		this.vidroManu = vidroManu;
	}
}
