package ru.geekbrains.lesson2;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


public class HomeWork {
//    public static void main(String[] args) {
//        float inputNumber = one();
//        System.out.println("Введенное число: " + inputNumber);
//
//        two();
//        three();
//
//
//        try {
//            four();
//            System.out.println("Ввод корректен");
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//    }
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



//Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке,
// разделенные пробелом:
//Фамилия Имя Отчество датарождения номертелефона пол
//
//Форматы данных:
//фамилия, имя, отчество - строки
//датарождения - строка формата dd.mm.yyyy
//номертелефона - целое беззнаковое число без форматирования
//пол - символ латиницей f или m.
//
//Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым,
// вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных,
// чем требуется.
//
//Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры.
// Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы.
// Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано,
// пользователю выведено сообщение с информацией, что именно неверно.
//
//Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии,
// в него в одну строку должны записаться полученные данные, вида
//
//<Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
//
//Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
//
//Не забудьте закрыть соединение с файлом.
//
//При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано,
// пользователь должен увидеть стектрейс ошибки.





    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите данные через пробел в формате 'Фамилия Имя Отчество датарождения номертелефона пол': ");
        String input = scanner.nextLine();

        String[] data = input.split(" ");

        if (data.length != 5) {
            System.err.println("Неверное количество данных");
            return;
        }

        String lastName = data[0];
        String firstName = data[1];
        String middleName = data[2];
        String birthDateStr = data[3];
        String phoneNumberStr = data[4];
        String genderStr = data[5];

        try {
            LocalDate birthDate = parseDate(birthDateStr);
            int phoneNumber = parsePhoneNumber(phoneNumberStr);
            Gender gender = parseGender(genderStr);

            String output = lastName + " " + firstName + " " + middleName + " " +
                    birthDateStr + " " + phoneNumberStr + " " + genderStr;

            writeFile(lastName, output);

            System.out.println("Данные успешно записаны в файл");
        } catch (DateTimeParseException e) {
            System.err.println("Неверный формат даты рождения");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат номера телефона");
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.err.println("Неверный формат пола");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл");
            e.printStackTrace();
        }
    }

    private static LocalDate parseDate(String dateStr) {
        return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    private static int parsePhoneNumber(String phoneNumberStr) {
        return Integer.parseInt(phoneNumberStr);
    }

    private static Gender parseGender(String genderStr) {
        if (genderStr.equalsIgnoreCase("f")) {
            return Gender.FEMALE;
        } else if (genderStr.equalsIgnoreCase("m")) {
            return Gender.MALE;
        } else {
            throw new IllegalArgumentException("Некорректное значение пола");
        }
    }

    private static void writeFile(String fileName, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
        }
    }

    private enum Gender {
        FEMALE,
        MALE
    }
}