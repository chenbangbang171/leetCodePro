package com.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class test {

    public static void Test(){

        ArrayList<Order> oRders = new ArrayList<Order>();
        ArrayList<Goods> goods = new ArrayList<Goods>();

        Order order = new Order();
        order.setGoodsList(goods);

        Goods goods1 = new Goods("1",2.0);
        Goods goods2 = new Goods("2",2.0);
        Goods goods3 = new Goods("3",3.0, BigDecimal.valueOf(3.5));

        goods.add(goods1);
        goods.add(goods2);
        goods.add(goods3);

        order.getGoodsList().forEach(x->x.setGoodsNum( null == x.getGoodsNum() ? BigDecimal.ZERO: x.getGoodsNum()));
        System.out.println(order);
    }



    public static void set(List<Integer> list){
        list.add(1111);
    }

    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(4);
        set.add(5);
        ArrayList<Integer> list = new ArrayList<>();
        set(list);

        System.out.println(list);




    }

}
