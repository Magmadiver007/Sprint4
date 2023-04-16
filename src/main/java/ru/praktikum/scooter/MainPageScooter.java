package ru.praktikum.scooter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPageScooter {
    private static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    private static final By CREATE_ORDER_BUTTON_TOP =
            By.xpath("//button[@class='Button_Button__ra12g']");
    private static final By CREATE_ORDER_BUTTON_DOWN =
            By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    private static final By COOKIE_BUTTON =
            By.xpath("//button[@class=\"App_CookieButton__3cvqF\"]");


    private static final By CHECK_STATUS_ORDER_BUTTON =
            By.xpath("//button[@class=\"Header_Link__1TAG7\"]");
    private final WebDriver driver;
    public MainPageScooter(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(PAGE_URL);
    }
    public void clickCheckOrderButton() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(CHECK_STATUS_ORDER_BUTTON));
        driver.findElement(CHECK_STATUS_ORDER_BUTTON).click();
    }
    public void clickCreateOrderButtonTop() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(CREATE_ORDER_BUTTON_TOP));
        driver.findElement(CREATE_ORDER_BUTTON_TOP).click();
    }
    public void clickCreateOrderButtonDown() {

        WebElement element = driver.findElement(CREATE_ORDER_BUTTON_DOWN);
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(element));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

        driver.findElement(CREATE_ORDER_BUTTON_DOWN).click();


    }

    public void clickFaqElement (String faqButtonText) {
        WebElement element = driver.findElement(By.xpath("//*[text()[contains(.,'"+faqButtonText+"')]]"));
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(element));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    public String getFaqAnswerText (String faqButtonText) {
        WebElement element = driver.findElement(By.xpath("//*[text()[contains(.,'"+faqButtonText+
                "')]]/../../div[@class='accordion__panel']/p"));
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(element));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        return element.getText();
    }
    public void clickCookieButtonIfOnScreen() {
        if (driver.findElements(COOKIE_BUTTON).size() != 0) {
            driver.findElement(COOKIE_BUTTON).click();
        }
    }

}
