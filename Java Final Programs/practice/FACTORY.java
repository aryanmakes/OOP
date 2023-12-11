import java.util.*;

abstract class car_factory {
    String company, car_name;
    double budget;

    abstract void getprice(double price);

    abstract void detail(String company_name, String car_name);

    abstract void accesories();

    void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Company- ");
        company = sc.next();
        System.out.println("Car- ");
        car_name = sc.next();
        System.out.println("Rough budget(IN Lakh)- ");
        budget = sc.nextDouble();
    }

    void display(car_factory obj1) {
        obj1.getprice(budget);
        obj1.detail(company, car_name);
        obj1.accesories();
    }
}

class Small_car extends car_factory {
    String ans;

    public void getprice(double price) {
        if (price > 2 && price < 5) {
            ans = "No";
        } else {
            ans = "Yes";
        }
    }

    public void detail(String company_name, String car_name) {
        System.out.println("Company- " + company_name);
        System.out.println("Car Name- " + car_name);
        System.out.println("Colors- whilte/orange/red/yellow/gray/black ");
        System.out.println("Fuel- Petrol/diesel ");
        System.out.println("Gears- Manual");
    }

    public void accesories() {
        System.out.println("Typer type- Alloy Wheels");
        System.out.println("Air Bags- " + ans);
        System.out.println("Back wiper- " + ans);
        System.out.println("Side Mirrors- Two ");
        System.out.println("Touch Screen Music Player - " + ans);

    }

}

class sedan extends car_factory {
    String ans;

    public void getprice(double price) {
        if (price > 6 && price < 10) {
            ans = "NO";
        } else {
            ans = "YES";
        }
    }

    public void detail(String company_name, String car_name) {
        System.out.println("Company- " + company_name);
        System.out.println("Car Name- " + car_name);
        System.out.println("Colors- whilte/orange/red/yellow/gray/black ");
        System.out.println("Fuel- Petrol/diesel ");
        System.out.println("Gears- Manual/Automatic");

    }

    public void accesories() {
        System.out.println("Typer type- Alloy Wheels");
        System.out.println("Air Bags- YES");
        System.out.println("Back wiper- YES");
        System.out.println("Side Mirrors- Two ");
        System.out.println("Touch Screen Music Player - YES");
        System.out.println("Roof window- " + ans);

    }
}

class Luxary extends car_factory {
    String ans;

    public void getprice(double price) {
        if (price > 12 && price < 14) {
            ans = "NO";
        } else {
            ans = "YES";
        }
    }

    public void detail(String company_name, String car_name) {
        System.out.println("Company- " + company_name);
        System.out.println("Car Name- " + car_name);
        System.out.println("Colors- whilte/orange/red/yellow/gray/black ");
        System.out.println("Fuel- Petrol/Electric ");
        System.out.println("Gears- Automatic");

    }

    public void accesories() {
        System.out.println("Typer type- Alloy Wheels");
        System.out.println("Air Bags- YES");
        System.out.println("Back wiper- YES");
        System.out.println("Side Mirrors- Two ");
        System.out.println("Touch Screen Music Player - YES");
        System.out.println("Roof window- YES");
        System.out.println("Button start- " + ans);
        System.out.println("Back Side SCREEN - " + ans);

    }

}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        car_factory obj;
        int ch;
        while (true) {
            System.out.println("Which car Do want to SEE-");
            System.out.println("1.Small car\n2.Sedan\n 3.Luxary Car\n4.Exit\n");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    obj = new Small_car();
                    obj.input();
                    obj.display(obj);
                    break;
                case 2:
                    obj = new sedan();
                    obj.input();
                    obj.display(obj);
                    break;
                case 3:
                    obj = new Luxary();
                    obj.input();
                    obj.display(obj);
                    break;
                case 4:
                    System.out.println("Thank you......");
                    return;
                default:
                    System.out.println("Invalid Choice..");
                    break;

            }
        }
    }
}