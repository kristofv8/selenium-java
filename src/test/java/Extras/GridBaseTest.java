package Extras;

import config.Config;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class GridBaseTest {

    protected WebDriver driver;
    protected Config config;

    @BeforeMethod
    public void baseBeforeMethod() throws MalformedURLException, UnknownHostException {
        config = new Config();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        String node = "http://localhost:5555";
        driver = new RemoteWebDriver(new URL(node), firefoxOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        System.out.println(InetAddress.getLocalHost().getHostAddress());
        String spcAddress = String.format("http://%s:4444", InetAddress.getLocalHost().getHostAddress());
        driver.get(spcAddress);
    }

    @AfterMethod
    public void baseAfterMethod(ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            getScreenShot(testResult.getMethod().getMethodName());
        }
        driver.quit();
    }

    private void getScreenShot(String name) {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String fileName = "\\snapshots\\" + name + "_" + new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date()) + ".jpg";
            String filePath = System.getProperties().get("user.dir") + fileName;
            FileUtils.copyFile(scrFile, new File(filePath));
        } catch (IOException ex) {
            System.out.println("Exception while taking screenshot: " + ex.getMessage());
        }
    }

}
