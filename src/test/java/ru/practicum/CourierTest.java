package ru.practicum;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runners.Suite;

public class CourierTest {

    private final CourierGenerator courierGenerator = new CourierGenerator();
    private final CourierClient client = new CourierClient();
    private final CourierAssertions courierAssertions = new CourierAssertions();


    @Test //создание курьера
    @DisplayName("Создание курьера")
    @Description("Проверка успешного создания курьера")
    public void testCreateCourier() {
        var courier = courierGenerator.generic();
        courierAssertions.createdSuccessful(client.createCourier(courier));
    }

    @Test // создание дубликата курьера
    @DisplayName("Создание существующего курьера - Проверка вывода ошибки")
    public void testCreateCourierCheckDuplicate() {
        var courier = courierGenerator.generic();
        courierAssertions.createdSuccessful(client.createCourier(courier));
        courierAssertions.createCheckConflict(client.createCourier(courier));
    }

    @Test // проверка обязательных полей
    @DisplayName("Создание курьера - Проверка обязательных полей")
    public void testCreateCourierCheckRequiredFields() {
        var courier = courierGenerator.emptyFields();
        courierAssertions.createCheckBadRequest(client.createCourier(courier));
    }

    @Test  // авторизация курьера
    @DisplayName("Успешная авторизация курьера")
    public void testLoginTest() {
        var courier = courierGenerator.generic();
        courierAssertions.createdSuccessful(client.createCourier(courier));
        courierAssertions.loginSuccessful(client.loginCourier(courier));
    }

    @Test //для авторизации нужно передать все обязательные поля
    @DisplayName("Проверка авторизации курьера - Проверка обязательного поля Логин")
    public void testLoginTestFailedWithoutLogin() {
        var courier = courierGenerator.emptyFieldLogin();
        courierAssertions.loginFailed(client.loginCourier(courier));
    }

    @Test //для авторизации нужно передать все обязательные поля
    @DisplayName("Проверка авторизации курьера - Проверка обязательного поля Пароль")
    public void testLoginTestFailedWithoutPassword() {
        var courier = courierGenerator.emptyFieldPassword();
        courierAssertions.loginFailed(client.loginCourier(courier));
    }

    @Test  // авторизация курьера с некорректными данными
    @DisplayName("Проверка корректности данных при авторизации курьера")
    public void testLoginIncorrectData() {
        var courier = courierGenerator.generic();
        courierAssertions.notFound(client.loginCourier(courier));
    }

}
