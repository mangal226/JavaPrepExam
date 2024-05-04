package src.datatypes.primitives;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class PrimitiveTypesAndVariables {

    public static void main(String [] args){
        //System.out.println("Working with data types");
        boolean isOK = Boolean.parseBoolean("True");
        byte fd;
        short myShort = (short) 145555;
        int myInt = 1455564999;
        long myLong = 1555555555;
        String myString = "Teslicapota";
        char [] chars = myString.toCharArray();
        /**
        * underscore in numeric literals
        * widening narowing and casting
        * alternative number system
        *
        * */
        long mySecondLong = 1244_32765_27894236_56L;
        int myIntCasted = (short) mySecondLong;
        double myDouble = myIntCasted;
        float myFloatCasted =  (float) 145555;
        double myDoubleCasted = myFloatCasted;
        //long underScoreForbiden = _1243567897654567865L || 1243567897654567865_L || 1._243567897654567865L;
        /**
         * Using the base 10(arabic) base octal, base hexadecimal and base binary
         * we can also use underscore in theses system but not before or after the prefix
         */
        int myOctal = 01455;
        int myHexadecimal = 0x0064;
        int myBinary = 0b0011011111;

        /**
         * The ternary operator
         * unboxing and outboxing
         * type inference
         * varargs parameter
         * date and time
         */
        int int1 = 134;
        int int2 = 340;

        /**
         * Scientific notation
         */
        double lightSpeed = 5.88e12;
        float diameterHydr = 5.0e-8f;


        /**
         * Narrowing widenning and casting
         * PS: When narrowing it seems that the variable is casted
         */
        int myIntNumber = 56;
        short myShortFromInt = (short) myIntNumber;
        byte myByteFromShort = (byte) myShortFromInt;
        long myLongFromInt = myIntNumber;
        long myLongTwo = 456778;
        int myIntFromLong = (int) myLongTwo;
        long myLongValue = 9223372036854775807L;
        int myIntValueOverflow = (int) myLongValue;
        short myShortValueOverflow = (short) myIntValueOverflow;
        byte myByteValueOverflow = (byte) myShortValueOverflow;


        Date myDate = new Date();
        LocalDateTime myLocalDate = LocalDateTime.now();
        String formatOfDate = "dd MM yyyy hh:mm:ss";
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern(formatOfDate);
        String dateFormated = myLocalDate.format(formatter);



        System.out.println("Display using for loop");
        for(char charI : chars){
            System.out.println("The char is : " + charI);
        }

        System.out.println("Display the boolean value : " + isOK);

        System.out.println("My short : "+ myShort);

        System.out.println("My int : "+ myInt);

        System.out.println("My long : "+ myLong);

        System.out.println("My int casted from long :" + myIntCasted);

        System.out.println("My double from float : " + myDouble);

        System.out.println("My float casted from long : " + myFloatCasted);

        System.out.println("My double casted from myFloatCasted : " + myDoubleCasted);

        System.out.println("My octal : " + myOctal);

        System.out.println("My hexadecimal : " + myHexadecimal);

        System.out.println("My binary : " + myBinary);



        System.out.println("Printing the date : " + myDate);

        System.out.println("Date formated : " + dateFormated);

        System.out.println("Short from int : " + myShortFromInt);

        System.out.println("Byte from short : " + myByteFromShort);

        System.out.println("Int from long : " + myIntFromLong);

        System.out.println("Long from int : " + myLongFromInt);

        System.out.println("Int overflow value from long : " + myIntValueOverflow);

        System.out.println("Short overflow value from int : " + myShortValueOverflow);

        System.out.println("The light speed is : " + lightSpeed);

        System.out.println("The diameter of hydrogen is : " + diameterHydr);

    }
}
