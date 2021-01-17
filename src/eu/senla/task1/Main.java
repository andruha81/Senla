package eu.senla.task1;

public class Main {

    public static void main(String[] args) {

        Primitives prim = new Primitives();
        Wraps wraps = new Wraps();

        // show default values
        System.out.println("byte default value: " + prim.getaByte());
        System.out.println("short default value: " + prim.getaShort());
        System.out.println("int default value: " + prim.getAnInt());
        System.out.println("long default value: " + prim.getaLong());
        System.out.println("float default value: " + prim.getaFloat());
        System.out.println("double default value: " + prim.getaDouble());
        System.out.println("char default value: " + prim.getaChar());
        System.out.println("boolean default value: " + prim.isaBoolean());

        prim.setaByte((byte) 25);
        System.out.println("byte: " + prim.getaByte());
        prim.setaShort((short) 2647);
        System.out.println("short: " + prim.getaShort());
        prim.setAnInt(2454545);
        System.out.println("int: " + prim.getAnInt());
        prim.setAnInt((int) 2454543445L);
        System.out.println("int: " + prim.getAnInt());
        prim.setaLong(5447);
        System.out.println("long: " + prim.getaLong());
        prim.setaLong(2454543445L);
        System.out.println("long: " + prim.getaLong());
        prim.setaFloat(44);
        System.out.println("float: " + prim.getaFloat());
        prim.setaFloat(4434.154F);
        System.out.println("float: " + prim.getaFloat());
        prim.setaDouble(12);
        System.out.println("double: " + prim.getaDouble());
        prim.setaDouble(12.98);
        System.out.println("double: " + prim.getaDouble());
        prim.setaChar('s');
        System.out.println("char: " + prim.getaChar());
        prim.setaChar((char) 87);
        System.out.println("char: " + prim.getaChar());
        prim.setaChar('\u0045');
        System.out.println("char: " + prim.getaChar());
        prim.setaBoolean(true);
        System.out.println("boolean: " + prim.isaBoolean());

    }

}
