package basemodule;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import Exception.FilloException;
import Fillo.Fillo;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.NetworkMode;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BaseClass extends UtilClass{

	
	@Before
	public void setUp(Scenario scenario) throws Exception{
		if(!isReportSetupCompleted){
			setReportingData();			
		}
		flushReportDataToHtml();
		
		getScenarioData(scenario.getName().toString());
		test = extent.startTest(scenario.getName().toString());
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get(setupData.getField("CRM_URL"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		
	}
	
	
	@After
	public void tearDown(Scenario scenario){
		extent.endTest(test);
		driver.close();
	}
}
