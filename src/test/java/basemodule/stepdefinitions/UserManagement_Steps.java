package basemodule.stepdefinitions;
import pageobjects.AdministrationPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import basemodule.actions.WebActions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class UserManagement_Steps extends WebActions{
	
	
	@Given("User access crm application")
	public void accessCRMApplication() throws Exception{
		LoginPage.loginCRMApplication();
	}
	
	@Then("Navigates to user creation page")
	public void navigationUserCreationPage(){
		HomePage.navigateToAdministrationPage();
		AdministrationPage.navigateUsersPage();
		
		
	}

}
