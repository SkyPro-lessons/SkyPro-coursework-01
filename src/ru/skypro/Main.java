package ru.skypro;

public class Main {

    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();
        Employee[] employees = employeeService.createEmployeeList();
        double salaryAmount = employeeService.calculateSalaryAmount(employees);
        Employee minSalaryEmployee = employeeService.findMinSalaryEmployee(employees);
        Employee maxSalaryEmployee = employeeService.findMaxSalaryEmployee(employees);
        double averageSalary = employeeService.calculateAverageSalary(employees);

        employeeService.printAllEmployees(employees);
        System.out.println();
        System.out.println("b. Сумма затрат на зарплаты в месяц: " + salaryAmount + " рублей");
        System.out.println("c. Сотрудник с минимальной зарплатой: " + minSalaryEmployee);
        System.out.println("d. Сотрудник с максимальной зарплатой: " + maxSalaryEmployee);
        System.out.println("e. Среднее значение зарплат: " + averageSalary);
        System.out.println();
        employeeService.printAllFIOEmployees(employees);

    }


}
