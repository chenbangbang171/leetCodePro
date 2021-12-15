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

    @Override
    public void customerSubscribe(Customer customer){
        customersObservers.add(customer);
        //用户订阅该商品，那么该商品也在该用户的订阅列表里
        System.out.println(customer.getName()+"成功订阅商品：" +this.getName());
        customer.getSubscribeGoodsList().add(this);
    }

    @Override
    public void supplierSubscribe(Supplier supplier){
        //供应商订阅该商品
        supplierObservers.add(supplier);
        //该商品也在供应商的售卖列表里
        System.out.println(supplier.getName()+"成功订阅商品：" +this.getName());
        supplier.getSaleGoodsList().add(this);

    }

    @Override
    public void customerCancelSubscribe(Customer customer){
        this.customersObservers.remove(customer);
        System.out.println("用户" + customer.getName()+ "取消订阅"+ this.getName() );
        customer.getSubscribeGoodsList().remove(this);
    }

    @Override
    public void supplierCancelSubscribe(Supplier supplier) {
        this.supplierObservers.remove(supplier);
        System.out.println("用户" + supplier.getName()+ "取消订阅 " +this.getName());
        supplier.getSaleGoodsList().remove(this);
    }


}
