package com.hui.lock;



import java.util.concurrent.locks.ReentrantLock;

class LTicket{

    //票数量
    private int number = 30;

    //创建可重入锁
    private final ReentrantLock lock = new ReentrantLock();
    //卖票方法
    public void sale(){
        //上锁
        lock.lock();
        try {
            if(number>0){
                System.out.println(Thread.currentThread().getName()+"：卖出 "+number--+"剩余："+number);
            }
        }finally {
            //解锁
            lock.unlock();
        }
    }
}
public class LSaleTicket {
    //第二步 创建多个线程，调用资源类的操作方法
    public static void main(String[] args) {
        //创建Ticket对象
        LTicket lticket = new LTicket();
        //new 三个线程
        new Thread(() ->{
                //调用卖票方法
                for (int i = 0; i < 30; i++) {
                    lticket.sale();
                }
        },"AA").start();
        new Thread(() -> {
            //调用卖票方法
            for (int i = 0; i < 30; i++) {
                lticket.sale();
            }
        },"BB").start();
        new Thread(() -> {
            //调用卖票方法
            for (int i = 0; i < 30; i++) {
                lticket.sale();
            }
        },"CC").start();

    }

}
