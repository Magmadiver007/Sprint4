package ru.praktikum.scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class OrderPageScooter {
    private static final By ORDER_FIELD_NAME =
            By.xpath("//input[@placeholder = '* Имя']");
    private static final By ORDER_FIELD_SURENAME =
            By.xpath("//input[@placeholder = '* Фамилия']");
    private static final By ORDER_FIELD_ADDRESS =
            By.xpath("//input[@placeholder = '* Адрес: куда привезти заказ']");
    private static final By ORDER_FIELD_METRO =
            By.xpath("//input[@placeholder = '* Станция метро']");

    private static final By ORDER_FIELD_PHONE =
            By.xpath("//input[@placeholder = '* Телефон: на него позвонит курьер']");
    private static final By ORDER_FIELD_DATE =
            By.xpath("//input[@placeholder = '* Когда привезти самокат']");
    private static final By ORDER_FIELD_DURATION =
            By.xpath("//div[@class='Dropdown-control']/div[text()='* Срок аренды']");
    private static final By ORDER_FIELD_COLOR_GREY =
            By.xpath("//input[@id='grey']");
    private static final By ORDER_FIELD_COMMENT =
            By.xpath("//input[@placeholder = 'Комментарий для курьера']");
    private static final By NEXT_ORDER_BUTTON =
            By.xpath("//div[@Class='Order_NextButton__1_rCA']/button");
    private static final By BACK_ORDER_BUTTON =
            By.xpath("//div[@class=\"Order_Buttons__1xGrp\"]/button[text()='Назад']");
    private static final By CREATE_ORDER_BUTTON =
            By.xpath("//div[@class=\"Order_Buttons__1xGrp\"]/button[text()='Заказать']");
    private static final By CREATE_ORDER_YES_BUTTON =
            By.xpath("//div[@class=\"Order_Buttons__1xGrp\"]/button[text()='Да']");
    private static final By CREATE_ORDER_NO_BUTTON =
            By.xpath("//div[@class=\"Order_Buttons__1xGrp\"]/button[text()='Нет']");
    private static final By CREATE_ORDER_CHECK_STATUS_BUTTON =
            By.xpath("//div[@class=\"Order_NextButton__1_rCA\"]/button[text()='Посмотреть статус']");
    private static final By CREATE_ORDER_SUCCESS_MESSAGE = By.xpath(
            "//div[@class='Order_ModalHeader__3FDaJ']");
    private final WebDriver driver;
    public OrderPageScooter (WebDriver driver) {
        this.driver = driver;
    }

    public void  clickNextButton() {
        driver.findElement(NEXT_ORDER_BUTTON).click();
    }
    public void  clickBackButton() {
        driver.findElement(BACK_ORDER_BUTTON).click();
    }
    public void  clickCreateButton() {
        driver.findElement(CREATE_ORDER_BUTTON).click();
    }
    public void enterNameField (String Text){
        driver.findElement(ORDER_FIELD_NAME).sendKeys(Text);
    }
    public void enterSurenameField (String Text){
        driver.findElement(ORDER_FIELD_SURENAME).sendKeys(Text);
    }
    public void enterAddressField (String Text){
        driver.findElement(ORDER_FIELD_ADDRESS).sendKeys(Text);
    }
    public void selectMetroField (String Text){
        driver.findElement(ORDER_FIELD_METRO).click();
        driver.findElement(By.xpath(getMetroStationXpath(Text))).click();
    }
    public void enterPhoneField (String Text){
        driver.findElement(ORDER_FIELD_PHONE).sendKeys(Text);
    }

    public void enterRentDateField (String Text){
        driver.findElement(ORDER_FIELD_DATE).sendKeys(Text);
        driver.findElement(ORDER_FIELD_DATE).sendKeys(Keys.ENTER);
    }

    public void enterRentDurationField (String Text) {
        driver.findElement(ORDER_FIELD_DURATION).click();
        driver.findElement(By.xpath(getRentDurationXpath(Text))).click();
    }
    private String getRentDurationXpath (String Text){
       return  "//div[@class='Dropdown-menu']/div[text()='"+Text+"']";
    }
    private String getMetroStationXpath (String Text){
        return  "//li[@class='select-search__row']//div[text()='"+Text+"']";
    }
    public void selectColour (String text) {
        driver.findElement(By.xpath("//input[@id='"+text+"']")).click();
    }
    public void enterDeliveryComment (String text){
        driver.findElement(ORDER_FIELD_COMMENT).sendKeys(text);
    }
    public void  clickYesConfirmCreateButton() {
        driver.findElement(CREATE_ORDER_YES_BUTTON).click();
    }
    public String getSuccessMessage () {
        return driver.findElement(CREATE_ORDER_SUCCESS_MESSAGE).getText();
    }
}
