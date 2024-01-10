package actionitems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
public class ActionItem_03 {
    public static void main(String[] args) throws InterruptedException {
        //setup chromedriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //navigate to Bing
        //Search a value on Bing using xpath
        ArrayList<String> teams = new ArrayList<>();
        teams.add("Manchester United");//index 0
        teams.add("Real Madrid");
        teams.add("Liverpool FC");
        teams.add("Bayern Munich");
        teams.add("FC Barcelona");
        //add loop condition to iterate the search results on bing
        int i = 0;
        while (i < teams.size()) {
            driver.navigate().to("https://www.Bing.com");
            driver.manage().window().maximize();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@name = 'q']")).sendKeys(teams.get(i));
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@class = 'gray70_fill_sb']")).submit();
            Thread.sleep(2000);
            String searchResult = driver.findElement(By.xpath("//*[@class = 'sb_count']")).getText();
            String[] splitSearchResulst = searchResult.split(" ");
            System.out.println("Search result number is " + splitSearchResulst[1]);
            i++;
        }//end of loop
        driver.quit();
    }//end of main
}//end of class

//index 0 index 1 index 2