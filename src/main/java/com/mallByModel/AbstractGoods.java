package com.mallByModel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public  abstract class AbstractGoods {

    private List<Customer> customersObservers = new ArrayList<>();

    private List<Supplier> supplierObservers = new ArrayList<>();

    /**
     * 注册订阅对象
     * @param customer    订阅对象 客户
     */
    public void customerSubscribe(Customer customer,String goodsName){
        customersObservers.add(customer);
        //用户订阅该商品，那么该商品也在该用户的订阅列表里
        System.out.println(customer.getName()+"成功订阅商品：" +goodsName );
    }

    /**
     * 注册订阅对象
     * @param supplier    订阅对象 供应商
     */
    public void supplierSubscribe(Supplier supplier,String goodsName){
        //供应商订阅该商品
        supplierObservers.add(supplier);
        //该商品也在供应商的售卖列表里
        System.out.println(supplier.getName()+"成功订阅商品：" +goodsName );
    }

    /**
     * 删除订阅对象 用户
     * @param customer 用户对象
     * */
    public void customerCancelSubscribe(Customer customer,String goodsName){
        this.customersObservers.remove(customer);
        System.out.println("用户" + customer.getName()+ "取消订阅"+ goodsName );
    }


    /**
     * 删除订阅对象 供应商
     * @param supplier 用户对象
     * */
    public void supplierCancelSubscribe(Supplier supplier){
        this.supplierObservers.remove(supplier);
        System.out.println("用户" + supplier.getName()+ "取消订阅 " );
    }

    /**
     * 通知所有注册的客户对象，所订阅的商品价格发生变动
     */
    public void nodifyCustomersForPrice(BigDecimal price,String goodsName){
        for(Customer customer : customersObservers){
            System.out.println("用户：" + customer.getName()+"所订阅的" + goodsName + "价格发生变动，新价格" + price);
        }
    }

    /**
     * 通知所有注册的客户对象，所订阅的货物已被补货
     */
    public void nodifyCustomersForCount(String goodsName){
        for(Customer customer : customersObservers){
            System.out.println("用户：" + customer.getName()+"所订阅的" + goodsName + "已补货，请及时购买" );
        }
    }

    /**
     * 通知所有注册的供应商对象，所订阅的商品需要补货
     */
    public void nodifySuppliersForCount(BigDecimal count,String goodsName){
        for(Supplier supplier : supplierObservers){
            System.out.println("供应商：" + supplier.getName()+"所订阅的" + goodsName + "数量达到预警值，请及时补货，当前剩余数量：" + count);
        }
    }


}
