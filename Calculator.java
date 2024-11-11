import java.io.IOException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Main result = new Main();

        System.out.println("Введите арифметическое выражение:");
        String expression = input.nextLine(); 
        String answer = result.calc(expression); 

        System.out.println("Результат: " + answer); 
    }
}




class Main {
   
    public static String calc(String input) {
      
        String[] parts = input.split(" ");



        int num1 = Integer.parseInt(parts[0]); 
        char op = parts[1].charAt(0); 
        int num2 = Integer.parseInt(parts[2]); 

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

        return String.valueOf(result); 
    }
}
