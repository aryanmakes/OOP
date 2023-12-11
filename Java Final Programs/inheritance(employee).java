class Employee {
    protected String Emp_name;
    protected int Emp_id;
    protected String Address;
    protected String Mail_id;
    protected long Mobile_no;

    public Employee(String name, int id, String address, String email, long mobile) {
        Emp_name = name;
        Emp_id = id;
        Address = address;
        Mail_id = email;
        Mobile_no = mobile;
    }

    public double calculateBasicPay() {
        return 0;
    }

    public void generatePaySlip() {
        double BP = calculateBasicPay();
        double DA = 0.97 * BP;
        double HRA = 0.10 * BP;
        double PF = 0.12 * BP;
        double staffClubFund = 0.001 * BP;
        double grossSalary = BP + DA + HRA;
        double netSalary = grossSalary - (PF + staffClubFund);
        System.out.println("Employee Name: " + Emp_name);
        System.out.println("Employee ID: " + Emp_id);
        System.out.println("Basic Pay: $" + BP);
        System.out.println("Dearness Allowance (DA): $" + DA);
        System.out.println("House Rent Allowance (HRA): $" + HRA);
        System.out.println("Provident Fund (PF): $" + PF);
        System.out.println("Staff Club Fund: $" + staffClubFund);
        System.out.println("Gross Salary: $" + grossSalary);
        System.out.println("Net Salary: $" + netSalary);
        System.out.println("==========================================");
    }
}

class Programmer extends Employee {
    public Programmer(String name, int id, String address, String email, long mobile) {
        super(name, id, address, email, mobile);
    }

    @Override
    public double calculateBasicPay() {
        return 50000;
    }
}

class TeamLead extends Employee {
    public TeamLead(String name, int id, String address, String email, long mobile) {
        super(name, id, address, email, mobile);
    }

    @Override
    public double calculateBasicPay() {
        return 60000;
    }
}

class AssistantProjectManager extends Employee {
    public AssistantProjectManager(String name, int id, String address, String email, long mobile) {
        super(name, id, address, email, mobile);
    }

    @Override
    public double calculateBasicPay() {
        return 70000;
    }
}

class ProjectManager extends Employee {
    public ProjectManager(String name, int id, String address, String email, long mobile) {
        super(name, id, address, email, mobile);
    }

    @Override
    public double calculateBasicPay() {
        return 80000;
    }
}

class EmployeePayroll {
    public static void main(String[] args) {
        Programmer programmer = new Programmer("John Doe", 01, "123 Main St", "john@example.com", 1234567890L);
        TeamLead teamLead = new TeamLead("Alice Smith", 102, "123 Main St", "alice@example.com", 9876543210L);
        AssistantProjectManager asstManager = new AssistantProjectManager("Bob Johnson", 103, "789 Elm Rd",
                "bob@example.com", 5678901234L);
        ProjectManager projectManager = new ProjectManager("Eva Williams", 104, "456 Pine Dr", "eva@example.com",
                6789012345L);

        programmer.generatePaySlip();
        teamLead.generatePaySlip();
        asstManager.generatePaySlip();
        projectManager.generatePaySlip();
    }
}
