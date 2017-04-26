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

public class VehicleServiceDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("OnlineShoppingListJPA");
		EntityManager em = emfactory.createEntityManager();
		
		int menuChoice = 0;
		
		Scanner input = new Scanner(System.in);
		
		em.getTransaction().begin();
		
		clearConsole();
		
		while (menuChoice != 6){
			menuChoice = Menu(input);
			switch (menuChoice){
				case 1:
					listVehicles(em,input);
					break;
				case 2:
					addVehicle(em,input);
					break;
				case 3:
					deleteVehicle(em,input);
					break;
				case 4:
					updateService(em,input);
					break;
				case 5:
					deleteService(em,input);
					break;
			}
		}
	
		input.close();
		em.close();
		emfactory.close();
	}

	private static void deleteService(EntityManager em, Scanner input) {
		// TODO Auto-generated method stub
		
	}

	private static void updateService(EntityManager em, Scanner input) {
		// TODO Auto-generated method stub
		
	}

	private static void addVehicle(EntityManager em, Scanner input) {
		// TODO Auto-generated method stub
		
	}

	private static void deleteVehicle(EntityManager em, Scanner input) {
		// TODO Auto-generated method stub
		
		Query queryVehicle = em.createQuery("SELECT v FROM VehicleEntity AS v");
		
		for ( VehicleEntity ve : (List<VehicleEntity>)queryVehicle.getResultList()) {
		    System.out.println(ve.getVehicleID()+ ": " + ve.getYear() + " -- " + ve.getMake()+ " -- " + ve.getModel());
		}
		
		System.out.println("Enter number of vehicle to delete: ");
		int deleteChoice = input.nextInt();
		
		VehicleEntity toRemove = em.find(VehicleEntity.class, deleteChoice);
		
		System.out.println(toRemove);
		
		em.remove(toRemove);
		
		em.getTransaction().commit();
	}

	private static void listVehicles(EntityManager em, Scanner input) {		
		
		Query queryVehicle = em.createQuery("SELECT v FROM VehicleEntity AS v");
		System.out.println("------------------Vehicle List---------------");
		for ( VehicleEntity ve : (List<VehicleEntity>)queryVehicle.getResultList()) {
		    System.out.println("|" + ve.getVehicleID()+ "| " + ve.getYear() + " -- " + ve.getMake()+ " -- " + ve.getModel());
		    System.out.println("---------------------------------------------");
		}
		
		
		System.out.println("Enter number of vehicle to get service records for: ");
		int vehicleChoice = input.nextInt();
		System.out.println("----------------Service Records--------------");
		TypedQuery<ServiceEntity> queryService = em
				.createQuery(
						"SELECT DISTINCT service FROM VehicleEntity AS vehicle, ServiceEntity as service "
								+ "WHERE vehicle.vehicleID=:name " + "AND service.vehicle = vehicle",
						ServiceEntity.class);
		queryService.setParameter("name", vehicleChoice);
		
		for (ServiceEntity se : (List<ServiceEntity>) queryService.getResultList()) {
			System.out.println("|" + se.getIdservice() + "| " +se.getService_Performed() + ": " + se.getDate_Service_Performed());
			System.out.println("---------------------------------------------");
		}
		
		System.out.println("");
	}

	private static int Menu(Scanner input) {
		// TODO Auto-generated method stub
		
		String menuHeading = "Please enter menu choice: ";
		String menuVehList = "1 - List Vehicles";
		String menuVehAdd = "2 - Add Vehicle";
		String menuVehDel = "3 - Delete Vehicle";		
		String menuUpdate = "4 - Update Service";
		String menuDelete = "5 - Delete Service";
		String menuExit = "6 - Exit";
		
		System.out.println(menuHeading);
		System.out.println(menuVehList);
		System.out.println(menuVehAdd);
		System.out.println(menuVehDel);
		System.out.println(menuUpdate);
		System.out.println(menuDelete);
		System.out.println(menuExit);	
		System.out.println();
		
		int menuChoice = input.nextInt();
		return menuChoice;
		
	}

	public static void clearConsole() {
		for(int i = 0; i < 10; i++)
		{
		    System.out.println("");
		}
	}
}
