package com.mallByModel;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Supplier extends TopSupplier {
    private String id;

    private String name;

    private List<Goods> saleGoodsList;

    @Override
    void changePrice(BigDecimal price) {
        for (Goods goods : saleGoodsList){
            goods.setPrice(price);
            goods.nodifyCustomersForPrice(price,goods.getName());
        }
    }

    @Override
    void addGoodsCount(Goods goods, BigDecimal number) {
        goods.setNumbers(number);
        goods.nodifySuppliersForCount(number,goods.getName());
    }
}
