package com.genericTest;

public interface GenerIc<T extends Drink<T>> {
    T getDrink(int chose);
}
