package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basemodule.UtilClass;

public class AdministrationPage extends UtilClass{
	
	
	@FindBy(xpath="//*[@class='page-header']/h3[text()='Administration']") WebElement administrationPageHeader;
	@FindBy(xpath="//*[@class='table table-bordered'][2]//a[text()='Users']") WebElement usersManagementLink;
	public AdministrationPage(){
		PageFactory.initElements(driver, this);
	}

	public boolean isAdministrationPageDisplayed(){
		return administrationPageHeader.isDisplayed();
	}
	
	public UsersManagementPage navigateUsersPage(){
		usersManagementLink.click();
		return new UsersManagementPage();
	}
}
