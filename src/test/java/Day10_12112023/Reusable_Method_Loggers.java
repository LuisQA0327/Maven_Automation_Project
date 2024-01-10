package Day10_12112023;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import static Day13_12192023.TestParent.logger;

public class Reusable_Method_Loggers {

    //create a click method to click on any web element
    public static void clickMethodB(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ":" + e);
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
            getScreenShot(driver, elementName, logger);
        }
    }

    //end of click method

    public static void isConditionTrue(boolean bool, ExtentTest logger) {
        if (bool == true) {
            logger.log(LogStatus.PASS, "Boolean Condition is " + bool);
        } else {
            logger.log(LogStatus.FAIL, "Boolean Condition is " + bool);

        }
    }//end of isConditionTrue method

    public static void clickMethod(WebDriver driver, String xpath, int index, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName);
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
            getScreenShot(driver, elementName, logger);
        }
    }


    public static void clickMethodWithoutIndexP(WebDriver driver, String xpath, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName);
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
            getScreenShot(driver, elementName, logger);
        }
    }

    public static void clickMethodWithoutIndexV(WebDriver driver, String xpath, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName);
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
            getScreenShot(driver, elementName, logger);
        }
    }

    public static void clickMethodWithoutIndexClickable(WebDriver driver, String xpath, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName);
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
            getScreenShot(driver, elementName, logger);
        }
    }

    public static void clickByIndexMethodV(WebDriver driver, String xpath, int index, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ":" + e);
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
            getScreenShot(driver, elementName, logger);
        }
    }

    public static void clickByIndexMethod(WebDriver driver, String xpath, int index, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ":" + e);
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
            getScreenShot(driver, elementName, logger);
        }
    }//end of clickByIndexMethod


    public static void submitMethod(WebDriver driver, String xpath, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).submit();
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName);
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
            getScreenShot(driver, elementName, logger);
        }
    }//end of click method

    public static String captureText(WebDriver driver, String xpath, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String result = "";
        try {
            result = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).getText();
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Unable to get text " + ":" + e);
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
            getScreenShot(driver, elementName, logger);
        }
        return result;
    }

    public static String captureTextByIndex(WebDriver driver, String xpath, int index, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String result = "";
        try {
            result = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).getText();
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to get text " + ":" + e);
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
            getScreenShot(driver, elementName, logger);
        }
        return result;
    }

    public static WebDriver setUpDriver() {
        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //declare chrome options variable
        ChromeOptions options = new ChromeOptions();
        //maximize for windows
        HashMap<String, Object> chromePrefs = new HashMap<>();
        String downloadFilePath = System.getProperty("user.dir") + "/Users/sergio/Desktop/Spring_Automation_Project/Maven_Automation_Project/src/test/java/downloadFiles";
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadFilePath);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("start-maximized");
        //open in incognito mode
        options.addArguments("incognito");
        //define the webdriver
        WebDriver driver = new ChromeDriver(options);
        //return a driver instance
        driver.manage().window().maximize();
        return driver;
    }//end of setupdriver method

    //create a click method to click on any web element by index


    public static void sendKeysMethod(WebDriver driver, String xpath, int index, String UserValue, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).sendKeys(UserValue);
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to sendkeys on element " + elementName + ":" + e);
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
            getScreenShot(driver, elementName, logger);
        }//end of try catch
    }

    public static void clearMethod(WebDriver driver, String xpath, int index, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).clear();
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to clear on element " + elementName + ":" + e);
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
            getScreenShot(driver, elementName, logger);
        }
    }


    public static void scrollToElementByXPath(WebDriver driver, String xpath, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to scroll to element " + e);
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
            getScreenShot(driver, elementName, logger);
        }
    }

    public static void scrollByPixel(WebDriver driver, String xValue, String yValue, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("scroll(" + xValue + "," + yValue + ")");
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to scroll by pixels ");
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
            getScreenShot(driver, elementName, logger);
        }
    }


    public static void selectByVisibleText(WebDriver driver, String xpath, String visibleText, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            Select selectDropdown = new Select(element);
            selectDropdown.selectByVisibleText(visibleText);
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to select " + visibleText + " from " + elementName + ": " + e);
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
            getScreenShot(driver, elementName, logger);
        }
    }

    public static void mouseActionsMethod(WebDriver driver, String xpath, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            Actions mouseAction = new Actions(driver);
            WebElement quickTool = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            mouseAction.moveToElement(quickTool).perform();
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to mouseAction to" + elementName);
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
            getScreenShot(driver, elementName, logger);
        }
    }

    public static void mouseActionsClickMethod(WebDriver driver, String xpath, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            Actions mouseAction = new Actions(driver);
            WebElement quickTool = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            mouseAction.moveToElement(quickTool).click().perform();
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to mouseAction to" + elementName);
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
            getScreenShot(driver, elementName, logger);
        }
    }

    public static void mouseActionsClickMethodIndex(WebDriver driver, String xpath, int index, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            Actions mouseAction = new Actions(driver);
            WebElement quickTool = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index);
            mouseAction.moveToElement(quickTool).click().perform();
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to mouseAction to" + elementName);
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
            getScreenShot(driver, elementName, logger);
        }
    }

    public static void switchToTabByIndex(WebDriver driver, int index, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(index));
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to Switch Tabs" + elementName);
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
            getScreenShot(driver, elementName, logger);
        }
    }

    public static void clickElementWithJs(WebDriver driver, String xpath, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            jsExecutor.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to click element using JavascriptExecutor");

        }
    }


    public static void mouseActionsDoubleClickMethod(WebDriver driver, String xpath, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            Actions mouseAction = new Actions(driver);
            WebElement quickTool = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            mouseAction.moveToElement(quickTool).doubleClick().perform();
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to mouseAction to" + elementName);
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
            getScreenShot(driver, elementName, logger);
        }
    }

    public static void mouseActionsRightClickMethod(WebDriver driver, String xpath, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            Actions mouseAction = new Actions(driver);
            WebElement quickTool = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            mouseAction.moveToElement(quickTool).contextClick().perform();
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to mouseAction to" + elementName);
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
            getScreenShot(driver, elementName, logger);
        }
    }

    public static void typeTextByJSE(WebDriver driver, String xpath, String userValue, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement textField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            String textToType = new String(userValue);
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].value = arguments[1];", textField, textToType);
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to type text into  " + elementName);
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
            getScreenShot(driver, elementName, logger);
        }
    }


    public static WebElement hrefGetAttribute(WebDriver driver, String xpath, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement newLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            String hrefAttributeValue = newLink.getAttribute("href");

            System.out.println("Href Attribute Value: " + hrefAttributeValue);
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to getAttribute " + elementName);
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
            getScreenShot(driver, elementName, logger);
        }
        return null;
    }


    public static void openCurrentURLMethod(WebDriver driver, String capturedUrl, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("window.open('" + capturedUrl + "','_blank');");
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to open : " + capturedUrl + "on a new tab");
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
            getScreenShot(driver, elementName, logger);
        }
    }

    public static void captureHrefAndClick(WebDriver driver, String xpath, int Index, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement newMailingLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            String hrefAttributeValue = newMailingLink.getAttribute("href");
            System.out.println("Href Attribute Value: " + hrefAttributeValue);
            openNewTab(driver);
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(Index));
            driver.get(hrefAttributeValue);
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to capture href and Open tab" + elementName);
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
            getScreenShot(driver, elementName, logger);
        }
    }

    public static void openNewTab(WebDriver driver) {
        // Execute JavaScript to open a new tab
        ((JavascriptExecutor) driver).executeScript("window.open();");

    }

    public static void booleanMethod(WebDriver driver, String xpath, String elementName, ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            boolean elementState = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).isSelected();
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName);
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
            getScreenShot(driver, elementName, logger);
        }
    }

    public static void selectByValue(WebDriver driver, String xpath, String selectValue, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement value = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            //set the select function for the start month dropdown
            Select selectedValue = new Select(value);
            //select by visible text
            selectedValue.selectByValue(selectValue);
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to select by visible text");
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
            getScreenShot(driver, elementName, logger);
        }
    }

    public static void moveByOffsetX(WebDriver driver, String xpath,int target, int yOffset, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        try {
            WebElement sliderHandle = driver.findElement(By.xpath(xpath));
            // Calculate the target offset (adjust this value based on your requirements)
            int targetOffset = target;
            // Use the Actions class to perform the drag-and-drop operation
            Actions builder = new Actions(driver);
            // Click and hold on the slider handle
            builder.clickAndHold(sliderHandle).perform();
            // Move the slider handle to the desired location
            builder.moveByOffset(targetOffset, 0).perform();
            // Release the slider handle
            builder.release().perform();
            // Pause for a moment (you may adjust this based on your needs)
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        }catch(Exception e){
            System.out.println("Unable to move " + e);
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
            getScreenShot(driver, elementName, logger);
        }
    }

    public static void getScreenShot(WebDriver driver, String imageName, ExtentTest logger) {
        try {
            String fileName = imageName + ".png";
            String directory = null;
            String snPath = null;
            directory = "src/main/java/HTML_Report/Screenshots/";
            snPath = "Screenshots//";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error occurred while taking SCREENSHOT!!!");
            e.printStackTrace();

        }
    }//end of getScreenshot method
}

