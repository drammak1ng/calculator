import java.io.IOException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Main result = new Main();

        System.out.println("Введите арифметическое выражение:");
        String expression = input.nextLine(); // Считываем выражение с консоли
        String answer = result.calc(expression); // Вычисляем результат выражения

        System.out.println("Результат: " + answer); // Вывод результата на консоль
    }
}




class Main {
    // Метод для вычисления арифметического выражения
    public static String calc(String input) {
        // Разбиваем строку на числа и операторы
        String[] parts = input.split(" ");



        int num1 = Integer.parseInt(parts[0]); // Преобразуем первую часть в целое число
        char op = parts[1].charAt(0); // Извлекаем оператор
        int num2 = Integer.parseInt(parts[2]); // Преобразуем вторую часть в целое число

        int result;
        for (int i = 1; i < parts.length; i++) {
            if (!parts[i].equals("+") && !parts[i].equals("-") && !parts[i].equals("*") && !parts[i].equals("/")) {
                try {
                    throw new IOException();
                } catch (IOException k){
                    return "Неверный оператор";
                }

            }
        }
        if ((num1 >= 11) || (num2 >= 11)) {
            try {
                throw new IOException();
            } catch (IOException e) {
                return "Ошибка: число не должно быть больше 10!";
            }
        }

        if (num1 <= 0 || num2 <= 0) {
            try {
                throw new IOException();
            } catch (IOException y) {
                return "Ошибка: число не должно быть равно нулю!";
            }
        }
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                return "Ошибка: некорректный оператор!";
        }

        return String.valueOf(result); // Возвращаем результат в виде строки
    }
}