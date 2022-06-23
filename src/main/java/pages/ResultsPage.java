package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultsPage {

    protected WebDriver driver;

    public ResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Add results sample")
    private WebElement addResultsButton;

    @FindBy(linkText = "Back to characteristics")
    private WebElement backButton;

    public CreateResultsPage clickAddResults() {
        addResultsButton.click();
        return new CreateResultsPage(driver);
    }

    public CharacteristicsPage backToCharacteristics() {
        backButton.click();
        return new CharacteristicsPage(driver);
    }
}
