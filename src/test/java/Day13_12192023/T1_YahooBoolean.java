package Day13_12192023;

import Day10_12112023.Reusable_Method_Loggers;
import Day10_12112023.Reusable_Methods;
import Day13_12192023.TestParent;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_YahooBoolean extends TestParent {
    @Test
    public void tc001_verifyStaySignedInIsChecked(){
        driver.navigate().to("https://www.Yahoo.com");
        //click on sign in button
        Reusable_Method_Loggers.clickMethod(driver,"//*[text()='Sign in']",0,"Sign In Button",logger);

        boolean isStaySignedInChecked = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        //print out if checkbox is selected
        System.out.println("The checkbox is checked: " + isStaySignedInChecked);
        //assert if it's true
        Assert.assertTrue(isStaySignedInChecked);
    }//end of tc001

    @Test
    public void tc002_verifySignInOptionIsUnchecked(){
        Reusable_Method_Loggers.clickMethodWithoutIndexP(driver,"//*[@class='stay-signed-in checkbox-container']","checkbox",logger);
        //should store false value since checkbox is not checked
        boolean isStaySignedInChecked = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        //print out if check is selected
        System.out.println("The checkbox is checked: " + isStaySignedInChecked);
        //assert if it's true
        Assert.assertFalse(isStaySignedInChecked);
    }
//test
}
