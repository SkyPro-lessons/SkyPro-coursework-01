package ru.skypro;

public class Main {

    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();

        System.out.println("--- Уровень 1. Базовая сложность ---");
        employeeBook.tasksFirstLevel();

        System.out.println("--- Уровень 2. Повышенная сложность ---");
        employeeBook.tasksSecondLevel();

        System.out.println("--- Уровень 3. Очень сложно ---");
        employeeBook.tasksThirdLevel();
    }
}
