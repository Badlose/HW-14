public class Main {
    public static void main(String[] args) throws IllegalAccessException {

        EmployeeBook employeeBook = new EmployeeBook();

        employeeBook.addEmployee("Ivanov 1 1", 3, 6_000);
        employeeBook.addEmployee("Ivanov 2 2", 3, 12_000);
        employeeBook.addEmployee("Ivanov 3 3", 3, 1_000);
        employeeBook.addEmployee("Ivanov 4 4", 3, 14_000);
        employeeBook.addEmployee("Ivanov 5 5", 2, 15_000);
        employeeBook.addEmployee("Ivanov 6 6", 3, 14_000);
        employeeBook.addEmployee("Ivanov 7 7", 3, 13_000);
        employeeBook.addEmployee("Ivanov 8 8", 2, 12_000);
        employeeBook.addEmployee("Ivanov 9 9", 3, 16_000);
        employeeBook.addEmployee("Ivanov 10 10", 2, 10_000);

        //Список всех сотрудников
        employeeBook.printAllEmployees();
        System.out.println();

        //сумма затрат на ЗП всех
        employeeBook.getSalarySum();
        System.out.println();

        //мин ЗП
        employeeBook.getMinSalary();
        System.out.println();

        //макс ЗП
        employeeBook.getMaxSalary();
        System.out.println();

        //Средняя ЗП
        employeeBook.getAverageSalary();
        System.out.println();

        //Имена всех
        employeeBook.printAllNames();
        System.out.println();

        //Индексация на аргумент
        employeeBook.indexSalary(5);
        System.out.println();

        //мин ЗП отдела
        employeeBook.getDeptMinSalary(3);
        System.out.println();

        //макс ЗП отдела
        employeeBook.getDeptMaxSalary(3);
        System.out.println();

        //сумма затрат на ЗП отдела
        employeeBook.getDeptSalarySum(2);
        System.out.println();

        //средняя ЗП в отделе
        employeeBook.getAverageDeptSalary(2);
        System.out.println();

        //индексация ЗП в конкретном отделе
        employeeBook.indexDeptSalary(2, 5);
        System.out.println();

        //все сотрудники отдела
        employeeBook.printAllDeptNames(2);
        System.out.println();

        //все с ЗП меньше, чем аргумент
        employeeBook.getEmployeesSalaryLessValue(10_000);
        System.out.println();

        //все с ЗП больше, чем аргумент
        employeeBook.getEmployeesSalaryMoreValue(16_000);
        System.out.println();

        //удалить сотрудника
        employeeBook.removeEmployee(2);
        System.out.println();

        //распечатать все имена (проверка удаления)
        employeeBook.printAllNames();

        //найти по ID
        employeeBook.findEmployeeById(3);

    }

}