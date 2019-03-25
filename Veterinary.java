public class Veterinary {
	
	public static final int NUMBER_ROOMS = 8;

	private String name;
  
	private ArrayList<User> people;
	private ArrayList<ClinicHistory> histories;
	private ArrayList<Medicine> medicines;
	private Miniroom[] rooms;
	
	public Veterinary (String theName) {
		name = theName;
	
		people = new ArrayList<User>();
		histories = new ArrayList<ClinicHistory>();
		medicines = new ArrayList<Medicine>();
		rooms = new Miniroom[NUMBER_ROOMS];
	}
		//Registar usuario 
	public void registerUser (String xuserName, int xidNumber, String xAddress, int xphoneNumber){
		User client = new User (xuserName,xidNumber,xAddress,xphoneNumber);
		people.add(client);
	}
		//Buscar usuario
	public User searchUser(int xid){
		User searching = null;
		int numberUsers = people.size();
		for (int j=0; j<numberUsers; j++){
			int idSearch = people.get(j).getidNumber(); 
			if (xid == idSearch){
				searching = people.get(j);
			}
		}
		return searching;
	}
		//Registrar mascota 
	public boolean registerPet(String xpetName, String xanimalType, int xage, double xweight, int xidOwner){
		boolean registered = false;
		Animal newPet = new Animal(xpetName, xanimalType, xage, xweight);
		User newOwner = searchUser(xid);
		if (newOwner != null){
			newOwner.getPets().add(newPet);
			registered = true;
		}
		return registered;
	}
		//Buscar disponiblidad en los minicuartos
	public Miniroom searchAvailable(){
		Miniroom available = null;
		for (int i=0; i<NUMBER_ROOMS; i++){
			if (rooms[i].getAnimal()==null){
				available = rooms[i];
			}
		}
		return available;
	}
		//Añadir mascota al minicuarto
	public boolean addPettoMiniroom(int xOwner, String xPet){
		boolean add = false;
		User u = searchUser(xOwner);
		if( u != null){
			Animal a = u.searchPet(xPet);
			if(a != null){
				Miniroom x = searchAvailable();
				if(x != null){
					x.setAnimal(a);
					add = true;
				}
			}
		}
		return add;
	}
	
	public Animal searchPet(String xName){
		Animal searching = null;
		int numberOwners = people.size();
		boolean found = false;
		for (int x=0; x<numberUsers && !found; x++){
			User temp = people.get(x);
			Animal a = temp.searchPet(xName);
			if (a.getName().equals(xName)){
				searching = a;
				found = true;
			}
		}
		return searching;
	}
	
		//
	public boolean hospitalize(int idOwner, String xPet, String xdate, String xsym, String xdiag, ArrayList<Medicine> xmed){
		boolean hospitalized = false;
		boolean petinMiniroom = addPettoMiniroom(idOwner, xPet);
		if(petinMiniroom){
			User owner = searchUser(idOwner);
			Animal a = owner.searchPet(xPet);
			ClinicHistory history = new ClinicHistory(ClinicHistory.ABIERTA, xdate, xsym, xdiag, a, owner, xmed);
			hospitalized = true;
		}
		return hospitalized;
	}
	
	public String generateHistoryReport(){
		String report = "";
		int numberHistory = histories.size();
		for(int i=0; i < numberHistory; i++){
			ClinicHistory temp = histories.get(i);
			report += "// ---------------------------------------- // \n";
			report += "Nombre Paciente: " + temp.getAnimalData().getpetName() + "\n";
			report += "Tipo de animal: " + temp.getAnimalData().getanimalType() + "\n";
			report += "Edad: " + temp.getAnimalData().getage() + " años \n";
			report += "Peso: " + temp.getAnimalData().getweight() + " Kg. \n \n";
			
			if(temp.getStatus()==ClinicHistory.ABIERTA){
				report += "Estado actual: Abierta \n";
			} else {
				report += "Estado actual: Cerrada \n";
			}
			
			// Date d = temp.getingressDate()";
			report += "Fecha de hospitalización: " + temp.getIngressDate() + "\n";
			report += "Síntomas: " + temp.getsymptoms() + "\n";
			report += "Diagnóstico: " + temp.getdiagnostic() + "\n \n";
			
			report += "Medicamentos recetados: " + temp.getsymptoms() + "\n";
			ArrayList<Medicine> m = temp.getmedicinesHistory();
			for (int j=0; j < m.size(); j++){
				String dn = m.get(i).getdrugName();
				int dose = m.get(i).getdose();
				double dcost = m.get(i).getdoseCost();
				int freq = m.get(i).getdoseFrequency();
				
				// Formato: "- Amoxicilina. Administrar 3 dosis cada 8 horas. Costo de la dosis: $60000."
				report += "- " + dn + ". Administrar " + dose + " dosis cada " + freq + " horas. Costo de la dosis: $" + dcost + ".\n"; 
			}
			report += "\n";
		}
		return report;	
	}
	
	public Animal searchAnimalByHistory(String xPetName){
		Animal animalHistory = null;
		boolean found = false;
		for (int z=0; z < histories.size() && !found; z++){
			String sName = histories.get(z).getpetName();
			if(sName.equals(xPetName)){
				animalHistory = histories.get(z).getAnimalData();
				found = true;
			}
		}
		return animalHistory;
	}
	
	public double calculateCostAnimalType(String type, double weight){
		double c = 0.0;
		if (type.equals(Animal.CAT)) {
			if (weight >= 1.0 && weight <= 3.0){
				c = 10000.0;
			} else if (weight > 3.0 && weight <= 10.0) {
				c = 12000.0; 
			} else if (weight > 10.0 && weight <= 20.0) {
				c = 15000.0;
			} else if (weight > 20.0) {
				c = 20000.0;
			}
		} else if (type.equals(Animal.DOG)) {
			if (weight >= 1.0 && weight <= 3.0){
				c = 15000.0;
			} else if (weight > 3.0 && weight <= 10.0) {
				c = 17000.0;
			} else if (weight > 10.0 && weight <= 20.0) {
				c = 20000.0;
			} else if (weight > 20.0) {
				c = 25000.0;
			}
		} else if (type.equals(Animal.BIRD)) {
			if (weight >= 1.0 && weight <= 3.0){
				c = 10000.0;
			} else if (weight > 3.0 && weight <= 10.0) {
				c = 12000.0;
			} else if (weight > 10.0 && weight <= 20.0) {
				c = 20000.0;
			} else if (weight > 20.0) {
				c = 25000.0;
			}
		} else if (type.equals(Animal.OTHER)) {
			if (weight >= 1.0 && weight <= 3.0){
				c = 10000.0;
			} else if (weight > 3.0 && weight <= 10.0) {
				c = 17000.0;
			} else if (weight > 10.0 && weight <= 20.0) {
				c = 30000.0;
			} else if (weight > 20.0) {
				c = 33000.0;
			}
		}
		return c;
	}
	
	public double calculateHospitalizationCost(String animal){
		double cost = 0.0;
		Animal a = searchAnimalByHistory(animal);
		if (searchAnimalByHistory(animal) != null){
			String animalT = a.getanimalType();
			double animalW = a.getweight();
			double costType = calculateCostAnimalType(animalT, animalW);
			
			double historyCost = 0.0;
			for (int k=0; k)
		}
	}
}