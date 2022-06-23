package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class CharacteristicsPage extends HomePage {

    private String GENERIC_CHARACTERISTIC_ROW_XPATH = "//td[text()='%s']/..";
    private String GENERIC_CHARACTERISTIC_RESULTS_XPATH = "//td[text()='%s']/..//a[contains(@href, 'Results')]";
    private String GENERIC_CHARACTERISTIC_REPORT_XPATH = "//td[text()='%s']/..//a[contains(@href, 'Report')]";

    public CharacteristicsPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(className = "page-title")
    private WebElement headerText;

    @FindBy(linkText = "Add new characteristic")
    private WebElement addNewCharacteristicButton;

    public CharacteristicsPage assertCharacteristicsUrl(String pageUrl) {
        Assert.assertEquals(driver.getCurrentUrl(), pageUrl, "Page URL is wrong");
        return this;
    }

    public CharacteristicsPage assertCharacteristicsTitle(String pageTitle) {
        Assert.assertEquals(driver.getTitle(), pageTitle, "Page title is wrong");
        return this;
    }

    public CharacteristicsPage assertCharacteristicsHeader(String pageHeader) {
        Assert.assertEquals(headerText.getText(), pageHeader, "Page header is wrong");
        return this;
    }

    public CreateCharacteristicsPage clickAddNewCharacteristic() {
        addNewCharacteristicButton.click();
        return new CreateCharacteristicsPage(driver);
    }

    public CharacteristicsPage assertCharacteristic(String characteristicName, String expLowSpcLimit, String expUpSpcLimit, String expHistogram) {
        String characteristicXpath = String.format(GENERIC_CHARACTERISTIC_ROW_XPATH, characteristicName);
        WebElement characteristicRow = driver.findElement(By.xpath(characteristicXpath));
        String actLowSpcLimit = characteristicRow.findElement(By.xpath("./td[3]")).getText();
        String actUpSpcLimit = characteristicRow.findElement(By.xpath("./td[4]")).getText();
        String actHistogram = characteristicRow.findElement(By.xpath("./td[5]")).getText();
        Assert.assertEquals(actLowSpcLimit, expLowSpcLimit, "Characteristics lower specification limit doesn't match");
        Assert.assertEquals(actUpSpcLimit, expUpSpcLimit, "Characteristics upper specification limit doesn't match");
        Assert.assertEquals(actHistogram, expHistogram, "Histogram value doesn't match");
        return this;
    }

    public CharacteristicsPage assertNotAddedCharacteristic(String expCharacteristicName) {
        String characteristicXpath = String.format(GENERIC_CHARACTERISTIC_ROW_XPATH, expCharacteristicName);
        List<WebElement> characteristicList = driver.findElements(By.xpath(characteristicXpath));
        Assert.assertTrue(characteristicList.isEmpty(), "Process name is visible on a list");
        return this;
    }

    public ResultsPage goToResults(String characteristicName) {
        String resultsButtonXpath = String.format(GENERIC_CHARACTERISTIC_RESULTS_XPATH, characteristicName);
        driver.findElement(By.xpath(resultsButtonXpath)).click();
        return new ResultsPage(driver);
    }

    public ReportPage goToReport(String characteristicName) {
        String reportBtnXpath = String.format(GENERIC_CHARACTERISTIC_REPORT_XPATH, characteristicName);
        driver.findElement(By.xpath(reportBtnXpath)).click();
        return new ReportPage(driver);
    }
}