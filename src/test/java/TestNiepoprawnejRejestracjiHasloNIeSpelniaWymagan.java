import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class TestNiepoprawnejRejestracjiHasloNIeSpelniaWymagan extends SeleniumBaseTest {
    @DataProvider
    public static Object[][] wrongPasswords() {
        return new Object[][]{
                {"testselenium12!", "Passwords must have at least one uppercase ('A'-'Z')."},
                {"Testselenium!", "Passwords must have at least one digit ('0'-'9')."},
                {"Testselenium12", "Passwords must have at least one non alphanumeric character."},

        };
    }

    @Test(dataProvider = "wrongPasswords")
    public void InvalidPasswordTest(String password, String expErrorMessage) {
        new LoginPage(driver)
                .goToRegisterPage()
                .typeEmail("Test1@mailinator.com")
                .typePassword(password)
                .typeConfirmPassword(password)
                .registerWithFailure()
                .assertTextErrorsOnList(expErrorMessage);


    }

}
