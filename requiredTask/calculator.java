package requiredTask;

import java.util.logging.*;
import java.util.Scanner;

public class calculator {
    static Logger logger = Logger.getLogger(calculator.class.getName());
    public static void main(String[] args) {
        try {
            FileHandler fh = new FileHandler("requiredTask/logCalculator.txt",true);
            logger.addHandler(fh);
            SimpleFormatter sFormat = new SimpleFormatter();
            fh.setFormatter(sFormat);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Для выхода наберите - s");
        char signUser = 'b';
        Scanner input = new Scanner(System.in);
        while (signUser != 's') {
            double numberUser01 = getNumberUser(input);
            logger.log(Level.INFO, Double.toString(numberUser01));
            double numberUser02 = getNumberUser(input);
            logger.log(Level.INFO, Double.toString(numberUser02));
            signUser = getSignUser(input);
            logger.log(Level.INFO, String.valueOf(signUser));
            double totalUser = getSolution(numberUser01, numberUser02, signUser);
            System.out.print("Итого: ");
            System.out.println(totalUser);
            logger.log(Level.INFO, Double.toString(totalUser));
        }
        input.close();
    }

    public static double getNumberUser(Scanner input) {
        System.out.print("Введите число: ");
        if (input.hasNextDouble()) {
            double num = input.nextDouble();
            return num;
        }
        else {
            System.out.println("Ошибка ввода. Не является числом!");
            return 0;
        }
    }

    public static char getSignUser(Scanner input) {
        System.out.print("Введите знак математического действия: ");
        if (input.hasNext()) {
            char sign = input.next().charAt(0);
        if (sign == '*' || sign == '/' || sign == '+' || sign == '-' || sign == 's') {
            return sign;
            } else {
                System.out.println("Ошибка ввода. Такой операции нет");
                return 'b';
            }
        }
        return 'b';
    }

    public static Double getSolution(Double number01, Double number02, char sign) {
        Double total = 0.0;
        switch (sign) {
            case '*':
                total = number01 * number02;
                break;
            case '/':
                total = number01 / number02;
                break;
            case '+':
                total = number01 + number02;
                break;
            case '-':
                total = number01 - number02;
                break;
        }
        return total;
    }
}
