package drivers;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

    // Chống bị race-condition (Chạy độc lập Driver)
    private static final ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    public static void setWebDriverThreadLocal(WebDriver driver) {
        webDriverThreadLocal.set(driver);
    }

    public static WebDriver getDriver() {
        return webDriverThreadLocal.get();
    }

    public static void removeDriverThreadLocal() {
        webDriverThreadLocal.remove();
    }
}
