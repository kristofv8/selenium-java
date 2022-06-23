package Extras;

import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTestUsingGrid extends GridBaseTest {

    @Test

    public void correctLoginTestWithChaining() {
        new LoginPage(driver)
                .typeEmail(config.getApplicationUser())
                .typePassword(config.getApplicationPassword())
                .submitLogin()
                .assertWelcomeTextIsShown("Welcome\ntest@test.com");
    }
}
