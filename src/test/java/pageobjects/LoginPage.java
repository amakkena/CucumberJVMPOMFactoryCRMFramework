package pageobjects;

import basemodule.actions.WebActions;
public class LoginPage extends WebActions{
	
	public static String loginUsername = "//*[@id='field-userName']";
	public static String loginPassword = "//*[@id='field-password']";
	public static String signinButton = "//*[@id='btn-login']";

	public static void loginCRMApplication() throws Exception{
		launchApplication("CRM_URL");
		type(loginUsername, "XXXXXX");
		type(loginPassword,"XXXXXXXXXX");
		click(signinButton);
		waitFor(5);
		printLog("Verify logged into application",isElementDisplayed(HomePage.homepageNavigationBar),true);
	}
	

}
