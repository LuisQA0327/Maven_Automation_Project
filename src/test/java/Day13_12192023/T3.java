package Day13_12192023;

import Day10_12112023.Reusable_Method_Loggers;
import Day13_12192023.TestParent;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class T3 extends TestParent {
    @Test
    public void tc001_verifyStaySignedInIsChecked() {
        //navigate to yahoo.com
        driver.navigate().to("https://www.yahoo.com/");
        //click on sign in button
        Reusable_Method_Loggers.clickMethodB(driver, "//*[text() = 'Sign in']", logger, "Sign In Button");
        //store checked option into a boolean variable
        boolean isStaySignedInChecked = driver.findElement(By.xpath("//*[@id = 'persistent']")).isSelected();
        //print out if checkbox is selected
        System.out.println("The checkbox is checked: " + isStaySignedInChecked);
        //assert if condition is true
        Reusable_Method_Loggers.isConditionTrue(isStaySignedInChecked, logger);
    }//end of tc 01
}

