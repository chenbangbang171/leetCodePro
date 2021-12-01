package com.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Order {
    private String userName;
    private List<Goods> goodsList;


    public Double getTotalPrice(){
        return this.goodsList.stream().map(Goods::getGoodsPrice).reduce(0.00,Double::sum);
    }
}
