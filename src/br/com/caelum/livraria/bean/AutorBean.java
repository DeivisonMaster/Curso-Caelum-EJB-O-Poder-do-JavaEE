package br.com.caelum.livraria.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.service.AutorService;

@Named
@RequestScoped
public class AutorBean {
	
	private Autor autor = new Autor();
	
	@Inject
	private AutorService dao;
	
	public Autor getAutor() {
		return autor;
	}
	
	public void cadastra() {
		this.dao.adiciona(autor);
		this.autor = new Autor();
	}
	
	public List<Autor> getAutores() {
		return this.dao.todosAutores();
	}
}