package requiredTask;

import java.util.Scanner;
// import java.io.IOException;
import java.util.Arrays;
import java.util.logging.*;

public class sortBubble {
    static Logger logger = Logger.getLogger(sortBubble.class.getName());
    public static void main(String[] args) {
        try {
            FileHandler fh = new FileHandler("requiredTask/logSortBubble.txt", true);
            logger.addHandler(fh);
            SimpleFormatter sFormat = new SimpleFormatter();
            fh.setFormatter(sFormat);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int lenArrUser = lenArr();
        int[] arrUser = newArr(lenArrUser);
        sortArr(arrUser);
    }

    public static int lenArr() {
        while (true) {
            try {
                System.out.println("");
                System.out.print("Введите натуральное число (длину массива): ");
                Scanner input = new Scanner(System.in);
                int num = input.nextInt();
                input.close();
                return num;
            } catch (Exception ex) {
                System.out.println("Ошибка ввода.");
            }
        }
    }

    public static int[] newArr(int nums) {
        int[] userArr = new int[nums];
        for (int j = 0; j < nums; j++) {
            userArr[j] = (int) (Math.random() * 101);
        }
        System.out.println("Получили числовой массив из " + nums + " элементов:");
        System.out.println(Arrays.toString(userArr));
        System.out.println("");
        return userArr;
    }

    public static void sortArr(int[] args) {
        boolean sorted = false;
        int interim;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < args.length - 1; i++) {
                if (args[i] > args[i + 1]) {
                    sorted = false;
                    interim = args[i];
                    args[i] = args[i + 1];
                    args[i + 1] = interim;
                }
            }
            logger.log(Level.INFO, Arrays.toString(args));
        }
        System.out.println("");
        System.out.println("Результат сортировки пузырьком числового массива:");
        System.out.println(Arrays.toString(args));
        System.out.println("");
    }
}