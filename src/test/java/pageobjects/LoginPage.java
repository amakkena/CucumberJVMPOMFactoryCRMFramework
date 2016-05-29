package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basemodule.HooksClass;



public class LoginPage extends HooksClass{
	
	public String appURL = "http://127.0.0.1:9090/espocrm/";
	
	@FindBy(id="field-userName") WebElement loginUsername;
	@FindBy(id="field-password") WebElement loginPassword;
	@FindBy(id="btn-login") WebElement loginBtn;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void loginApplication(){
		driver.get(appURL);
		loginUsername.sendKeys("nmakkena");
		loginPassword.sendKeys("naren1306");
		loginBtn.click();
	}
	
	

}
