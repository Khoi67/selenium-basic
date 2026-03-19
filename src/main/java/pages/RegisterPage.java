package pages;

import constants.TimeOutConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends CommonPage{
    private By byTxtAccount = By.id("taiKhoan");
    private By byTxtPassword = By.id("matKhau");
    private By byTxtConfirmPassword = By.id("confirmPassWord");
    private By byTxtFullname = By.id("hoTen");
    private By byTxtEmail = By.id("email");
    private By byBtnRegister = By.xpath("//button[span[text()=\"Đăng ký\"]]");

    private WebDriver driver;
    //constructor
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    //Account
    public void enterAccount(String accountName, long timeOut) {
        inputText(byTxtAccount, accountName);
    }
    public void enterAccount(String accountName) {
        enterAccount(accountName, TimeOutConstant.DEFAULT_TIMEOUT);
    }

    //Password
    public void enterPassword(String password, long timeOut) {
       inputText(byTxtPassword, password);
    }

    public void enterPassword(String password) {
        enterPassword(password, TimeOutConstant.DEFAULT_TIMEOUT);
    }

    public void confirmPassword(String password, long timeOut) {
        inputText(byTxtConfirmPassword, password);
    }

    public void confirmPassword(String password) {
        confirmPassword(password, TimeOutConstant.DEFAULT_TIMEOUT);
    }

    //Fullname
    public void enterFullname(String fullname, long timeOut) {
        inputText(byTxtFullname, fullname);
    }

    public void enterFullname(String fullname) {
        enterFullname(fullname, TimeOutConstant.DEFAULT_TIMEOUT);
    }

    //Email
    public void enterEmail(String email, long timeOut) {
        inputText(byTxtEmail, email);
    }

    public void enterEmail(String email) {
        enterEmail(email, TimeOutConstant.DEFAULT_TIMEOUT);
    }

    //Click btn
    public void clickRegisterBtn(long timeOut) {
        click(byBtnRegister);
    }

    public void clickRegisterBtn() {
        clickRegisterBtn(TimeOutConstant.DEFAULT_TIMEOUT);
    }


}
