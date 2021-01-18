package eu.senla.task1;

public class Main {

    static byte aByte;
    static short aShort;
    static int anInt;
    static long aLong;
    static float aFloat;
    static double aDouble;
    static char aChar;
    static boolean aBoolean;
    static String firstString;
    static String secondString;
    static String thirdString;
    static Byte wrapByte;
    static Short wrapShort;
    static Integer wrapInt;
    static Long wrapLong;
    static Float wrapFloat;
    static Double wrapDouble;

    public static void main(String[] args) {

        byte localByte;
        short localShort;
        int localInt;
        long localLong;
        float localFLoat;
        double localDouble;
        char localChar;
        String localString;
        String localString2;
        boolean localBoolean;
        Byte wrapLocalByte;
        Short wrapLocalShort;
        Integer wrapLocalInt;
        Long wrapLocalLong;
        Float wrapLocalFloat;
        Double wrapLocalDouble;

        Number number = new Number();

        // show default values
        System.out.println("byte default value: " + number.getaByte());
        System.out.println("short default value: " + number.getaShort());
        System.out.println("int default value: " + number.getAnInt());
        System.out.println("long default value: " + number.getaLong());
        System.out.println("float default value: " + number.getaFloat());
        System.out.println("double default value: " + number.getaDouble());
        System.out.println("char default value: " + number.getaChar());
        System.out.println("boolean default value: " + number.isaBoolean());

        //byte
        number.setaByte((byte) 25);
        System.out.println("byte: " + number.getaByte());
        aByte = 5;
        System.out.println("byte: " + aByte);
        localByte = (byte) (aByte + number.getaByte());
        System.out.println("localByte: " + localByte);
        //localByte = 128;      error - byte max value is 127

        // short
        number.setaShort((short) 2647);
        System.out.println("short: " + number.getaShort());
        aShort = 5488;
        System.out.println("short: " + aShort);
        localShort = (short) (aShort + aByte);
        localShort = (short) (localShort + number.getaShort());
        System.out.println("local short: " + localShort);
        aByte = (byte) localShort;
        System.out.println("byte after casting local short: " + aByte);
        // aShort = 32768;      error - short max value is 32767

        // int
        number.setAnInt(2454545);
        System.out.println("int: " + number.getAnInt());
        number.setAnInt((int) 2454543445L);
        System.out.println("int: " + number.getAnInt());
        anInt = 1_000_000;
        System.out.println("int: " + anInt);
        localInt = anInt + number.getAnInt() + aByte + number.getaShort();
        System.out.println("local int: " + localInt);
        aByte = (byte) anInt;
        System.out.println("byte after casting int: " + aByte);
        aShort = (short) anInt;
        System.out.println("short after casting int: " + aShort);
        // anInt = 2147483648;      error - int max value is 2,147,483,647

        // long
        number.setaLong(5447);
        System.out.println("long: " + number.getaLong());
        number.setaLong(2454543445L);
        System.out.println("long: " + number.getaLong());
        aLong = 987456 + 5647896456L;
        System.out.println("long: " + aLong);
        localLong = aLong + aByte + localShort + number.getaLong();
        System.out.println("local long: " + localLong);
        aByte = (byte) localLong;
        System.out.println("byte after casting local long: " + aByte);
        aShort = (short) localLong;
        System.out.println("short after casting local long: " + aShort);
        anInt = (int) localLong;
        System.out.println("int after casting local long: " + anInt);

        // float
        number.setaFloat(44);
        System.out.println("float: " + number.getaFloat());
        number.setaFloat(4434.154F);
        System.out.println("float: " + number.getaFloat());
        aFloat = 99 + 54.8f;
        System.out.println("float: " + aFloat);
        localFLoat = aByte + aShort + aLong + number.getaFloat();
        System.out.println("local float: " + localFLoat);
        anInt = (int) aFloat;
        System.out.println("int after casting float: " + anInt);
        aLong = (long) localFLoat;
        System.out.println("long after casting local float: " + aLong);

        // double
        number.setaDouble(12);
        System.out.println("double: " + number.getaDouble());
        number.setaDouble(12.98);
        System.out.println("double: " + number.getaDouble());
        aDouble = 18.69 + 17 + number.getaDouble();
        System.out.println("double: " + aDouble);
        localDouble = aByte + localShort + aFloat + aDouble;
        System.out.println("local double: " + localDouble);
        localDouble = aDouble + 0.33;
        System.out.println("local double: " + localDouble);
        aFloat = (float) aDouble;
        System.out.println("float after casting double: " + aFloat);
        anInt = (int) aDouble;
        System.out.println("int after casting double: " + anInt);

        // char
        number.setaChar('s');
        System.out.println("char: " + number.getaChar());
        number.setaChar((char) 87);
        System.out.println("char: " + number.getaChar());
        number.setaChar('\u0045');
        System.out.println("char: " + number.getaChar());
        aChar = (char) (number.getaChar() + 10);
        System.out.println("char: " + aChar);
        localChar = (char) (aChar + aByte);
        System.out.println("local char: " + localChar);
        localChar = (char) (aChar + aFloat);
        System.out.println("local char: " + localChar);
        anInt = localChar;
        System.out.println("int: " + anInt);

        // boolean
        number.setaBoolean(true);
        System.out.println("boolean: " + number.isaBoolean());
        aBoolean = !number.isaBoolean();
        System.out.println("boolean: " + aBoolean);
        localBoolean = true;
        System.out.println(aBoolean != localBoolean);

        // String
        firstString = "string";
        secondString = "string";
        localString = new String("string");
        thirdString = localString;
        localString2 = secondString;
        System.out.println("first string: " + firstString);
        System.out.println("second string: " + secondString);
        System.out.println("third string: " + thirdString);
        System.out.println("local string: " + localString);
        System.out.println("local string 2: " + localString2);

        // comparing strings ==
        System.out.println(firstString == secondString);
        System.out.println(firstString == thirdString);
        System.out.println(firstString == localString);
        System.out.println(firstString == localString2);
        System.out.println(secondString == thirdString);
        System.out.println(secondString == localString);
        System.out.println(secondString == localString2);
        System.out.println(thirdString == localString);
        System.out.println(thirdString == localString2);
        System.out.println(localString == localString2);

        // comparing strings equals
        System.out.println(firstString.equals(secondString));
        System.out.println(firstString.equals(thirdString));
        System.out.println(firstString.equals(localString));
        System.out.println(firstString.equals(localString2));
        System.out.println(secondString.equals(thirdString));
        System.out.println(secondString.equals(localString));
        System.out.println(secondString.equals(localString2));
        System.out.println(thirdString.equals(localString));
        System.out.println(thirdString.equals(localString2));
        System.out.println(localString.equals(localString2));

        secondString = secondString + "2";
        System.out.println("second string: " + secondString);
        System.out.println(firstString.equals(secondString));
        thirdString = thirdString + aByte;
        System.out.println("third string: " + thirdString);
        localString = localString + aFloat;
        System.out.println("local string: " + localString);
        localString2 = localString2 + aBoolean;
        System.out.println("local string 2: " + localString2);

        firstString = "100";
        secondString = "54.98";
        thirdString = "true";

        // Byte
        wrapByte = Byte.parseByte(firstString);
        System.out.println("Byte: " + wrapByte);
        wrapLocalByte = (byte) (10 + wrapByte);
        System.out.println("local Byte: " + wrapLocalByte);
        wrapLocalByte = Byte.valueOf(firstString);
        System.out.println("local Byte: " + wrapLocalByte);
        wrapLocalByte = Byte.valueOf((byte) 10);    // not a good initialization
        System.out.println("local Byte: " + wrapLocalByte);
        wrapLocalByte = Byte.valueOf(wrapByte);     // not a good initialization
        System.out.println("local Byte: " + wrapLocalByte);

        // Short
        wrapShort = Short.parseShort(firstString);
        System.out.println("Short: " + wrapShort);
        wrapLocalShort = 58 + 44;
        System.out.println("local Short: " + wrapLocalShort);

        // Integer
        wrapInt = Integer.parseInt(firstString);
        System.out.println("Integer: " + wrapInt);
        wrapLocalInt = 87 + wrapInt;
        System.out.println("local Integer: " + wrapLocalInt);

        // Long
        wrapLong = Long.parseLong(firstString);
        System.out.println("Long: " + wrapLong);
        wrapLocalLong = wrapLong * anInt;
        System.out.println("local Long: " + wrapLocalLong);

        // Float
        wrapFloat = Float.parseFloat(secondString);
        System.out.println("Float: " + wrapFloat);
        wrapFloat = Float.parseFloat(firstString);
        System.out.println("Float: " + wrapFloat);
        wrapLocalFloat = 97.3f;
        System.out.println("local Float: " + wrapLocalFloat);
        wrapLocalFloat = 97.3f + wrapFloat;
        System.out.println("local Float: " + wrapLocalFloat);

        //Double
        wrapDouble = Double.parseDouble(secondString);
        System.out.println("Double: " + wrapDouble);
        wrapLocalDouble = Double.valueOf(aByte + aFloat);
        System.out.println("local Double: " + wrapLocalDouble);
    }
}
