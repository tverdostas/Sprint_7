package ru.practicum;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import java.util.List;

import static java.net.HttpURLConnection.HTTP_CREATED;
import static java.net.HttpURLConnection.HTTP_OK;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class OrderAssertions {

    @Step("проверка создания заказа")
    public void createdOrderSuccessful(ValidatableResponse response) {

        int orderId = response.assertThat().statusCode(HTTP_CREATED).extract().path("track");
        assertThat(orderId, notNullValue());
    }

    @Step("проверка списка заказов")
    public void checkedOrdersList(ValidatableResponse response) {

        List<String> orderId = response.assertThat().statusCode(HTTP_OK).extract().path("orders");
        assertThat(orderId, notNullValue());
    }

}
