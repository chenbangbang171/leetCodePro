package com.mallByModel;

import lombok.Data;

import java.util.List;

@Data
public class Customer {

    private String id;

    private String name;

    private List<Goods> subscribeGoodsList;
}
