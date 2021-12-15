package com.mallByModel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public  abstract class AbstractGoods {

    //拥有观察者的集合，下面进行操作的时候使用到这两个集合
    public List<Customer> customersObservers = new ArrayList<>();

    public List<Supplier> supplierObservers = new ArrayList<>();

    /**
     * 注册订阅对象
     * @param customer    订阅对象 客户
     */
    public abstract void customerSubscribe(Customer customer);

    /**
     * 注册订阅对象
     * @param supplier    订阅对象 供应商
     */
    public abstract void supplierSubscribe(Supplier supplier);

    /**
     * 删除订阅对象 用户
     * @param customer 用户对象
     * */
    public abstract void customerCancelSubscribe(Customer customer);


    /**
     * 删除订阅对象 供应商
     * @param supplier 用户对象
     * */
    public abstract void supplierCancelSubscribe(Supplier supplier);

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
