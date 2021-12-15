package com.mallByModel.orderStatus;

import com.mallByModel.Order;

public class FinishedStatus implements OrderStatus{
    @Override
    public void action(Order order) {
        /**
         * 转售后逻辑...
         * */

        order.setOrderStatus(new AfterSaleStatus());
    }

    @Override
    public void doPrint() {
        System.out.println("结束状态");
    }
}
