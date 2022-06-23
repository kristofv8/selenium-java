import org.testng.annotations.Test;
import pages.LoginPage;

public class TestMenuNaStronie extends SeleniumBaseTest {

    @Test
    public void menuNavToCorrectPagesTest() {
        new LoginPage(driver)
                .typeEmail(config.getApplicationUser())
                .typePassword(config.getApplicationPassword())
                .submitLogin()
                .goToDashboard()
                .assertDashboardUrl(config.getApplicationUrl())
                .assertDashboardTitle("Dashboard - Statistical Process Control")
                .assertDashboardHeader("DEMO PROJECT")
                .goToProcesses()
                .assertProcessesUrl(config.getApplicationUrl() + "Projects")
                .assertProcessesTitle("Processes - Statistical Process Control")
                .assertProcessesHeader("Processes")
                .goToCharacteristics()
                .assertCharacteristicsUrl(config.getApplicationUrl() + "Characteristics")
                .assertCharacteristicsTitle("Characteristics - Statistical Process Control")
                .assertCharacteristicsHeader("Characteristics");


    }
}