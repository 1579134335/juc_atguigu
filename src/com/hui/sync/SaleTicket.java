package com.hui.sync;

class Ticket{
    private int number = 30;

    public synchronized void sale(){
        if (number > 0){
            System.out.println(Thread.currentThread().getName()+"卖出"+number--+"剩下"+number);
        }
    }
}

public class SaleTicket {
    //第二步 创建多个线程，调用资源类的操作方法
    public static void main(String[] args) {
        //创建Ticket对象
        Ticket ticket = new Ticket();
        //new 三个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                //调用卖票方法
                for (int i = 0; i < 30; i++) {
                    ticket.sale();
                }
            }
        },"AA").start(); new Thread(new Runnable() {
            @Override
            public void run() {
                //调用卖票方法
                for (int i = 0; i < 30; i++) {
                    ticket.sale();
                }
            }
        },"BB").start(); new Thread(new Runnable() {
            @Override
            public void run() {
                //调用卖票方法
                for (int i = 0; i < 30; i++) {
                    ticket.sale();
                }
            }
        },"CC").start();

    }
}
