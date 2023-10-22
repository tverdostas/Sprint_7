package ru.practicum;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class CourierClient {

    static final String BASE_URL = "http://qa-scooter.praktikum-services.ru/";
    static final String COURIER_API = "/api/v1/courier";

    @Step("Создание курьера")
    public ValidatableResponse createCourier(Courier courier) {
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL)
                .body(courier)
                .when()
                .post(COURIER_API)
                .then().log().all();

    }

    @Step("Авторизация курьера")
    public ValidatableResponse loginCourier(Courier courier) {
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL)
                .body(courier)
                .when()
                .post(COURIER_API + "/login")
                .then().log().all();
    }

}
