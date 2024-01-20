public class anonymousObject {
    public static void main(String[] args) {
        /*
         * new A08() 是匿名对象 匿名对象使用后自动释放
         * 匿名对象创建好后就可以调用其成员方法 .count1()
         */
        new A08().count1();  //10

        A08 a08 = new A08();
        a08.count2();  //9
        a08.count2();  //10
    }
}

class A08 {
    int count = 9;

    public void count1() {
        count = 10;
        System.out.println(count);
    }

    public void count2() {
        System.out.println(count++);
    }
}
