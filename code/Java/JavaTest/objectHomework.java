public class objectHomework {
    public static void main(String[] args) {

        A06 cale = new A06(2, 0);
        Double res = cale.div();
        if(res != null) {
            System.out.println(res);
        }
        
        Music hsgj = new Music("灰色轨迹", 6);
        hsgj.play();
        System.out.println(hsgj.getInfo());
    }
}

class A01 {
    public double max(double[] arrs) {
        double res = arrs[0];
        for(int i = 1; i < arrs.length; i++) {
            if(res > arrs[i]) {
                res = arrs[i];
            }
        }
        return res;
    }
}

class A02 {
    public int find(String findstr, String[] strs) {
        for(int i = 0; i < strs.length; i++) {
            if(findstr.equals(strs[i])) {
                return i;
            }
        }
        return -1;
    }
}

class A03 {
    String name;
    double price;

    public A03(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void updatePrice() {
        if(this.price > 150) {
            this.price = 150;
        }else if(this.price > 100) {
            this.price = 100;
        }
    }
}

class A04 {
    public int[] copyArr(int[] arrs) {
        int[] arrs2 = new int[arrs.length];

        for(int i = 0; i< arrs.length; i++) {
            arrs2[i] = arrs[i];
        }

        return arrs2;
    }
}

class A05 {
    double r;

    public A05(double r) {
        this.r = r;
    }

    public double circleP() {
        return Math.PI * 2 * r;
    }
    
    public double circleS() {
        return Math.PI * r * r;
    }
}

class A06 {
    double n1;
    double n2;
    
    public A06(double n1, double n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    public double sum() {
        return n1 + n2;
    }

    public double minus() {
        return n1 - n2;
    }

    public double sub() {
        return n1 * n2;
    }

    /*
     * Double包装类
     * 解决没有正确结果时
     * 返回值类型不统一问题
     */
    public Double div() {
        if(n2 == 0) {
            System.out.println("ERROR");
            return null;
        }
        return (n1 / n2);
    }
}

class A07 {
    String name;
    int age;
    String color;

    public A07(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public void show() {
        System.out.println(name + " " + age + " " + color);
    }
}

class Music {
    int times;
    String name;

    public Music(String name, int times) {
        this.name = name;
        this.times = times;
    }
    //播放功能
    public void play() {
        System.out.println("歌名" + this.name + " " + "时长" + this.times + "正在播放...");
    }
    //返回信息
    public String getInfo() {
        return "歌曲信息:歌名" + this.name + " " + "时长" + this.times;
    }
}

class Employee {
    String name;
    String gender;
    int age;
    String profession;
    double salary;

    public Employee(String profession, double salary) {
        this.profession = profession;
        this.salary = salary;
    }

    public Employee(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public Employee(String name, String gender, int age, String profession, double salary) {
        this(name, gender, age);  //通过this访问构造器实现构造器复用
        this.profession = profession;
        this.salary = salary;
    }
}