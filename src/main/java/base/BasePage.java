package base;

import constants.TimeOutConstant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected final Logger LOG = LogManager.getLogger(getClass());

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public Boolean waitInVisibilityOfElementLocated(By locator, long timeOutInSec) {
        LOG.info("waitInVisibilityOfElementLocated... in " + timeOutInSec + "s");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSec));
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public WebElement waitVisibilityElement(By locator, long timeOut) {
        LOG.info("waitVisibilityElement by " + locator + " in " + timeOut + "s");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }

    public WebElement waitElementClickable(By locator, long timeOut) {
        LOG.info("waitElementClickable by " + locator + " in " + timeOut + "s");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        return element;
    }

    public void inputText(By locator, String value, long timeOut) {
        LOG.info("inputText: " + locator + " with " + value + " in " + timeOut + "s");

        WebElement element = waitVisibilityElement(locator, timeOut);
        element.sendKeys(value);
    }

    public void inputText(By locator, String value) {
        inputText(locator, value, TimeOutConstant.DEFAULT_TIMEOUT);
    }

    public void click(By locator, long timeOut) {
        LOG.info("click: " + locator + " with in " + timeOut + "s");

        WebElement element = waitElementClickable(locator, timeOut);
        element.click();
    }

    public void click(By locator) {
        click(locator, TimeOutConstant.LONG_TIMEOUT);
    }

    public String getText(By locator, long timeOut) {
        LOG.info("getText: " + locator + " in " + timeOut + "s");

        WebElement element = waitVisibilityElement(locator, timeOut);
        return element.getText();
    }

    public String getText(By locator) {
        return getText(locator, TimeOutConstant.DEFAULT_TIMEOUT);
    }
}
