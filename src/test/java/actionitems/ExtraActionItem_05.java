package actionitems;

import Day10_12112023.Reusable_Methods;
import Day13_12192023.TestParent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ExtraActionItem_05 extends TestParent {
    @Test
    public void TC001_USPS() throws InterruptedException {
        //navigate to USPS site
        driver.navigate().to("https://www.usps.com");
        //Mouse hover to Business Module
        Reusable_Methods.mouseActionsMethod(driver,"//*[text()='Business']","Business Module");
        //click "calculate a business price button
        Reusable_Methods.clickMethod(driver,"//*[text()='Calculate a Business Price']",0,"Calculate a Business Price Button");
        Reusable_Methods.clearMethod(driver,"//*[@class='form-control datepicker hasDatepicker']",0,"Mail Date Textfield");
        Reusable_Methods.typeTextByJSE(driver,"//*[@class='form-control datepicker hasDatepicker']","12/28/2023","Mail Date Textfield");
        Reusable_Methods.submitMethod(driver,"//*[@class='form-control datepicker hasDatepicker']","Mail Date Textfield");
        Reusable_Methods.clickByIndexMethod(driver,"//*[@id='option_0']",0,"Postcards Button");
        Reusable_Methods.captureHrefAndClick(driver,"//*[text()='New Mailing']",1,"New Tab");
        Reusable_Methods.typeTextByJSE(driver,"//*[@name='NumberOfPieces']","5","Number of pieces field");
        Reusable_Methods.typeTextByJSE(driver,"//*[@name='Pounds']","16","Pounds Field");
        Reusable_Methods.typeTextByJSE(driver,"//*[@name='Ounces']","5","Ounces Field");
    }

}
