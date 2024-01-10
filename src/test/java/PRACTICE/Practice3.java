package PRACTICE;

import Day10_12112023.Reusable_Methods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Practice3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = Reusable_Methods.setUpDriver();
        driver.navigate().to("https://www.Nike.com");
      //  Reusable_Methods.captureText(driver,"//*[contains(text(),'Last-Minute Gifts | Save Up to 50%')]","Last Minute Gifts Message");

        //Reusable_Methods.mouseActionsMethod(driver,"//*[@aria-label='New & Featured']","New & Featured");
       // Reusable_Methods.clickByIndexMethod(driver,"//*[text()='Gifts']",0,"Gifts");
        Reusable_Methods.scrollToElementByXPath(driver,"//*[@class='nav-btn p0-sm feed-back-button']","Send Us Feedback link");
        Reusable_Methods.clickMethod(driver,"//*[@class='nav-btn p0-sm feed-back-button']",0,"Send Us Feedback");
        Reusable_Methods.selectByVisibleText(driver,"//*[@class='_pi_select']","Customer Service Experience","Feedback Dropdown");
        Reusable_Methods.mouseActionsClickMethod(driver,"//*[@aria-label='5 out of 5 stars']","3 Star Rating");
        Reusable_Methods.clickMethod(driver,"//*[@class='_pi_free_text_question_field']",0,"feedback field");
        Reusable_Methods.sendKeysMethod(driver,"//*[@class='_pi_free_text_question_field']",0,"Terrible Prices","feedback field");




        //Thread.sleep(2000);
        //driver.quit();
    }

}
