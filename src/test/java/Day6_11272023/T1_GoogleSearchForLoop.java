package Day6_11272023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class T1_GoogleSearchForLoop {
    public static void main(String[] args) throws InterruptedException {
       //setup the chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //define the webdriver
        WebDriver driver = new ChromeDriver();
        //maximize the window
        driver.manage().window().maximize();
        //declare an arraylist of car brands
        ArrayList<String> carBrands = new ArrayList<>();
        carBrands.add("BMW");
        carBrands.add("Mercedes");
        carBrands.add("Toyota");
        for (int i = 0; i < carBrands.size(); i++) {
            //navigate to google web page
            driver.navigate().to("https://www.google.com");
            //search for cars (using relative xpath)
            driver.findElement(By.xpath("//*[@name= 'q']")).sendKeys(carBrands.get(i));
            //search for cars (using absolute xpath)
            //driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("cars");
            //hit submit on google search button
            driver.findElement(By.xpath("//*[@name= 'btnK']")).submit();
            //slow down by 2 seconds
            Thread.sleep(2000);
//store the results in a string variable
            String searchResult = driver.findElement(By.xpath("//*[@id = 'result-stats']")).getText();
            //print out the result to the console
            System.out.println("Search result is " + searchResult);
            //split the search result using split command
            String[] searchResultArray = searchResult.split(" ");
            //print out only the search result number
            System.out.println("Search Result Number for car " + carBrands.get(i) + " is " + searchResultArray[1]);
        }//end of for loop
        //quit the browser
        driver.quit();
    }//end of main
}//end of class
