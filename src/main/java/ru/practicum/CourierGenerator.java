package ru.practicum;

import org.apache.commons.lang3.RandomStringUtils;

public class CourierGenerator {

    public Courier generic() {
        return new Courier("логин_тест", "пароль_тест", "имя_тест");
    }


    public Courier emptyFields() {
        return new Courier("", "", "имя_тест");
    }


    public Courier genericRand() {
        return new Courier(RandomStringUtils.randomAlphanumeric(4, 5), "пароль_тест", "имя_тест");
    }

    public Courier notFullData() {
        Courier courier = new Courier();
        courier.setPassword("пароль_тест");
        return courier;
    }

}
