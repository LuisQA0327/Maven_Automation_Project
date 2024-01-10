package day15_01082024;

import Day10_12112023.Reusable_Method_Loggers;
import Day13_12192023.TestParent;
import org.testng.annotations.Test;

import static Day13_12192023.TestParent.driver;
import static Day13_12192023.TestParent.logger;

public class T1_google_screenshot extends TestParent {
    @Test
    public void tc001_searchForACar() throws InterruptedException {
        //navigate to google web page
        driver.navigate().to("https://www.google.com");
        //search for BMW
        Reusable_Method_Loggers.sendKeysMethod(driver, "//*[@name= 'q']", 0, "BMW" ,"Search Field",logger);
        //hit submit on the google search button
        Reusable_Method_Loggers.submitMethod(driver, "//*[@name= 'btnKlp']", "field",logger);
        Thread.sleep(1000);
    }//end of test case 1
//hello world

}

