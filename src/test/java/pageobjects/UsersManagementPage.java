package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basemodule.UtilClass;

public class UsersManagementPage extends UtilClass{

	@FindBy(xpath="//*[@href='#User/create']") WebElement createUserLink;
	
	public UsersManagementPage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean isCreateUserLinkDisplayed(){
		return createUserLink.isDisplayed();
	}
	
}
