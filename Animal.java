

public class Animal{
	
	//Constantes 
	public final static String DOG = "Dog";
	public final static String CAT = "Cat";
	public final static String BIRD = "Bird";
	public final static String OTHER = "Other";
	
	//Atributos
	private String petName;
	private String animalType;
	private int age;
	private double weight;
	
	
	public Animal(String xpetName, String xanimalType, int xage, double xweight){
	
		petName = xpetName;
		animalType = xanimalType;
		age = xage;
		weight = xweight;
	}
	
	//getters
	
	public String getpetName(){
		return petName;
	}
	public String getanimalType(){
		return animalType;
	}
	public int getage(){
		return age;
	}
	public double getweight(){
		return weight;
	}
	
	//setters
	
	public void setpetName (String xpetName){
		petName = xpetName;
	}
	public void setanimalType (String xanimalType){
		animalType = xanimalType;
	}
	public void setage (int xage){
		age = xage;
	}
	public void setweight (double xweight){
		weight = xweight;
	}
	
}