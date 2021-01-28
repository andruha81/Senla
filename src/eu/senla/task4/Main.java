package eu.senla.task4;

public class Main {

    private static final String ABC = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqtstuvwxyz";

    public static void main(String[] args) {

        int arrayLength = 10;
        int numberArrayIndex = 0;
        double doubleFromString;
        boolean compareDiagonals = true;
        String[][] mainArray = new String[arrayLength][arrayLength];
        String[] diagArray = new String[arrayLength * 2];
        int[] numberArray = new int[arrayLength * 2];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < mainArray.length; i++) {
            for (int j = 0; j < mainArray[i].length; j++) {
                if (j % 3 == 0) {
                    mainArray[i][j] = String.valueOf(Math.random() * 10 + 1).substring(0, 6);
                } else {
                    mainArray[i][j] = createString();
                }
            }
        }

        System.out.println("Main array:");
        for (String[] lines : mainArray) {
            for (String str : lines) {
                System.out.print(str + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < arrayLength; i++) {
            if (!mainArray[i][i].equals(mainArray[i][arrayLength - 1 - i])) {
                compareDiagonals = false;
            }
            diagArray[i] = mainArray[i][i];
            diagArray[i + arrayLength] = mainArray[i][arrayLength - 1 - i];
        }

        System.out.println(compareDiagonals ? "Diagonals are equal" : "Diagonals aren't equal");

        for (String stringDiag : diagArray) {
            if (stringDiag.matches("\\d+\\.\\d+")) {
                doubleFromString = Double.parseDouble(stringDiag);
                if ((doubleFromString * 10) % 10 >= 7) {
                    numberArray[numberArrayIndex] = (int) Math.ceil(doubleFromString);
                } else {
                    numberArray[numberArrayIndex] = (int) Math.floor(doubleFromString);
                }
                numberArrayIndex++;
            } else {
                sb.append(stringDiag.substring(1, 4) + ",");
            }
        }

        System.out.printf("Symbols from string: %s%n", sb);

        System.out.print("Round numbers from string: ");
        for (int number : numberArray) {
            if (number != 0) {
                System.out.print(number + "_");
            }
        }
    }

    static String createString() {

        int numberOfSymbols = 6;
        String resultString = "";

        while (numberOfSymbols > 0) {
            resultString += ABC.charAt((int) (Math.random() * ABC.length()));
            numberOfSymbols--;
        }

        return resultString;
    }
}
