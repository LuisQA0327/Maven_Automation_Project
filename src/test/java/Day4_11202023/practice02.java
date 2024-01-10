package Day4_11202023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class practice02  {
    public static void main(String[] args) throws InterruptedException {
        //setup the chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //define the webdriver
        WebDriver driver = new ChromeDriver();
        //creating an array list for countries
        ArrayList<String> countries = new ArrayList<>();
        //add some values to the array list
        countries.add("USA");
        countries.add("PAKISTAN");
        countries.add("BANGLADESH");
        countries.add("INDIA");
        countries.add("PALESTINE");
        //set the chromedriver for chrome
        for (int i = 0; i < countries.size(); i++){
            //navigate to bing.com
            driver.navigate().to("https://www.bing.com");
            //maximize the window
            driver.manage().window().maximize();
            Thread.sleep(2000);
            //define the arraylist variables
            driver.findElement(By.xpath("//*[@name = 'q']")).sendKeys(countries.get(i));
            Thread.sleep(2000);
            //click on bing search button
            driver.findElement(By.xpath("//*[@class = 'gray70_fill_sb']")).submit();
            //wait for 2 seconds
            Thread.sleep(2000);
            //store the results in a string variable
            String searchResult = driver.findElement(By.xpath("//*[@class = 'sb_count']")).getText();
            //split the search result using split command
            String[] searchResultArray = searchResult.split(" ");
            //print out only the search result number
            System.out.println("Search number for" + countries.get(i) + "is " + searchResultArray[1]);
        }//end of loop
        //quit the browser
        driver.quit();
    }//end of main
}//end of class


