package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ReportPage {
    protected WebDriver driver;

    public ReportPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//td[text()='Mean (x)']/../td[2]")
    private WebElement meanCell;

    @FindBy(xpath = "//td[text()='Standard deviation (s)']/../td[2]")
    private WebElement standardDeviationCell;

    @FindBy(xpath = "//td[text()='Performance index (Pp)']/../td[2]")
    private WebElement performanceIndexCell;

    @FindBy(xpath = "//td[text()='Lower process performance index (Ppl)']/../td[2]")
    private WebElement lowerProcessPerformanceIndexCell;

    @FindBy(xpath = "//td[text()='Upper process performance index (Ppu)']/../td[2]")
    private WebElement upperProcessPerformanceIndexCell;

    @FindBy(xpath = "//td[text()='Process performance index (Ppk)']/../td[2]")
    private WebElement processPerformanceIndexCell;

    public ReportPage assertMean(String expMean) {
        Assert.assertEquals(meanCell.getText(), expMean, "Mean value is not as expected");
        return this;
    }

    public ReportPage assertStandardDeviation(String expStandardDeviation) {
        Assert.assertEquals(standardDeviationCell.getText(), expStandardDeviation, "Standard deviation value is not as expected");
        return this;
    }

    public ReportPage assertPerformanceIndex(String expPerformanceIndex) {
        Assert.assertEquals(performanceIndexCell.getText(), expPerformanceIndex, "Performance index value is not as expected");

        return this;
    }

    public ReportPage assertLowerProcessPerformanceIndex(String expLowerProcessPerformanceIndex) {
        Assert.assertEquals(lowerProcessPerformanceIndexCell.getText(), expLowerProcessPerformanceIndex, "Lower process performance index value is not as expected");
        return this;
    }

    public ReportPage assertUpperProcessPerformanceIndex(String expUpperProcessPerformanceIndex) {
        Assert.assertEquals(upperProcessPerformanceIndexCell.getText(), expUpperProcessPerformanceIndex, "Upper process performance index value is not as expected");
        return this;
    }

    public ReportPage assertProcessPerformanceIndex(String expProcessPerformanceIndex) {
        Assert.assertEquals(processPerformanceIndexCell.getText(), expProcessPerformanceIndex, "Process performance index value is not as expected");
        return this;
    }
}

