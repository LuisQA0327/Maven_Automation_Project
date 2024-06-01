package PRACTICE;

import Day10_12112023.Reusable_Methods;
import Day13_12192023.TestParent;
import org.apache.hc.core5.reactor.Command;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Practice4 extends TestParent {
    @Test
    public void tc001_generalCoverage() throws InterruptedException {
        //navigate to fideliscare.org
        driver.navigate().to("https://www.fideliscare.org/");
        //click on search element
        Reusable_Methods.clickByIndexMethod(driver, "//*[@class='tool dropdown search']", 0, "Search Button");
        //click search field
        Reusable_Methods.clickByIndexMethod(driver, "//*[@class='form-control search-input']", 0, "Search Field");
        //enter dental coverage into search field
        Reusable_Methods.sendKeysMethod(driver, "//*[@class='form-control search-input']", 0, "get dental coverage", "Search Field Input");
        //submit search
        Reusable_Methods.clickByIndexMethod(driver, "//*[@class='btn btn-primary btn-search']", 0, "Submit Search Button");
        //capture and print out search results
        String searchResults = new String(Reusable_Methods.captureText(driver, "//*[@id='dnn_ContentPane']", "Search Results"));
        System.out.println(searchResults);
        Thread.sleep(1000);
        //splint and print search number only
        String searchAmount = new String(Reusable_Methods.captureText(driver, "//*[@class='gsc-result-info']", "Search Results"));
        String[] searchAmountSplit = searchAmount.split(" ");
        System.out.println("The amount of search results for dental coverage is " + searchAmountSplit[1]);
        //Click on Get General Coverage Link
        Reusable_Methods.clickByIndexMethod(driver, "//*[text()='Get Dental Coverage']", 0, "Get Dental Coverage Link");
        Thread.sleep(3000);
    }

    @Test(dependsOnMethods = "tc001_generalCoverage")
    public void tc002_contactMeForm() throws InterruptedException {
        //Thread.sleep(2000);
        //Call switchToTabByIndex
        Reusable_Methods.switchToTabByIndex(driver, 1, "Second tab");
        //enter first name, last name, zipcode into respective fields
        Reusable_Methods.sendKeysMethod(driver, "//*[@id='firstName']", 0, "Luis", "First Name Field");
        Reusable_Methods.sendKeysMethod(driver, "//*[@id='lastName']", 0, "Varela", "last Name Field");
        Reusable_Methods.sendKeysMethod(driver, "//*[@id='zipCode']", 0, "11423", "zipCodeField");
        //select county by visible text
        Reusable_Methods.selectByVisibleText(driver, "//*[@id='county']", "Queens", "County Field");
        //enter phone number into respective field
        Reusable_Methods.sendKeysMethod(driver, "//*[@id='phoneNumber']", 0, "7188021983", "Phone Number Field");
        //enter Email into respective field
        Reusable_Methods.sendKeysMethod(driver, "//*[@id='email']", 0, "LuisVarelaQA@Gmail.com", "Email Field");
        //Click on contact me checkbox
        Reusable_Methods.mouseActionsClickMethod(driver, "//*[(text()='By checking this box you are agreeing to have a Fidelis Care representative contact you about health insurance.')]", "Contact Me Box");
        //click on contact me button
        Reusable_Methods.clickMethod(driver, "//*[@type='submit']", 0, "Contact Me Button");
        //capture text from message containing "Thank you for your submission"
        String postSubmissionMessage = new String(Reusable_Methods.captureText(driver, "//*[@class='alert alert-success']", "Thank You Message"));
        //Print out entire message
        System.out.println(postSubmissionMessage);
        //close tab
        driver.close();
       Thread.sleep(1000);
    }


  @Test(dependsOnMethods="tc002_contactMeForm")
    public void tc3_Login()throws InterruptedException{
        //call swtichToTabByIndex to switch to main tab
        Reusable_Methods.switchToTabByIndex(driver,0,"Main Page Tab");
        ////Click Login Button
        Reusable_Methods.clickByIndexMethod(driver,"//*[contains(text(),'Login')]",0,"Login Button");
        Thread.sleep(2000);
        //Click "Member Online Portal" Button
        Reusable_Methods.clickByIndexMethod(driver,"//*[text()= 'Member Online Portal']",0,"Member Online Portal Button");
        //call swtichToTabByIndex to switch to second tab
        Reusable_Methods.switchToTabByIndex(driver,1,"Member Portal Tab");
        //Capture and Print out entire message under Helpful Hints
        String helpfulHintsMessage = new String(Reusable_Methods.captureText(driver,"//*[@class='flex flex-column p-8']","Helpful Hints Box"));
        System.out.println(helpfulHintsMessage);
        //close current tab
        driver.close();
    }

    //new commit
    //Hey Luis, great code! :) ;)
}



