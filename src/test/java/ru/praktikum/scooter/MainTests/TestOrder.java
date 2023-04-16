package ru.praktikum.scooter.MainTests;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.praktikum.scooter.MainPageScooter;
import ru.praktikum.scooter.OrderPageScooter;
import static org.junit.Assert.assertTrue;
import static ru.praktikum.scooter.TestData.TestDataOrderTest.*;
@RunWith(Parameterized.class)
public class TestOrder {

    private WebDriver driver;
    private final String buttonLocation;
    private final String orderName;
    private final String orderSureName;
    private final String orderAddress;
    private final String orderMetro;
    private final String orderPhone;
    private final String orderRentDate;
    private final String orderRentDuration;
    private final String orderScooterColor;
    private final String orderComment;

    public TestOrder(String buttonLocation, String orderName, String orderSureName, String orderAddress,
                     String orderMetro, String orderPhone, String orderRentDate, String orderRentDuration,
                     String orderScooterColor, String orderComment) {
        this.buttonLocation = buttonLocation;
        this.orderName = orderName;
        this.orderSureName = orderSureName;
        this.orderAddress = orderAddress;
        this.orderMetro = orderMetro;
        this.orderPhone = orderPhone;
        this.orderRentDate = orderRentDate;
        this.orderRentDuration = orderRentDuration;
        this.orderScooterColor = orderScooterColor;
        this.orderComment = orderComment;
    }
    @Parameterized.Parameters
    public static Object[][] getFaqVarians() {
        return new Object[][] {
                {TEST_BUTTON_TO_ORDER[0],
                        TEST_ORDER_NAME[0],
                        TEST_ORDER_SURENAME[0],
                        TEST_ORDER_ADDRESS[0],
                        TEST_ORDER_METRO[0],
                        TEST_ORDER_PHONE[0],
                        TEST_ORDER_RENT_DATE[0],
                        TEST_ORDER_RENT_DURATION[0],
                        TEST_ORDER_SCOOTER_COLOUR[0],
                        TEST_ORDER_COMMENT[0]},
                { TEST_BUTTON_TO_ORDER[1],
                        TEST_ORDER_NAME[1],
                        TEST_ORDER_SURENAME[1],
                        TEST_ORDER_ADDRESS[1],
                        TEST_ORDER_METRO[1],
                        TEST_ORDER_PHONE[1],
                        TEST_ORDER_RENT_DATE[1],
                        TEST_ORDER_RENT_DURATION[1],
                        TEST_ORDER_SCOOTER_COLOUR[1],
                        TEST_ORDER_COMMENT[1]},
        };
    }
    @Before
    public void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--whitelisted-ips=''");
        driver = new ChromeDriver();

        //driver = new FirefoxDriver();
        // Хм... Можно завязаться чтобы один тест отерывался в FireFox а второй в Chrome...
    }
    @Test
    public void testOrder() {
        MainPageScooter mainPage = new MainPageScooter(driver);
        mainPage.open();
        mainPage.clickCookieButtonIfOnScreen();
        if (buttonLocation == "TOP")  {
            mainPage.clickCreateOrderButtonTop();
        } else if (buttonLocation == "DOWN") {
            mainPage.clickCreateOrderButtonDown();
        } else {
            System.out.println("Некорректно указана кнопка");
        }
        OrderPageScooter orderPage = new OrderPageScooter(driver);
        orderPage.enterNameField(orderName);
        orderPage.enterSurenameField(orderSureName);
        orderPage.enterAddressField(orderAddress);
        orderPage.selectMetroField(orderMetro);
        orderPage.enterPhoneField(orderPhone);
        orderPage.clickNextButton();
        orderPage.enterRentDateField(orderRentDate);
        orderPage.enterRentDurationField(orderRentDuration);
        orderPage.selectColour(orderScooterColor);
        orderPage.enterDeliveryComment(orderComment);
        orderPage.clickCreateButton();
        orderPage.clickYesConfirmCreateButton();
        assertTrue("Заказ не был оформлен",orderPage.getSuccessMessage().contains(TEST_ORDER_SUCCESS_TEXT));
    }
    @After
    public void teardown() {

        driver.quit();
    }
}
