package com.mallByModel;

import com.mallByModel.orderStatus.OrderStatus;
import com.mallByModel.orderStatus.WaittingPayStatus;
import lombok.Data;

import java.util.List;

@Data
public class Order {
    private OrderStatus orderStatus = new WaittingPayStatus();

    private String id;

    private List<Goods> goodsList;

    private String address;

    public void action(){
        this.orderStatus.action(this);
    }

    public void doPrint(){
        this.orderStatus.doPrint();
    }
}
