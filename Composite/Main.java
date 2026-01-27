package Composite;

public class Main {
    public static void main(String[] args) {
        Department organization = new Department("ACME");
        Employee ceo = new Employee("Mary Jane", 100000.0);
        organization.addEmployee(ceo);

        Department engineering = new Department("ACME Engineering");
        Employee engineer = new Employee("John Doe", 1000.0);
        organization.addDepartment(engineering);
        engineering.addEmployee(engineer);

        Double totalSalary = organization.getSalary();

        System.out.println("Total salaries: " + totalSalary);

        organization.printXML(0);
    }
}
