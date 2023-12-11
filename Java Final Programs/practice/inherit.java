class Employee {
    protected String emp_name;
    protected int emp_id;
    protected String emp_mail;
    protected String Address;
    protected long mobile_no;

    public Employee(String name, int id, String email, String address, long mobile) {
        emp_name = name;
        emp_id = id;
        emp_mail = email;
        Address = address;
        mobile_no = mobile;
    }

    public double calculatebasicpay() {
        return 0;
    }

    public void generatepayslip() {
        double BP = calculatebasicpay();
        double DA = 0.97 * BP;
        double HRA = 0.10 * BP;
        double PF = 0.12 * BP;
        double staffclubfund = 0.001 * BP;
        double grossSalary = BP + DA + HRA;
        double netSalary = grossSalary - (PF - staffclubfund);
        System.out.print("EMPLOYEE NAME: " + emp_name + '\n');
        System.out.print("EMPLOYEE ID: " + emp_id + '\n');
        System.out.print("BASIC PAY $ : " + BP + '\n');
        System.out.print("DEARNESS ALLOWANCE(DA) : " + DA + '\n');
        System.out.print("HOUSE RENT ALOWANCE(HRA) : " + HRA + "\n");
        System.out.print("PROVIDENT FUND (PF) : " + PF + '\n');
        System.out.print("STAFF CLUB FUND($) : " + staffclubfund + "\n");
        System.out.print("GROSS SALARY ($) : " + grossSalary + "\n");
        System.out.print("NET SALARY ($) : " + netSalary + "\n");
        System.out.print("============================================\n");
    }

}

class Programmer extends Employee {
    public Programmer(String name, int id, String email, String address, long mobile) {
        super(name, id, email, address, mobile);
    }

    @Override
    public double calculatebasicpay() {
        return 40000;
    }
}

class Teamlead extends Employee {
    public Teamlead(String name, int id, String email, String address, long mobile) {
        super(name, id, email, address, mobile);
    }

    @Override
    public double calculatebasicpay() {
        return 50000;
    }
}

class AssistantManager extends Employee {
    public AssistantManager(String name, int id, String email, String address, long mobile) {
        super(name, id, email, address, mobile);
    }

    @Override
    public double calculatebasicpay() {
        return 60000;
    }
}

class ProjectManager extends Employee {
    public ProjectManager(String name, int id, String email, String address, long mobile) {
        super(name, id, email, address, mobile);
    }

    @Override
    public double calculatebasicpay() {
        return 80000;
    }
}

class Employeepayroll {
    public static void main(String[] args) {
        Programmer programmer = new Programmer("Aryan", 53, "iamwagharyan@gmail.com", "alkuti", 7666587204L);
        Teamlead teamlead = new Teamlead("Hujefa", 39, "sayyadhujefa31@gmail.com", "jambut", 7756937861L);
        AssistantManager assist = new AssistantManager("Pranav", 44, "pranavshinde9597@gmail.com", "bhalwani",
                9423609597L);
        ProjectManager manager = new ProjectManager("Goraksh", 45, "goraksh1234@gmail.com", "takli", 9011337303L);
        programmer.generatepayslip();
        teamlead.generatepayslip();
        assist.generatepayslip();
        manager.generatepayslip();
    }
}
