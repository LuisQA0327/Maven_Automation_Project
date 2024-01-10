package actionitems;

import Day10_12112023.Reusable_Methods;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class ActionItem06 {
    public static void main(String[] args) {
        ArrayList<String> zipcodes = new ArrayList<>();
        zipcodes.add("11432");
        zipcodes.add("11417");
        zipcodes.add("10001");
        WebDriver driver = Reusable_Methods.setUpDriver();
       // String studioAddress = new String (Reusable_Methods.captureText(driver,"//*[@class = 'address-2PZwW']","Studio Address"));

        for (int i = 0; i < zipcodes.size(); i++){
            //navigate to weight watchers
            driver.navigate().to("https://WeightWatchers.com");
            //click Find A Workshop Button
            Reusable_Methods.clickMethod(driver,"//*[text() = 'Find a Workshop']",0,"Find A WorkShop Button");
            //click In-Person Button
            Reusable_Methods.clickMethod(driver,"//*[contains(@class, 'QK2gi')]",0,"In-Person Button");
            //Clear Search Field
            Reusable_Methods.clearMethod(driver,"//*[@id = 'location-search']",0,"Location Search Button Clear");
            //Input zipcodes from ArrayList
            Reusable_Methods.sendKeysMethod(driver,"//*[@id = 'location-search']",0,zipcodes.get(i),"Location Search Field SendKeys");
            //Click Search Arrow
            Reusable_Methods.clickMethod(driver,"//*[contains(@class, 'ww button')]",0,"Search Button Click");
            //Use If condition to click studio links
            if (i == 0) {
                Reusable_Methods.clickMethod(driver,"//*[contains(@class,'linkUnderline-1_h4g')]",1,"Second studio link");
            } else if (i == 1) {
                Reusable_Methods.clickMethod(driver,"//*[contains(@class,'linkUnderline-1_h4g')]",2,"Third studio link");
            } else if (i == 2) {
                Reusable_Methods.clickMethod(driver, "//*[contains(@class,'linkUnderline-1_h4g')]", 0, "First studio link");
            }
            //get the address and print in Print Statement
           // System.out.println(studioAddress);
            String studioAddress = new String (Reusable_Methods.captureText(driver,"//*[@class = 'address-2PZwW']","Studio Address"));
            System.out.println(studioAddress);
            Reusable_Methods.scrollToElementByXPath(driver,"//*[contains(@id, 'studioW')]","Studio Schedule");
            String studioSchedule = new String(Reusable_Methods.captureText(driver,"//*[contains(@id, 'studioW')]","Studio Schedule"));
            System.out.println(studioSchedule);
        }//end of loop
        driver.quit();
    }//end of main
}//end of class
