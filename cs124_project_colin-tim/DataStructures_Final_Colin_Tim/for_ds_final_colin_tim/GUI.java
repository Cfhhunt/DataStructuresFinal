package for_ds_final_colin_tim;

// Tim reviewed the code

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//This GUI uses the Separate Chaining class to store user inputs in the contact list.
public class GUI extends JFrame {

	private JTextField searchTF, nameTF, numberTF, emailTF, addressTF;
	private JLabel nameL, numberL, searchL, outputL, emailL, addressL;
	private JTextArea outputTA;
	private JButton addB, deleteB, searchB, printB, editB;
	private Container myCP;
	private Color myColor = new Color(150, 225, 225);
	private SeparateChainingHashTable myContactList;
	private Contact currentContact = null;

	public GUI() {		

		super("Contact List");
		setSize(800, 1100);
		setLocation(100, 100);
		myCP = getContentPane();
		myCP.setLayout(null);
		myCP.setBackground(myColor);
		myCP.setForeground(Color.BLACK);

		myContactList = new SeparateChainingHashTable();
		myContactList.insert("Alan", "1234567890", "Something something, Blechly Park, UK", "alan@turinginstitute.uk");

		// Search Bar
		searchL = new JLabel("Search");
		searchL.setOpaque(true);
		searchL.setBackground(myColor);
		searchL.setForeground(Color.BLACK);
		searchL.setSize(100, 30);
		searchL.setLocation(10,10);
		myCP.add(searchL);

		searchTF = new JTextField("");
		searchTF.setEditable(true);
		searchTF.setSize(300, 30);
		searchTF.setLocation(10, 50);
		searchTF.addActionListener(new SearchTFHandler());
		myCP.add(searchTF);

		//search button
		searchB = new JButton("Search");
		searchB.setOpaque(true);
		searchB.setSize(150, 30);
		searchB.setLocation(350, 50);
		searchB.addActionListener(new SearchTFHandler());
		myCP.add(searchB);

		//add button
		addB = new JButton("Add to database");
		addB.setOpaque(true);
		addB.setSize(150, 30);
		addB.setLocation(350, 100);
		addB.addActionListener(new AddBHandler());
		myCP.add(addB);

		//delete button
		deleteB = new JButton("Delete the contact");
		deleteB.setOpaque(true);
		deleteB.setSize(150, 30);
		deleteB.setLocation(350, 150);
		deleteB.addActionListener(new DeleteBHandler());
		myCP.add(deleteB);

		printB = new JButton("Print all contacts");
		printB.setOpaque(true);
		printB.setSize(150, 30);
		printB.setLocation(350, 200);
		printB.addActionListener(new PrintBHandler());
		myCP.add(printB);

		//edit button
		editB = new JButton("Edit selected contact");
		editB.setOpaque(true);
		editB.setSize(150, 30);
		editB.setLocation(350, 250);
		editB.addActionListener(new EditBHandler());
		myCP.add(editB);

		// Name
		nameL = new JLabel("Name");
		nameL.setOpaque(true);
		nameL.setBackground(myColor);
		nameL.setForeground(Color.BLACK);
		nameL.setSize(100, 30);
		nameL.setLocation(10,100);
		myCP.add(nameL);

		nameTF = new JTextField("");
		nameTF.setEditable(true);
		nameTF.setSize(300, 30);
		nameTF.setLocation(10, 150);
		myCP.add(nameTF);

		// Number(s) 
		numberL = new JLabel("Number");
		numberL.setOpaque(true);
		numberL.setBackground(myColor);
		numberL.setForeground(Color.BLACK);
		numberL.setSize(100, 30);
		numberL.setLocation(10,200);
		myCP.add(numberL);

		numberTF = new JTextField("");
		numberTF.setEditable(true);
		numberTF.setSize(300, 30);
		numberTF.setLocation(10, 250);
		myCP.add(numberTF);

		// email
		emailL = new JLabel("Email");
		emailL.setOpaque(true);
		emailL.setBackground(myColor);
		emailL.setForeground(Color.BLACK);
		emailL.setSize(100, 30);
		emailL.setLocation(10,300);
		myCP.add(emailL);

		emailTF = new JTextField("");
		emailTF.setEditable(true);
		emailTF.setSize(300, 30);
		emailTF.setLocation(10, 350);
		myCP.add(emailTF);

		// address
		addressL = new JLabel("Address");
		addressL.setOpaque(true);
		addressL.setBackground(myColor);
		addressL.setForeground(Color.BLACK);
		addressL.setSize(100, 30);
		addressL.setLocation(10,400);
		myCP.add(addressL);

		addressTF = new JTextField("");
		addressTF.setEditable(true);
		addressTF.setSize(300, 30);
		addressTF.setLocation(10, 450);
		myCP.add(addressTF);

		// output results	
		outputL = new JLabel("Contacts");
		outputL.setOpaque(true);
		outputL.setBackground(myColor);
		outputL.setSize(100, 30);
		outputL.setLocation(10, 500);
		myCP.add(outputL);

		outputTA = new JTextArea("");
		outputTA.setEditable(false);
		outputTA.setBackground(Color.white);
		outputTA.setSize(300, 400);
		outputTA.setLocation(10, 550);
		myCP.add(outputTA);

		setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}//GUI constructor

	public void clearAll() {
		nameTF.setText("");
		numberTF.setText("");
		outputTA.setText("");
		emailTF.setText("");
		addressTF.setText("");
	}

	public boolean userInputsValid() {
		String num = numberTF.getText();
		num = num.replaceAll("[^0-9]", "");
		if (num.length()!=10) { 
			outputTA.setText("Invalid number. Format: (123) 456-7890"); 
			return false;
		} else if (nameTF.getText().equals("") || numberTF.getText().equals("")) {
			outputTA.setText("Not valid, enter name and number");
			return false;
		} 
		return true;
	}

	public Contact extractContact() {
		return new Contact(nameTF.getText(), numberTF.getText().replaceAll("[^0-9]", ""), addressTF.getText(), emailTF.getText());
	}

	public class SearchTFHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Contact contact = myContactList.find(searchTF.getText());
			currentContact = contact;
			clearAll();
			if (contact == null) {
				outputTA.setText("Not Found");
			} else {
				nameTF.setText(contact.getName());
				numberTF.setText(contact.getNumber());
				addressTF.setText(contact.getAddress());
				emailTF.setText(contact.getEmail());
			}
		}
	}//SearchTFHandler

	public class AddBHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (userInputsValid() && myContactList.insert((extractContact()))) {
				outputTA.setText("Successfully added");
			}
		}
	}//AddBHandler

	public class DeleteBHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(myContactList.delete(searchTF.getText())) {
				clearAll();
				outputTA.setText("Delete successful");
			} else {outputTA.setText("Delete Unsuccesful");}
		}
	}//DeleteBHandler

	public class PrintBHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			clearAll();
			outputTA.setText(myContactList.printAllContacts());
		}
	}//PrintBHandler

	public class EditBHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(userInputsValid() && myContactList.edit(searchTF.getText(), extractContact())) {
				outputTA.setText("Edit successful");
				searchTF.setText("");
			} else {outputTA.setText("Edit unsuccessful");}
		}
	}//PrintBHandler

	public static void main(String[] args) {
		GUI myAppF = new GUI();
	}//main

}//GUI
