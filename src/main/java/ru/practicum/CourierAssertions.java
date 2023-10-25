package ru.practicum;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static java.net.HttpURLConnection.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CourierAssertions {

    @Step("Проверка создания курьера")
    public void createdSuccessful(ValidatableResponse response) {
        boolean isClient = response.assertThat().statusCode(HTTP_CREATED).extract().path("ok");
        assert isClient;
    }

    @Step("Проверка - Этот логин уже используется")
    public void createCheckConflict(ValidatableResponse response) {
        String isClient = response.assertThat().statusCode(HTTP_CONFLICT).extract().path("message");
        assertThat(isClient, equalTo("Этот логин уже используется. Попробуйте другой."));
    }

    @Step("Проверка - Недостаточно данных для создания учетной записи")
    public void createCheckBadRequest(ValidatableResponse response) {
        String isClient = response.assertThat().statusCode(HTTP_BAD_REQUEST).extract().path("message");
        assertThat(isClient, equalTo("Недостаточно данных для создания учетной записи"));
    }

    @Step("Проверка успешной авторизации")
    public void loginSuccessful(ValidatableResponse response) {
        int isClient = response.assertThat().statusCode(HTTP_OK).extract().path("id");
        assert isClient != 0;
    }

    @Step("Проверка - Учетная запись не найдена")
    public void notFound(ValidatableResponse response) {
        String isClient = response.assertThat().statusCode(HTTP_NOT_FOUND).extract().path("message");
        assertThat(isClient, equalTo("Учетная запись не найдена"));
    }


    @Step("Проверка - Недостаточно данных для входа")
    public void loginFailed(ValidatableResponse response) {
        String isClient = response.assertThat().statusCode(HTTP_BAD_REQUEST).extract().path("message");
        assertThat(isClient, equalTo("Недостаточно данных для входа"));
    }
}
