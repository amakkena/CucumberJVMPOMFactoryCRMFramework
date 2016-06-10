package basemodule;

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
		launchApplication();
	}	
	
	@After
	public void tearDown(Scenario scenario){
		extent.endTest(test);
		driver.close();
	}
}
