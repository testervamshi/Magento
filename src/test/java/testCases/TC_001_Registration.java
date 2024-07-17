package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC_001_Registration extends BaseClass{
	@Test
	public void AccountRegistration() {
		HomePage hp=new HomePage(driver);
		hp.clickAccount();
		logger.info("*******clicked on create account*********");
		RegistrationPage rp=new RegistrationPage(driver);
		rp.setFirstname(RB.getString("firstname"));
		logger.info("*******Entered firstname*********");
		rp.setLastname(RB.getString("lastname"));
		logger.info("*******entered lastname*********");
		rp.setEmail(RB.getString("email"));
		logger.info("*******entered email*********");
		rp.setPassword(RB.getString("password"));
		logger.info("*******entered password*********");
		rp.setCnfPassword(RB.getString("Cnfpassword"));
		logger.info("*******entered cnfpassword*********");
		rp.clickRegister();
		logger.info("*******clicked on register*********");
	}

}
