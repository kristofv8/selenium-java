package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DashboardPage extends HomePage {

    private String GENERIC_PROCESS_ROW_XPATH = "//h2[text()='%s']";
    private String GENERIC_CHARACTERISTIC_ROW_XPATH = "//p[contains(text(),'%s')]";

    public DashboardPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(className = "x_title")
    private WebElement headerText;

    public DashboardPage assertDashboardUrl(String pageUrl) {
        Assert.assertEquals(driver.getCurrentUrl(), pageUrl, "Page URL is wrong");
        return this;
    }

    public DashboardPage assertDashboardTitle(String pageTitle) {
        Assert.assertEquals(driver.getTitle(), pageTitle, "Page title is wrong");
        return this;
    }

    public DashboardPage assertDashboardHeader(String pageHeader) {
        Assert.assertEquals(headerText.getText(), pageHeader, "Page header is wrong");
        return this;
    }

    public DashboardPage assertAddedProcess(String randomProcessName) {
        String processXpath = String.format(GENERIC_PROCESS_ROW_XPATH, randomProcessName);
        WebElement processName = driver.findElement(By.xpath(processXpath));
        Assert.assertTrue(processName.isDisplayed(), "Added process in not visible");
        return this;
    }

    public DashboardPage assertCharacteristic(String characteristicName) {
        String characteristicXpath = String.format(GENERIC_CHARACTERISTIC_ROW_XPATH, characteristicName);
        WebElement characteristicRow = driver.findElement(By.xpath(characteristicXpath));
        Assert.assertTrue(characteristicRow.isDisplayed(), "Added characteristic in not visible");
        return this;
    }
}
