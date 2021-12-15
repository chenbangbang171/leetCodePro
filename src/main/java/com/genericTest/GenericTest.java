package com.genericTest;


public class GenericTest implements GenerIc{

    /**
     * 测试泛型
     *
     * */

    @Override
    public  Drink getDrink(int chose) {
        if (chose == 1) {
            return new Juice();
        } else if (chose == 2) {
            return new Coffe();
        } else if (chose == 3) {
            return new Milk();
        }
        return null;
    }

    void print(){
        Drink drink = getDrink(3);
        System.out.println(drink.getClass());
    }




}

