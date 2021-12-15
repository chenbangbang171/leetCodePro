package com.mallByModel;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Supplier extends TopSupplier implements DoDelivery {
    private String id;

    private String name;

    private List<Goods> saleGoodsList;

    @Override
    void changePrice(BigDecimal price) {
        for (Goods goods : saleGoodsList){
            goods.setPrice(price);
            //调用商品的通知方法，通知订阅该商品的所有顾客
            goods.nodifyCustomersForPrice(price,goods.getName());
        }
    }

    @Override
    void addGoodsCount(Goods goods, BigDecimal number) {
        goods.setNumbers(number);
        goods.nodifyCustomersForCount(goods.getName());
    }

    @Override
    public void deLivery(Order order) {
        System.out.println("发货。。。");
    }
}
