package for_ds_final_colin_tim;
// Tim: will add testing later
//Tests to check that the other 2 classes work properly


import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class ContactListTest {
	// may need to provide type parameters for ContactList
	// depending on how it is defined
	private ContactList contactListTest;
	@Before
	public void setUp() throws Exception {
		contactListTest = new ContactList();
		contactListTest.insert("User 1", "123-456-7890");
		contactListTest.insert("User 2", "123-456-7891");
		contactListTest.insert("Alice", "1154059534");
		contactListTest.insert("Betty", "2154059534");
		contactListTest.insert("Clara", "3154059534");
		contactListTest.insert("Diann", "4154059534");


	}
	
	@Test
	public void testFindByName () {
		
		// we have several lines below that result in test's failure, which we added to test abnormal user behavior. 
		// if you comment out lines 41, 43, 44, the test results in proper run.  
		
		Contact contactTest = contactListTest.findByName("Nobody");
		Contact contactTest1 = contactListTest.findByName("Alice");
		Contact contactTest2 = contactListTest.findByName("Diann");
		assertNotNull(contactTest1);
		assertNotNull(contactTest1);
		assertNotNull(contactTest2);
		
		assertEquals("Alice", contactTest1.getNumber());
		assertEquals("Alice", contactTest1.getName());
		assertEquals("2154059534", contactTest1.getName());
		assertEquals("2154059534", contactTest1.getNumber());
		contactListTest.deleteByName("Alice");
		assertEquals("Alice", contactTest1.getName());
		assertNull(contactListTest.findByName("User X"));
	}
	
}
