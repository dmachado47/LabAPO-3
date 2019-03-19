public class Veterinary {

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
		rooms = new Miniroom[8];
	}	
}