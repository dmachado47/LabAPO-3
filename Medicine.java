

public class Medicine{
	
	//Atributos
	private String drugName;
	private double dose;
	private double doseCost;	
	private int doseFrequency;
	
	
	public Medicine(String xdrugName, double xdose, double xdoseCost, int xdoseFrequency) {
	
		drugName = xdrugName;
		dose = xdose;
		doseCost = xdoseCost;
		doseFrequency = xdoseFrequency;
		
	}
	
	//getters 
	
	public String getdrugName(){
		return drugName;
	}
	public double getdose(){
		return dose;
	}
	public double getdoseCost(){
		return doseCost;
	}
	public int getdoseFrequency(){
		return doseFrequency;
	}
	
	//setters
	
	public void setdrugName (String xdrugName){
		drugName = xdrugName;
	}
	public void setdose (double xdose){
		dose = xdoseCost;
	}
	public void setdoseCost (double xdoseCost){
		doseCost = xdoseCost;
	}
	public void setdoseFrequency (int xdoseFrequency){
		doseFrequency = xdoseFrequency
	}
}