package actionitems;

import Day10_12112023.Reusable_Method_Loggers;
import Day10_12112023.Reusable_Methods;
import Day13_12192023.TestParent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ActionItem07 extends TestParent {
    @Test
    public void tc001_AllyBankReviewPurchaseLoansLink() throws InterruptedException {
        //navigate to lending tree site
        driver.navigate().to("https://www.lendingtree.com");
        //click Mortgages Module Dropdown
        Reusable_Method_Loggers.clickMethodWithoutIndexP(driver, "//*[contains(@class,'mortgages-trigger')]", "Mortgages Module", logger);
        //Click Mortgage Rates
        Reusable_Method_Loggers.clickMethodWithoutIndexP(driver, "//*[@class='nav-dropdown-icon lt4-Mortgage']", "Mortgage Rates Section", logger);
        Thread.sleep(2000);
        //Scroll to Mortgage Lenders Chart
        Reusable_Method_Loggers.scrollToElementByXPath(driver, "//*[text()='Our picks for the best mortgage lenders']", "Our picks for the best mortgage lenders", logger);
        //capture text and print
        String mortgageLenders = new String(Reusable_Method_Loggers.captureText(driver, "//*[text()='Our picks for the best mortgage lenders']", "Mortgage Lenders Chart", logger));
        System.out.println(mortgageLenders);
        //click on Ally Bank "Read our review"
        Reusable_Method_Loggers.clickMethod(driver, "//*[@class='btn btn-blue']", 2, "Read our review button", logger);
        Reusable_Method_Loggers.captureHrefAndClick(driver, "//*[contains(@href,'types-of-conventional')]", 1, "Purchase Loans Link", logger);
    }

    @Test
    public void tc002_averageHomeRates() throws InterruptedException {
        driver.navigate().to("https://www.lendingtree.com");
        //click mortgages tab
        Reusable_Method_Loggers.clickMethodWithoutIndexP(driver, "//*[contains(@class,'mortgages-trigger')]", "Mortgages Module", logger);
        //click cash out refinance option
        Reusable_Method_Loggers.clickMethodWithoutIndexP(driver, "//*[@class='nav-dropdown-icon lt4-Cash']", "Mortgage Rates Section", logger);
        //scroll to refinance rates in Queens, NY
        Reusable_Method_Loggers.scrollByPixel(driver, "0", "3000", "Mortgage Refinance Rates in Queens, NY", logger);
        //click home equity
        Reusable_Method_Loggers.clickMethodWithoutIndexP(driver, "//*[@value='home-equity']", "home equity", logger);
        //click search field for zip code
        Reusable_Method_Loggers.clickMethod(driver, "//*[@id='stInput']", 0, "Zip Search Field", logger);
        //clear search field for zip code
        Reusable_Method_Loggers.clearMethod(driver, "//*[@id='stInput']", 0, "Zip Search Field", logger);
        //enter zip code value
        Reusable_Methods.typeTextByJSE(driver, "//*[@id='stInput']", "10001", "Zip Search Field");
        //click home field value
        Reusable_Method_Loggers.clickMethod(driver, "//*[@data-position='0']", 1, "Home Value Field", logger);
        //enter home field value
        Reusable_Method_Loggers.sendKeysMethod(driver, "//*[@data-position='0']", 1, "300000", "Home Value", logger);
        //add sleep
        Thread.sleep(1000);
        //click current balance field
        Reusable_Method_Loggers.clickMethod(driver, "//*[@maxlength='13']", 3, "Current Balance Field", logger);
        //enter a balance value
        Reusable_Method_Loggers.sendKeysMethod(driver, "//*[@maxlength='13']", 3, "175000", "Current Balance Field", logger);
        //click see rates button
        Reusable_Method_Loggers.clickElementWithJs(driver, "//*[@class='btn btn-blue']", "See Rates Button", logger);
    }

    @Test
    public void tc003_LoanSlider() throws InterruptedException {
        //navigate to Home Equity Rates
        driver.navigate().to("https://www.lendingtree.com/home/home-equity/");
        //Scroll to Shop Around Heading
        Reusable_Method_Loggers.scrollToElementByXPath(driver, "//*[text()='Shop around']", "Shop Around Text", logger);
        //add sleep
        Thread.sleep(3000);
        //Use moveByOffset method to move slider handle to $100,000+ value
        Reusable_Method_Loggers.moveByOffsetX(driver, "//*[@style='width: 16px; height: 16px; top: -5px; transition-duration: 0s; transform: translateX(238px);']", 411, 0, "Loan Amount Slider", logger);
        //Use moveByOffset method to move slider handle to $20,000 value
        Reusable_Method_Loggers.moveByOffsetX(driver, "//*[@style='width: 16px; height: 16px; top: -5px; transition-duration: 0s; transform: translateX(649px);']", -649, 0, "Loan Amount Slider", logger);
        //Create a String Variable that captures the $20,000 value text
        String loanAmount = new String(Reusable_Method_Loggers.captureText(driver, "//*[@class= 'mortgage-amount']", "Loan Amount Requested", logger));
        //Use if condition to print out method is successful
        if (loanAmount.equals("$20,000")) {
            System.out.println("moveByOffset method successful");
        } else {
            System.out.println("moveByOffset method failed");
        }
    }

    @Test
    public void tc004_mortgageCalculator() {
        //navigate to mortgage calculator page
        driver.navigate().to("https://www.lendingtree.com/home/mortgage/mortgage-calculator/");
        //verify that current page is the correct page
        String actualTitle = driver.getTitle();
        String expectedTitle = new String("Mortgage Calculator: Free Monthly Payment Estimate | LendingTree");
        Assert.assertEquals(actualTitle, expectedTitle);
        //add home price value
        Reusable_Method_Loggers.clickByIndexMethod(driver, "//*[@maxlength='13']", 0, "Home Price", logger);
        Reusable_Method_Loggers.sendKeysMethod(driver, "//*[@maxlength='13']", 0, "500000", "Home Price", logger);
        //select loan term
        Reusable_Method_Loggers.clickMethodWithoutIndexP(driver, "//*[@value='15']", "Loan Term", logger);
        //Add down Payment
        Reusable_Method_Loggers.clickByIndexMethod(driver, "//*[@maxlength='13']", 1, "Down Payment", logger);
        Reusable_Method_Loggers.sendKeysMethod(driver, "//*[@maxlength='13']", 1, "20000", "Down Payment", logger);
        //click advanced options
        Reusable_Method_Loggers.clickMethodWithoutIndexP(driver, "//*[@class='show-hide-options']", "Advanced Options", logger);
        boolean includePmiIsSelected = driver.findElement(By.xpath("//*[@id='includePMI']")).isSelected();
        //print out if check is selected
        System.out.println("The checkbox is checked: " + includePmiIsSelected);
        //assert if it's true
        Assert.assertTrue(includePmiIsSelected);
    }

    @Test
    public void tc005_test() throws InterruptedException {
        ArrayList<String> downPayment = new ArrayList<>();
        downPayment.add("10000");
        downPayment.add("20000");
        downPayment.add("120001");
        for (int i = 0; i < downPayment.size(); i++) {
            //navigate to current mortgage rates page
            driver.navigate().to("https://www.lendingtree.com/home/mortgage/rates/?icid=mort-menu-mort-rate#inputs");
            //navigate down to mortgage purchase rates filter
            String actualTitle = driver.getTitle();
            String expectedTitle = new String("Compare Current Mortgage Rates Today: Rates in January 2024");
            Assert.assertEquals(actualTitle, expectedTitle);
            Reusable_Method_Loggers.scrollByPixel(driver, "0", "800", "Text", logger);
            //enter Down Payment amount
            Reusable_Method_Loggers.clickMethod(driver, "//*[@maxlength='13']", 1, "down payment search field", logger);
            Reusable_Method_Loggers.sendKeysMethod(driver, "//*[@maxlength='13']", 1, downPayment.get(i), "down payment search field", logger);
            //click rates button
            Reusable_Method_Loggers.clickMethod(driver, "//*[@class='btn btn-orange']", 0, "update rates", logger);
            //use if statement
            if (i == 0) {
                Thread.sleep(3000);
                System.out.println("Loans are available for this downpayment amount");
            } else if (i == 1) {
                Thread.sleep(3000);
                System.out.println("Loans are available fot this downpayment amount");
            } else if (i == 2) {
                Thread.sleep(3000);
                String noLoansAvailable = new String(Reusable_Method_Loggers.captureText(driver, "//*[@class='text-left']", "No Loans Available Message", logger));
                System.out.println("The error message is: " + noLoansAvailable);
            }
        }
    }

   /* @Test
    public void Tc_005MunicipalFunski() throws InterruptedException {
        driver.navigate().to("https://www.nymcu.org/");
        Reusable_Method_Loggers.mouseActionsMethod(driver, "//*[text()='Lending']", "X", logger);
        Reusable_Method_Loggers.clickMethodWithoutIndexP(driver, "//*[text()='Loans Overview']", "J", logger);
        Reusable_Method_Loggers.clickMethodWithoutIndexP(driver, "//*[text()='See Auto Loans & Services']", "Click Auto Loans", logger);
        Reusable_Method_Loggers.clickByIndexMethod(driver, "//*[@class=' btn1 ']", 2, "Y", logger);
        Reusable_Method_Loggers.clickMethodWithoutIndexP(driver, "//*[text()='Find Your Auto Protection Plan']", "Z", logger);
        Reusable_Method_Loggers.clickMethodWithoutIndexP(driver, "//*[text()='Get Started']", "logger", logger);
        Thread.sleep(3000);
        Reusable_Method_Loggers.clickElementWithJs(driver, "//*[@for='postalCodecqf-2acf690fdbab4d2aa18edaee4aa047a0']", "T", logger);
    }

    @Test
    public void tc_AllanSucksCock() throws InterruptedException {
        driver.navigate().to("https://www.enorthfield.com/locations");
        Thread.sleep(4000);
        Reusable_Method_Loggers.scrollByPixel(driver,"0","-1000","scroll",logger);
        Reusable_Method_Loggers.clickMethodWithoutIndexP(driver,"//*[@id='ddlCity-button']","select",logger);
        Reusable_Method_Loggers.clickMethodWithoutIndexP(driver,"//*[@id='ui-id-23']","showtime",logger);
    }*/
}