package com.mallByModel;

import java.math.BigDecimal;

public abstract class TopSupplier {

   abstract void  changePrice(BigDecimal price);

    abstract void addGoodsCount(Goods goods,BigDecimal number);
}
