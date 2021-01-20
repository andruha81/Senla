package eu.senla.task2.entity;

public class Rainbow {

    private static final int RED = 1;
    private static final int ORANGE = 2;
    private static final int YELLOW = 3;
    private static final int GREEN = 4;
    private static final int BLUE = 5;
    private static final int PURPLE = 6;


    private String getColor(int numberColor, int halfColor) {
        String returnColor;

        switch (numberColor) {
            case RED:
                returnColor = halfColor == 0 ? "Красный" : "Красно-";
                break;
            case ORANGE:
                returnColor = halfColor == 0 ? "Оранжевый" : "Оранжево-";
                break;
            case YELLOW:
                returnColor = halfColor == 0 ? "Желтый" : "Желто-";
                break;
            case GREEN:
                returnColor = halfColor == 0 ? "Зеленый" : "Зелено-";
                break;
            case BLUE:
                returnColor = halfColor == 0 ? "Синий" : "Сине-";
                break;
            case PURPLE:
                returnColor = halfColor == 0 ? "Фиолетовый" : "Фиолетово-";
                break;
            default:
                returnColor = halfColor == 0 ? "Безцветный" : "Безцветно-";
        }

        return returnColor;
    }

    public void printColor(int numberFirstColor, int numberSecondColor) {
        System.out.println(getColor(numberFirstColor,1) + getColor(numberSecondColor,0));
    }

    public void printColor(int numberColor) {
        System.out.println(getColor(numberColor,0));
    }
}
