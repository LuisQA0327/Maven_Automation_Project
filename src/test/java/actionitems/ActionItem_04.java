
package actionitems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.channels.NotYetBoundException;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;

import static java.lang.System.*;

public class ActionItem_04 {

    public static void main(String[] args) throws InterruptedException {
        //setup Google Chrome as driver
        WebDriverManager.chromedriver().setup();
        //Create an ArrayList to iterate through steps using different zipcodes
        ArrayList<String> zipCodes = new ArrayList<>();
        //add zipcodes to list
        zipCodes.add("11423");
        zipCodes.add("11417");
        zipCodes.add("10001");
        //establish options for Google Chrome
        ChromeOptions options = new ChromeOptions();
        //add incognito option to Chrome
        options.addArguments("Incognito");
        WebDriver driver = new ChromeDriver(options);
        //create for loop to iterate through all steps several times
        for (int i = 0; i < zipCodes.size(); i++) {
            //maximize screen
            driver.manage().window().maximize();
            //navigate to Weight Watchers website
            driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/");
            //add sleep
            Thread.sleep(3000);
            //Click Find A Workshop Button
            driver.findElement(By.xpath("//*[text() = 'Find a Workshop']")).click();
            //Click In Person Button
            driver.findElement(By.xpath("//*[contains(@class, 'QK2gi')]")).click();
            //add sleep
            Thread.sleep(3000);
            //create a Web Element for the location search field
            WebElement zipSearch = driver.findElement(By.xpath("//*[@id = 'location-search']"));
            //clear and add zipcode to search field
            zipSearch.clear();
            zipSearch.sendKeys(zipCodes.get(i));
            //Click the search button
            driver.findElement(By.xpath("//*[contains(@class, 'ww button')]")).click();
            //add sleep
            Thread.sleep(3000);
            //Create ArrayList for Studio Link
            ArrayList<WebElement> studio = new ArrayList<WebElement>(driver.findElements(By.xpath("//*[contains(@class,'linkUnderline-1_h4g')]")));
            //add if condition
            if (i == 0) {
                studio.get(1).click();
            } else if (i == 1) {
                studio.get(2).click();
            } else if (i == 2) {
                studio.get(0).click();
            }//end of if condition
            //add sleep
            Thread.sleep(3000);
            //Get address for studio and print it out
            WebElement address = driver.findElement(By.xpath("//*[@class = 'address-2PZwW']"));
            System.out.println("  The address for the studio is " + address.getText());
            //scroll down to Studio Schedule
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            WebElement studioSchedule = driver.findElement(By.xpath("//*[contains(@id, 'studioW')]"));
            jse.executeScript("arguments[0].scrollIntoView(true);", studioSchedule);
            //Print out Studio Schedule
            System.out.print(" " + studioSchedule.getText());
        }//end of loop
        driver.quit();
    }//end of main
}//end of class
