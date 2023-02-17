public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello, idea");
        int[] arrs = {2, 3, 5, 1, 4, 0, -1};
        Mytools tool1 = new Mytools();
        tool1.sort(arrs);
        tool1.say(arrs);
    }
}

class Mytools {
    //冒泡排序
    public void sort(int[] arrs) {
        int temp = 0;
        for (int i = 0; i < arrs.length - 1; i++) {
            for (int j = i + 1; j < arrs.length; j++) {
                if (arrs[i] > arrs[j]) {
                    temp = arrs[i];
                    arrs[i] = arrs[j];
                    arrs[j] = temp;
                }
            }
        }
    }

    //输出
    public void say(int[] arrs) {
        for (int i = 0; i < arrs.length; i++) {
            System.out.print(arrs[i] + " ");
        }
        System.out.println();
    }
}

class Person {
    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
}