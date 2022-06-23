import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.UUID;

public class TestRaportuDodanejCharakterystyki extends SeleniumBaseTest {

    @Test
    public void addedCharacteristicReportTest() {
        String processName = "DEMO PROJECT";
        String characteristicName = UUID.randomUUID().toString().substring(0, 10);
        String lowSpcLimit = "8";
        String upSpcLimit = "10";
        String histogram = "1";
        String sampleName = "Test sample";
        String results = "8.0;9.0";
        String expMean = "8.5000";
        String expStandardDeviation = "0.7071";
        String expPerformanceIndex = "0.4714";
        String expLowerProcessPerformanceIndex = "0.2357";
        String expUpperProcessPerformanceIndex = "0.7071";
        String expProcessPerformanceIndex = "0.2357";


        new LoginPage(driver)
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
                .clickAddNewCharacteristic()
                .goToResults(characteristicName)
                .clickAddResults()
                .typeName(sampleName)
                .typeResults(results)
                .createResults()
                .backToCharacteristics()
                .goToReport(characteristicName)
                .assertMean(expMean)
                .assertStandardDeviation(expStandardDeviation)
                .assertPerformanceIndex(expPerformanceIndex)
                .assertLowerProcessPerformanceIndex(expLowerProcessPerformanceIndex)
                .assertUpperProcessPerformanceIndex(expUpperProcessPerformanceIndex)
                .assertProcessPerformanceIndex(expProcessPerformanceIndex);

    }
}
