import org.testng.annotations.Test;
import pages.CreateProcessPage;
import pages.LoginPage;
import pages.ProcessesPage;

public class TestPoprawnegoDodaniaProcesu extends SeleniumBaseTest {

    @Test
    public void processIsVisibleProcessesPageTest() {
        String randomProcessName = CreateProcessPage.generateProcessUUID();

        addProcess(randomProcessName)
                .assertAddedProcess(randomProcessName, "Process Test Description", "Process Test Notes");


    }

    @Test
    public void processIsVisibleDashboardPage() {
        String randomProcessName = CreateProcessPage.generateProcessUUID();

        addProcess(randomProcessName)
                .goToDashboard()
                .assertAddedProcess(randomProcessName);

    }

    private ProcessesPage addProcess(String randomProcessName) {
        return new LoginPage(driver)
                .typeEmail(config.getApplicationUser())
                .typePassword(config.getApplicationPassword())
                .submitLogin()
                .goToProcesses()
                .clickAddNewProcess()
                .typeName(randomProcessName)
                .typeDescription("Process Test Description")
                .typeNotes("Process Test Notes")
                .clickCreate();

    }
}
