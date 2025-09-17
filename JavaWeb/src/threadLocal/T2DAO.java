package threadLocal;

public class T2DAO {
    public void update() {
        Object o = T.threadLocal.get();
        System.out.println("[在 T2 中] " + Thread.currentThread().getName() + " 对象 " + o);
    }
}
