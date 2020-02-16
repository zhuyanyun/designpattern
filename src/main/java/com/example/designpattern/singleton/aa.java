package com.example.designpattern.singleton;

/**
 * Created by zyy on 20/2/16.
 */
public class aa {
    public static void main(String[] args) {
        long id = IdGenerator.INSTANCE.getId();
        System.out.println(id);
    }
}
