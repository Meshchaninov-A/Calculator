import java.util.Scanner;

/**
 * Проект "Калькулятор"
 *
 * @author Meshchaninov
 * @version 1.0.0
 */
public class Calculator {
    private int operandFirst;
    private int operandSecond;
    private boolean isResetNeeded = true;

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println("Добро пожаловать в калькулятор.");
        calculator.run();
        System.out.println("Завершение работы программы.");
    }

    /**
     * Метод по запуску калькулятора
     */
    private void run() {
        char operation;
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                if (isResetNeeded) {
                    System.out.print("Введите первое значение: ");
                    operandFirst = Integer.parseInt(scanner.nextLine());
                } else {
                    System.out.println("Значение первого операнда : " + operandFirst);
                }
                System.out.print("Введите тип операции (доступные операции: -, +, *, /) :");
                operation = scanner.nextLine().charAt(0);
                if (operation == 'C' || operation == 'c') {
                    resetOperands();
                } else if (operation == 's' || operation == 'S') {
                    break;
                } else {
                    System.out.print("Введите второе значение: ");
                    operandSecond = Integer.parseInt(scanner.nextLine());
                    doOperation(operation);
                    System.out.println("Результат выполнения операции: " + operandFirst);
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Неверное значение операнда!");
            } catch (ArithmeticException e) {
                System.out.println("Арифметическая ошибка: " + e.getMessage() + " !!!");
            }
        } while (true);
    }

    /**
     * Обработка заданного типа операции
     *
     * @param operation тип операции в char
     */
    private void doOperation(char operation) {
        switch (operation) {
            case ('+'):
                operandFirst += operandSecond;
                break;
            case ('-'):
                operandFirst -= operandSecond;
                break;
            case ('/'):
                operandFirst /= operandSecond;
                break;
            case ('*'):
                operandFirst *= operandSecond;
                break;
            default:
                System.out.println("Неизвестная операция");
        }
        isResetNeeded = false;
    }

    /**
     * Сброс значений операндов
     */
    private void resetOperands() {
        operandFirst = 0;
        operandSecond = 0;
        isResetNeeded = true;
    }

}
