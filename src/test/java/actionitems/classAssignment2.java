package actionitems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class classAssignment2 {
    public static void main(String[] args) throws InterruptedException {
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
        driver.navigate().to("https://www.equinox.com");

       ArrayList<WebElement> equinoxHeaders = new ArrayList<>(driver.findElements(By.xpath("//*[contains(@class, 'GlobalHeader_main-nav-item__evs91')]")));
       System.out.println(equinoxHeaders.size());
       driver.findElement(By.xpath("//*[@class = 'GlobalHeader_main-nav-cta__QEaOK']")).click();
        Thread.sleep(3000);
       ArrayList<WebElement> infoForm = new ArrayList<>(driver.findElements(By.xpath("//*[contains(@class, 'MuiInputBase-input')]")));
        Thread.sleep(3000);
        infoForm.get(0).click();
        infoForm.get(0).sendKeys("James");
        infoForm.get(1).click();
        infoForm.get(1).sendKeys("Jones");
        infoForm.get(2).click();
        infoForm.get(2).sendKeys("JasonJones@Gmail.com");
        infoForm.get(3).click();
        infoForm.get(3).sendKeys("800-291-0320");

        driver.findElement(By.xpath("//*[contains (@class, 'contact-info_club-name')]")).click();
        driver.findElement(By.xpath("//*[@name = 'autoSearchString']")).sendKeys("Queens, NY 11435, USA");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class = 'pac-item']")).click();
        Thread.sleep(3000);
        ArrayList<WebElement> clubLocation = new ArrayList<>(driver.findElements(By.xpath("//*[@class = 'col-sm-9 col-md-11 col-lg-5 p-0']")));
        System.out.println(clubLocation.get(0).getText());
        clubLocation.get(0).click();
        driver.findElement(By.xpath("//*[text() = 'Visit a Club']")).click();

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement skipButton = driver.findElement(By.xpath("//*[text() = 'Skip']"));
        jse.executeScript("arguments[0].scrollIntoView(true);", skipButton);
        skipButton.click();
        Thread.sleep(3000);




    }//end of main
}//end of class
