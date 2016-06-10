package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import basemodule.BaseClass;

public class LoginPage extends BaseClass{
	
	public String appURL = "http://127.0.0.1:9090/espocrm/";
	
	@FindBy(id="field-userName") WebElement loginUsername;
	@FindBy(id="field-password") WebElement loginPassword;
	@FindBy(id="btn-login") WebElement loginBtn;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void launchURL(String appURL) throws Exception{
		driver.get(appURL);
		reportResult("Verifying applicaiton is launched successfully", loginUsername.isDisplayed(), true);
	}
	
	public HomePage loginApplication(){		
		loginUsername.sendKeys("XXXXXX");
		loginPassword.sendKeys("XXXXXXXXXX");
		loginBtn.click();
		return new HomePage();
	}
	
	

}
