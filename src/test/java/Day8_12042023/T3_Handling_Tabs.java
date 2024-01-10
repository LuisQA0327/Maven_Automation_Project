package Day8_12042023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class T3_Handling_Tabs {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        //set chromeoption for preset of arguments for driver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-maximized");
        //declare your web driver and pass the options variable inside the chromedriver
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.fideliscare.org");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()='Shop For a Plan']")).click();
        Thread.sleep(2000);
        driver.findElements(By.xpath("//*[text()='Shop for a Plan']")).get(0).click();
        Thread.sleep(1500);
        driver.findElements(By.xpath("//*[@href='/Find-A-Doctor']")).get(0).click();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.findElement(By.xpath("//*[@id='searchLocation']")).sendKeys("11218");
        Thread.sleep(1500);
        driver.close();
        driver.switchTo().window(tabs.get(0));
        driver.findElements(By.xpath("//*[@href='/Find-A-Doctor']")).get(1).click();
    }
}
