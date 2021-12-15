package com.mallByModel;

import com.build.Product;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Goods extends AbstractGoods{
    private BigDecimal price;

    private String name;

    private String id;

    private BigDecimal numbers;

    public static class Builder {
        //required parameters
        private final BigDecimal price;
        private final BigDecimal numbers;

        //optional parameters
        private String id ;
        private String name ;

        public Builder(BigDecimal price, BigDecimal numbers){
            this.price = price;
            this.numbers = numbers;
        }


        public Goods.Builder setName(String name){
            this.name = name;
            return this;
        }

        public Goods build(){
            return new Goods(this);
        }
    }


    private Goods(Goods.Builder builder){
        price = builder.price;
        numbers = builder.numbers;
        name = builder.name;
    }


}
