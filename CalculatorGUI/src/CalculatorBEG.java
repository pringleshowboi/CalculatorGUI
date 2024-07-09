import java.util.Scanner;

public class CalculatorBEG {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your first number: ");
        double num1 = scanner.nextDouble();

        System.out.println("Enter your operator (+ - / * %)");
        char operator = scanner.next().charAt(0);

        System.out.println("Enter your second number: ");
        double num2 = scanner.nextDouble();
        
        double result = 0;
        boolean validOperation = true;

        switch(operator){
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
                if (num2 != 0){
                    result = num1 / num2;
                } else {
                    System.out.println("Error: Division by 0!");
                    validOperation = false;
                }
                break;

            case '%':
                if (num2 != 0){
                    result = num1 % num2;
                } else {
                    System.out.println("Error: Division by 0!");
                    validOperation = false;
                }
                break;

            default:
                System.out.println("Error: Invalid operator!");
                validOperation = false;
                break;
        }

        if (validOperation) {
            System.out.println("The result is: " + result);
        }
        scanner.close();
    }
}

/*
import java.util.Scanner;

public class CalculatorBEG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculating = true;

        while (continueCalculating) {
            System.out.println("Enter your first number: ");
            double num1 = scanner.nextDouble();

            System.out.println("Enter your operator (+ - / * %)");
            char operator = scanner.next().charAt(0);

            System.out.println("Enter your second number: ");
            double num2 = scanner.nextDouble();

            double result = 0;
            boolean validOperation = true;

            switch (operator) {
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
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        System.out.println("Error: Division by 0!");
                        validOperation = false;
                    }
                    break;

                case '%':
                    if (num2 != 0) {
                        result = num1 % num2;
                    } else {
                        System.out.println("Error: Division by 0!");
                        validOperation = false;
                    }
                    break;

                default:
                    System.out.println("Error: Invalid operator!");
                    validOperation = false;
                    break;
            }

            if (validOperation) {
                System.out.println("The result is: " + result);
            }

            System.out.println("Do you want to perform another calculation? (yes/no)");
            String userResponse = scanner.next();
            if (!userResponse.equalsIgnoreCase("yes")) {
                continueCalculating = false;
            }
        }

        scanner.close();
    }
}

 */