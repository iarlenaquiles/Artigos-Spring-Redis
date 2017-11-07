package com.br.quixada.lista10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.br.quixada.lista10.dao.ArtigoJedisDao;
import com.br.quixada.lista10.model.Artigo;

@Controller
public class ArtigoController {

	@Autowired
	ArtigoJedisDao dao;
 
	@GetMapping("/artigos")
	public String home(Model model) {
		List<Artigo> lista = dao.getLista();
		model.addAttribute("artigos", lista);
		return "lista-artigos";
	}

	@RequestMapping("/")
	public String homeRequest(Model model) {
		List<Artigo> lista = dao.getLista();
		model.addAttribute("artigos", lista);
		return "lista-artigos";
	}

	@GetMapping("/artigos/add")
	public String insereForm(Model model) {
		model.addAttribute("artigo", new Artigo());
		model.addAttribute("acao", "/artigos");
		return "inserir-artigo";
	}

	@PostMapping("/artigos")
	public String addArtigo(Artigo artigo, Model model, RedirectAttributes redirect, BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("artigo", artigo);
			model.addAttribute("acao", "/artigos");

			return "inserir-livros";

		}

		dao.inserir(artigo);
		redirect.addFlashAttribute("mensagem", "Artigo inserido com sucesso!");

		return "redirect:/artigos";
	}
	
	@RequestMapping("/artigos/{id}/tags")
	public String tagsForm(@PathVariable String id, Model model) {
		List<String> lista = dao.getTags(Long.parseLong(id));
		model.addAttribute("tags", lista);
		return "lista-tags";
	}

	@RequestMapping("/artigos/{tag}")
	public String artigosTagsForm(@PathVariable String tag, Model model) {
		List<String> lista = dao.getArtigosTag(tag);
		model.addAttribute("artigos", lista);
		return "lista-artigos-tags";
	}
	
	@RequestMapping("/tags")
	public String getTags(Model model){
		List<String> lista = dao.getAllTags();
		model.addAttribute("tags", lista);
		return "lista-all-tags";
	}
}
