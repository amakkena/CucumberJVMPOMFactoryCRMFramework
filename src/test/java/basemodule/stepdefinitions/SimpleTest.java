package basemodule.stepdefinitions;

import pageobjects.LoginPage;
import cucumber.api.java.en.Given;

public class SimpleTest {
	LoginPage login = new LoginPage();
	
	@Given("This is simple given step")
	public void sampleTest(){
		login.loginApplication();
	}

}
