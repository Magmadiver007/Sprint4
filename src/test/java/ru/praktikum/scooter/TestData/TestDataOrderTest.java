package ru.praktikum.scooter.TestData;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDataOrderTest {
    public static final String TEST_ORDER_NAME = "Тест";
    public static final String TEST_ORDER_SURENAME = "Тестовский";
    public static final String TEST_ORDER_ADDRESS = "ул. Тестовая 42";
    public static final String TEST_ORDER_METRO = "Тверская";
    public static final String TEST_ORDER_PHONE = "+79898989898";
    public static final String TEST_ORDER_RENT_DATE = getTomorrowDate ();
    public static final String TEST_ORDER_RENT_DURATION = "трое суток";
    public static final String TEST_ORDER_SCOOTER_COLOUR = "серая безысходность";
    public static final String TEST_ORDER_COMMENT = "Быстрее бы! 123456789";
    public static final String TEST_ORDER_SUCCESS_TEXT = "Заказ оформлен";

    private static String getTomorrowDate(){
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date();
        String tomorrow = dateFormat.format(date);
        return tomorrow;
    }
}
