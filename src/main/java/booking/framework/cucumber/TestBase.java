package booking.framework.cucumber;

import booking.framework.pages.InfoPage;
import booking.framework.pages.PaymentPage;
import booking.framework.pages.RoomPage;
import booking.framework.pages.SearchPage;

import io.appium.java_client.android.AndroidDriver;

public class TestBase {
    protected AndroidDriver driver = Hook.getdriver();
    protected SearchPage searchPage = new SearchPage(driver);
    protected RoomPage roomPage = new RoomPage(driver);
    protected InfoPage infoPage = new InfoPage(driver);
    protected PaymentPage paymentPage = new PaymentPage(driver);
}
