package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ProcessesPage extends HomePage {

    private String GENERIC_PROCESS_ROW_XPATH = "//td[text()='%s']/..";

    public ProcessesPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(className = "page-title")
    private WebElement headerText;

    @FindBy(css = "a[class*=btn-success]")
    private WebElement addNewProcessButton;


    public ProcessesPage assertProcessesUrl(String pageUrl) {
        Assert.assertEquals(driver.getCurrentUrl(), pageUrl, "Page URL is wrong");
        return this;
    }

    public ProcessesPage assertProcessesTitle(String pageTitle) {
        Assert.assertEquals(driver.getTitle(), pageTitle, "Page title is wrong");
        return this;
    }

    public ProcessesPage assertProcessesHeader(String pageHeader) {
        Assert.assertEquals(headerText.getText(), pageHeader, "Page header is wrong");
        return this;
    }

    public CreateProcessPage clickAddNewProcess() {
        addNewProcessButton.click();
        return new CreateProcessPage(driver);
    }


    public ProcessesPage assertAddedProcess(String randomProcessName, String processDescription, String processNotes) {
        String processXpath = String.format(GENERIC_PROCESS_ROW_XPATH, randomProcessName);
        WebElement processRow = driver.findElement(By.xpath(processXpath));
        String actDescription = processRow.findElement(By.xpath("./td[2]")).getText();
        String actNotes = processRow.findElement(By.xpath("./td[3]")).getText();
        Assert.assertEquals(actDescription, processDescription, "Process description doesn't match");
        Assert.assertEquals(actNotes, processNotes, "Process notes don't match");
        return this;
    }

    public ProcessesPage assertNotAddedProcess(String shortProcessName) {
        String processXpath = String.format(GENERIC_PROCESS_ROW_XPATH, shortProcessName);
        List<WebElement> processList = driver.findElements(By.xpath(processXpath));
        Assert.assertTrue(processList.isEmpty(), "Process name is visible on a list");
        return this;
    }
}
