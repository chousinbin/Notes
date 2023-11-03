package com.Extends;

public class Computer {
    private String CPU;
    private String Memory;
    private String Disk;

    public Computer(){}
    public Computer(String CPU, String memory, String disk) {
        this.CPU = CPU;
        this.Memory = memory;
        this.Disk = disk;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }
    public void setMemory(String Memory) {
        this.Memory = Memory;
    }
    public void setDisk(String Disk) {
        this.Disk = Disk;
    }

    public String getCPU() {
        return CPU;
    }
    public String getMemory() {
        return Memory;
    }
    public String getDisk() {
        return Disk;
    }

    public String getDetails() {
        return getCPU() + " " + getMemory() + " " + getDisk() + " ";
    }
}

class PC extends Computer {
    private String brand;
    public PC(){}
    /**
     *这里IDEA根据继承的规则, 自动把构造器的调用写好
     * 这里也体现继承设计的基本思想:父类的构造器完成父类属性初始化
     * 子类构造器完成子类属性的初始化
     */
    public PC(String CPU, String memory, String disk, String brand) {
        super(CPU, memory, disk);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void printInfo() {
        System.out.println("PC信息");
        System.out.println(getDetails()+ " " + getBrand() + " ");
    }
}

class NotePad extends Computer {
    private String color;

    public NotePad(){}
    public NotePad(String CPU, String memory, String disk, String color) {
        super(CPU, memory, disk);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void printInfo() {
        System.out.println("Pad信息");
        System.out.println(getDetails()+ " " + getColor() + " ");
    }
}

class test {
    public static void main(String[] args) {
        PC pc = new PC();
        pc.setBrand("DELL");
        pc.setCPU("i5-10400");
        pc.setMemory("16GB");
        pc.setDisk("1TB");
        pc.printInfo();

        NotePad notePad = new NotePad("A1", "8GB", "256GB", "blue");
        notePad.printInfo();
    }
}
