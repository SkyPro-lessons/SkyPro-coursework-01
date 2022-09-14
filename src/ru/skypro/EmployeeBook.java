package ru.skypro;

public class EmployeeBook {
    Employee[] employees;

    public EmployeeBook() {
        createEmployeeList();
    }

    public void createEmployeeList() {
        employees = new Employee[10];
        employees[0] = new Employee("Иванов Петр Ильич", 1, 100_000);
        employees[1] = new Employee("Петров Илья Иванович", 1, 130_000);
        employees[2] = new Employee("Ильин Иван Петрович", 5, 30_000);
        employees[3] = new Employee("Максимов Сергей Дмитриевич", 5, 22_001);
        employees[4] = new Employee("Сергеев Дмитрий Максимович", 2, 50_000);
        employees[5] = new Employee("Дмитриев Максим Сергеевич", 3, 230_000);
        employees[6] = new Employee("Васильев Алексей Антонович", 2, 80_000);
        employees[7] = new Employee("Алексеев Антон Васильевич", 4, 33_000);
    }

    public void tasksFirstLevel() {
        System.out.println("a. Получить список всех сотрудников");
        printAllEmployees();
        printSalaryAmount();
        printMinSalaryEmployee();
        printMaxSalaryEmployee();
        printAverageSalary();
        printAllFIOEmployees();
        System.out.println();
    }

    public void tasksSecondLevel() {
        System.out.println("1. После индексации зарплат:");
        increaseSalary(employees, 12.12);
        printAllEmployees();
        printMinSalaryEmployeeByDepartment(2);
        printMaxSalaryEmployeeByDepartment(5);
        printSalaryAmountByDepartment(1);
        printAverageSalaryByDepartment(5);
        System.out.println("2.e. Проиндексировать зарплату сотрудников в отделе:");
        increaseSalaryByDepartment(7, 3);
        printAllEmployees();
        printAllEmployeesByDepartment(2);
        printEmployeesBySalaryLower(70_000);
        printEmployeesBySalaryHigher(70_000);
        System.out.println();
    }

    public void tasksThirdLevel() {
        System.out.println("4.a. Добавление нового сотрудника");
        addEmployee("Тарасов Сергей Евгеньевич", 3, 350_000);
        addEmployee("Носырев Иван Витальевич", 1, 100_000);
        addEmployee("Ткач Ирина Владимировна", 5, 30_000);
        printAllEmployees();
        System.out.println("4.b. Удаление сотрудника");
        delEmployee("Петров Илья Иванович");
        addEmployee("Ткач Ирина Владимировна", 5, 30_000);
        delEmployee(1003);
        printAllEmployees();
        System.out.println("5.a. Изменить зарплату сотрудника");
        setSalaryEmployee("Сергеев Дмитрий Максимович", 60_000);
        setDepartmentEmployee("Сергеев Дмитрий Максимович", 4);
        printAllEmployees();
        System.out.println("6. Получить ФИО всех сотрудников по отделам");
        printGroupEmployeesByDepartments();
    }

    public void printGroupEmployeesByDepartments() {
        int[] departments = {1, 2, 3, 4, 5};
        for (int department : departments) {
            System.out.println("    Отдел №" + department);
            printFIOEmployees(getEmployeesByDepartment(department));
        }
    }

    public void printFIOEmployees(Employee[] employees) {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println("        " + employee.getFullName());
            }
        }
    }

    public void setDepartmentEmployee(String fio, int department) {
        Employee employee = findEmployeeByFIO(fio);
        if (employee != null) {
            employee.setDepartment(department);
        }
    }

    public void setSalaryEmployee(String fio, double newSalary) {
        Employee employee = findEmployeeByFIO(fio);
        if (employee != null) {
            employee.setSalary(newSalary);
        }
    }

    public Employee findEmployeeByFIO(String fio) {
        for (Employee employee : employees) {
            if (employee != null && employee.getFullName().equals(fio)) {
                return employee;
            }
        }
        return null;
    }

    public void delEmployee(String fio) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getFullName().equals(fio)) {
                employees[i] = null;
                break;
            }
        }
    }

    public void delEmployee(Integer id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                employees[i] = null;
                break;
            }
        }
    }

    public void addEmployee(String fio, int department, double salary) {
        boolean isAdded = false;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                Employee newEmployee = new Employee(fio, department, salary);
                employees[i] = newEmployee;
                isAdded = true;
                break;
            }
        }
        if (!isAdded) {
            System.out.printf(" ! Сотрудник не добавлен. Недостаточно места в массиве: %s", fio);
        }
    }

    public void printAllEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println("    " + employee);
            }
        }
    }

    public double calculateSalaryAmount(Employee[] employees) {
        double salaryAmount = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                salaryAmount += employee.getSalary();
            }
        }
        return salaryAmount;
    }

    public void printSalaryAmount() {
        double salaryAmount = calculateSalaryAmount(employees);
        System.out.println("b. Сумма затрат на зарплаты в месяц: " + salaryAmount + " рублей");
    }

    public void printSalaryAmountByDepartment(int department) {
        Employee[] employeesFromDepartment = getEmployeesByDepartment(department);
        double salaryAmountByDepartment = calculateSalaryAmount(employeesFromDepartment);
        System.out.println("2.c. Сумма затрат на зарплату по отделу №" + department + ": " + salaryAmountByDepartment);
    }

    public Employee findMinSalaryEmployee(Employee[] employees) {
        double minSalary = employees[0].getSalary();
        Employee minSalaryEmployee = employees[0];
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

    public void printMinSalaryEmployee() {
        Employee minSalaryEmployee = findMinSalaryEmployee(employees);
        System.out.println("c. Сотрудник с минимальной зарплатой: " + minSalaryEmployee);
    }

    public Employee findMinSalaryEmployeeByDepartment(int department) {
        Employee[] employeesFromDepartment = getEmployeesByDepartment(department);
        return findMinSalaryEmployee(employeesFromDepartment);
    }

    public Employee[] getEmployeesByDepartment(int department) {
        Employee[] employeesFromDepartment = new Employee[employees.length];
        int employeeNumber = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                employeesFromDepartment[employeeNumber] = employee;
                employeeNumber++;
            }
        }
        return employeesFromDepartment;
    }

    public void printMinSalaryEmployeeByDepartment(int department) {
        Employee minSalaryEmployeeByDepartment = findMinSalaryEmployeeByDepartment(department);
        if (minSalaryEmployeeByDepartment == null) {
            System.out.println("В отделе №" + department + " не найдены сотрудники");
        } else {
            System.out.println("2.a. Сотрудник с минимальной зарплатой в отделе №" + department + ": " + minSalaryEmployeeByDepartment);
        }
    }

    public Employee findMaxSalaryEmployee(Employee[] employees) {
        double maxSalary = employees[0].getSalary();
        Employee maxSalaryEmployee = employees[0];
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

    public void printMaxSalaryEmployee() {
        Employee maxSalaryEmployee = findMaxSalaryEmployee(employees);
        System.out.println("d. Сотрудник с максимальной зарплатой: " + maxSalaryEmployee);
    }

    public Employee findMaxSalaryEmployeeByDepartment(int department) {
        Employee[] employeesFromDepartment = getEmployeesByDepartment(department);
        return findMaxSalaryEmployee(employeesFromDepartment);
    }

    public void printMaxSalaryEmployeeByDepartment(int department) {
        Employee maxSalaryEmployeeByDepartment = findMaxSalaryEmployeeByDepartment(department);
        if (maxSalaryEmployeeByDepartment == null) {
            System.out.println("В отделе №" + department + " не найдены сотрудники");
        } else {
            System.out.println("2.b. Сотрудник с максимальной зарплатой в отделе №" + department + ": " + maxSalaryEmployeeByDepartment);
        }
    }

    public int calculateEmployeesCount(Employee[] employees) {
        int employeesCount = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                employeesCount++;
            }
        }
        return employeesCount;
    }

    public double calculateAverageSalary(Employee[] employees) {
        double salaryAmount = calculateSalaryAmount(employees);
        int employeesCount = calculateEmployeesCount(employees);
        if (employeesCount != 0) {
            return (double) Math.round(salaryAmount / employeesCount * 100) / 100;
        }
        return 0;
    }

    public void printAverageSalary() {
        double averageSalary = calculateAverageSalary(employees);
        System.out.println("e. Среднее значение зарплат: " + averageSalary);
    }

    public void printAverageSalaryByDepartment(int department) {
        Employee[] employees = getEmployeesByDepartment(department);
        double averageSalaryByDepartment = calculateAverageSalary(employees);
        System.out.println("2.d. Средняя зарплата по отделу №" + department + ": " + averageSalaryByDepartment);
    }

    public void printAllFIOEmployees() {
        System.out.println("f. Получить ФИО всех сотрудников:");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println("    " + employee.getFullName());
            }
        }
    }

    public void increaseSalary(Employee[] employees, double increasePercent) {
        if (increasePercent < 0) {
            throw new IllegalArgumentException("Неверное значение");
        }
        for (Employee employee : employees) {
            if (employee != null) {
                double currSalary = employee.getSalary();
                System.out.println("currSalary = " + currSalary);
                System.out.println("currSalary * increasePercent = " + currSalary * increasePercent);
                System.out.println("(double) Math.round(currSalary * increasePercent) = " + (double) Math.round(currSalary * increasePercent));
                System.out.println("(double) Math.round(currSalary * increasePercent) / 100 = " + (double) Math.round(currSalary * increasePercent) / 100);


                double newSalary = currSalary + (double) Math.round(currSalary * increasePercent) / 100;
                System.out.println("newSalary = " + newSalary);
                employee.setSalary(newSalary);
            }
        }
    }

    public void increaseSalaryByDepartment(int increasePercent, int department) {
        Employee[] employeesFromDepartment = getEmployeesByDepartment(department);
        increaseSalary(employeesFromDepartment, increasePercent);
    }

    public void printAllEmployeesByDepartment(int department) {
        System.out.println("2.f. Все сотрудники отдела №" + department);
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                System.out.println("    " + employee.getId() + ", " + employee.getFullName() + ", " + employee.getSalary());
            }
        }
    }

    public Employee[] findEmployeesBySalaryLower(double baseSalary) {
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

    public void printEmployeesBySalaryLower(double baseSalary) {
        System.out.println("3.a. Все сотрудники с зарплатой меньше " + baseSalary);
        Employee[] employeesBySalaryLower = findEmployeesBySalaryLower(baseSalary);
        for (Employee employee : employeesBySalaryLower) {
            if (employee != null) {
                System.out.println("    " + employee);
            }
        }
    }

    public Employee[] findEmployeesBySalaryHigher(double baseSalary) {
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

    public void printEmployeesBySalaryHigher(double baseSalary) {
        System.out.println("3.a. Все сотрудники с зарплатой больше или равно " + baseSalary);
        Employee[] employeesBySalaryHigher = findEmployeesBySalaryHigher(baseSalary);
        for (Employee employee : employeesBySalaryHigher) {
            if (employee != null) {
                System.out.println("    " + employee);
            }
        }
    }
}
