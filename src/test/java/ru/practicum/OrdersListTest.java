package ru.practicum;

import org.junit.Test;

public class OrdersListTest {

    OrderAssertions orderAssertions = new OrderAssertions();
    OrderClient orderClient = new OrderClient();

    @Test

    public void testCheckListOfOrders() {
        orderAssertions.checkedOrdersList(orderClient.checkOrders());

    }
}