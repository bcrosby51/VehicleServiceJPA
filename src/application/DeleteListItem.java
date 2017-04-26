package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.ListVehicles;
import entities.ServiceEntity;

public class DeleteListItem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("OnlineShoppingListJPA");
		
		EntityManager em = emfactory.createEntityManager();
		
		em.getTransaction().begin();
		
		ServiceEntity toRemove = em.find(ServiceEntity.class, 2);
		
		System.out.println(toRemove);
		
		em.remove(toRemove);
		
		em.getTransaction().commit();
		em.close();
		emfactory.close();
	}

}
