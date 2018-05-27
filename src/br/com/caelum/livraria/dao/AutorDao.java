package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import br.com.caelum.livraria.interceptador.LogInterceptador;
import br.com.caelum.livraria.modelo.Autor;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
//@Interceptors({LogInterceptador.class})
public class AutorDao {

	@PersistenceContext
	private EntityManager entityManager;

	// gerenciamento manual de transações
	// @Inject
	// private UserTransaction tx;

	@PostConstruct
	void aposCriacao() {
		System.out.println("autorDAO foi criado");
	}

	// Solicita uma transação ativa para efetuar a operação
	@TransactionAttribute(TransactionAttributeType.MANDATORY) // Mandatory = obrigatoriedade da existencia de uma transação feita pela camada anterior = AutorService
	public void salva(Autor autor) {
		
		long millis = System.currentTimeMillis();
		System.out.println("salvando autor " + autor.getNome());

		entityManager.persist(autor);
		
		System.out.println("salvou autor " + autor.getNome());
	}

	public List<Autor> todosAutores() {
		return entityManager.createQuery("select a from Autor a", Autor.class).getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
		Autor autor = entityManager.find(Autor.class, autorId);
		return autor;
	}

}
