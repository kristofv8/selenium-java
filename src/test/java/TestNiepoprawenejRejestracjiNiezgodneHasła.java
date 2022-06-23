import org.testng.annotations.Test;
import pages.LoginPage;

public class TestNiepoprawenejRejestracjiNiezgodneHasła extends SeleniumBaseTest {

    @Test
    public void differentPasswordsTest() {
        new LoginPage(driver)
                .goToRegisterPage()
                .typeEmail("Test1@mailinator.com")
                .typePassword("TestSelenium12")
                .typeConfirmPassword("TestSelenium1")
                .registerWithFailure()
                .assertErrorIsShown("The password and confirmation password do not match.")
                .registerWithFailure()
                .assertListOfErrorsIsShown();


    }
}