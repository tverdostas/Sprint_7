package ru.practicum;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class OrderClient {

    static final String BASE_URL = "http://qa-scooter.praktikum-services.ru/";
    static final String ORDER_API = "/api/v1/orders";

    @Step("создание заказа")
    public ValidatableResponse createOrder(Order order) {
        return given().log().all().contentType(ContentType.JSON).baseUri(BASE_URL).body(order).when().post(ORDER_API).then().log().all();

    }

    @Step("получение заказов")
    public ValidatableResponse checkOrders() {
        return given().log().all().contentType(ContentType.JSON).baseUri(BASE_URL).when().get(ORDER_API).then().log().all();
    }

}
