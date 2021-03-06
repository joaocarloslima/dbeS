package br.com.fiap.progamer.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.progamer.model.Setup;

public class SetupDao {

	@Inject
	private EntityManager manager;

	public void create(Setup setup) {

		manager.getTransaction().begin();
		manager.persist(setup);
		manager.getTransaction().commit();

		manager.clear();
	}

	public List<Setup> listAll() {
		TypedQuery<Setup> query = manager.createQuery("SELECT s FROM Setup s", Setup.class);
		return query.getResultList();
	}

	public void delete(Setup setup) {
		manager.getTransaction().begin();
		manager.remove(setup);		
		manager.getTransaction().commit();
	}

	public void update(Setup setup) {
		manager.getTransaction().begin();
		
		System.out.println(setup);
		
		manager.merge(setup);
		
		manager.getTransaction().commit();
		
	}

}
