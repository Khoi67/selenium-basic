package pages;

import constants.TimeOutConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends CommonPage{
    private By byTxtAccountLogin = By.id("taiKhoan");
    private By byTxtPasswordLogin = By.id("matKhau");
    private By byBtnLogin = By.xpath("//button[span[text()=\"Đăng nhập\"]]");

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterAccount(String accountName, long timeOut) {
        inputText(byTxtAccountLogin, accountName);
    }
    //Override
    public void enterAccount(String accountName) {
        enterAccount(accountName, TimeOutConstant.DEFAULT_TIMEOUT);
    }

    public void enterPassword(String password, long timeOut) {
        inputText(byTxtPasswordLogin, password);
    }
    //Override
    public void enterPassword(String password) {
        enterPassword(password, TimeOutConstant.DEFAULT_TIMEOUT);
    }

    public void clickLoginBtn(long timeOut) {
        click(byBtnLogin);
    }

    public void clickLoginBtn() {
        clickLoginBtn(TimeOutConstant.DEFAULT_TIMEOUT);
    }
}

