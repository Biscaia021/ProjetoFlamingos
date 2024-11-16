package com.projetojava.app.entidades;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Apartamento")
public class Apartamento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer bloco;
	private Integer apartamento;
	private String proprietario;
	
	public Apartamento() {
		
	}

	public Apartamento(Long id, Integer bloco, Integer apartamento, String proprietario) {
		super();
		this.id = id;
		this.bloco = bloco;
		this.apartamento = apartamento;
		this.proprietario = proprietario;
	}
	//
	//
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getBloco() {
		return bloco;
	}

	public void setBloco(Integer bloco) {
		this.bloco = bloco;
	}

	public Integer getApartamento() {
		return apartamento;
	}

	public void setApartamento(Integer apartamento) {
		this.apartamento = apartamento;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Apartamento other = (Apartamento) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Apartamento [id=" + id + ", bloco=" + bloco + ", apartamento=" + apartamento + ", proprietario="
				+ proprietario + "]";
	}
	
	
	
	
}
