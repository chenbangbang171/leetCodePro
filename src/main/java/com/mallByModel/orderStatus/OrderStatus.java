package com.mallByModel.orderStatus;

import com.mallByModel.Customer;
import com.mallByModel.Order;

public interface OrderStatus {
    /**
     * order对象拥有对orderStatus的引用，同时orderStatus的action方法传入当前的order对象
     * 将该order的状态设置为下一阶段的状态，从而只用调用order.action(),那么该方法就会自动修改order的状态，
     * */
    void action(Order order);

    void doPrint();
}
