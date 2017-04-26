package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.ServiceEntity;
import entities.VehicleEntity;

public class CreateVehicle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("OnlineShoppingListJPA");
		
		EntityManager em = emfactory.createEntityManager();
		
		em.getTransaction().begin();
		
		VehicleEntity toAdd = new VehicleEntity(null, "Subaru","Legacy", 2008);
		ServiceEntity toAdd2 = new ServiceEntity(null,"2017-04-15");
		
		em.persist(toAdd);
		
		em.getTransaction().commit();
		
		em.close();
		emfactory.close();
	}

}
