class Vehicle {
    private double speed;
    private int power;

    public void setPower(int p) {
        this.power = p;
    }

    public int getPower() {
        return this.power;
    }

    public void speedUp(int s) {
        if(this.speed + s <= 200)
            this.speed += s;
        else {
            this.speed = 200;
        }
    }

    public void speedDown(int s) {
        if(this.speed - s >= 0)
            this.speed -= s;
        else {
            this.speed = 0;
        }
    }

    public double getSpeed() {
        return this.speed;
    }

    public void brake() {
        this.speed = 0;
    }
}

public class User {
    public static void main(String[] args) {
        Vehicle myVehicle = new Vehicle();


        myVehicle.setPower(200);


        myVehicle.speedUp(50);
        System.out.println("speed: " + myVehicle.getSpeed());

        myVehicle.speedUp(160);
        System.out.println("speed: " + myVehicle.getSpeed());

        myVehicle.speedDown(220);
        System.out.println("speed: " + myVehicle.getSpeed());
        
        myVehicle.speedUp(50);
        System.out.println("speed: " + myVehicle.getSpeed());

        myVehicle.brake();
        System.out.println("speed: " + myVehicle.getSpeed());

        System.out.println("power: " + myVehicle.getPower());
    }
}
