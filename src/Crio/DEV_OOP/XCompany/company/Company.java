package Crio.DEV_OOP.XCompany.company;

import java.util.*;

public class Company{
    private String companyName;
    private Employee founder;
    private Map<String,Employee> employeeBook;
    private Map<String,ArrayList<Employee>> hierarchyGraph;


    public  Company(String companyName, Employee founder) {
        this.companyName = companyName;
        this.founder = founder;
        employeeBook = new HashMap<String,Employee>();
        employeeBook.put(founder.getName(), founder);
        hierarchyGraph = new HashMap<>();
    }


    public static Company create(String companyName, Employee founder){
        return new Company(companyName,founder);
    }


    public String getCompanyName() {
        return companyName;
    }

    // TODO: CRIO_TASK_MODULE_XCOMPANY
    // Please define all the methods required here as mentioned in the XCompany BuildOut Milestone for each functionality before implementing the logic.
    // This will ensure that the project can be compiled successfully.

    public void registerEmployee(String employeeName, Gender gender){
        Employee E = new Employee(employeeName,gender);
        employeeBook.put(employeeName,E);
        hierarchyGraph.put(employeeName,new ArrayList<>());
        System.out.println("EMPLOYEE_REGISTRATION_SUCCEEDED");
    }

    public Employee getEmployee(String employeeName){
        Employee Temp = employeeBook.getOrDefault(employeeName,null);
        if(Temp == null) System.out.println("EMPLOYEE_NOT_FOUND");
        return Temp;
    }

    public void deleteEmployee(String employeeName){
        employeeBook.remove(employeeName);
        hierarchyGraph.remove(employeeName);
        System.out.println("EMPLOYEE_DELETION_SUCCEEDED");
    }

    public void assignManager(String employeeName, String managerName){
        //System.out.println("assignManager");
        hierarchyGraph.get(managerName).add(employeeBook.get(employeeName));
    }

    public List getDirectReports(String managerName){
        return hierarchyGraph.get(managerName);
    }

    public List getTeamMates(String employeeName){
        String managerName = "";
        for (Map.Entry<String,ArrayList<Employee>> entry : hierarchyGraph.entrySet()){
            for (Employee x : entry.getValue()){
                if(x.getName().equals(employeeName)){
                    managerName = entry.getKey();
                    break;
                }
            }
        }
        List<Employee> T = new ArrayList<>();
        T = hierarchyGraph.get(managerName);
        T.add(employeeBook.get(managerName));
        T.sort(Comparator.comparing(Employee::getName));
        return T;
    }

    public List<List<Employee>> getEmployeeHierarchy(String managerName){
        List<List<Employee>> hierarchy = new ArrayList<>();
        Queue<String> Q = new LinkedList<>();
        Q.add(managerName);
        HashSet<String> visited = new HashSet<>();
        List<Employee> L = new ArrayList<>();
        L.add(employeeBook.get(managerName));
        hierarchy.add(L);
        visited.add(managerName);

        while (!Q.isEmpty()){
            int size = Q.size();
            L = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                String name = Q.poll();
                for (Employee e : hierarchyGraph.getOrDefault(name,new ArrayList<>())){
                    String nam = e.getName();
                    if(!visited.contains(nam)){
                        visited.add(nam);
                        Q.add(nam);
                        L.add(e);
                    }
                }
            }
            L.sort(Comparator.comparing(Employee::getName));
            if(!L.isEmpty()) hierarchy.add(L);
        }
        return hierarchy;
    }
}
