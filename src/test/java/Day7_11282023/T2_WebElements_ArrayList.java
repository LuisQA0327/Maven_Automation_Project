package Day7_11282023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class T2_WebElements_ArrayList {
    public static void main(String[] args) {
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
        driver.navigate().to("https://www.yahoo.com");
//define arrayList of WebElements
        ArrayList<WebElement> yahooHeaders = new ArrayList<>(driver.findElements(By.xpath("//*[contains(@class,'_yb_yc')]")));
//print out how many headers
        System.out.println("There are " +  yahooHeaders.size() + " yahoo headers");
        for (int i =0; i < yahooHeaders.size(); i++){
            System.out.println("Yahoo headers are " + yahooHeaders.get(i).getText());
        }
        driver.quit();
    }
}
