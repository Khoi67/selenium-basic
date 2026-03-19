package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;

public class SafariDriverManger extends DriverManager{

    @Override
    public void createWebDriver() {
        this.driver = new SafariDriver();
    }
}
