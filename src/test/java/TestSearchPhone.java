import org.testng.annotations.Test;

/**
 * Test class searching phone
 *
 */
public class TestSearchPhone extends TestBase {

    @Test
    public void shouldCalculatePhonesAndShowsHigestPrice(){
        MainPage mainPage = new MainPage(webDriver);
        mainPage.acceptingCookies();
        mainPage.putSerchingPhoneModel("Iphone 11");
        mainPage.choosingBlackColor();
        mainPage.countPhonesAndPrint();
        mainPage.showHighestPrices();
    }
}