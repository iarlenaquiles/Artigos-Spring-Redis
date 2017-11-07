package com.br.quixada.lista10.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class Artigo {

	private String id;
	@NotNull
	@NotEmpty
	private String descricao;
	@NotNull
	@NotEmpty
	private String nome;
	@NotNull
	@NotEmpty
	private String arquivo;
	private List<String> tags;

	public Artigo() {

	}

	public Artigo(String id, String descricao, String nome, String arquivo, List<String> tags) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.nome = nome;
		this.arquivo = arquivo;
		this.tags = tags;
	}

	public Artigo(String descricao, String nome, String arquivo, List<String> tags) {
		this.descricao = descricao;
		this.nome = nome;
		this.arquivo = arquivo;
		this.tags = tags;
	}

	public Artigo(String descricao, String nome, String arquivo) {
		this.descricao = descricao;
		this.nome = nome;
		this.arquivo = arquivo;
	}

	public Artigo(String id, String descricao, String nome, String arquivo) {
		this.descricao = descricao;
		this.nome = nome;
		this.arquivo = arquivo;
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getArquivo() {
		return arquivo;
	}

	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "Artigo [id=" + id + ", descricao=" + descricao + ", nome=" + nome + ", arquivo=" + arquivo + ", tags="
				+ tags + "]";
	}

}
