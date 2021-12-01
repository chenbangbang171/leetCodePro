package com.jikeTime;

import com.pojo.Goods;
import com.pojo.Order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class FlatMapTest {


    public  static void Test(){
        ArrayList<Order> orders = new ArrayList<>();
        ArrayList<Goods> goodsArrayList = new ArrayList<>();

        Goods apple = new Goods("苹果", 10.00);
        Goods clothes = new Goods("衣服", 50.00);
        Goods shoes = new Goods("鞋子", 40.00);
        Goods conputer = new Goods("电脑", 500.00);
        goodsArrayList.add(apple);
        goodsArrayList.add(clothes);
        goodsArrayList.add(shoes);
        goodsArrayList.add(conputer);

        //创建4个订单，为每个订单随机加入十个商品
        IntStream.rangeClosed(1,4).forEach(i-> {
                    Order order = new Order();
                    ArrayList<Goods> goods = new ArrayList<>();
                    IntStream.rangeClosed(1,10).forEach(j->{
                        Goods goods1 = goodsArrayList.get(ThreadLocalRandom.current().nextInt(goodsArrayList.size()));
                        if (goods.contains(goods1)) {
                            goods1.setGoodsNum(goods1.getGoodsNum().add(BigDecimal.valueOf(1)));
                        }else {
                            goods.add(goods1);
                        }
                    }
                    );
                    order.setGoodsList(goods);
                    order.setUserName(i+"");
                    orders.add(order);
                }
                );
        System.out.println(orders);
//
//        //按照用户名分组，统计订单金额
//        List<Map.Entry<String, Double>> collect1 = orders.stream().collect(groupingBy(Order::getUserName, summingDouble(Order::getTotalPrice)))
//                                                    .entrySet().stream().sorted(Map.Entry.<String, Double>comparingByValue().reversed()).collect(toList());
//        System.out.println("按照用户名分组，统计订单总金额：" +collect1);
//
//        List<Map.Entry<String, Integer>> collect2 = orders.stream().collect(groupingBy(Order::getUserName, summingInt(order -> (Integer) order.getGoodsList().stream().mapToInt(Goods::getGoodsNum).sum())))
//                                                    .entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).collect(toList());
//        System.out.println("按照用户名分组，统计所有商品数量" + collect2);
////
//        List<Map.Entry<String, Integer>> collect3 = new ArrayList<>(orders.stream().flatMap(order -> order.getGoodsList().stream())
//                                                    .collect(groupingBy(Goods::getGoodsName, summingInt(Goods::getGoodsNum))).entrySet());
//        System.out.println("按照商品名分组，统计所有各类商品数量" + collect3);

    }

    public static void main(String[] args) {
        Test();
    }

}
