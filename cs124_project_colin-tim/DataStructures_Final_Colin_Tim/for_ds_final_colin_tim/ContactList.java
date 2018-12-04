package for_ds_final_colin_tim;

import java.util.*;

// Tim: first review of contactlist written by Colin. Looking good.
//List of all the different contacts
public class ContactList {

	static HashMap<String, Contact> contactListByName;
	static HashMap<String, Contact> contactListByNumber;	

	//add another implementation of the contactlist with the custom separateChain class

	public ContactList() {
		contactListByName = new HashMap<>();
		contactListByNumber = new HashMap<>();
	}//0 parameter contructor

	private int size = 0;//Size of the entire contact list

	public Contact findByName(String theName) { //Should have runtime of Theta(1)
		Contact contact = contactListByName.get(theName);
		return contact;
	}

	public Contact findByNumber(String theNumber) {//Should have runtime of Theta(1)
		Contact namefind = contactListByNumber.get(theNumber);
		return namefind;
	}

	public boolean deleteByNumber(String theNumber) {
		Contact contact = contactListByNumber.get(theNumber);
		if (contact==null) return false;
		contactListByNumber.remove(theNumber);
		contactListByName.remove(contact.getName());
		return true;
	}

	public boolean deleteByName(String theName) {
		Contact contact = contactListByNumber.get(theName);
		if (contact==null) return false;
		contactListByNumber.remove(theName);
		contactListByName.remove(contact.getNumber());
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
		for (Object contact : contactListByName.values()) {
			System.out.println(contact);
		}
	}

	public static void main(String[] args) {
		ContactList ourList = new ContactList();
		ourList.insert("Captain Falcon", "1234567890");
		ourList.insert("Gary", "0987654321");

		System.out.println(" " + ourList.contactListByName.get("Gary"));
		System.out.println(" " + ourList.contactListByName.get("Jon"));
		System.out.println(" " + ourList.contactListByNumber.get("0987654321"));
		
		System.out.println("" + ourList.deleteByName("Gary"));
		ourList.deleteByNumber("" + ourList.deleteByNumber("1234567890"));
		System.out.println("" + ourList.deleteByName("Gary"));
	}
}
