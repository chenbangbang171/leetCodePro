package com.mallByModel.orderStatus;

import com.mallByModel.Order;

public class WaittingDeliveryStatus implements OrderStatus{
    @Override
    public void action(Order order) {
        /**
         *
         * 发货逻辑.....
         * */

        order.setOrderStatus(new WaittingConfirmStatus());
    }

    @Override
    public void doPrint() {
        System.out.println("待发货状态.....");
    }
}
