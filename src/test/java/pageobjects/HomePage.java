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
	
	public boolean isHomePageNavigationBarDisplayed(){
		return homepageNavigationBar.isDisplayed();
	}
	
}
