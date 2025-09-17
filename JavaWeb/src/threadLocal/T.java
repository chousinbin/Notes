package threadLocal;

import jdk.nashorn.internal.ir.CallNode;

public class T implements Runnable{
    public static ThreadLocal<Object> threadLocal = new ThreadLocal<>();
    @Override
    public void run() {
        Share share = new Share();
        threadLocal.set(share);
        Object o = T.threadLocal.get();
        System.out.println("[在 T0 中] " + Thread.currentThread().getName() + " 对象 " + o) ;
        new T1Service().update();
    }

    public static void main(String[] args) {
        new Thread(new T()).start();
    }
}
