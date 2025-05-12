package Rahulshettyacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(id = "userEmail")
    private WebElement email;

    @FindBy(id = "userPassword")
    private WebElement password;

    @FindBy(id = "login")
    private WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String user, String pass) {
        email.sendKeys(user);
        password.sendKeys(pass);
        loginBtn.click();
    }
}
