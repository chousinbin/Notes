package com.polymorphic.polyparameter;

/**
 * @ClassName: PolyParameter
 * @Description:
 * @date: 2023-02-24 17:01
 */
public class PolyParameter {
    public static void main(String[] args) {
        Test test = new Test();
        Employee employee = new Employee("null", 0);
        Handle handle = new Handle("经理李", 10000, 1000);
        Staff staff = new Staff("小工晓", 4000);

        test.showEmpAnnual(employee);
        test.showEmpAnnual(handle);
        test.showEmpAnnual(staff);

        test.testWork(employee);
        test.testWork(handle);
        test.testWork(staff);


    }
}

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getAnnual() {
        return salary;
    }
}

class Handle extends Employee{
    private double bonus;

    public Handle(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void manage() {
        System.out.println("经理" + getName() + "正在喝茶");
    }

    public double getAnnual() {
        return super.getAnnual() + bonus;
    }
}

class Staff extends Employee {
    public Staff(String name, double salary) {
        super(name, salary);
    }

    public void work() {
        System.out.println("员工" + getName() + "正在工作");
    }

    public double getAnnual() {
        return super.getAnnual();
    }
}

class Test {
    public void showEmpAnnual(Employee e) {
        //动态绑定机制a.getAnnual()
        System.out.println(e.getName() + "月总薪资:" + e.getAnnual());
    }

    public void testWork(Employee e) {
        if(e instanceof Staff) {
            ((Staff) e).work();
        } else if (e instanceof Handle) {
            ((Handle) e).manage();
        }
    }
}