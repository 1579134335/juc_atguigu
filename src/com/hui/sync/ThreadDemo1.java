package com.hui.sync;

//第一步，创建资源类，定义属性和操作方法
class Share {
    private int number = 0;
    public synchronized void incr() throws InterruptedException {
        while (number!=0) this.wait(); //如果不是0，就等待
        //如果number是0，就++；
        number++;
        System.out.println(Thread.currentThread().getName()+":"+number);
        //通知其他线程
        notifyAll();
    }
    public synchronized void decr() throws InterruptedException {
        while (number!=1) this.wait();
        //如果number是0，就++；
        number--;
        System.out.println(Thread.currentThread().getName()+":"+number);
        //通知其他线程
        notifyAll();
    }
}
public class ThreadDemo1 {
    public static void main(String[] args) {
        Share share = new Share();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    share.incr();//+1
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"AA").start();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    share.decr();//-1
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"BB").start();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    share.incr();//+1
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"CC").start();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    share.decr();//-1
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"DD").start();
    }

}
