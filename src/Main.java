import java.util.Scanner;

public class Main {

    public static String calc(String input) throws Exception {
        OperationType operationType;
        int number1;
        int number2;

        if (input.contains("+")) {
            operationType = OperationType.ADDITION;
        } else if (input.contains("-")) {
            operationType = OperationType.SUBTRACTION;
        } else if (input.contains("*")) {
            operationType = OperationType.MULTIPLYING;
        } else if (input.contains("/")) {
            operationType = OperationType.DIVISION;
        } else {
            throw new Exception("Строка не является математической операцией");
        }

        int index = input.indexOf(operationType.value);

        String firstElementString = input.substring(0, index).trim();

        String secondElementString = input.substring(index + 1).trim();

        number1 = Integer.parseInt(firstElementString);
        number2 = Integer.parseInt(secondElementString);

        if (number1 < 1 || number1 > 10 || (number2 < 1 | number2 > 10)) {
            throw new Exception("Число должно быть >1 или <=10");
        }

        if (operationType == OperationType.ADDITION) {
            return String.valueOf(number1 + number2);
        } else if (operationType == OperationType.SUBTRACTION) {
            return String.valueOf(number1 - number2);
        } else if (operationType == OperationType.MULTIPLYING) {
            return String.valueOf(number1 * number2);
        } else {
            return String.valueOf(number1 / number2);
        }
    }

    public static void main(String[] args) throws Exception {
        while (true) {
            try {
                System.out.print("Введите арифметическую операцию");
                Scanner consoleInput = new Scanner(System.in);
                String expression = consoleInput.nextLine();
                if (expression.equalsIgnoreCase("STOP")) {
                    return;
                }
                System.out.println(calc(expression));
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
        }
    }
}