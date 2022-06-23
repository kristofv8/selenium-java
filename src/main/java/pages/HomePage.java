package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage {
    protected WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".profile_info>h2")
    private WebElement welcomeTxt;

    @FindBy(className = "menu-home")
    private WebElement homeButton;

    @FindBy(linkText = "Dashboard")
    private WebElement dashboardLink;

    @FindBy(className = "menu-workspace")
    private WebElement workspaceButton;

    @FindBy(linkText = "Processes")
    private WebElement processesLink;

    @FindBy(linkText = "Characteristics")
    private WebElement characteristicsLink;

    public HomePage assertWelcomeTextIsShown(String welcomeText) {
        Assert.assertTrue(welcomeTxt.isDisplayed(), "Welcome element is not shown.");
        Assert.assertEquals(welcomeTxt.getText(), welcomeText, "Welcome element text doesn't match ");
        return this;
    }

    private boolean isClassActive(WebElement menuButton) {
        WebElement parent = menuButton.findElement(By.xpath("./.."));
        return !parent.getAttribute("class").equals("active");
    }

    public DashboardPage goToDashboard() {
        if (isClassActive(homeButton)) {
            homeButton.click();
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(dashboardLink));
        dashboardLink.click();
        return new DashboardPage(driver);
    }

    public ProcessesPage goToProcesses() {
        if (isClassActive(workspaceButton)) {
            workspaceButton.click();
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(processesLink));
        processesLink.click();
        return new ProcessesPage(driver);
    }

    public CharacteristicsPage goToCharacteristics() {
        if (isClassActive(workspaceButton)) {
            workspaceButton.click();
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(characteristicsLink));
        characteristicsLink.click();
        return new CharacteristicsPage(driver);
    }

}
