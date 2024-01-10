package classActionItem;

import Day10_12112023.Reusable_Methods;
import Day13_12192023.TestParent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Ai1 extends TestParent {
    @Test
    public static void classAI_001() throws InterruptedException {
        driver.navigate().to("https://www.Lifetime.life/");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Life Time Healthy Way of Life | Join Life Time";
        Assert.assertEquals(actualTitle, expectedTitle);
        Reusable_Methods.clickByIndexMethodV(driver, "//*[@class='navbar-toggler ms-n1']", 0, "Tab");
        Thread.sleep(5000);
        ArrayList<WebElement> options = new ArrayList<>(driver.findElements(By.xpath("//*[@class='nav-item']")));
        System.out.println(options.size());
        if (options.size() > 1) {
            options.get(0).click();
            Thread.sleep(2000);
            Reusable_Methods.sendKeysMethod(driver, "//*[@id='floatingInput']", 0, "Jamaica", "1");
            Reusable_Methods.clickByIndexMethodV(driver, "//*[@aria-label='Filter']", 0, "2");
            Reusable_Methods.clickByIndexMethodV(driver, "//*[@aria-controls='program-filter']", 0, "3");
            Reusable_Methods.clickByIndexMethodV(driver, "//*[@id='program-bball']", 0, "4");
            Thread.sleep(2000);
            Reusable_Methods.clickByIndexMethodV(driver,"//*[@class='btn btn-dark btn-sm px-2 px-sm-3 px-lg-2 px-xl-3']",0,"details");
            Reusable_Methods.scrollToElementByXPath(driver,"//*[@class='opacity-75']","open hours");
            String address2 = new String(Reusable_Methods.captureText(driver,"//*[contains(text(),'Life Time -')]","address"));
            System.out.println(address2);
            Reusable_Methods.clickByIndexMethod(driver,"//*[contains(text(),'Explore Membership')]",1,"Explore Membership");
            Reusable_Methods.clickElementWithJs(driver,"//*[contains(text(),'Join Today')]","Join Today");
            Reusable_Methods.clickMethod(driver,"//*[@id='move-forward-btn']",0,"Move Forward");
            Reusable_Methods.clickMethod(driver,"//*[@id='card-select-membership-0']",0,"Select Membership");
            String pricingSummary = new String(Reusable_Methods.captureText(driver,"//*[@class='b-a b-rounded-lg box-shadow bg-white']","Pricing Summary"));
            System.out.println(pricingSummary);
            Reusable_Methods.clickMethod(driver,"//*[@id='omsc-summary-continue-btn']",0,"Continue to Checkout");
        }
    }
}




