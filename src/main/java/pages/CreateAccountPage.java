package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class CreateAccountPage {

    protected WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Email")
    private WebElement emailTxt;

    @FindBy(id = "Password")
    private WebElement passwordTxt;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordTxt;

    @FindBy(css = "button[type=submit]")
    private WebElement registerBtn;

    @FindBy(id = "ConfirmPassword-error")
    private WebElement confirmPasswordErrorTxt;

    @FindBy(css = ".validation-summary-errors>ul>li")
    public List<WebElement> loginErrors;


    public CreateAccountPage typeEmail(String email) {
        emailTxt.clear();
        emailTxt.sendKeys(email);
        return this;
    }

    public CreateAccountPage typePassword(String password) {
        passwordTxt.clear();
        passwordTxt.sendKeys(password);
        return this;
    }

    public CreateAccountPage typeConfirmPassword(String confirmPassword) {
        confirmPasswordTxt.clear();
        confirmPasswordTxt.sendKeys(confirmPassword);
        return this;
    }

    public CreateAccountPage registerWithFailure() {
        registerBtn.click();
        return this;
    }

    public CreateAccountPage assertErrorIsShown(String errorText) {
        Assert.assertTrue(confirmPasswordErrorTxt.isDisplayed(), "Password error text is not visible");
        Assert.assertEquals(confirmPasswordErrorTxt.getText(), errorText, "Password error text doesn't match");
        return this;
    }

    public CreateAccountPage assertListOfErrorsIsShown() {
        int errorIsDisplayed = loginErrors.size();
        Assert.assertTrue(errorIsDisplayed > 0, "List of errors is empty");
        return this;
    }

    public CreateAccountPage assertTextErrorsOnList(String errorText) {
        String getErrorText = loginErrors.get(0).getText();
        Assert.assertEquals(getErrorText, errorText, "Password error text on the list doesn't match");
        return this;
    }

    public CreateAccountPage typeRandomEmail(String randomEmail, String email) {

        emailTxt.clear();
        emailTxt.sendKeys(randomEmail + email);
        return this;
    }

    public HomePage successfulRegister() {
        registerBtn.click();
        return new HomePage(driver);
    }
}
