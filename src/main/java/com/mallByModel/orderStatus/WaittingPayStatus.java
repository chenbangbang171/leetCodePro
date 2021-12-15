package com.mallByModel.orderStatus;

import com.mallByModel.Customer;
import com.mallByModel.Order;

public class WaittingPayStatus implements OrderStatus{

    @Override
    public void action(Order order) {
        /**
         * 付款逻辑....
         * */

        order.setOrderStatus(new WaittingDeliveryStatus());
    }

    @Override
    public void doPrint() {
        System.out.println("待付款状态.....");
    }
}
