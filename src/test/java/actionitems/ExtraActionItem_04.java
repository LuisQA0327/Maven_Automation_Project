package actionitems;

import Day10_12112023.Reusable_Methods;
import Day13_12192023.TestParent;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ExtraActionItem_04 extends TestParent {

    @Test
    public void tc001_medicaidManagedCare(){
        driver.navigate().to("https://www.Fideliscare.org");
        Reusable_Methods.clickElementWithJs(driver,"//*[text()='Shop For a Plan']","Shop For a Plan Button");
        Reusable_Methods.clickElementWithJs(driver,"//*[text()='Medicaid Managed Care']","Medicaid Managed Care Link");
        String currentURL = new String(driver.getCurrentUrl());
        System.out.println("Current URL: " + currentURL);
        Reusable_Methods.openCurrentURLMethod(driver,currentURL);
    }

    @Test
    public void tc002_clickButtons() throws InterruptedException {
    driver.navigate().to("https://demoqa.com/buttons");
    Reusable_Methods.mouseActionsDoubleClickMethod(driver,"//*[text()='Double Click Me']","Double Click Button");
    Reusable_Methods.mouseActionsRightClickMethod(driver,"//*[text()='Right Click Me']","Right Click Button");
    driver.navigate().to("https://demoqa.com/upload-download");
    Reusable_Methods.sendKeysMethod(driver,"//*[@id='uploadFile']",0,"/Users/sergio/Desktop/xpath formulas.png","xpath formulas file");
    Reusable_Methods.clickMethod(driver,"//*[@id='downloadButton']",0,"Download Button");
    Thread.sleep(10000);
    }
}

   /* Optional Ai #2
        Navigate to demoqa.com/buttons
        Automate double click and right click button (you can create reusable methods)
        Navigate to demoqa.com/upload-download
        Automate upload and download functionality (research item)
        Navigate to demoqa.com/alerts
        Automate the alert functionality (research item)*/

