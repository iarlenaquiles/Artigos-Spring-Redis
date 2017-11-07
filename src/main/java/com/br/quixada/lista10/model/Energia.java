package com.br.quixada.gestao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "energia")
public class Energia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private int tensao;

	private int corrente;

	public Energia(Integer id, int tensao, int corrente) {
		this.id = id;
		this.tensao = tensao;
		this.corrente = corrente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getTensao() {
		return tensao;
	}

	public void setTensao(int tensao) {
		this.tensao = tensao;
	}

	public int getCorrente() {
		return corrente;
	}

	public void setCorrente(int corrente) {
		this.corrente = corrente;
	}

}
