package com.algaworks.pedidovenda.util.jpa;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManagerProducer {
	
	EntityManagerFactory managerFactory;

	public EntityManagerProducer() {
		this.managerFactory =  Persistence.createEntityManagerFactory("PedidoPU");
	}
	
	
	@Produces @RequestScoped
	public EntityManager createEntityManager() {
		return this.managerFactory.createEntityManager();
	}
	
	public void closeEntityManager(@Disposes EntityManager manager) {
		manager.close();
	}
	
	

}
