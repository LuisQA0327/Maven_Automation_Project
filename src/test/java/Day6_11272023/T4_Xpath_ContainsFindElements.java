package Day6_11272023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T4_Xpath_ContainsFindElements {
    public static void main(String[] args) throws InterruptedException {
        //setup the chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //declare the chrome options
        ChromeOptions options = new ChromeOptions();
        // add some options for chromeoptions
        options.addArguments("start-maximized");
        //open in incognito mode
        options.addArguments("incognito");
        //run in headless mode
        //define the WebDriver and pass the options argument
        WebDriver driver = new ChromeDriver(options);
        //navigate to yahoo
        driver.navigate().to("https://www.Yahoo.com");
        //wait 3 seconds
        Thread.sleep(3000);
        //click on the news menu button
        driver.findElements(By.xpath("//*[contains(@class,'_yb_yc')]")).get(1).click();
        //wait 3 seconds
        Thread.sleep(3000);
        //quit the browser
        driver.quit();
    }//end of main
}//end of class
