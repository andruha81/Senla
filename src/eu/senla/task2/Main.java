package eu.senla.task2;

import eu.senla.task2.entity.Rainbow;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Rainbow rainbow = new Rainbow();
        Scanner scanner = new Scanner(System.in);
        int colorBegin = 1;
        int colorEnd = 6;
        int numberFirstColor;
        int numberSecondColor;

        System.out.printf("Введите число для выбора цвета из дипазона от %s до %s: ", colorBegin, colorEnd);

        numberFirstColor = scanner.nextInt();

        if (numberFirstColor >= colorBegin && numberFirstColor <= colorEnd) {
            System.out.printf("Для полуцвета можно ввести число для выбора второго цвета" +
                    " из дипазона от 1 до 6, за исключением %s, или любое другое число для полного цвета: ", numberFirstColor);

            numberSecondColor = scanner.nextInt();

            if (numberSecondColor >= colorBegin && numberSecondColor <= colorEnd && numberSecondColor != numberFirstColor) {
                rainbow.printColor(numberFirstColor, numberSecondColor);
            } else {
                rainbow.printColor(numberFirstColor);
            }

        } else {
            System.out.printf("Введенное число %s не попадает в заданный диапазон от %s до %s", numberFirstColor, colorBegin, colorEnd);
        }
    }
}
