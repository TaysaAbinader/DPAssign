package Composite;

import java.util.ArrayList;
import java.util.HashMap;

public interface Organization {

    public void addDepartment();
    public void addEmployee();
    public ArrayList<String> getDepartments();
    public HashMap<String, Integer> getEmployeesData();
    public Integer getSalary();
    public void removeDepartment();
    public void removeEmployee();

}
