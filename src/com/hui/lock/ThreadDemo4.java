package com.hui.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Vector;

/**
 * list线程不安全
 */
public class ThreadDemo4 {
    public static void main(String[] args) {
        //创建ArrayList集合
        //List<String> list = new ArrayList<>();
        Vector<String> list = new Vector<>();
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                //向集合中添加内容
                list.add(UUID.randomUUID().toString().substring(0,8));
                //从集合中获取内容
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
