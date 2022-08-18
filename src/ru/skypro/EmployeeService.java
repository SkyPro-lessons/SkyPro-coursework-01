package ru.skypro;

public class EmployeeService {

    public static Employee[] createEmployeeList() {
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

    public static void printAllEmployees(Employee[] employees) {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println("    " + employee);
            }
        }
    }

    public static double calculateSalaryAmount(Employee[] employees) {
        double salaryAmount = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                salaryAmount += employee.getSalary();
            }
        }
        return salaryAmount;
    }

    public static double calculateSalaryAmountByDepartment(Employee[] employees, int department) {
        double salaryAmount = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                salaryAmount += employee.getSalary();
            }
        }
        return salaryAmount;
    }

    public static Employee findMinSalaryEmployee(Employee[] employees) {
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

    public static Employee findMinSalaryEmployeeByDepartment(Employee[] employees, int department) {
        double minSalary = Double.MAX_VALUE;
        Employee minSalaryEmployee = null;
        for (Employee employee : employees) {
            if ((employee != null) && (employee.getDepartment() == department)) {
                if (minSalary > employee.getSalary()) {
                    minSalary = employee.getSalary();
                    minSalaryEmployee = employee;
                }
            }
        }
        return minSalaryEmployee;
    }

    public static Employee findMaxSalaryEmployee(Employee[] employees) {
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

    public static Employee findMaxSalaryEmployeeByDepartment(Employee[] employees, int department) {
        double maxSalary = 0;
        Employee maxSalaryEmployee = null;
        for (Employee employee : employees) {
            if ((employee != null) && (employee.getDepartment() == department)) {
                if (maxSalary < employee.getSalary()) {
                    maxSalary = employee.getSalary();
                    maxSalaryEmployee = employee;
                }
            }
        }
        return maxSalaryEmployee;
    }

    public static double calculateAverageSalary(Employee[] employees) {
        double salaryAmount = EmployeeService.calculateSalaryAmount(employees);
        int employeesCount = EmployeeService.calculateEmployeesCount(employees);
        return (double) Math.round(salaryAmount / employeesCount * 100) / 100;
    }

    public static double calculateAverageSalaryByDepartment(Employee[] employees, int department) {
        double salaryAmount = EmployeeService.calculateSalaryAmountByDepartment(employees, department);
        int employeesCount = EmployeeService.calculateEmployeesCountByDepartment(employees, department);
        if (employeesCount != 0) {
            return (double) Math.round(salaryAmount / employeesCount * 100) / 100;
        }
        return 0;
    }

    public static int calculateEmployeesCount(Employee[] employees) {
        int employeesCount = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                employeesCount++;
            }
        }
        return employeesCount;
    }

    public static int calculateEmployeesCountByDepartment(Employee[] employees, int department) {
        int employeesCount = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                employeesCount++;
            }
        }
        return employeesCount;
    }

    public static void printAllFIOEmployees(Employee[] employees) {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println("    " + employee.getFullName());
            }
        }
    }

    public static void increaseSalary(Employee[] employees, double increasePercent) {
        if (increasePercent < 0) {
            throw new IllegalArgumentException("Неверное значение");
        }
        for (Employee employee : employees) {
            if (employee != null) {
                double currSalary = employee.getSalary();
                double newSalary = currSalary + (double) Math.round(currSalary * increasePercent) / 100;
                employee.setSalary(newSalary);
            }
        }
    }

    public static void increaseSalaryByDepartment(Employee[] employees, int increasePercent, int department) {
        Employee[] employeesFromDepartment = new Employee[employees.length];
        int employeeNumber = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                employeesFromDepartment[employeeNumber] = employee;
                employeeNumber++;
            }
        }
        EmployeeService.increaseSalary(employeesFromDepartment, increasePercent);
    }

    public static void printEmployeeWithMinSalaryByDepartment(Employee[] employees, int department) {
        Employee minSalaryEmployeeByDepartment = EmployeeService.findMinSalaryEmployeeByDepartment(employees, department);
        if (minSalaryEmployeeByDepartment == null) {
            System.out.println("В отделе №" + department + " не найдены сотрудники");
        } else {
            System.out.println("2.a. Сотрудник с минимальной зарплатой в отделе №" + department + ": " + minSalaryEmployeeByDepartment);
        }
    }

    public static void printEmployeeWithMaxSalaryByDepartment(Employee[] employees, int department) {
        Employee maxSalaryEmployeeByDepartment = EmployeeService.findMaxSalaryEmployeeByDepartment(employees, department);
        if (maxSalaryEmployeeByDepartment == null) {
            System.out.println("В отделе №" + department + " не найдены сотрудники");
        } else {
            System.out.println("2.b. Сотрудник с максимальной зарплатой в отделе №" + department + ": " + maxSalaryEmployeeByDepartment);
        }
    }

    public static void printSalaryAmountByDepartment(Employee[] employees, int department) {
        double salaryAmountByDepartment = EmployeeService.calculateSalaryAmountByDepartment(employees, department);
        System.out.println("2.c. Сумма затрат на зарплату по отделу №" + department + ": " + salaryAmountByDepartment);
    }

    public static void printAverageSalaryByDepartment(Employee[] employees, int department) {
        double averageSalaryByDepartment = EmployeeService.calculateAverageSalaryByDepartment(employees, department);
        System.out.println("2.d. Средняя зарплата по отделу №" + department + ": " + averageSalaryByDepartment);
    }

    public static void printAllEmployeesByDepartment(Employee[] employees, int department) {
        System.out.println("2.f. Все сотрудники отдела №" + department);
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                System.out.println("    " + employee.getId() + ", " + employee.getFullName() + ", " + employee.getSalary());
            }
        }
    }

    public static Employee[] findEmployeesBySalaryLower(Employee[] employees, double baseSalary) {
        Employee[] foundEmployees = new Employee[employees.length];
        int employeeNumber = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < baseSalary) {
                foundEmployees[employeeNumber] = employee;
                employeeNumber++;
            }
        }
        return foundEmployees;
    }

    public static void printEmployeesBySalaryLower(Employee[] employees, double baseSalary) {
        System.out.println("3.a. Все сотрудники с зарплатой меньше " + baseSalary);
        Employee[] employeesBySalaryLower = EmployeeService.findEmployeesBySalaryLower(employees, baseSalary);
        for (Employee employee : employeesBySalaryLower) {
            if (employee != null) {
                System.out.println("    " + employee);
            }
        }
    }

    public static Employee[] findEmployeesBySalaryHigher(Employee[] employees, double baseSalary) {
        Employee[] foundEmployees = new Employee[employees.length];
        int employeeNumber = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() >= baseSalary) {
                foundEmployees[employeeNumber] = employee;
                employeeNumber++;
            }
        }
        return foundEmployees;
    }

    public static void printEmployeesBySalaryHigher(Employee[] employees, double baseSalary) {
        System.out.println("3.a. Все сотрудники с зарплатой больше или равно " + baseSalary);
        Employee[] employeesBySalaryHigher = EmployeeService.findEmployeesBySalaryHigher(employees, baseSalary);
        for (Employee employee : employeesBySalaryHigher) {
            if (employee != null) {
                System.out.println("    " + employee);
            }
        }
    }
}
