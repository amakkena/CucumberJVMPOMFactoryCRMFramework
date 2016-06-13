package basemodule;

import basemodule.actions.WebActions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class InitClass extends WebActions{
	
	@Before
	public void setUp(Scenario scenario) throws Exception{
		if(!isReportSetupCompleted){
			setReportingData();			
		}
		flushReportDataToHtml();		
		getScenarioData(scenario.getName().toString());
		test = extent.startTest(scenario.getName().toString());		
	}	
	
	@After
	public void tearDown(Scenario scenario){
		extent.endTest(test);
		driver.close();
	}
}
