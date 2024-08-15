import java.util.Objects;

public class Employee {
    private final String employeeFullName;
    private int department;      //возможно int
    private int salary;
    private final int id;
    private static int counter = 1;

    public Employee(String employeeFullName, int department, int salary) {
        this.employeeFullName = employeeFullName;
        if (department <= 0 || department >= 6) {
            throw new IllegalArgumentException("Введен неверный отдел");
        } else {
            this.department = department;
        }
        this.salary = salary;
        this.id = counter;
        counter++;
    }

    @Override
    public String toString() {
        return "{" +
                "fullName = '" + employeeFullName + '\'' +
                ", department = " + department +
                ", salary = " + salary +
                '}';
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    public void setDepartment(int department) {
        this.department = department;
    }

    public String getEmployeeFullName() {
        return employeeFullName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }


}
