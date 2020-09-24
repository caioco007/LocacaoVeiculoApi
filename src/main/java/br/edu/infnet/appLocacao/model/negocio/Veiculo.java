package br.edu.infnet.appLocacao.model.negocio;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "TVeiculo")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(
		use = JsonTypeInfo.Id.NAME,
		include = JsonTypeInfo.As.PROPERTY,
		property = "tipoVeiculo"
		)
@JsonSubTypes({
	@JsonSubTypes.Type(value = Economico.class, name = "Economico"),
	@JsonSubTypes.Type(value = Executivo.class, name = "Executivo"),
	@JsonSubTypes.Type(value = Picape.class, name = "Picape")
})
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class Veiculo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ApiModelProperty(value = "O modelo do veiculo")
	private String modelo;
	private String placa;
	private String cor;
	private Integer ano;
	private String marca;
	private Float valor;
	@ManyToMany(mappedBy = "veiculos")
	@JsonBackReference
	private List<Locacao> locacoes;
	
	@Override
	public String toString() {
		return String.format("%s - %s",
				this.getModelo(),
				this.getPlaca()
			);
	}

	public Veiculo() {
		
	}
	
	public Veiculo(Integer id) {
		this();
		this.setId(id);
	}
	
	public Veiculo(Integer id, String modelo, String placa, String cor, Integer ano, String marca, Float valor) {
		this();
		this.setId(id);
		this.setModelo(modelo);
		this.setPlaca(placa);
		this.setCor(cor);
		this.setAno(ano);
		this.setMarca(marca);
		this.setValor(valor);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}
	public List<Locacao> getLocacoes() {
		return locacoes;
	}

	public void setLocacoes(List<Locacao> locacoes) {
		this.locacoes = locacoes;
	}		
}
