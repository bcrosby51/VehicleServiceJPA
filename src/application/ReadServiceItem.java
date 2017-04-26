package application;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entities.ServiceEntity;
import entities.VehicleEntity;

public class ReadServiceItem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("OnlineShoppingListJPA");
		
		EntityManager em = emfactory.createEntityManager();
		
		em.getTransaction().begin();
		
		Scanner in = new Scanner(System.in);
		//System.out.println("Enter a vehicle make: ");
		//String selectedMake = in.nextLine();
		/*TypedQuery<ServiceEntity> query =
			    em.createQuery("SELECT service FROM VehicleEntity AS vehicle, ServiceEntity as service " +
			    "WHERE vehicle.make=:make " +
			    "AND service.vehicle = vehicle", ServiceEntity.class);	*/	
		Query query = em.createQuery("SELECT v FROM VehicleEntity AS v");
		for ( VehicleEntity ve : (List<VehicleEntity>)query.getResultList()) {
		    System.out.println(ve.getVehicleID()+ ": " + ve.getMake() );
		}
		
		em.close();
		emfactory.close();
	}

}
