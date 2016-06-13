package pageobjects;

import basemodule.actions.WebActions;

public class HomePage extends WebActions {
	
	public static String homepageNavigationBar = "//div[@role='navigation']";
	public static String adminNavigationMenu = "//*[@id='nav-menu-dropdown']";
	public static String administrationMenuItem = "//*[@aria-labelledby='nav-menu-dropdown']//*[text()='Administration']";

	
	
	
	public static void navigateToAdministrationPage(){
		click(adminNavigationMenu);
		waitFor(2);
		click(administrationMenuItem);
		waitFor(2);
		printLog("Verify navigation to adminstration page",isElementDisplayed(AdministrationPage.administrationPageHeader),true);
		
	}
	
}
