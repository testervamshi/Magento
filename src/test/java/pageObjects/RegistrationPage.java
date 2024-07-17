package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{

	public RegistrationPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy (xpath="//input[@id='firstname']")
	WebElement txt_firstname;
	
	@FindBy (xpath="//input[@id='lastname']")
	WebElement txt_lastname;
	
	@FindBy (xpath="//input[@id='email_address']")
	WebElement txt_email;
	
	@FindBy (xpath="//input[@id='password']")
	WebElement txt_password;
	
	@FindBy (xpath="//input[@id='password-confirmation']")
	WebElement txt_CnfPassword;
	
	@FindBy (xpath="//button[@title='Create an Account']")
	WebElement btn_register;
	
	public void setFirstname(String fname) {
		txt_firstname.sendKeys(fname);
	}
	
	public void setLastname(String lname) {
		txt_lastname.sendKeys(lname);
	}
	
	public void setEmail(String mail) {
		txt_lastname.sendKeys(mail);
	}
	
	public void setPassword(String pwd) {
		txt_password.sendKeys(pwd);
	}
	
	public void setCnfPassword(String cnfpwd) {
		txt_CnfPassword.sendKeys(cnfpwd);
	}
	
	public void clickRegister() {
		btn_register.click();
	}

}
