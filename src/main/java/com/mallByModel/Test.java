package com.mallByModel;

import com.utils.DateUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.math.BigDecimal;
import java.util.*;

public class Test {
    /**
     * 题目描述:现假设要实现-个网络商城系统的部分功能
     * 1、商品状态的订阅:网络商城中的每种 商品，供应商和用户都可以对其进
     * 行订阅关注。对供应商来说，当商品缺货的时候，提醒供应商补货。对于用户
     * 来说，当商品价格变动的时候，或商品由缺货变成有货的时候，可以自动通知
     * 用户。请使用观察者模式，实现这种效果。
     * 2、订单状态的管理:当用户在商城中下了订单后，订单存在着几种状态:下
     * 单状态(下订单未付款)，已付款状态(付款未发货)，已发货状态(发货未
     * 确认)，已完成状态(用户确认或售后完成)，已取消状态(用户未付款或用
     * 户取消)，售后状态(用户收货确认后有退换货问题)。 状态之间存在行为转
     * 换，请用状态模式，实现订单状态的转换。
     * 3、订单发货的管理:该商城在全国有西南、西北、东南、东北4个物流中心，
     * 订单会根据收货地的范围不同，确定应该由那个物流中心发货。请使用代理模
     * 式，实现订单发货的物流管理。
     * 请给出你针对三个问题的分析、设计、测试用例，并能综合应用
     * */

    public static void main(String[] args) {
        Goods computer = new Goods.Builder(BigDecimal.valueOf(100100),BigDecimal.valueOf(3)).setName("电脑").build();
        Goods apple = new Goods.Builder(BigDecimal.valueOf(80),BigDecimal.valueOf(102)).setName("苹果").build();
        Goods shoe = new Goods.Builder(BigDecimal.valueOf(500),BigDecimal.valueOf(1)).setName("鞋").build();
        Goods cup = new Goods.Builder(BigDecimal.valueOf(20),BigDecimal.valueOf(121)).setName("杯子").build();

        Supplier supplier = new Supplier();
        supplier.setName("大潮巴");
        supplier.setSaleGoodsList(new ArrayList<Goods>());

        Customer customer = new Customer();
        customer.setName("大潮种");
        customer.setSubscribeGoodsList(new ArrayList<Goods>());

        computer.customerSubscribe(customer);
        computer.supplierSubscribe(supplier);

        apple.customerSubscribe(customer);
        apple.supplierSubscribe(supplier);
        shoe.customerSubscribe(customer);
        cup.customerSubscribe(customer);

        System.out.println("用户"+ customer.getName()+"所订阅的商品有："+customer.getSubscribeGoodsList().toString());

        apple.customerCancelSubscribe(customer);

        System.out.println("用户"+ customer.getName()+"取消订阅后的商品有："+customer.getSubscribeGoodsList().toString());

        computer.nodifyCustomersForPrice(BigDecimal.valueOf(12),computer.getName());
        apple.nodifySuppliersForCount(BigDecimal.valueOf(200),apple.getName());
        apple.nodifyCustomersForCount(apple.getName());


        Order order = new Order();
        order.setAddress("东南");
        order.setGoodsList(new ArrayList<>());
        order.getGoodsList().add(apple);
        order.getGoodsList().add(computer);
        order.getGoodsList().add(cup);
        order.getGoodsList().add(shoe);

        order.action();
        order.doPrint();

        order.action();
        order.doPrint();

        order.action();
        order.doPrint();

        order.action();
        order.doPrint();

        order.action();
        order.doPrint();

        InvocationHandler deliveryHandler = new DeliveryHandler(supplier);

        DoDelivery newSupplier = (DoDelivery)Proxy.newProxyInstance(Supplier.class.getClassLoader(), Supplier.class.getInterfaces(), deliveryHandler);

        newSupplier.deLivery(order);

//
//        Date endTime = DateUtil.addYear(new Date() , (int) 0.5);
//        Date startTime = DateUtil.addYear(new Date() , -1);

//
//        Date endTime = DateUtil.addYear(DateUtil.getBeginningOfDay(new Date()), -1);
//        Date startTime = DateUtil.getBeginningOfDay(DateUtil.addDay(endTime, -1));
//
//
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:SS");
//
//        String endTimeFormat = simpleDateFormat.format(endTime);
//        String startTimeFormat = simpleDateFormat.format(startTime);
//
//
//        System.out.println("startTimeFormat : " + startTimeFormat);
//        System.out.println("endTimeFormat : " + endTimeFormat);

//
//        Scanner scanner = new Scanner(System.in);
//
//
//        while (scanner.hasNext()){
//            int a = scanner.nextInt();
//            System.out.println(a);
//        }
//
//        int sum = 0;
//        int count = 0;
//        for (int i = 100; i <= 200; i++){
//            if (i%3 == 0){
//                count ++ ;
//                sum += i;
//            }
//        }
//        System.out.println(count);
//        System.out.println(sum);

//        long count1 = IntStream.rangeClosed(100, 200);
//                .filter(x -> x % 3 == 0).count();
//        int sum2 = IntStream.rangeClosed(100, 200)
//                .filter(x -> x % 3 == 0).reduce(0, Integer::sum);
//
//
//        System.out.println(count1);
//        System.out.println(sum2);

//        for (int i = 1; i <= 5;i++){
//            int number = ThreadLocalRandom.current().nextInt(1, 7);
//            System.out.println(number % 2 == 0 ? (number + "偶数," + "平方根："+ Math.sqrt(number)):(number + "奇数," + "平方根："+ Math.sqrt(number)));
//        }

    }



}
