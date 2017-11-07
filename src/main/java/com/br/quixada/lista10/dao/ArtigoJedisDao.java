package com.br.quixada.lista10.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.br.quixada.lista10.model.Artigo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Component
public class ArtigoJedisDao implements ArtigoDao {
	JedisPool pool;
	Jedis jedis;
	// Integer cont;

	public ArtigoJedisDao() {
		pool = new JedisPool(new JedisPoolConfig(), "localhost");
		jedis = pool.getResource();
		// cont = 0;
	}

	@Override
	public void inserir(Artigo artigo) {
		Long cont = this.jedis.incr("contatorRegistros");
		// this.cont++;
		List<String> lista = artigo.getTags();
		Map<String, String> hash = new HashMap<String, String>();
		hash.put("id", "" + cont + "");
		hash.put("name", artigo.getNome());
		hash.put("file", artigo.getArquivo());
		hash.put("desc", artigo.getDescricao());
		this.jedis.hmset("art:" + cont, hash);

		for (String tag : lista) {
			this.jedis.sadd("art:" + cont + ":tags", tag);
			this.jedis.sadd("all:tag", tag);
			this.jedis.sadd("tags:art:" + tag, "" + cont + "");
		}

		this.jedis.sadd("all:art", "" + cont + "");
	}

	@Override
	public List<Artigo> getLista() {
		List<Artigo> artigos = new ArrayList<Artigo>();
		Artigo a = null;
		int tamanho = Integer.parseInt(this.jedis.get("contatorRegistros"));
		for (int i = 1; i <= tamanho; i++) {
			Map<String, String> map = this.jedis.hgetAll("art:" + i);

			a = new Artigo(map.get("id"), map.get("desc"), map.get("name"), map.get("file"));
			artigos.add(a);

		}
		return artigos;

	}

	@Override
	public List<String> getTags(Long id) {
		List<String> lista = new ArrayList<String>();
		Set<String> set = this.jedis.smembers("art:" + id + ":tags");

		for (String s : set) {
			lista.add(s);
		}

		return lista;
	}

	@Override
	public List<String> getArtigosTag(String tag) {
		List<String> lista = new ArrayList<String>();

		Set<String> set = this.jedis.smembers("tags:art:" + tag);

		for (String s : set) {
			lista.add(s);
		}
		return lista;
	}

	@Override
	public List<String> getAllTags() {

		List<String> lista = new ArrayList<String>();

		Set<String> set = this.jedis.smembers("all:tag");

		for (String s : set) {
			lista.add(s);
		}
		return lista;
	}

}
