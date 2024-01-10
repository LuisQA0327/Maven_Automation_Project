package PRACTICE;

import Day10_12112023.Reusable_Methods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class PRACTICE {
    WebDriver driver;

    @BeforeSuite
    public void driverSetup() {
        driver = Reusable_Methods.setUpDriver();
    }

    @Test
    public void TC001_MainMortgagesTab() throws InterruptedException {
        driver.navigate().to("https://www.LendingTree.com");
        Thread.sleep(1000);
        //Reusable_Methods.scrollToElementByXPath(driver,"//*[text()='refinancing to a lower rate']","refinancing to a lower rate link");
        Reusable_Methods.clickByIndexMethod(driver, "//*[@class='col-md-1 col-sm-2 header-nav header-nav-mortgages']", 0, "Main Mortgage Tab");
        Reusable_Methods.clickByIndexMethod(driver, "//*[@class='nav-submenu-trigger']", 5, "Mortgage Rates Option");
    }

    @Test
   public void TC002_LoanTypeButton() {
     // Reusable_Methods.scrollToElementByXPath(driver,"//*[@class='zip-sec']","Refinance option");
      Reusable_Methods.selectByVisibleText(driver,"//*[@aria-labelledby='ae-formFieldLabelOptIn_kiizp0st7x_0']","Refinance","Refinance option");
    }

    @AfterSuite

    public void quitDriver() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();


    }
}
