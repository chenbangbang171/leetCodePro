package com.pojo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Goods {

    private String goodsName;
    private Double goodsPrice;
    private BigDecimal goodsNum ;

    public Goods(String goodsName, Double goodsPrice) {
        this.goodsName = goodsName;
        this.goodsPrice =goodsPrice;
    }


    public Goods(String goodsName, Double goodsPrice, BigDecimal goodsNum) {
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsNum = goodsNum;
    }
}
