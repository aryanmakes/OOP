interface Vehicle {
    void gearChange(int newGear);

    void speedUp(int increment);

    void applyBrakes(int decrement);
}

class Bicycle implements Vehicle {
    private int gear;
    private int speed;

    public Bicycle() {
        gear = 1;
        speed = 0;
    }

    public void gearChange(int newGear) {
        gear = newGear;
        System.out.print("Bicycle: Change To gear : " + gear + '\n');

    }

    public void speedUp(int increment) {
        speed += increment;
        System.out.print("Bicycle: Speed Increase Up to: " + speed + "km/h\n");
    }

    public void applyBrakes(int decrement) {
        speed -= decrement;
        System.out.print("Bicycle: Applying Brakes: current speed: " + speed + "km/h\n");
    }
}

class Bike implements Vehicle {
    private int gear;
    private int speed;

    public Bike() {
        gear = 1;
        speed = 0;
    }

    public void gearChange(int newGear) {
        gear = newGear;
        System.out.print("Bike: Change Gear to: " + gear + '\n');
    }

    public void speedUp(int increment) {
        speed += increment;
        System.out.print("Bike: Speed increased up to: " + speed + "km/h\n");
    }

    public void applyBrakes(int decrement) {
        speed -= decrement;
        System.out.print("Bike: Applying Brakes, Current speed; " + speed + "kmm/h\n");
    }
}

class Car implements Vehicle {
    private int gear;
    private int speed;

    public Car() {
        gear = 1;
        speed = 0;
    }

    public void gearChange(int newGear) {
        gear = newGear;
        System.out.print("Car: Change Gear to: " + gear + '\n');
    }

    public void speedUp(int increment) {
        speed += increment;
        System.out.print("Car: Speed icreased up to: " + speed + "km/h\n");
    }

    public void applyBrakes(int decrement) {
        speed -= decrement;
        System.out.print("Car: Applying Brakes, current speed: " + speed + "km/h\n");
    }
}

class VehicleApp {
    public static void main(String[] args) {
        Bicycle bicycle = new Bicycle();
        Bike bike = new Bike();
        Car car = new Car();
        bicycle.gearChange(2);
        bicycle.speedUp(30);
        bicycle.applyBrakes(10);

        bike.gearChange(3);
        bike.speedUp(60);
        bike.applyBrakes(25);

        car.gearChange(4);
        car.speedUp(85);
        car.applyBrakes(35);
    }
}