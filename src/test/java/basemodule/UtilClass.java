package basemodule;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import Exception.FilloException;
import Fillo.Connection;
import Fillo.Fillo;
import Fillo.Recordset;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

public class UtilClass{
	public static WebDriver driver;	
	public static ExtentReports extent;
	public static ExtentTest test;
	public static boolean isReportSetupCompleted = false;	
	public static String reportPath;
	public static String imagesPath;
	public static boolean scenarioResultFlag;
	public static Connection conn;
	public static Recordset testData;
	public static Recordset setupData;
	private static boolean dunit = false;
	
	
	public void launchApplication() throws Exception{
		String browserName = testData.getField("Browser_Name");
		String appURL = setupData.getField("CRM_URL");
		if(browserName.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"/drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else if(browserName.equalsIgnoreCase("FF")||browserName.equalsIgnoreCase("FireFox"))
			driver = new FirefoxDriver();
		else{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(setupData.getField("Element_Timeout")), TimeUnit.SECONDS);	
		driver.get(appURL);
	}
	/***
	 * @author NARENDRA MAKKENA
	 * @description To fetch data from excel in any of the sheet with matching with scenario name
	 * @param scenarioName
	 * @return No Return type
	 */
	public static void getScenarioData(String scenarioName){
		String[] dataSheetsArray=null;
			try {
				setupData = conn.executeQuery("SELECT * FROM Setup");
				setupData.moveFirst();
				dataSheetsArray = setupData.getField("Testdata_Sheet_Names").split(",");
			} catch (FilloException e) {
				System.out.println("Error occrued while reading data from Setup sheet");
				e.printStackTrace();
			}										
			for(String sheetName:dataSheetsArray){
				try {
					testData = conn.executeQuery("SELECT * FROM "+sheetName+" WHERE Testcase_Name='"+scenarioName.toString()+"' AND Execution_Flag='Yes'");
					if(testData.getCount() >=1){
						testData.moveFirst();
						break;
					}
				} catch (FilloException e) {
					System.out.println("Error occrued while reading data from"+dataSheetsArray+"Sheet");
					e.printStackTrace();
				}				
			}		
	}
	
	/***
	 * @author NAENDRA MAKKENA
	 * @description function is to create reporting folder and html file using extentreports. Also establishes connection to testdata excel.
	 * 						This will be executed only once per suite execution.
	 * @return No return 
	 * @param No parameters
	 */
	public static void setReportingData(){
		try{
			conn = new Fillo().getConnection(System.getProperty("user.dir")+"/TestData/CRM_Testdata.xlsx");
		}catch (FilloException e) {
			System.out.println("Error occrued while connecting test data excel.");
			e.printStackTrace();
		}	
		reportPath = System.getProperty("user.dir")+"/target/CRM_application_Execution_Report_"+getCurrentTimeStamp();
		imagesPath = reportPath+"/images";
		new File(reportPath).mkdir();
		new File(imagesPath).mkdir();
		extent = new ExtentReports(reportPath+"/CRM_application_execution_Summary.html",false,NetworkMode.OFFLINE);
		isReportSetupCompleted = true;
	}
	
	/***
	 * @author NAENDRA MAKKENA
	 * @description function is to send buffered extent report data to html file. This will be executed only once just before completion of suite.
	 * @return No return 
	 * @param No parameters
	 */
	public static void flushReportDataToHtml(){
		 if(!dunit) {
             Runtime.getRuntime().addShutdownHook(new Thread() {
                 public void run() {
                	try{
               			//Runtime.getRuntime().exec( "wscript LaunchUFT.vbs" );
                		System.out.println("Flushing data to report");
                   	 	extent.flush();
               		}catch(Exception e){
               			e.printStackTrace();
               		  }
                }
             });
             dunit = true;
         }
	}
	
	/***
	 * @author NAENDRA MAKKENA
	 * @description function is to get current timestamp. Used in creating report folder with unique name by appending timestamp
	 * @return timestamp in String format 
	 * @param No parameters
	 */
	public static String getCurrentTimeStamp(){
			DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy hh mm ss");
			Date date = new Date();
			String dateTimeValue = dateFormat.format(date).replace(" ", "").toUpperCase().trim();		
			return dateTimeValue.substring(0, 9)+"_"+dateTimeValue.substring(9);
		}
		
	/***
	 * @author NAENDRA MAKKENA
	 * @description function is to capture the snapshot the application screen. Places the snap in images folder
	 * @return snap file path in String format 
	 * @param No parameters
	 */
	public String getSnap(){
			String snapPath="";		
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				snapPath = imagesPath+"/"+"img_"+getCurrentTimeStamp()+".png";
				try {
					FileUtils.copyFile(scrFile, new File(snapPath));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				return snapPath;		
		}
	
	/***
	 * @author NAENDRA MAKKENA
	 * @description function is verify condition and report the result with pass/fail to extent report log
	 * @return No return value 
	 * @param stepDescription(Simple description of the step)
	 * 				stepStatus(Verification / Condition with results true of false
	 * 				snapForPass (true if we need snap of pass step as well. By default snap will be taken for fail step	 

	 */
	public void reportResult(String stepDescription,boolean stepStatus,boolean snapForPass){
			if(stepStatus){
				if(snapForPass){
					test.log(LogStatus.PASS, stepDescription +" - PASS", test.addScreenCapture(getSnap()));
					System.out.println(stepDescription + " is PASS");
				}
				else{
					test.log(LogStatus.PASS, stepDescription +" - PASS","");
					System.out.println(stepDescription + " is PASS");				
				}
			}else{
				test.log(LogStatus.FAIL, stepDescription +" - FAIL", test.addScreenCapture(getSnap()));
				scenarioResultFlag = false;
				System.out.println(stepDescription + " is FAIL");
			}
		}
	
	public void waitFor(int seconds){
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/***
	 * @author NAENDRA MAKKENA
	 * @description function is verify condition and report the result with pass/fail to extent report log
	 * @return No return value 
	 * @param stepDescription(Simple description of the step)
	 * 				stepStatus(Verification / Condition with results true of false
	 * 				snapForPass (true if we need snap of pass step as well. By default snap will be taken for fail step	
	 * 				exitTest (true if we want to exit the current test and continue to next step when stepStatus returns false

	 */
	public void reportResult(String stepDescription,boolean stepStatus,boolean snapForPass,boolean exitTest) throws Exception{
			if(stepStatus){
				if(snapForPass){
					test.log(LogStatus.PASS, stepDescription +" - PASS", test.addScreenCapture(getSnap()));
					System.out.println(stepDescription + " is PASS");
				}
				else{
					test.log(LogStatus.PASS, stepDescription +" - PASS","");
					System.out.println(stepDescription + " is PASS");				
				}
			}else{
				scenarioResultFlag = false;
				if(exitTest){
					test.log(LogStatus.FAIL, stepDescription +" - FAILED. Stopping the execution of Current Scenario", test.addScreenCapture(getSnap()));
					Assert.assertTrue(stepDescription +" Check failed and Stopping the execution of Current Scenario",false);
				}else
					test.log(LogStatus.FAIL, stepDescription +" - FAIL", test.addScreenCapture(getSnap()));
			}
	}
		// ######################## End of Extent Report related functions ############################
		
}
