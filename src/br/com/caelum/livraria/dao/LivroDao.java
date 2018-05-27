package br.com.caelum.livraria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Livro;

@Stateless
public class LivroDao {
	
	@PersistenceContext
	private EntityManager entityManager;

//	@Inject
//	private Banco banco;
	
	public void salva(Livro livro) {
		entityManager.persist(livro);
	}
	
	public List<Livro> todosLivros() {
		return entityManager.createQuery("select l from Livro l", Livro.class).getResultList();
	}
	
}
