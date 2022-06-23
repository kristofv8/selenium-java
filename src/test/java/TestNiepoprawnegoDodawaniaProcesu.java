import org.testng.annotations.Test;
import pages.LoginPage;

public class TestNiepoprawnegoDodawaniaProcesu extends SeleniumBaseTest {

    @Test
    public void processIsNotVisibleProcessesPage() {
        String shortProcessName = "ab";
        String expErrorMessage = "The field Name must be a string with a minimum length of 3 and a maximum length of 30.";

        new LoginPage(driver)
                .typeEmail(config.getApplicationUser())
                .typePassword(config.getApplicationPassword())
                .submitLogin()
                .goToProcesses()
                .clickAddNewProcess()
                .typeName(shortProcessName)
                .clickCreateWithFailure()
                .assertErrorMessage(expErrorMessage)
                .clickBackToList()
                .assertNotAddedProcess(shortProcessName)
        ;
    }
}