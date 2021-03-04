package com.rakovets.course.java.core.practice.concurrency.thread_synchronization.producer_consumer;

import java.util.LinkedList;

public class ProductList {
    private static final LinkedList<Integer> productList = new LinkedList<>();

    public static int size() {
        return productList.size();
    }

    public static void removeFirst() {
        productList.removeFirst();
    }

    public static void add(int value) {
        productList.add(value);
    }
}