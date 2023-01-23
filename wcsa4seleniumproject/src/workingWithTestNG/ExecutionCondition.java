package workingWithTestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class ExecutionCondition {
     
	@Test(dependsOnMethods = "register")
	 public void createAccount() {
		 Reporter.log("From Create Account", true);
	 }
      
      @Test(dependsOnMethods = {"register","createAccount"})
 	 public void modifyAccount() {
 		 Reporter.log("From Modify Account", true);
 	 }
      
      @Test
 	 public void register() {
 		 Reporter.log("From Register", true);
 	 }
      
      @Test(dependsOnMethods = "createAccount")
 	 public void amountTransfer() {
 		 Reporter.log("From Amount Transfer", true);
 	 }
      
      @Test(dependsOnMethods = {"createAccount","modifyAccount"})
 	 public void deleteAccount() {
 		 Reporter.log("From Create Account", true);
 	 }
}
