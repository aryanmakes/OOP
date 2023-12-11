import java.util.*;

class Publication {
    Scanner sc = new Scanner(System.in);
    private String title;
    private int price;
    private int copies;
    private int total;

    public void settitle(String title) {
        this.title = title;

    }

    public void setcopies(int copies) {
        this.copies = copies;

    }

    public String gettitle() {
        return title;
    }

    public int getTotal() {
        return total;
    }

    public int getcopies() {
        return copies;
    }

    public int getprice() {
        return price;

    }

    void read_publication() {
        System.out.print("Enter Title:");
        title = sc.next();
        System.out.print("Enter price: ");
        price = sc.nextInt();
        System.out.print("Enter Copies:");
        copies = sc.nextInt();

    }

    void display() {
        System.out.print("TITLE \t  PRICE\t  COPIES\n");
        System.out.print(title + "\t" + price + "\t" + copies + "\t\n");
    }

    void sale_copies(int number) {
        if (number <= copies) {
            copies = copies - number;
            total =total + number * price;
            System.out.print("You P<urchased " + number + "  YOU HAVE TO PAY: " + (number * price) + "\n");
        } else {
            System.out.print("INSUFFICIENT STOCK.....SORRY\n");

        }
    }

}

class Book extends Publication {
    private String author;

    void order(int number) {
        System.out.print(" THIS PART ONLY FOR SHOP OWNER\n");
        int x = getcopies() + number;
        setcopies(getcopies() + number);
        System.out.print("ORDER SUCCESSFULL....");
        System.out.print("You have to pay to Supplier :" + (number * getprice()) + "\n");
    }

    void readd_book() {
        read_publication();
        System.out.print("Enter Author Book:");
        author = sc.next();

    }
}

class magzine extends Publication {
    private int orderQty;
    private String reciveissue;

    void receive_issue() {

        System.out.print("THERE IS NO RECEIVED ISSUES");
    }

    void read_mag() {
        read_publication();

    }

    void display_mag() {
        display();
    }

}

class Aryan extends Publication {

    public static void main(String[] args) {
        int k, a;

        Scanner sc = new Scanner(System.in);
        System.out.print("1.Book\t2.Magzine");
        System.out.print("\nChoose::");
        k = sc.nextInt();

        Book b = new Book();
        magzine m = new magzine();

        aa: if (k == 1) {
            do {

                System.out.print("1.BOOK DETAIL\t2.Buy\t3.ORDER FROM SUPPLIER(ONLY FOR SHOP OWNER)\n");
                System.out.print("Choose::");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        b.readd_book();
                        b.display();
                        break;
                    case 2:
                        System.out.print("\nHOW MANY BOOK DO YOU WANT(FOR CUSTOMER):: ");
                        int n1 = sc.nextInt();
                        b.sale_copies(n1);
                        break;
                    case 3:
                        System.out.print("\nHOW MANY CAN ORDER (FOR SHOP)::");
                        int n2 = sc.nextInt();
                        b.order(n2);
                        break;
                }

                System.out.print("\nDO YOU WANT CONTINUE WITH THIS..1.YES ,0.NO");
                System.out.print("\nCHOICE::");
                a = sc.nextInt();
                if (a == 0)
                    break aa;
            } while (a == 1);
        }
        mm: if (k == 2) {
            do {
                System.out.print("1.Magzine Detail\t 2.Order\t 3.Received ISSUES\n");
                System.out.print("Choice::");
                int D = sc.nextInt();
                switch (D) {
                    case 1:
                        m.read_publication();
                        m.display();
                        break;
                    case 2:
                        System.out.print("HOW MANY MAGZINE DO YOU WANT(FOR CUSTOMER)::");
                        int n3 = sc.nextInt();
                        m.sale_copies(n3);
                        break;
                    case 3:
                        m.receive_issue();
                        break;

                }
                System.out.print("\nDO YOU WANT CONTINUE WITH THIS..1.YES ,0.NO");
                System.out.print("\nCHOICE::");
                a = sc.nextInt();
                if (a == 0)
                    break mm;

            } while (a == 1);
        }

    }
}