package com.mallByModel.orderStatus;

import com.mallByModel.Order;

public class WaittingEvaluateStatus implements OrderStatus{
    @Override
    public void action(Order order) {
        /**
         * 评价逻辑....
         * */
        order.setOrderStatus(new FinishedStatus());
    }

    @Override
    public void doPrint() {
        System.out.println("待评价状态");
    }
}
