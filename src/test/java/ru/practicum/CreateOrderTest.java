package ru.practicum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class CreateOrderTest {


    private String[] color;

    OrderClient orderClient = new OrderClient();
    OrderAssertions orderAssertions = new OrderAssertions();

    public CreateOrderTest(String[] color) {
        this.color = color;
    }

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][]{{new String[]{"GREY"}}, {new String[]{}}, {new String[]{"BLACK"}}, {new String[]{"BLACK", "GREY"}},};
    }

    @Test
    @DisplayName("Создание заказа")
    public void testOrder() {
        Order order = new OrderData().generic(color);
        orderAssertions.createdOrderSuccessful(orderClient.createOrder(order));

    }
}
