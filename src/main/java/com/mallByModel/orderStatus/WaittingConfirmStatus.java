package com.mallByModel.orderStatus;

import com.mallByModel.Order;

public class WaittingConfirmStatus implements OrderStatus{
    @Override
    public void action(Order order) {
        /***
         *
         * 确认收获逻辑....
         * */

        order.setOrderStatus(new WaittingEvaluateStatus());
    }

    @Override
    public void doPrint() {
        System.out.println("待收货状态.....");
    }
}
