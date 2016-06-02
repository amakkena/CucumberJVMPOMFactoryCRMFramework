package basemodule.stepdefinitions;

import java.io.IOException;

import pageobjects.LoginPage;
import cucumber.api.java.en.Given;

public class SimpleTest {
	LoginPage login = new LoginPage();
	
	@Given("This is simple given step")
	public void sampleTest() throws Exception{
		login.loginApplication();
	}

}
