package com.mallByModel;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Objects;

public class DeliveryHandler implements InvocationHandler {
    //被代理的对象引用
    private Supplier supplier;

    public DeliveryHandler(Supplier supplier){
        this.supplier = supplier;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //判断被调用的方法名，不同的方法使用不同的代理加强逻辑
        if (method.getName().equals("deLivery")){
            //获取参数列表，如果需要使用参数的话，需要根据实际方法传入的类型手动转换
            Order order = (Order)args[0];
            String address = order.getAddress();
            //这里简单对地址进行输出，实际应用中应根据参数地址去选择发货地
            System.out.println("发货地是："+ (Objects.nonNull(address) ? address : ""));
            method.invoke(supplier,args);
        }
        return null;
    }
}
