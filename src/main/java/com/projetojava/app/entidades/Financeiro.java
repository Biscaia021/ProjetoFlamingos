package com.projetojava.app.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Financeiro")
public class Financeiro implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date periodo;
	private Double fundoReserva;
	private Double cedae;
	private Double light;
	private Double cotaExtra;
	private Double outros;
	private Double mensalidade;
	private Double multa;
	private Integer atraso;
	private Double juros;
	private Double correcaoMonetari;
	
	public Financeiro() {
		
	}

	public Financeiro(Long id, Date periodo, Double fundoReserva, Double cedae, Double light, Double cotaExtra,
			Double outros, Double mensalidade, Double multa, Integer atraso, Double juros, Double correcaoMonetari) {
		super();
		this.id = id;
		this.periodo = periodo;
		this.fundoReserva = fundoReserva;
		this.cedae = cedae;
		this.light = light;
		this.cotaExtra = cotaExtra;
		this.outros = outros;
		this.mensalidade = mensalidade;
		this.multa = multa;
		this.atraso = atraso;
		this.juros = juros;
		this.correcaoMonetari = correcaoMonetari;
	}
	
	public Date getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Date periodo) {
		this.periodo = periodo;
	}

	public Double getFundoReserva() {
		return fundoReserva;
	}

	public void setFundoReserva(Double fundoReserva) {
		this.fundoReserva = fundoReserva;
	}

	public Double getCedae() {
		return cedae;
	}

	public void setCedae(Double cedae) {
		this.cedae = cedae;
	}

	public Double getLight() {
		return light;
	}

	public void setLight(Double light) {
		this.light = light;
	}

	public Double getCotaExtra() {
		return cotaExtra;
	}

	public void setCotaExtra(Double cotaExtra) {
		this.cotaExtra = cotaExtra;
	}

	public Double getOutros() {
		return outros;
	}

	public void setOutros(Double outros) {
		this.outros = outros;
	}

	public Double getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(Double mensalidade) {
		this.mensalidade = mensalidade;
	}

	public Double getMulta() {
		return multa;
	}

	public void setMulta(Double multa) {
		this.multa = multa;
	}

	public Integer getAtraso() {
		return atraso;
	}

	public void setAtraso(Integer atraso) {
		this.atraso = atraso;
	}

	public Double getJuros() {
		return juros;
	}

	public void setJuros(Double juros) {
		this.juros = juros;
	}

	public Double getCorrecaoMonetari() {
		return correcaoMonetari;
	}

	public void setCorrecaoMonetari(Double correcaoMonetari) {
		this.correcaoMonetari = correcaoMonetari;
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
		Financeiro other = (Financeiro) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Financeiro [id=" + id + ", periodo=" + periodo + ", fundoReserva=" + fundoReserva + ", cedae=" + cedae
				+ ", light=" + light + ", cotaExtra=" + cotaExtra + ", outros=" + outros + ", mensalidade="
				+ mensalidade + ", multa=" + multa + ", atraso=" + atraso + ", juros=" + juros + ", correcaoMonetari="
				+ correcaoMonetari + "]";
	}

}
