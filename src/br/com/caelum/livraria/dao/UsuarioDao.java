package br.com.caelum.livraria.dao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Usuario;

@Stateless
public class UsuarioDao {
	
//	@PersistenceContext
//	private EntityManager entityManager;

	@Inject
	private Banco banco;

	public Usuario buscaPeloLogin(String login) {
		return this.banco.buscaPeloNome(login);
	}
	
//	public Usuario buscaPeloLogin(String login){
//		return this.entityManager.find(Usuario.class, login);
//	}
}
