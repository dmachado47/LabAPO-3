

public class User{
	
	//Atributos
	private String userName;
	private int idNumber;
	private String address;
	private int phoneNumber;
	
	
	public User(String xuserName, int xidNumber, String xAddress, int xphoneNumber){
	
		userName = xuserName;
		idNumber = xidNumber;
		address = xAddress;
		phoneNumber = xphoneNumber;
		
	}
	
	//getters
	public String getuserName(){
		return userName;
	}
	public int getidNumber(){
		return idNumber;
	}
	public String getAddress(){
		return address;
	}
	public int getphoneNumber(){
		return phoneNumber;
	}
	
	//setters
	 
	 public void setuserName (String xuserName){
		 userName = xuserName;
	 }
	 public void setidNumber (int xidNumber){
		 idNumber = xidNumber;
	 }
	 public void setAddress (String xAddress){
		 address = xAddress;
	 }
	 public void setphoneNumber (int xphoneNumber){
		 phoneNumber = xphoneNumber;
	 }
	 
	 
}