package Day7_11282023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T3_Scroll {
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
        driver.navigate().to("https://www.mlcalc.com");

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0,1500)");
        //scroll down 800 pixels (based on your need you can adjust the number by + or -200)
        Thread.sleep(2000);
        jse.executeScript("scroll(0,-400)");
      /*  jse.executeScript("scroll("0",-"400")");
        Thread.sleep(2000);
        //store the calculate button in a webelement variable
        WebElement calcButton = driver.findElement(By.xpath("//*[@value = 'Calculate']"));
        jse.executeScript("arguments[0].scrollIntoView(true);", calcButton);
        Thread.sleep(2000);
        driver.quit();

        "window.scrollBy(" + xPixels + ", " + yPixels + ");");

        System.out.println("Rafin" + driver + "and" + driver + "Luis");*/
    }//end of main
}//end of class
