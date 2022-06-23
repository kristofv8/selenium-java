import org.testng.annotations.Test;
import pages.CharacteristicsPage;
import pages.LoginPage;

import java.util.UUID;

public class TestPoprawnegoDodawaniaCharakterystyki extends SeleniumBaseTest {

    @Test
    public void characteristicIsVisibleCharacteristicsPageTest() {
        String processName = "DEMO PROJECT";
        String characteristicName = UUID.randomUUID().toString().substring(0, 10);
        String lowSpcLimit = "8";
        String upSpcLimit = "10";
        String histogram = "1";


        addCharacteristic(processName, characteristicName, lowSpcLimit, upSpcLimit, histogram)
                .assertCharacteristic(characteristicName, lowSpcLimit, upSpcLimit, histogram);

    }

    @Test
    public void characteristicIsVisibleDashboardPageTest() {
        String processName = "DEMO PROJECT";
        String characteristicName = UUID.randomUUID().toString().substring(0, 10);
        String lowSpcLimit = "8";
        String upSpcLimit = "10";
        String histogram = "1";


        addCharacteristic(processName, characteristicName, lowSpcLimit, upSpcLimit, histogram)
                .goToDashboard()
                .assertCharacteristic(characteristicName);

    }

    private CharacteristicsPage addCharacteristic(String processName, String characteristicName, String lowSpcLimit, String upSpcLimit, String histogram) {
        return new LoginPage(driver)
                .typeEmail(config.getApplicationUser())
                .typePassword(config.getApplicationPassword())
                .submitLogin()
                .goToCharacteristics()
                .clickAddNewCharacteristic()
                .selectProcess(processName)
                .typeCharacteristicsName(characteristicName)
                .typeLowSpcLimit(lowSpcLimit)
                .typeUpSpcLimit(upSpcLimit)
                .typeHistogram(histogram)
                .clickAddNewCharacteristic();
    }
}