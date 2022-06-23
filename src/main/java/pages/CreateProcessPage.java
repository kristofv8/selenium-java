package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.UUID;

public class CreateProcessPage {

    protected WebDriver driver;

    public CreateProcessPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Name")
    private WebElement processNameInputField;

    @FindBy(id = "Description")
    private WebElement processDescriptionInputField;

    @FindBy(id = "Notes")
    private WebElement processNotesInputField;

    @FindBy(css = "input[value=Create]")
    private WebElement processCreateButton;

    @FindBy(css = "span[class$=field-validation-error]")
    private WebElement errorMessage;

    @FindBy(linkText = "Back to List")
    private WebElement backToListButton;

    public static String generateProcessUUID() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    public CreateProcessPage typeName(String randomProcessName) {
        processNameInputField.clear();
        processNameInputField.sendKeys(randomProcessName);
        return this;
    }

    public CreateProcessPage typeDescription(String description) {
        processDescriptionInputField.clear();
        processDescriptionInputField.sendKeys(description);
        return this;
    }

    public CreateProcessPage typeNotes(String notes) {
        processNotesInputField.clear();
        processNotesInputField.sendKeys(notes);
        return this;
    }

    public ProcessesPage clickCreate() {
        processCreateButton.click();
        return new ProcessesPage(driver);
    }

    public CreateProcessPage clickCreateWithFailure() {
        processCreateButton.click();
        return this;
    }

    public CreateProcessPage assertErrorMessage(String expErrorMessage) {
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(), expErrorMessage, "Error message is not visible");
        return this;
    }

    public ProcessesPage clickBackToList() {
        backToListButton.click();
        return new ProcessesPage(driver);
    }
}
