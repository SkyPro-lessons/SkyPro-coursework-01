package ru.skypro;

public class EmployeeService {

    public Employee[] createEmployeeList() {
        Employee[] employees = new Employee[10];
        employees[0] = new Employee("Иванов Петр Ильич", 1, 100_000);
        employees[1] = new Employee("Петров Илья Иванович", 1, 130_000);
        employees[2] = new Employee("Ильин Иван Петрович", 5, 30_000);
        employees[3] = new Employee("Максимов Сергей Дмитриевич", 5, 22_001);
        employees[4] = new Employee("Сергеев Дмитрий Максимович", 2, 50_000);
        employees[5] = new Employee("Дмитриев Максим Сергеевич", 3, 230_000);
        employees[6] = new Employee("Васильев Алексей Антонович", 2, 80_000);
        employees[7] = new Employee("Алексеев Антон Васильевич", 4, 33_000);
        return employees;
    }

    public void printAllEmployees(Employee[] employees) {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    public double calculateSalaryAmount(Employee[] employees) {
        double salaryAmount = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
                salaryAmount += employee.getSalary();
            }
        }
        return salaryAmount;
    }

    public Employee findMinSalaryEmployee(Employee[] employees) {
        double minSalary = Double.MAX_VALUE;
        Employee minSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee != null) {
                if (minSalary > employee.getSalary()) {
                    minSalary = employee.getSalary();
                    minSalaryEmployee = employee;
                }
            }
        }
        return minSalaryEmployee;
    }

    public Employee findMaxSalaryEmployee(Employee[] employees) {
        double maxSalary = 0;
        Employee maxSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee != null) {
                if (maxSalary < employee.getSalary()) {
                    maxSalary = employee.getSalary();
                    maxSalaryEmployee = employee;
                }
            }
        }
        return maxSalaryEmployee;
    }

    public double calculateAverageSalary(Employee[] employees) {
        double salaryAmount = this.calculateSalaryAmount(employees);
        int employeesCount = this.calculeteEmployeesCount(employees);
        return salaryAmount / employeesCount;
    }

    private int calculeteEmployeesCount(Employee[] employees) {
        int employeesCount = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                employeesCount++;
            }
        }
        return employeesCount;
    }

    public void printAllFIOEmployees(Employee[] employees) {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }
        }
    }
}
