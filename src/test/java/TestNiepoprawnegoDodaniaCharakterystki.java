import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.UUID;

public class TestNiepoprawnegoDodaniaCharakterystki extends SeleniumBaseTest {

    @Test
    public void addCharacteristicNegative() {
        String processName = "DEMO PROJECT";
        String characteristicName = UUID.randomUUID().toString().substring(0, 10);
        String lowSpcLimit = "8";
        String histogram = "1";

        new LoginPage(driver)
                .typeEmail(config.getApplicationUser())
                .typePassword(config.getApplicationPassword())
                .submitLogin()
                .goToCharacteristics()
                .clickAddNewCharacteristic()
                .selectProcess(processName)
                .typeCharacteristicsName(characteristicName)
                .typeLowSpcLimit(lowSpcLimit)
                .typeHistogram(histogram)
                .clickAddNewCharacteristicWithFailure()
                .assertErrorMessage("The value '' is invalid.")
                .clickBackToList()
                .assertNotAddedCharacteristic(characteristicName);
    }
}
