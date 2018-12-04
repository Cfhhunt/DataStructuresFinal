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
}
@Test
public void testFindByName () {
Contact contactTest = contactListTest.findByName("User 1");
assertNotNull(contactTest);
assertEquals("User 1", contactTest.getName());
assertEquals("1234567890", contactTest.getNumber());
assertNull(contactListTest.findByName("User X");
}
// other tests to be included
}
