package Composite;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Department implements Organization {
    protected String name;
    protected ArrayList<Department> departments = new ArrayList<>();

    public Department (String name) {
        this.name = name;
    }

    public void addDepartment(Department department) {
        departments.add(department);
    };

    public void addEmployee(){};
    public ArrayList<String> getDepartments();
    public HashMap<String, Integer> getEmployeesData();
    public Integer getSalary();
    public void removeDepartment();
    public void removeEmployee();
}
