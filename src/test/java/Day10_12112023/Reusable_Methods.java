package Day10_12112023;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashMap;

public class Reusable_Methods {

    //create a click method to click on any web element
    public static void clickMethod(WebDriver driver, String xpath, int index, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName);
        }
    }


    public static void clickMethodWithoutIndexP(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName);
        }
    }

    public static void clickMethodWithoutIndexV(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName);
        }
    }

    public static void clickMethodWithoutIndexClickable(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName);
        }
    }

    public static void clickByIndexMethodV(WebDriver driver, String xpath, int index, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ":" + e);
        }
    }

    public static void clickByIndexMethod(WebDriver driver, String xpath, int index, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ":" + e);
        }
    }//end of clickByIndexMethod


    public static void submitMethod(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).submit();
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName);
        }
    }//end of click method

    public static String captureText(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String result = "";
        try {
            result = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).getText();
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Unable to get text " + ":" + e);
        }
        return result;
    }

    public static String captureTextByIndex(WebDriver driver, String xpath, int index, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String result = "";
        try {
            result = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).getText();
        } catch (Exception e) {
            System.out.println("Unable to get text " + ":" + e);
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


    public static void sendKeysMethod(WebDriver driver, String xpath, int index, String UserValue, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).sendKeys(UserValue);
        } catch (Exception e) {
            System.out.println("Unable to sendkeys on element " + elementName + ":" + e);
        }//end of try catch
    }

    public static void clearMethod(WebDriver driver, String xpath, int index, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).clear();
        } catch (Exception e) {
            System.out.println("Unable to clear on element " + elementName + ":" + e);
        }
    }


    public static void scrollToElementByXPath(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            System.out.println("Unable to scroll to element " + e);
        }
    }

    public static void scrollByPixel(WebDriver driver, String xValue, String yValue, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("scroll(" + xValue + "," + yValue + ")");
        } catch (Exception e) {
            System.out.println("Unable to scroll by pixels ");
        }
    }


    public static void selectByVisibleText(WebDriver driver, String xpath, String visibleText, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select selectDropdown = new Select(element);
            selectDropdown.selectByVisibleText(visibleText);
        } catch (Exception e) {
            System.out.println("Unable to select " + visibleText + " from " + elementName + ": " + e);
        }
    }

    public static void mouseActionsMethod(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            Actions mouseAction = new Actions(driver);
            WebElement quickTool = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            mouseAction.moveToElement(quickTool).perform();
        } catch (Exception e) {
            System.out.println("Unable to mouseAction to" + elementName);
        }
    }

    public static void mouseActionsClickMethod(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            Actions mouseAction = new Actions(driver);
            WebElement quickTool = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            mouseAction.moveToElement(quickTool).click().perform();
        } catch (Exception e) {
            System.out.println("Unable to mouseAction to" + elementName);
        }
    }

    public static void mouseActionsClickMethodIndex(WebDriver driver, String xpath, int index, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            Actions mouseAction = new Actions(driver);
            WebElement quickTool = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index);
            mouseAction.moveToElement(quickTool).click().perform();
        } catch (Exception e) {
            System.out.println("Unable to mouseAction to" + elementName);
        }
    }

    public static void switchToTabByIndex(WebDriver driver, int index, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(index));
        } catch (Exception e) {
            System.out.println("Unable to Switch Tabs" + elementName);
        }
    }

    public static void clickElementWithJs(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            jsExecutor.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to click element using JavascriptExecutor");
        }
    }


    public static void mouseActionsDoubleClickMethod(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            Actions mouseAction = new Actions(driver);
            WebElement quickTool = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            mouseAction.moveToElement(quickTool).doubleClick().perform();
        } catch (Exception e) {
            System.out.println("Unable to mouseAction to" + elementName);
        }
    }

    public static void mouseActionsRightClickMethod(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            Actions mouseAction = new Actions(driver);
            WebElement quickTool = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            mouseAction.moveToElement(quickTool).contextClick().perform();
        } catch (Exception e) {
            System.out.println("Unable to mouseAction to" + elementName);
        }
    }

    public static void typeTextByJSE(WebDriver driver, String xpath, String userValue, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement textField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            String textToType = new String(userValue);
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].value = arguments[1];", textField, textToType);
        } catch (Exception e) {
            System.out.println("Unable to type text into  " + elementName);
        }
    }


    public static WebElement hrefGetAttribute(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement newLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            String hrefAttributeValue = newLink.getAttribute("href");

            System.out.println("Href Attribute Value: " + hrefAttributeValue);
        } catch (Exception e) {
            System.out.println("Unable to getAttribute " + elementName);
        }
        return null;
    }


    public static void openCurrentURLMethod(WebDriver driver, String capturedUrl) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("window.open('" + capturedUrl + "','_blank');");
        } catch (Exception e) {
            System.out.println("Unable to open : " + capturedUrl + "on a new tab");
        }
    }

    public static void captureHrefAndClick(WebDriver driver, String xpath, int Index, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement newMailingLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            String hrefAttributeValue = newMailingLink.getAttribute("href");
            System.out.println("Href Attribute Value: " + hrefAttributeValue);
            openNewTab(driver);
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(Index));
            driver.get(hrefAttributeValue);
        } catch (Exception e) {
            System.out.println("Unable to capture href and Open tab" + elementName);
        }
    }

    public static void openNewTab(WebDriver driver) {
        // Execute JavaScript to open a new tab
        ((JavascriptExecutor) driver).executeScript("window.open();");
    }

    public static void booleanMethod(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            boolean elementState = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).isSelected();
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName);
        }
    }


}







