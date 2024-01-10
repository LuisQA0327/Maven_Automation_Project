package Day13_12192023;

import Day10_12112023.Reusable_Method_Loggers;
import Day10_12112023.Reusable_Methods;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class TestParent {
    //declare a global public driver variable
    public static WebDriver driver;
    public static ExtentReports reports;
    public static ExtentTest logger;

    @BeforeSuite
    public void setupReports(){
        //declare report path
        reports = new ExtentReports("src/main/java/HTML_Report/AutomationReport.html", true);
    }//end of before suite

    @BeforeClass
    public void setUpChromeDriver() {
        driver = Reusable_Methods.setUpDriver();
    }//end of before class
    @BeforeMethod
    public void setTestName(Method methodName) {
        logger = reports.startTest(methodName.getName());
    }//end of before method

    @AfterMethod
    public void endTest() {
        reports.endTest(logger);
    }

    @AfterClass
    public void quitDriver(){
        driver.quit();
    }//end of after class

    @AfterSuite
    public void flushReport() {
        //generate final report
        reports.flush();
    }//end of after suite
}


