import config.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class SeleniumBaseTest {
    protected WebDriver driver;
    protected Config config;

    @BeforeMethod
    public void baseBeforeMethod() {
        config = new Config();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();
        driver.get(config.getApplicationUrl());
    }

    @AfterMethod
    public void baseAfterMethod(ITestResult testResult) {
        driver.quit();
    }
}
