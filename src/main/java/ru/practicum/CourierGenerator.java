package ru.practicum;

import org.apache.commons.lang3.RandomStringUtils;

public class CourierGenerator {

    public Courier generic() {

        return new Courier(RandomStringUtils.randomAlphanumeric(10), RandomStringUtils.randomAlphanumeric(10), RandomStringUtils.randomAlphanumeric(10));
    }

    public Courier emptyFields() {
        return new Courier("", "", RandomStringUtils.randomAlphanumeric(10));
    }
    public Courier emptyFieldLogin() {
        return new Courier("", RandomStringUtils.randomAlphanumeric(10), RandomStringUtils.randomAlphanumeric(10));
    }
    public Courier emptyFieldPassword() {
        return new Courier(RandomStringUtils.randomAlphanumeric(10), "", RandomStringUtils.randomAlphanumeric(10));
    }
}
