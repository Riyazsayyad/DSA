package Crio.DEV_OOP.XCompany.company;
import java.util.*;
public class Employee {
    private String name;
    private Gender gender;


    public Employee(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    // TODO: CRIO_TASK_MODULE_XCOMPANY
    // Please define all the methods required here as mentioned in the XCompany BuildOut Milestone before implementing the logic.
    // This will ensure that the project can be compiled successfully.


    @Override
    public String toString() {
        return "Employee [name=" + name + ", gender=" + gender + "]";
    }

    void assignManager(Employee employee){
    }

    List getDirectReports(){
        return new ArrayList<Integer>();
    }

    List getTeamMates(){
        return new ArrayList<Integer>();
    }
}

