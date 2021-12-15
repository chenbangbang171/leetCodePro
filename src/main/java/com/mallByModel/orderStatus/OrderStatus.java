package com.mallByModel.orderStatus;

import com.mallByModel.Customer;
import com.mallByModel.Order;

public interface OrderStatus {
    void action(Order order);
    void doPrint();
}
