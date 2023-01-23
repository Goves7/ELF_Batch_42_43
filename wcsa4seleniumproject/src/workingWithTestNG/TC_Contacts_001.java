package workingWithTestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_Contacts_001 {
	
	@Test
	public void createContact(){
		Reporter.log("FROM CREATE CONTACT", true);
	}
	@Test
	public void addContact(){
		Reporter.log("FROM ADD CONTACT", true);
	}
	@Test
	public void deleteContact(){
		Reporter.log("FROM DELETE CONTACT", true);
	}
	@Test
	public void removeContact(){
		Reporter.log("FROM REMOVE CONTACT", true);
	}
	@Test
	public void editContact(){
		Reporter.log("FROM EDIT CONTACT", true);
	}
	@Test
	public void modifyContact(){
		Reporter.log("FROM modify CONTACT", true);
	}

}
