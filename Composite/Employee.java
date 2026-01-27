package Composite;

public class Employee implements OrganizationEntity {
    private String name;
    private Double salary;

    public Employee (String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return this.name;
    }

    public Double getSalary() {
        return this.salary;
    }

    public void printXML(Integer level) {
        String indent = "  ".repeat(level);
        System.out.println(indent + "<Employee>");
        System.out.println(indent + "  <Name>" + name + "</Name>");
        System.out.println(indent + "  <Salary>" + salary + "</Salary>");
        System.out.println(indent + "</Employee>");
    }
}

