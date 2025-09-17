package threadLocal;

public class T1Service {
    public void update() {
        Object o = T.threadLocal.get();
        System.out.println("[在 T1 中] " + Thread.currentThread().getName() + " 对象 " + o);
        new T2DAO().update();
    }
}
