package for_ds_final_colin_tim;

//Class for the unique person's contact info.
public class Contact {
	
	private String name, number, address, email;//Name and number are needed. I added the rest for if we have time for extra credit
	
	public Contact(String theName, String theNumber) {
		name = theName;
		number = theNumber;
		address = "";
		email = "";
	}//2 parameter constructor
	
	public Contact(String theName, String theNumber, String theAddress, String theEmail) {
		name = theName;
		number = theNumber;
		address = theAddress;
		email = theEmail;
	}//2 parameter constructor
	
	public String getName() {
		return name;
	}
	
	public String getNumber() {
		return number;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getEmail() {
		return email;
	}
}
