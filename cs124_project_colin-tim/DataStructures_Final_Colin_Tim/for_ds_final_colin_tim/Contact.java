package for_ds_final_colin_tim;

//Class for the unique person's contact info.
public class Contact {
	
	private String name, number, address, email, id;//Name and number are needed. I added the rest for if we have time for extra credit
	
	public Contact(String theName, String theNumber) {
		name = theName;
		number = theNumber;
	}//2 parameter constructor
	
	public String getName() {
		return name;
	}
	
	public String getNumber() {
		return number;
	}

}
