package ru.praktikum.scooter.MainTests;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.praktikum.scooter.MainPageScooter;
import static org.junit.Assert.*;
import static ru.praktikum.scooter.TestData.TestDataFaqTest.*;

@RunWith(Parameterized.class)
public class TestFAQParametrized {
    private final String faqButtonText;
    private final String faqHiddenText;
    private static WebDriver driver;
    private static MainPageScooter mainPage;

    public TestFAQParametrized(String faqButtonText, String faqHiddenText) {
        this.faqButtonText = faqButtonText;
        this.faqHiddenText = faqHiddenText;
    }

    @Parameterized.Parameters
    public static Object[][] getFaqVarians() {
        return new Object[][] {
                { FAQ_1_QUESTION_TEXT, FAQ_1_ANSWER_TEXT},
                { FAQ_2_QUESTION_TEXT, FAQ_2_ANSWER_TEXT},
                { FAQ_3_QUESTION_TEXT, FAQ_3_ANSWER_TEXT},
                { FAQ_4_QUESTION_TEXT, FAQ_4_ANSWER_TEXT},
                { FAQ_5_QUESTION_TEXT, FAQ_5_ANSWER_TEXT},
                { FAQ_6_QUESTION_TEXT, FAQ_6_ANSWER_TEXT},
                { FAQ_7_QUESTION_TEXT, FAQ_7_ANSWER_TEXT},
                { FAQ_8_QUESTION_TEXT, FAQ_8_ANSWER_TEXT},
        };
    }
    @BeforeClass
    public static void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--whitelisted-ips=''");
        driver = new ChromeDriver();
        mainPage = new MainPageScooter(driver);

    }
    @Before
    public void openPage(){
        mainPage.open();
        mainPage.clickCookieButtonIfOnScreen();
    }
    @Test
    public void testFaqListParametrizedExpectTrue() {
        mainPage.clickFaqElement(faqButtonText);
        assertEquals("Значение на странице не совпадает с ожидаемым", faqHiddenText, mainPage.getFaqAnswerText(faqButtonText));
    }

    @AfterClass
    public static void tearDown() {
       driver.quit();
    }
}
