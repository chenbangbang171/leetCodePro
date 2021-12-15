package com.multyTest;

public  abstract class Parent implements InterfaceA{

    @Override
    public  void printA(){
        System.out.println("A");
    }


    void initData(){
        printA("gogogo");
    }

}
