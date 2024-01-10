package Day11_12122023;

import Day10_12112023.Reusable_Methods;
import org.openqa.selenium.WebDriver;

public class T2_ReusableYahoo{
        public static void main(String[] args) {
            //instantiate the driver
            WebDriver driver = Reusable_Methods.setUpDriver();
            //navigate to metlife
            driver.navigate().to("https://www.yahoo.com/");
            //click on the sports menu (third tab, index 2)
            Reusable_Methods.clickByIndexMethod(driver, "//*[contains(@class,'_yb_q22uj')]", 2, "yahoo headers");
            //quit driver
            driver.quit();
        }//end of main{
}
