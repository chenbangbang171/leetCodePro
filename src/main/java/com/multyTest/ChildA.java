package com.multyTest;

public class ChildA extends Parent{

    @Override
    public  void printA(String str){
        System.out.println("这是子类继承的A方法,并且重载"+str);
    }


    @Override
    public void printE(Double doubleNumber) {

    }
}
