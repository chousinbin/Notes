package com.sinbin.DJTU_Java;

/**
 * @ClassName: User
 * @UserName: SinBin
 * @date: 2023-04-21 12:01
 * @Description:
 */
public class User {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.setPower(40);
        System.out.println("power = " + vehicle.getPower());
        vehicle.speedUp(20);
        System.out.println("speed = " + vehicle.getSpeed());
        vehicle.speedUp(181);
        System.out.println("speed = " + vehicle.getSpeed());
        vehicle.speedDown(21);
        System.out.println("speed = " + vehicle.getSpeed());
        vehicle.brake();
        System.out.println("speed = " + vehicle.getSpeed());
    }
}

class Vehicle {
    private double speed;
    private int power;

    public void speedUp(double speed) {
        if(this.speed + speed <= 200) {
            this.speed += speed;
        }else {
            System.out.println("速度不能大于200");
        }
    }

    public void speedDown(double speed) {
        if(this.speed - speed >=0 ) {
            this.speed -= speed;
        }else {
            System.out.println("速度不能小于0");
        }
    }

    public void brake() {
        this.speed = 0;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getPower() {
        return this.power;
    }

    public double getSpeed() {
        return speed;
    }
}
