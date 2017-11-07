package com.br.quixada.lista10.dao;

import java.util.List;

import com.br.quixada.lista10.model.Artigo;

public interface ArtigoDao {

	public void inserir(Artigo artigo);

	public List<Artigo> getLista();

	public List<String> getTags(Long id);
	
	public List<String> getArtigosTag(String tag);
	
	public List<String> getAllTags();
}
