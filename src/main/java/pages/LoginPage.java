package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    protected WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(partialLinkText = "Register")
    private WebElement registerLnk;

    @FindBy(id = "Email")
    private WebElement emailInputField;

    @FindBy(id = "Password")
    private WebElement passwordInputField;

    @FindBy(css = "button[type=submit]")
    private WebElement loginBtn;

    public CreateAccountPage goToRegisterPage() {
        registerLnk.click();
        return new CreateAccountPage(driver);
    }

    public LoginPage typeEmail(String email) {
        emailInputField.clear();
        emailInputField.sendKeys(email);
        return this;
    }

    public LoginPage typePassword(String password) {
        passwordInputField.clear();
        passwordInputField.sendKeys(password);
        return this;
    }

    public HomePage submitLogin() {
        loginBtn.click();
        return new HomePage(driver);
    }
}

