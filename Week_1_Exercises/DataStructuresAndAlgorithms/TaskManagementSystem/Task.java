package tms;

public class Employee {
    private String employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(String employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: " + salary;
    }

    public static class EmployeeManagementSystem {
        private Employee[] employees;
        private int size;
        private static final int INITIAL_CAPACITY = 10;

        public EmployeeManagementSystem() {
            employees = new Employee[INITIAL_CAPACITY];
            size = 0;
        }

        public void addEmployee(Employee employee) {
            if (size == employees.length) {
                resize();
            }
            employees[size++] = employee;
        }

        public Employee searchEmployee(String employeeId) {
            for (int i = 0; i < size; i++) {
                if (employees[i].getEmployeeId().equals(employeeId)) {
                    return employees[i];
                }
            }
            return null;
        }

        public void traverseEmployees() {
            for (int i = 0; i < size; i++) {
                System.out.println(employees[i]);
            }
        }

        public void deleteEmployee(String employeeId) {
            int index = -1;
            for (int i = 0; i < size; i++) {
                if (employees[i].getEmployeeId().equals(employeeId)) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                for (int i = index; i < size - 1; i++) {
                    employees[i] = employees[i + 1];
                }
                employees[size - 1] = null;
                size--;
            }
        }

        private void resize() {
            Employee[] newArray = new Employee[employees.length * 2];
            System.arraycopy(employees, 0, newArray, 0, size);
            employees = newArray;
        }

        public static void main(String[] args) {
            EmployeeManagementSystem ems = new EmployeeManagementSystem();
            ems.addEmployee(new Employee("E001", "Ravi", "Manager", 50000));
            ems.addEmployee(new Employee("E002", "Aarti", "Developer", 40000));
            ems.addEmployee(new Employee("E003", "Suresh", "Tester", 30000));

            System.out.println("All Employees:");
            ems.traverseEmployees();

            System.out.println("\nSearching for Employee E002:");
            System.out.println(ems.searchEmployee("E002"));

            System.out.println("\nDeleting Employee E001:");
            ems.deleteEmployee("E001");

            System.out.println("\nAll Employees after deletion:");
            ems.traverseEmployees();
        }
    }
}
