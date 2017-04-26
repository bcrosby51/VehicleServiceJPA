package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.ListVehicles;

public class UpdateListItem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("OnlineShoppingListJPA");
		
		EntityManager em = emfactory.createEntityManager();
		
		em.getTransaction().begin();
		
		ListVehicles toUpdate = em.find(ListVehicles.class, 4);
		System.out.println(toUpdate.toString());
		toUpdate.setItem("Trix Cereal");
		
		em.getTransaction().commit();
		
		em.close();
		emfactory.close();
	}

}
