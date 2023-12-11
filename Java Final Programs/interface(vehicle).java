// Interface for Vehicle functionality
interface Vehicle {
    void gearChange(int newGear);

    void speedUp(int increment);

    void applyBrakes(int decrement);
}

// Bicycle class implementing Vehicle interface
class Bicycle implements Vehicle {
    private int gear;
    private int speed;

    public Bicycle() {
        gear = 1;
        speed = 0;
    }

    public void gearChange(int newGear) {
        gear = newGear;
        System.out.println("Bicycle: Changed to gear " + gear);
    }

    public void speedUp(int increment) {
        speed += increment;
        System.out.println("Bicycle: Speeding up to " + speed + " km/h");
    }

    public void applyBrakes(int decrement) {
        speed -= decrement;
        System.out.println("Bicycle: Applying brakes, current speed: " + speed + " km/h");
    }
}

// Bike class implementing Vehicle interface
class Bike implements Vehicle {
    private int gear;
    private int speed;

    public Bike() {
        gear = 1;
        speed = 0;
    }

    public void gearChange(int newGear) {
        gear = newGear;
        System.out.println("Bike: Changed to gear " + gear);
    }

    public void speedUp(int increment) {
        speed += increment;
        System.out.println("Bike: Speeding up to " + speed + " km/h");
    }

    public void applyBrakes(int decrement) {
        speed -= decrement;
        System.out.println("Bike: Applying brakes, current speed: " + speed + " km/h");
    }
}

// Car class implementing Vehicle interface
class Car implements Vehicle {
    private int gear;
    private int speed;

    public Car() {
        gear = 1;
        speed = 0;
    }

    public void gearChange(int newGear) {
        gear = newGear;
        System.out.println("Car: Changed to gear " + gear);
    }

    public void speedUp(int increment) {
        speed += increment;
        System.out.println("Car: Speeding up to " + speed + " km/h");
    }

    public void applyBrakes(int decrement) {
        speed -= decrement;
        System.out.println("Car: Applying brakes, current speed: " + speed + " km/h");
    }
}

class VehicleApp {
    public static void main(String[] args) {
        Bicycle bicycle = new Bicycle();
        Bike bike = new Bike();
        Car car = new Car();

        // Demonstrate vehicle functionalities
        bicycle.gearChange(3);
        bicycle.speedUp(20);
        bicycle.applyBrakes(5);

        bike.gearChange(2);
        bike.speedUp(30);
        bike.applyBrakes(10);

        car.gearChange(4);
        car.speedUp(60);
        car.applyBrakes(15);
    }
}
