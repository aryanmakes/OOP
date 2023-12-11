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

    public int getcopies() {
        return copies;

    }

    public int getTotal() {
        return total;
    }

    public int getprice() {
        return price;
    }

    void read_publication() {
        System.out.print("Enter Title: ");
        title = sc.next();
        System.out.print("Enetr Copies: ");
        copies = sc.nextInt();
        System.out.print("Enter Price: ");
        price = sc.nextInt();
    }

    void display() {
        System.out.print("TITLE \t PRICE \t COPIES\n");
        System.out.print(title + "\t" + price + "\t" + copies + '\n');
    }

    void sale_copies(int number) {
        if (number <= copies) {
            copies = copies - number;
            total = total + number * price;
            System.out.print("You purchased " + number + "You have to pay: " + (number * price) + '\n');
        } else {
            System.out.print("INSUFFICIENT STOCK !! SORRY");
        }
    }
}

class Book extends Publication {
    private String author;

    void order(int number) {
        System.out.print("THIS PART ONLY FOR EMPLOYEE");
        int x = getcopies() + number;
        setcopies(getcopies() + number);
        System.out.print("order successfull..");
        System.out.print("You have to pay supplier :" + (getprice() * number) + "\n");
    }

    void read_book() {
        System.out.print("Enter Author Name: ");
        author = sc.next();
        read_publication();
    }
}

class Magzine extends Publication {
    private int orderQTY;
    private String recieveissue;

    void recieve_issue() {
        System.out.print("THere is no recieved issues..");
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
        System.out.print("1.BOOK \t 2.MAGZINE\n");
        System.out.print("choose: ");
        k = sc.nextInt();
        Book b = new Book();
        Magzine m = new Magzine();
        aa: if (k == 1) {
            do {
                System.out.print("1.BOOK DETAILS \t 2.BUY \t 3.ORDER(Only for shop employee)\n");
                System.out.print("choose: ");
                int choose = sc.nextInt();
                switch (choose) {
                    case 1:
                        b.read_book();
                        b.display();
                        break;
                    case 2:
                        System.out.print("HOW MANY BOOK DO YOU WANT: ");
                        int n1 = sc.nextInt();
                        b.sale_copies(n1);
                        break;
                    case 3:
                        System.out.print("HOW MANY CAN ORDER FROM SUPPLIER: ");
                        int n2 = sc.nextInt();
                        b.order(n2);
                        break;
                }
                System.out.print("DO YOU WANT CONTINUE..1.YES 0.NO \n");
                System.out.print("Choose:");
                a = sc.nextInt();
                if (a == 0) {
                    break aa;
                }
            } while (a == 1);
        }
        mm: if (k == 2) {
            do {
                System.out.print("1.magzine details \t 2.buy \t 3.recieved issues\n");
                System.out.print("choose: ");
                int d = sc.nextInt();
                switch (d) {
                    case 1:
                        m.read_publication();
                        m.display_mag();
                        break;
                    case 2:
                        System.out.print("HOW MANY MAGZINES DO YOU WANT : ");
                        int n3 = sc.nextInt();
                        m.sale_copies(n3);
                        break;
                    case 3:
                        m.recieve_issue();
                }
                System.out.print("Do you want ot continue 1.YES  0.NO\n");
                a = sc.nextInt();
                if (a == 0) {
                    break mm;
                }
            } while (a == 1);
        }
    }
}