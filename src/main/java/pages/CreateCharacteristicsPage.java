package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CreateCharacteristicsPage {

    protected WebDriver driver;

    public CreateCharacteristicsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Name")
    private WebElement nameInputField;

    @FindBy(id = "LowerSpecificationLimit")
    private WebElement lowSpcLimitInputField;

    @FindBy(id = "UpperSpecificationLimit")
    private WebElement upSpcLimitInputField;

    @FindBy(id = "HistogramBinCount")
    private WebElement histogramInputField;

    @FindBy(id = "ProjectId")
    private WebElement selectProcess;

    @FindBy(css = "input[value=Create]")
    private WebElement createButton;

    @FindBy(css = "span[class$=field-validation-error]")
    private WebElement errorMessage;

    @FindBy(linkText = "Back to List")
    private WebElement backToListButton;

    public CreateCharacteristicsPage typeCharacteristicsName(String name) {
        nameInputField.clear();
        nameInputField.sendKeys(name);
        return this;
    }

    public CreateCharacteristicsPage typeLowSpcLimit(String lowLimit) {
        lowSpcLimitInputField.clear();
        lowSpcLimitInputField.sendKeys(lowLimit);
        return this;
    }

    public CreateCharacteristicsPage typeUpSpcLimit(String upLimit) {
        upSpcLimitInputField.clear();
        upSpcLimitInputField.sendKeys(upLimit);
        return this;
    }

    public CreateCharacteristicsPage typeHistogram(String histogram) {
        histogramInputField.clear();
        histogramInputField.sendKeys(histogram);
        return this;
    }

    public CreateCharacteristicsPage selectProcess(String processName) {
        new Select(selectProcess).selectByVisibleText(processName);
        return this;
    }

    public CharacteristicsPage clickAddNewCharacteristic() {
        createButton.click();
        return new CharacteristicsPage(driver);
    }

    public CreateCharacteristicsPage clickAddNewCharacteristicWithFailure() {
        createButton.click();
        return this;
    }

    public CreateCharacteristicsPage assertErrorMessage(String expErrorMessage) {
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(), expErrorMessage, "Error message is not visible");
        return this;
    }

    public CharacteristicsPage clickBackToList() {
        backToListButton.click();
        return new CharacteristicsPage(driver);
    }


}
