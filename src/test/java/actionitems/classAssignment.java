package actionitems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Array;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;

import static io.github.bonigarcia.wdm.WebDriverManager.safaridriver;

public class classAssignment {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> firstName = new ArrayList<>();
        firstName.add("Devon");
        firstName.add("James");

        ArrayList<String> lastName = new ArrayList<>();
        lastName.add("King");
        lastName.add("Cat");

        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11221");
        zipCode.add("11432");

        ArrayList<String> dob = new ArrayList<>();
        dob.add("05081995");
        dob.add("09011978");

        ArrayList<String> vehicleYear = new ArrayList<>();
        vehicleYear.add("2005");
        vehicleYear.add("2021");

        ArrayList<String> vehicleMake = new ArrayList<>();
        vehicleMake.add("Mercedez Benz");
        vehicleMake.add("Toyota");

        ArrayList<String> vehicleModel = new ArrayList<>();
        vehicleModel.add("Sprinter");
        vehicleModel.add("Rav4");

        ArrayList<String> daysPerWeek = new ArrayList<>();
        daysPerWeek.add("5");
        daysPerWeek.add("4");

        ArrayList<String> miles = new ArrayList<>();
        miles.add("175");//inedx 0
        miles.add("90");//index 1

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //set chromeoption for preset of arguments for driver
        //SafariDriver options = new SafariDriver();
        options.addArguments("incognito");
        //declare your web driver and pass the options variable inside the chromedriver
        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("https://www.Geico.com");
        driver.manage().window().maximize();

        for (int i = 0; i < vehicleModel.size(); i++){
            //click Auto box
            try {
                driver.findElement(By.xpath("//*[contains (@class, 'btn btn--primary')]"));
                ArrayList<WebElement> checkBox = new ArrayList<>(driver.findElements(By.xpath("//*[@class='product-checkbox']")));
                checkBox.get(0).click();
            } catch(Exception e) {
                System.out.println("Unable to click Auto Check Box " + e);
            }
            try {
                Thread.sleep(1000);
                //click on Start My Quote
                driver.findElement(By.xpath("//*[@class='modal-trigger btn btn--primary btn--full-mobile']")).click();
            }catch (Exception e){
                System.out.println("Unable to click Start My Quote " + e);
            }
            Thread.sleep(1000);
            //enter 5 digit zip
            try {
            driver.findElement(By.xpath("//*[@id = 'bundle-modal-zip']")).sendKeys(zipCode.get(i));
            } catch(Exception e) {
                System.out.println("Unable to send zipcode " + e);
            }
            Thread.sleep(1000);
            //click Homeowners box
                try {
            ArrayList<WebElement> checkBox = new ArrayList<>(driver.findElements(By.xpath("//*[@class='product-checkbox']")));
            checkBox.get(6).click();
                } catch(Exception e) {
                    System.out.println("Unable to click homeowners check box " + e);
                }
            Thread.sleep(1000);
            //click Continue button
            try {
            driver.findElement(By.xpath("//*[@value = 'Continue']")).click();
            } catch(Exception e) {
                System.out.println("Unable to click continue button " + e);
            }
            Thread.sleep(4000);
            //enter date of birth into field
            try {
            driver.findElement(By.xpath("//*[@class='date']")).sendKeys(dob.get(i));
            } catch(Exception e) {
                System.out.println("Unable to send date of birth " + e);
            }
            Thread.sleep(1000);
            //click Next Button
            try {
            driver.findElement(By.xpath("//*[contains (@class, 'btn btn--primary')]")).click();
            } catch(Exception e) {
                System.out.println("Unable to click next for DOB " + e);
            }
            //Add First and Last Name into respective fields
            //make an Array List for first name field
            Thread.sleep(7000);
            try {
            ArrayList<WebElement> firstNameField = new ArrayList<>(driver.findElements(By.xpath("//*[contains(@id, 'Id_GiveFirstName')]")));
            firstNameField.get(1).sendKeys(firstName.get(i));
            } catch(Exception e) {
                System.out.println("Unable to send first name " + e);
            }
            Thread.sleep(1000);
            //make an Array List for last name field
            try {
            ArrayList<WebElement> lastNameField = new ArrayList<>(driver.findElements(By.xpath("//*[contains(@id, 'Id_GiveLastName')]")));
            lastNameField.get(1).sendKeys(lastName.get(i));
            } catch(Exception e) {
                System.out.println("Unable to send last name " + e);
            }
            //click Next Button
            try {
                driver.findElement(By.xpath("//*[contains (@class, 'btn btn--primary')]")).click();
            } catch(Exception e) {
                System.out.println("Unable to click next for name input "+ e);
            }
            Thread.sleep(5000);
            //enter address and apt number into respective fields
            try {
            if (i==0){
                driver.findElement(By.xpath("//*[contains(@class,'address-search-field')]")).sendKeys("816 Greene Ave");
                Thread.sleep(1000);
                driver.findElement(By.xpath("//*[@aria-label='Apt #']")).sendKeys("1");
            } else if (i==1){
                driver.findElement(By.xpath("//*[contains(@class,'address-search-field')]")).sendKeys("88-23 171st Street");
                Thread.sleep(1000);
                driver.findElement(By.xpath("//*[@aria-label='Apt #']")).sendKeys("1R");
            }
        }catch(Exception e) {
                System.out.println("Unable to send address or apartment number " + e);
            }
            Thread.sleep(1000);
            //click Next Button
            try {
            driver.findElement(By.xpath("//*[contains (@class, 'btn btn--primary')]")).click();
            }catch(Exception e) {
                System.out.println("Unable to click next button for address " + e);
            }

            //Make ArrayList for Yes Button
            try {
                Thread.sleep(12000);
            ArrayList<WebElement> radioButtons = new ArrayList<>(driver.findElements(By.xpath("//*[contains(@id,'labelFor')]")));
            radioButtons.get(0).click();
            }catch(Exception e) {
                System.out.println("Unable to click yes after address page " + e);
            }
            //Make Arraylist for No Button
            Thread.sleep(1000);
            //click Next
            try{
            driver.findElement(By.xpath("//*[contains (@class, 'btn btn--primary')]")).click();
            }catch(Exception e) {
                System.out.println("Unable to click next button for prior address " + e);
            }
            Thread.sleep(4000);
            //reminder to add ArrayList again after implementing try catch
            try{
                ArrayList<WebElement> radioButtons = new ArrayList<>(driver.findElements(By.xpath("//*[contains(@id,'labelFor')]")));
            radioButtons.get(1).click();
            }catch(Exception e) {
                System.out.println("Unable to click no button  " + e);
            }
            Thread.sleep(1000);
            //Click Next
            try{
            driver.findElement(By.xpath("//*[contains (@class, 'btn btn--primary')]")).click();
            }catch(Exception e) {
                System.out.println("Unable to click next button  " + e);
            }
            //reminder to add ArrayList again after implementing try catch
            Thread.sleep(4000);
            try {
                ArrayList<WebElement> radioButtons = new ArrayList<>(driver.findElements(By.xpath("//*[contains(@id,'labelFor')]")));
                radioButtons.get(0).click();
            }catch(Exception e) {
                System.out.println("Unable to click No button  " + e);
            }
            //click Next Button
            Thread.sleep(1000);
            try{
            driver.findElement(By.xpath("//*[contains (@class, 'btn btn--primary')]")).click();
            }catch(Exception e) {
                System.out.println("Unable to click Next button  " + e);
            }
            Thread.sleep(4000);
            //add prior street address
            try{
            if (i==0){
                driver.findElement(By.xpath("//*[contains(@class,'address-search-field')]")).sendKeys("188 Utica Ave");
                Thread.sleep(1000);
                driver.findElement(By.xpath("//*[@aria-label='Apt #']")).sendKeys("1");
                Thread.sleep(1000);
                driver.findElement(By.xpath("//*[@aria-label ='5-Digit ZIP Code']")).sendKeys("11213");
                Thread.sleep(1000);
            } else if (i==1){
                driver.findElement(By.xpath("//*[contains(@class,'address-search-field')]")).sendKeys("90-04 Jamaica Ave");
                Thread.sleep(1000);
                driver.findElement(By.xpath("//*[@aria-label='Apt #']")).sendKeys("2");
                Thread.sleep(1000);
                driver.findElement(By.xpath("//*[@aria-label ='5-Digit ZIP Code']")).sendKeys("11421");
                Thread.sleep(1000);
            }
            }catch(Exception e) {
                System.out.println("Unable to send prior address, apartment number or zip " + e);
            }
            //click Next
            try{
            driver.findElement(By.xpath("//*[contains (@class, 'btn btn--primary')]")).click();
            }catch(Exception e) {
                System.out.println("Unable to click Next button " + e);
            }
            Thread.sleep(4000);
            //Click No
                try{
                driver.findElements(By.xpath("//*[@class='radio react-markdown ']")).get(1).click();
                }catch(Exception e) {
                    System.out.println("Unable to click No button" + e);
                }
            Thread.sleep(1000);
            //click Next
            try{
            driver.findElement(By.xpath("//*[contains (@class, 'btn btn--primary')]")).click();
            }catch(Exception e) {
                System.out.println("Unable to click Next button" + e);
            }
            Thread.sleep(4000);
            try{
            WebElement year = driver.findElement(By.xpath("//*[@aria-label = 'Year']"));
            Select yearSelect = new Select(year);
            //else if for year
            driver.findElement(By.xpath("//*[@aria-label ='Year']")).click();
            }catch(Exception e) {
                System.out.println("Unable to click Year button" + e);
            }
            try{
            if (i==0){
                driver.findElement(By.xpath("//*[text() = '2005']")).click();
            }else if (i==1){
                driver.findElement(By.xpath("//*[text() = '2021']")).click();
            } }catch(Exception e) {
                System.out.println("Unable to send year " + e);
            }

            Thread.sleep(1000);

            //else if for make select box
            try{
            driver.findElement(By.xpath("//*[@aria-label ='Make']")).click();
            }catch(Exception e) {
                System.out.println("Unable to click Make button" + e);
            }
            try{
            if (i==0){
                driver.findElement(By.xpath("//*[text() = 'Mercedes Benz']")).click();
            } else if (i==1){
                driver.findElement(By.xpath("//*[text() = 'Toyota']")).click();
            }}catch(Exception e) {
                System.out.println("Unable to send Make " + e);
            }

            Thread.sleep(1000);

            //else if for model select box
            try{
            driver.findElement(By.xpath("//*[@aria-label ='Model']")).click();
            }catch(Exception e) {
                System.out.println("Unable to click Model button" + e);
            }
            try{
            if (i==0){
                driver.findElement(By.xpath("//*[text() = 'S430']")).click();
            }else if (i==1){
                driver.findElement(By.xpath("//*[text() = 'Rav4']")).click();
            } }catch(Exception e) {
                System.out.println("Unable to send Model " + e);
            }

            Thread.sleep(1000);
            //Click Next
            try{
            driver.findElement(By.xpath("//*[contains (@class, 'btn btn--primary')]")).click();
            }catch(Exception e) {
                System.out.println("Unable to click next button for Year, Make, Model page " + e);
            }
            //click Next
            Thread.sleep(1000);
            try{
            driver.findElement(By.xpath("//*[contains (@class, 'btn btn--primary')]")).click();
            }catch(Exception e) {
                System.out.println("Unable to click next button  " + e);
            }
            //click leased radio button
            try{
            driver.findElement(By.xpath("//*[@id = 'labelForL']")).click();
            }catch(Exception e) {
                System.out.println("Unable to click leasing button " + e);
            }
            Thread.sleep(1000);
            try{
            driver.findElement(By.xpath("//*[contains (@class, 'btn btn--primary')]")).click();
            }catch(Exception e) {
                System.out.println("Unable to click next button for type of ownership page " + e);
            }
            Thread.sleep(4000);
            //click no radio button
            //reminder to add arraylist after implementing try catch
            try{
            driver.findElements(By.xpath("//*[@class='radio react-markdown ']")).get(1).click();
            }catch(Exception e) {
                System.out.println("Unable to click no button " + e);
            }
            Thread.sleep(1000);
            //click next
            try{
            driver.findElement(By.xpath("//*[contains (@class, 'btn btn--primary')]")).click();
            }catch(Exception e) {
                System.out.println("Unable to click next button " + e);
            }
            Thread.sleep(4000);
            //click commute button
            try{
            driver.findElement(By.xpath("//*[@id = 'labelForC']")).click();
            }catch(Exception e) {
                System.out.println("Unable to click commute button " + e);
            }
            Thread.sleep(1000);
            try{
            driver.findElement(By.xpath("//*[contains (@class, 'btn btn--primary')]")).click();
            }catch(Exception e) {
                System.out.println("Unable to click next button for commute page " + e);
            }
            Thread.sleep(4000);
            try{
            driver.findElement(By.xpath("//*[@aria-label ='Days per Week']")).click();
            }catch(Exception e) {
                System.out.println("Unable to click days per week dropdown " + e);
            }
            Thread.sleep(1000);
            //add else if for amound of days per week
            try{
            if (i==0){
                driver.findElement(By.xpath("//*[text() = '5']"));
            }else if (i==1){
                driver.findElement(By.xpath("//*[text() = '4']"));
            }}catch(Exception e) {
                System.out.println("Unable to click amount of days " + e);
            }
            //input miles one-way
            Thread.sleep(1000);
            try{
            driver.findElement(By.xpath("//*[@type = 'tel']")).sendKeys(miles.get(i));
            }catch(Exception e) {
                System.out.println("Unable to send miles in text field " + e);
            }
            Thread.sleep(1000);
            //click next 3 times
            try{
            driver.findElement(By.xpath("//*[contains (@class, 'btn btn--primary')]")).click();
            }catch(Exception e) {
                System.out.println("Unable to next button for miles page " + e);
            }
            Thread.sleep(1000);
            try{
            driver.findElement(By.xpath("//*[contains (@class, 'btn btn--primary')]")).click();
            }catch(Exception e) {
                System.out.println("Unable to next button for " + e);
            }
            Thread.sleep(1000);
            try{
            driver.findElement(By.xpath("//*[contains (@class, 'btn btn--primary')]")).click();
            }catch(Exception e) {
                System.out.println("Unable to next button  " + e);
            }
            Thread.sleep(4000);
            try{
            driver.findElement(By.xpath("//*[@aria-label = 'Gender']")).click();
            }catch(Exception e) {
                System.out.println("Unable to Gender dropdown " + e);
            }
            Thread.sleep(1000);
            try{
            driver.findElement(By.xpath("//*[@value ='Male']")).click();
            }catch(Exception e) {
                System.out.println("Unable to click male  " + e);
            }
            try{

            driver.findElement(By.xpath("//*[@type ='submit']")).click();
            }catch(Exception e) {
                System.out.println("Unable to click Agree & Continue " + e);
            }
        }//end of loop
    }//end of main
}//end of class
