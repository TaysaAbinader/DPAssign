package Composite;

import java.util.ArrayList;

public class Department implements OrganizationEntity {
    protected String name;
    protected ArrayList<Department> departments = new ArrayList<>();
    protected ArrayList<Employee> employees = new ArrayList<>();

    public Department (String name) {
        this.name = name;
    }

    public void addDepartment(Department department) {
        departments.add(department);
    };

    public void addEmployee(Employee employee) {
        employees.add(employee);
    };

    public ArrayList<Department> getDepartments() {
        return departments;
    };

    public ArrayList<Employee> getEmployees() {
        return employees;
    };

    public Double getSalary() {
        Double sum = 0.0;

        for (Department department : departments) {
            sum += department.getSalary();
        }

        for (Employee employee : employees) {
            sum += employee.getSalary();
        }

        return sum;
    }

    public void printXML(Integer level) {
        // Level 0 identifies the root element.
        if (level == 0) {
            System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\" ?>");
        }

        String indent = "  ".repeat(level);

        String tagName = name.replace(" ", "");
        System.out.println(indent + "<" + tagName + ">");

        if (!departments.isEmpty()) {
            System.out.println(indent + "  <departments>");
            for (Department department : departments) {
                department.printXML(level + 2);
            }
            System.out.println(indent + "  </departments>");
        }

        if (!employees.isEmpty()) {
            System.out.println(indent + "  <employees>");
            for (Employee employee : employees) {
                employee.printXML(level + 2);
            }
            System.out.println(indent + "  </employees>");
        }

        System.out.println(indent + "</" + tagName + ">");
    }
}
