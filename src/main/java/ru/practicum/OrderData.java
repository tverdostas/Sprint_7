package ru.practicum;

public class OrderData {

    public Order generic(String[] color) {
        return new Order("firstName", "lastName", "address", "metroStation", "phone", 5, "2020-06-06", color);
    }

}