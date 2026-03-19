package testcases.register;

import base.BaseTest;
import constants.TimeOutConstant;
import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CommonDialog;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;
import reports.ExtentReportManager;

import java.time.Duration;
import java.util.UUID;

public class Register_01_Verify_Register_Function extends BaseTest {

    @Test(description = "Verify register successfully")
    public void testValidRegister() {
        String account = UUID.randomUUID().toString();
        System.out.println(account);
        String email = account + "@example.com";
        String password = "Test123@";

        WebDriver driver = DriverFactory.getDriver();

        //Khai báo pages
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CommonDialog commonDialog = new CommonDialog(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //Step 1: Go to demo1
        ExtentReportManager.info("Step 1: Go to demo1 website");
        LOG.info("Step 1: Go to demo1 website");

        driver.get("https://demo1.cybersoft.edu.vn");
        driver.manage().window().maximize();

        //Step 2: Click on "Đăng ký" link
        ExtentReportManager.info("Step 2: Click on \"Đăng ký\" link");
        LOG.info("Step 2: Click on \"Đăng ký\" link");

        homePage.getTopBarNavigation().navigateToRegisterPage();

        //Step 3: Enter account name
        //enterAcount(accountName, timeOut = default (10s))
//        registerPage.enterAccount(account);
        ExtentReportManager.info("Step 3: Enter account field");
        LOG.info("Step 3: Enter account field");

        registerPage.enterAccount(account);

        //Step 4: Enter password
        ExtentReportManager.info("Step 4: Enter passwordd");
        LOG.info("Step 4: Enter passwordd");

        registerPage.enterPassword(password);

        //Step 5: Re-enter password
        ExtentReportManager.info("Step 5: Re-enter password");
        LOG.info("Step 5: Re-enter password");

        registerPage.confirmPassword(password);

        //Step 6: Enter full name
        ExtentReportManager.info("Step 6: Enter full name");
        LOG.info("Step 6: Enter full name");

        registerPage.enterFullname("Khoi Do");

        //Step 7: Enter email
        ExtentReportManager.info("Step 7: Enter email");
        LOG.info("Step 7: Enter email");

        registerPage.enterEmail(email);

        //Step 8: Click "Đăng ký" button
        ExtentReportManager.info("Step 8: Click \"Đăng ký\" button");
        LOG.info("Step 8: Click \"Đăng ký\" button");

        registerPage.clickRegisterBtn(TimeOutConstant.LONG_TIMEOUT);

        //VP1: Check success message display
        ExtentReportManager.info("Step 9 - VP1: Check success message display");
        LOG.info("Step 9 - VP1: Check success message display");

        Assert.assertEquals(commonDialog.getDialogMessage(), "Đăng ký thành công", "Register failed!");
        commonDialog.waitForDialogNotDisplayed(TimeOutConstant.DEFAULT_TIMEOUT);

        //VP2: Check login successfully by login with the registered account
        ExtentReportManager.info("VP2: Check login successfully by login with the registered account");
        LOG.info("VP2: Check login successfully by login with the registered account");

        homePage.getTopBarNavigation().navigateToLoginPage();

        loginPage.enterAccount(account);
        loginPage.enterPassword(password);

        loginPage.clickLoginBtn();

        ExtentReportManager.info("VP2.1: Check login successfully message displayed");
        LOG.info("VP2.1: Check login successfully message displayed");

        Assert.assertEquals(commonDialog.getDialogMessage(), "Đăng nhập thành công", "Login failed!");
    }
}
