import org.testng.annotations.Test;
import pages.LoginPage;

public class TestPoprawnegoLogowania extends SeleniumBaseTest {

    @Test
    public void validLoginTest() {
        new LoginPage(driver)
                .typeEmail(config.getApplicationUser())
                .typePassword(config.getApplicationPassword())
                .submitLogin()
                .assertWelcomeTextIsShown("Welcome\ntest@test.com");

    }
}
