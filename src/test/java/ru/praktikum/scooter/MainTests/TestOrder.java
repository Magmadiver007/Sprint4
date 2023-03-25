package ru.praktikum.scooter.MainTests;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.praktikum.scooter.MainPageScooter;
import ru.praktikum.scooter.OrderPageScooter;
import static org.junit.Assert.assertTrue;
import static ru.praktikum.scooter.TestData.TestDataOrderTest.*;

public class TestOrder {

    private WebDriver driver;
    @Before
    public void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--whitelisted-ips=''");
        driver = new ChromeDriver();

        //driver = new FirefoxDriver();

    }
    @Test
    public void testOrder() {
        MainPageScooter mainPage = new MainPageScooter(driver);
        mainPage.open();
        mainPage.clickCookieButtonIfOnScreen();
        mainPage.clickCreateOrderButtonTop();
        //mainPage.clickCreateOrderButtonDown();
        OrderPageScooter orderPage = new OrderPageScooter(driver);
        orderPage.enterNameField(TEST_ORDER_NAME);
        orderPage.enterSurenameField(TEST_ORDER_SURENAME);
        orderPage.enterAddressField(TEST_ORDER_ADDRESS);
        orderPage.selectMetroField(TEST_ORDER_METRO);
        orderPage.enterPhoneField(TEST_ORDER_PHONE);
        orderPage.clickNextButton();
        orderPage.enterRentDateField(TEST_ORDER_RENT_DATE);
        orderPage.enterRentDurationField(TEST_ORDER_RENT_DURATION);
        orderPage.selectColour(TEST_ORDER_SCOOTER_COLOUR);
        orderPage.enterDeliveryComment(TEST_ORDER_COMMENT);
        orderPage.clickCreateButton();
        orderPage.clickYesConfirmCreateButton();
        //assertEquals("Значение В окне не совпадает с ожидаемым", TEST_ORDER_SUCCESS_TEXT, orderPage.getSuccessMessage());
        assertTrue("Заказ не был оформлен",orderPage.getSuccessMessage().contains(TEST_ORDER_SUCCESS_TEXT));
    }
    @After
    public void teardown() {

        driver.quit();
    }
}
