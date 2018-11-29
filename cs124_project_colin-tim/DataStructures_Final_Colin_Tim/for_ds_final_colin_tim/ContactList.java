package for_ds_final_colin_tim;

import java.util.*;

//List of all the different contacts
public class ContactList {

	static HashMap<String, Contact> contactListByName = new HashMap<>();
	static HashMap<String, Contact> contactListByNumber = new HashMap<>();	
	
	public ContactList() {
		
	}//No parameter contructor
	
	private int size = 0;//Size of the entire contact list
	
	public Contact findByName() {//Should have runtime of Theta(1)
		return null;
	}
	
	public Contact findByNumber() {//Should have runtime of Theta(1)
		return null;
	}
	
	public boolean delete() {
		return true;
	}
	
	public boolean insert(String theName, String theNumber) {//As of right now this doesn't check if the insert is succesful
		Contact toInsert = new Contact(theName, theNumber);
		contactListByName.put(toInsert.getName(), toInsert);
		contactListByNumber.put(toInsert.getNumber(), toInsert);
		return true;
	}

	public int size() {
		return size;
	}
	
	public void printAllContacts() {
		//Print all contacts to console. In what order?
	}
	
	public static void main(String[] args) {
		//We won't need this main method later, I'm just putting it in for fast testing
		ContactList ourList = new ContactList();
		ourList.insert("Captain Falcon", "1234567890");
		ourList.insert("Gary", "0987654321");
		
		System.out.println(" " + ourList.contactListByName.get("Gary").getNumber());
		System.out.println(" " + ourList.contactListByName.get("Jon"));
	}
}
