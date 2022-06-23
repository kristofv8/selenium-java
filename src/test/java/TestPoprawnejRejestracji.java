import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.UUID;

public class TestPoprawnejRejestracji extends SeleniumBaseTest {

    @Test
    public void successfulRegistrationTest() {
        String randomEmail = UUID.randomUUID().toString().substring(0, 5);

        new LoginPage(driver)
                .goToRegisterPage()
                .typeRandomEmail(randomEmail, "Test@mailinator.com")
                .typePassword("TestSelenium12!")
                .typeConfirmPassword("TestSelenium12!")
                .successfulRegister()
                .assertWelcomeTextIsShown("Welcome\n" + randomEmail + "Test@mailinator.com")
        ;

    }

}
