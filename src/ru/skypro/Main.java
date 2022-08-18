package ru.skypro;

public class Main {

    public static void main(String[] args) {
        Employee[] employees = EmployeeService.createEmployeeList();
        double salaryAmount = EmployeeService.calculateSalaryAmount(employees);
        Employee minSalaryEmployee = EmployeeService.findMinSalaryEmployee(employees);
        Employee maxSalaryEmployee = EmployeeService.findMaxSalaryEmployee(employees);
        double averageSalary = EmployeeService.calculateAverageSalary(employees);

        System.out.println("--- Уровень 1. Базовая сложность ---");
        System.out.println("a. Получить список всех сотрудников");
        EmployeeService.printAllEmployees(employees);
        System.out.println("b. Сумма затрат на зарплаты в месяц: " + salaryAmount + " рублей");
        System.out.println("c. Сотрудник с минимальной зарплатой: " + minSalaryEmployee);
        System.out.println("d. Сотрудник с максимальной зарплатой: " + maxSalaryEmployee);
        System.out.println("e. Среднее значение зарплат: " + averageSalary);
        System.out.println("f. Получить ФИО всех сотрудников:");
        EmployeeService.printAllFIOEmployees(employees);
        System.out.println();

        System.out.println("--- Уровень 2. Повышенная сложность ---");
        System.out.println("1. После индексации зарплат:");
        EmployeeService.increaseSalary(employees, 10);
        EmployeeService.printAllEmployees(employees);
        EmployeeService.printEmployeeWithMinSalaryByDepartment(employees, 2);
        EmployeeService.printEmployeeWithMaxSalaryByDepartment(employees, 5);
        EmployeeService.printSalaryAmountByDepartment(employees, 1);
        EmployeeService.printAverageSalaryByDepartment(employees, 5);
        System.out.println("2.e. Проиндексировать зарплату сотрудников в отделе:");
        EmployeeService.increaseSalaryByDepartment(employees, 7, 3);
        EmployeeService.printAllEmployees(employees);
        EmployeeService.printAllEmployeesByDepartment(employees, 2);
        EmployeeService.printEmployeesBySalaryLower(employees, 70_000);
        EmployeeService.printEmployeesBySalaryHigher(employees, 70_000);
    }


}
