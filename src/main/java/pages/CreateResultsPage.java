package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateResultsPage {
    protected WebDriver driver;


    public CreateResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Sample")
    private WebElement sampleNameInputField;

    @FindBy(id = "Values")
    private WebElement resultsInputField;

    @FindBy(css = "input[value=Create]")
    private WebElement resultsCreateButton;

    public CreateResultsPage typeName(String sampleName) {
        sampleNameInputField.clear();
        sampleNameInputField.sendKeys(sampleName);
        return this;
    }

    public CreateResultsPage typeResults(String results) {
        resultsInputField.clear();
        resultsInputField.sendKeys(results);
        return this;
    }

    public ResultsPage createResults() {
        resultsCreateButton.click();
        return new ResultsPage(driver);
    }

}
