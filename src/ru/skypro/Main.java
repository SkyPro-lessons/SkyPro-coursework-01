package ru.skypro;

public class Main {

    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();
        Employee[] employees = employeeService.createEmployeeList();
        double salaryAmount = employeeService.calculateSalaryAmount(employees);
        Employee minSalaryEmployee = employeeService.findMinSalaryEmployee(employees);
        Employee maxSalaryEmployee = employeeService.findMaxSalaryEmployee(employees);
        double averageSalary = employeeService.calculateAverageSalary(employees);

        System.out.println("--- Уровень 1. Базовая сложность ---");
        System.out.println("a. Получить список всех сотрудников");
        employeeService.printAllEmployees(employees);
        System.out.println("b. Сумма затрат на зарплаты в месяц: " + salaryAmount + " рублей");
        System.out.println("c. Сотрудник с минимальной зарплатой: " + minSalaryEmployee);
        System.out.println("d. Сотрудник с максимальной зарплатой: " + maxSalaryEmployee);
        System.out.println("e. Среднее значение зарплат: " + averageSalary);
        System.out.println("f. Получить ФИО всех сотрудников:");
        employeeService.printAllFIOEmployees(employees);
        System.out.println();

        System.out.println("--- Уровень 2. Повышенная сложность ---");
        System.out.println("1. После индексации зарплат:");
        EmployeeService.increaseSalary(employees, 10);
        employeeService.printAllEmployees(employees);

        employeeService.printEmployeeWithMinSalaryByDepartment(employees, 2);
        employeeService.printEmployeeWithMaxSalaryByDepartment(employees, 5);
        employeeService.printSalaryAmountByDepartment(employees, 1);

    }


}
