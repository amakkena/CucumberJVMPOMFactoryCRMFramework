package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basemodule.BaseClass;

public class HomePage extends BaseClass {
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@role='navigation']") WebElement homepageNavigationBar;
	@FindBy(id="nav-menu-dropdown") WebElement adminNavigationMenu;
	@FindBy(xpath="//*[@aria-labelledby='nav-menu-dropdown']//*[text()='Administration']") WebElement administrationMenuItem;

	
	public boolean isHomePageNavigationBarDisplayed(){
		return homepageNavigationBar.isDisplayed();
	}
	
	public AdministrationPage navigateToAdministrationPage(){
		adminNavigationMenu.click();
		waitFor(2);
		administrationMenuItem.click();
		waitFor(2);
		return new AdministrationPage();
	}
	
}
