package basemodule.stepdefinitions;

import pageobjects.AdministrationPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import basemodule.UtilClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class UserManagement_Steps extends UtilClass{
	LoginPage login = new LoginPage();
	HomePage homePage;
	AdministrationPage adminstrationPage;
	
	@Given("User access crm application")
	public void accessCRMApplication() throws Exception{
		homePage=login.loginApplication();	
		waitFor(5);
		reportResult("Verify login is successful",homePage.isHomePageNavigationBarDisplayed(), true);		
	}
	
	@Then("Navigates to user creation page")
	public void navigationUserCreationPage(){
		adminstrationPage = homePage.navigateToAdministrationPage();
		reportResult("Navigation to user creation page", adminstrationPage.isAdministrationPageDisplayed(), true);
	}

}
