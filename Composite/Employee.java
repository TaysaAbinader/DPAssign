package Composite;

import java.util.HashMap;

public class Employee extends Department{
    protected String name;
    protected Integer salary;
    HashMap<String, Integer> employeeData = new HashMap<>();

    public Employee (String departmentName, String name, Integer salary) {
        super(departmentName);
        this.name = name;
        this.salary = salary;
    }

    public void addEmployee(Employee employee) {
        employeeData.put(employee.name, employee.salary);
    }
}
