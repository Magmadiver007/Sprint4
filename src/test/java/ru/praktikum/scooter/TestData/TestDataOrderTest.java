package ru.praktikum.scooter.TestData;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDataOrderTest {
    public static final String[] TEST_BUTTON_TO_ORDER = {"TOP", "DOWN"};
    public static final String[] TEST_ORDER_NAME = {"Тест", "Тестик"};
    public static final String[] TEST_ORDER_SURENAME = {"Тестовский", "Тестович"};
    public static final String[] TEST_ORDER_ADDRESS = {"ул. Тестовая 42","ул. Дебажная 18"};
    public static final String[] TEST_ORDER_METRO = {"Тверская","Динамо"};
    public static final String[] TEST_ORDER_PHONE = {"+79898989898","+78989898989"};
    public static final String[] TEST_ORDER_RENT_DATE = {getRentDate (1), getRentDate (7)};
    public static final String[] TEST_ORDER_RENT_DURATION = {"трое суток","семеро суток"};
    public static final String[] TEST_ORDER_SCOOTER_COLOUR = {"grey","black"};
    public static final String[] TEST_ORDER_COMMENT = {"Быстрее бы! 123456789","Хочу кататься!"};
    public static final String TEST_ORDER_SUCCESS_TEXT = "Заказ оформлен";

    private static String getRentDate(int day){
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE,day);
        date = c.getTime();
        String dateStart = dateFormat.format(date);
        return dateStart;
    }
}
