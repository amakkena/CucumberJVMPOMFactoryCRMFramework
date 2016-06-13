package pageobjects;

import basemodule.actions.WebActions;


public class AdministrationPage extends WebActions{
	
	public static String administrationPageHeader = "//*[@class='page-header']/h3[text()='Administration']";
	public static String usersManagementLink = "//*[@class='table table-bordered'][2]//a[text()='Users']";

	

	
	public static void navigateUsersPage(){
		click(usersManagementLink);
	
	}
}
