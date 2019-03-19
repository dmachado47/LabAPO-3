

public class clinicHistory{
	
	//Constantes
	public final static int ABIERTA = 1;
	public final static int CERRADA = 0;
	
	//Atributos
	private int status;
	private String ingressDate;
	private String symptoms;
	private String diagnostic;
	
	public clinicHistory(int status, String xingressDate, String xsymptoms, String xdiagnostic){
	
		status = xstatus;
		ingressDate = xingressDate; 
		symptoms = xsymptoms;
		diagnostic = xdiagnostic;
	}
	
	//getters
	
	public int getstatus(){
		return status;
	}
	public String getingressDate(){
		return ingressDate;
	}
	public String getsymptoms(){
		return symptoms;
	}
	public String getdiagnostic(){
		return diagnostic;
	}
	
	//setters
	
	public void setstatus (int xstatus){
		status = xstatus;
	}
	public void setingressDate (String xingressDate){
		ingressDate = xingressDate;
	}
	public void setsymptoms (String xsymptoms){
		symptoms = xsymptoms;
	}
	public void setdiagnostic (String xdiagnostic){
		diagnostic = xdiagnostic;
	} 









}