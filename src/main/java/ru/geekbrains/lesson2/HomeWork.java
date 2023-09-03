package ru.geekbrains.lesson2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class HomeWork {
    public static void main(String[] args) {
        float inputNumber = one();
        System.out.println("Введенное число: " + inputNumber);

        two();
        three();


        try {
            four();
            System.out.println("Ввод корректен");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
//   1. Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
//    и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению
//    приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.

    public static float one() {
        Scanner scanner = new Scanner(System.in);
        float number = 0;

        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Введите дробное число: ");
                number = scanner.nextFloat();
                validInput = true;
            } catch (Exception e) {
                System.out.println("Ошибка: введено некорректное значение. Пожалуйста, введите дробное число.");
                scanner.nextLine(); // Очистить буфер ввода
            }
        }

        return number;
    }



//    2. Если необходимо, исправьте данный код
//    (задание 2 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)

    public static void two() {
        try {
            int d = 0;
            int[] intArray = new int[10];
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Catching exception: " + e);
        }
    }


//    3. Дан следующий код, исправьте его там, где требуется
//    (задание 3 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)

    public static void three() {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;

        }catch (ArithmeticException ex) {
            System.out.println("Ошибка в расчетах");
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Exception ex) {
        System.out.println("Что-то пошло не так...");
        }
    }
    public static void printSum(Integer a, Integer b) throws FileNotFoundException {
        System.out.println(a + b);
    }



//    4. Разработайте программу, которая выбросит Exception,
//    когда пользователь вводит пустую строку. Пользователю должно
//    показаться сообщение, что пустые строки вводить нельзя.

    public static void four() throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String userInput = scanner.nextLine();

        if (userInput.isEmpty()) {
            throw new Exception("Ошибка: пустая строка недопустима");
        }
    }

}

