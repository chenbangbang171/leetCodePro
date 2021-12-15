package com.mallByModel;

import java.math.BigDecimal;

public abstract class TopSupplier {

    //供应商修改商品价格，具体通知逻辑交给实现类
   abstract void  changePrice(BigDecimal price);

    //供应商修改商品的数量，具体通知逻辑交给实现类
    abstract void addGoodsCount(Goods goods,BigDecimal number);
}
