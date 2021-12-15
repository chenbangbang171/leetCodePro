package com.mallByModel;

import com.utils.DateUtil;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Test {

    public static void main(String[] args) {
//        Goods computer = new Goods.Builder(BigDecimal.valueOf(100100),BigDecimal.valueOf(3)).setName("电脑").build();
//        Goods apple = new Goods.Builder(BigDecimal.valueOf(80),BigDecimal.valueOf(102)).setName("苹果").build();
//        Goods shoe = new Goods.Builder(BigDecimal.valueOf(500),BigDecimal.valueOf(1)).setName("鞋").build();
//        Goods cup = new Goods.Builder(BigDecimal.valueOf(20),BigDecimal.valueOf(121)).setName("杯子").build();
//
//        Supplier supplier = new Supplier();
//        supplier.setName("狗子");
//        Customer customer = new Customer();
//        customer.setName("大狗");
//
//        computer.customerSubscribe(customer,computer.getName());
//        computer.supplierSubscribe(supplier,computer.getName());
//
//        apple.customerSubscribe(customer,apple.getName());
//        apple.supplierSubscribe(supplier,apple.getName());
//        shoe.customerSubscribe(customer,shoe.getName());
//        cup.customerSubscribe(customer,cup.getName());
//
//        computer.nodifyCustomersForPrice(BigDecimal.valueOf(12),computer.getName());
//        apple.nodifySuppliersForCount(BigDecimal.valueOf(200),apple.getName());
//        apple.nodifyCustomersForCount(apple.getName());
//
//
//        Order order = new Order();
//        order.setGoodsList(new ArrayList<>());
//        order.getGoodsList().add(apple);
//        order.getGoodsList().add(computer);
//        order.getGoodsList().add(cup);
//        order.getGoodsList().add(shoe);
//
//        order.action();
//        order.doPrint();
//
//        order.action();
//        order.doPrint();
//
//        order.action();
//        order.doPrint();
//
//        order.action();
//        order.doPrint();
//
//        order.action();
//        order.doPrint();

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
