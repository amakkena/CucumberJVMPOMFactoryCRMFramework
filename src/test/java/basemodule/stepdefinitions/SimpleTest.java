package basemodule.stepdefinitions;

import basemodule.UtilClass;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import cucumber.api.java.en.Given;

public class SimpleTest extends UtilClass{
	LoginPage login = new LoginPage();
	HomePage homePage;
	
	
	@Given("This is simple given step")
	public void sampleTest() throws Exception{
		homePage=login.loginApplication();	
		waitFor(5);
		reportResult("Verify login is successful",homePage.isHomePageNavigationBarDisplayed(), true);
		
	}

}
