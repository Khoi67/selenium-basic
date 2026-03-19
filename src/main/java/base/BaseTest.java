package base;

import drivers.ChromeDriverManager;
import drivers.DriverFactory;
import drivers.DriverManager;
import drivers.DriverManagerFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import reports.ExtentReportManager;

import java.lang.reflect.Method;

public class BaseTest {

    protected final Logger LOG = LogManager.getLogger(getClass());
    @BeforeSuite
    public void beforeSuit() {
        LOG.info("beforeSuit");
        //Create extent report
        ExtentReportManager.initializeExtentReports();
    }

    @BeforeClass
    public void beforeClass() {
        LOG.info("beforeClass");

        DriverManager driverManager = DriverManagerFactory.getDriverManager("chrome");
        driverManager.createWebDriver();
        WebDriver driver = driverManager.getDriver();
        DriverFactory.setWebDriverThreadLocal(driver);
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        LOG.info("beforeMethod: " + method);
        //Get testcase name
        ExtentReportManager.createTest(method.getName());
    }

    @AfterMethod
    public void afterMethod(ITestResult testResult) {
        String methodName = testResult.getMethod().getMethodName();
        if(testResult.getStatus() == ITestResult.FAILURE) {
            ExtentReportManager.captureScreenshot(DriverFactory.getDriver(), methodName);
            // Show lỗi cụ thể
            ExtentReportManager.fail(testResult.getThrowable().toString());
        }
        LOG.info("Test method: " + methodName + " - END");
    }
    
    @AfterClass
    public void afterClass() {
        LOG.info("afterClass");

        WebDriver driver = DriverFactory.getDriver();
        if (driver != null) {
            driver.quit();
        }
        //Xóa thread local de do tốn bộ nhớ
        DriverFactory.removeDriverThreadLocal();
    }

    @AfterSuite
    public void afterSuit() {
        ExtentReportManager.flushReports();
        LOG.info("----- SUIT END -----");
    }
}
