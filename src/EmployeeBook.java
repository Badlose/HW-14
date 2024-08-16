import java.util.Arrays;
import java.util.Objects;

public class EmployeeBook {
    private Employee[] employees;
    private int size;

    public EmployeeBook() {
        this.employees = new Employee[10];
    }

    @Override
    public String toString() {
        return "EmployeeBook { " + Arrays.toString(employees) + " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeBook that = (EmployeeBook) o;
        return Objects.deepEquals(employees, that.employees);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(employees);
    }

    public void printAllEmployees() {
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (employee != null) {
                System.out.println("Сотрудник {Ф.И.О. : " + employee.getEmployeeFullName() +
                        ", отдел " + employee.getDepartment() + ", зарплата " + employee.getSalary() + ", ID "
                        + employee.getId() + "}");
            }
        }
    }

    private int salarySum() {
        int salarySum = 0;
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (employee != null) {
                employee = employees[i];
                salarySum += employee.getSalary();
            }
        }
        return salarySum;
    }

    private int totalEmployees() {
        int total = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                total++;
            }
        }
        return total;
    }

    public void getSalarySum() {
        System.out.println("Сумма затрат на ЗП в месяц " + salarySum());
    }

    public void getMaxSalary() {
        int maxSalary = 0;
        Employee maxSalaryEmployee = employees[0];
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];

            if (employee != null) {
                if (employee.getSalary() > maxSalary) {
                    maxSalary = employee.getSalary();
                    maxSalaryEmployee = employee;
                }
            }
        }
        System.out.println("Сотрудник с самой высокой зарплатой: " + maxSalaryEmployee.toString());
    }

    public void getMinSalary() {
        Employee minSalaryEmployee = employees[0];
        int minSalary = minSalaryEmployee.getSalary();
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (employee != null) {
                if (employee.getSalary() < minSalary) {
                    minSalary = employee.getSalary();
                    minSalaryEmployee = employee;
                }
            }
        }
        System.out.println("Сотрудник с самой низкой зарплатой: " + minSalaryEmployee.toString());
    }

    public void getAverageSalary() {
        System.out.println("Среднее значение зарплат: " + salarySum() / totalEmployees());
    }

    public void indexSalary(int salaryIncrease) {
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            int currentSalary;
            if (employee != null) {
                currentSalary = employee.getSalary();
                employee.setSalary((currentSalary / 100) * salaryIncrease + currentSalary);
            }
        }
    }

    public void printAllNames() {
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (employee != null) {
                System.out.println(employee.getEmployeeFullName());
            }
        }
    }

    private Employee[] getEmployeesSortedByDept(int deptNo) {
        Employee[] sortedDept = new Employee[employees.length];
        int count = 0;
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (employee != null) {
                if (employee.getDepartment() == deptNo) {
                    sortedDept[count] = employee;
                    count++;
                }
            }
        }
        return sortedDept;
    }

    public void getDeptMaxSalary(int deptNo) {
        Employee[] sortedDept = getEmployeesSortedByDept(deptNo);
        Employee maxSalaryEmployeeInDept = sortedDept[0];
        int maxSalaryInDept = 0;
        for (int i = 0; i < sortedDept.length; i++) {
            Employee employee = sortedDept[i];
            if (employee != null) {
                if (employee.getSalary() > maxSalaryInDept) {
                    maxSalaryInDept = employee.getSalary();
                    maxSalaryEmployeeInDept = employee;
                }
            }
        }
        System.out.println("В отделе " + deptNo + " самая высокая зарплата у " + maxSalaryEmployeeInDept);
    }

    public void getDeptMinSalary(int deptNo) {
        Employee[] sortedDept = getEmployeesSortedByDept(deptNo);
        Employee minSalaryEmployeeInDept = sortedDept[0];
        int minSalaryInDept = minSalaryEmployeeInDept.getSalary();
        for (int i = 0; i < sortedDept.length; i++) {
            Employee employee = sortedDept[i];
            if (employee != null) {
                if (employee.getSalary() < minSalaryInDept) {
                    minSalaryInDept = employee.getSalary();
                    minSalaryEmployeeInDept = employee;
                }
            }
        }
        System.out.println("В отделе " + deptNo + " самая низкая зарплата у " + minSalaryEmployeeInDept);
    }

    private int deptSalarySum(int deptNo) {
        Employee[] sortedDept = getEmployeesSortedByDept(deptNo);
        int detpSalarySum = 0;
        for (int i = 0; i < sortedDept.length; i++) {
            Employee employee = sortedDept[i];
            if (employee != null) {
                detpSalarySum += employee.getSalary();
            }
        }
        return  detpSalarySum;
    }

    public void getDeptSalarySum(int deptNo) {
        System.out.println("Сумма затрат на ЗП в отделе " + deptNo + " в месяц " + deptSalarySum(deptNo));
    }

    private int totalDeptEmployees(int deptNo) {
        int total = 0;
        Employee[] sortedDept = getEmployeesSortedByDept(deptNo);
        for (int i = 0; i < sortedDept.length; i++) {
            if (sortedDept[i] != null) {
                total++;
            }
        }
        return total;
    }

    public void getAverageDeptSalary(int deptNo) {
        System.out.println("Среднее значение зарплат в отделе " + deptNo + " равно "
                + deptSalarySum(deptNo) / totalDeptEmployees(deptNo));
    }

    public void indexDeptSalary(int deptNo, int salaryIncrease) {
        Employee[] sortedDept = getEmployeesSortedByDept(deptNo);
        for (int i = 0; i < sortedDept.length; i++) {
            Employee employee = sortedDept[i];
            int currentSalary;
            if (employee != null) {
                currentSalary = employee.getSalary();
                employee.setSalary((currentSalary / 100) * salaryIncrease + currentSalary);
            }
        }
    }

    public void printAllDeptNames(int deptNo) {
        Employee[] sortedDept = getEmployeesSortedByDept(deptNo);
        for (int i = 0; i < sortedDept.length; i++) {
            Employee employee = sortedDept[i];
            if (employee != null) {
                System.out.println("Сотрудник {Ф.И.О. : " + employee.getEmployeeFullName() + ", зарплата "
                        + employee.getSalary() + ", ID " + employee.getId() + "}");
            }
        }
    }

    public void getEmployeesSalaryLessValue(int value) {
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (employee != null) {
                if (employee.getSalary() < value) {
                    System.out.println("Сотрудник { ID " + employee.getId()  + ", Ф.И.О. : " + employee.getEmployeeFullName() +
                            ", зарплата " + employee.getSalary() + " }");
                }
            }
        }
    }

    public void getEmployeesSalaryMoreValue(int value) {
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (employee != null) {
                if (employee.getSalary() >= value) {
                    System.out.println("Сотрудник { ID " + employee.getId()  + ", Ф.И.О. : " + employee.getEmployeeFullName() +
                            ", зарплата " + employee.getSalary() + " }");
                }
            }
        }
    }

    public void addEmployee(String employeeFullName, int department, int salary) {
        if (size >= employees.length) {
            System.out.println("Нельзя добавить нового сотрудника. Закончилось место");
        }
        Employee newEmployee = new Employee(employeeFullName, department, salary);
        employees[size++] = newEmployee;
    }

    public void removeEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (employee.getId() == id) {
                System.out.println(employee.getEmployeeFullName() + " удален");
                System.arraycopy(employees, i + 1, employees, i, size - i - 1);    // или -1
                employees[size - 1] = null;
                size--;
                return;
            }
        }
    }

    public void findEmployeeById(int id) {
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (employee != null) {
                if (id == employee.getId()) {
                    System.out.println("{Ф.И.О. : " + employee.getEmployeeFullName() +
                            ", отдел " + employee.getDepartment() + ", зарплата " + employee.getSalary() + "}");
                    return;
                }
            }
        }
        System.out.println("Сотрудник с таким ID не найден");
    }

}
