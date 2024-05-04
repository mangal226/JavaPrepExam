package src.datatypes.operators;

public class OperatorsAndMathAPIs {

    public static void main(String [] args){

        int myInt = 2;
        int int1 = ++myInt;
        int int2 = --myInt;

        Integer integerAuto = myInt;

        int intUn = integerAuto;

        Boolean isInteger = integerAuto.getClass().getName().equals("java.lang.Integer");

        double myDouble = 2.0;

        int myInteger = 2;

        Boolean equalsNumberOne = myDouble == myInteger;

        int numberOne = 2;

        int numberTwo = 5;

        /**
         * Difference between && and & : && don't take time to check the other side if the first side
         * permit to give the answer i.e a>b && a>c if a<b it return false don't need to
         * check the second operation. It is more faster and avoid wasting time
         * The same for | and ||
         */
        Boolean isOrOK = numberOne >= 2 || numberTwo >= 5;

        Boolean isAndOK = numberOne >= 2 && numberTwo > 5;

        Boolean isOrxOK = numberOne>=2 ^ numberTwo>5 ? true: false;

        Boolean isNotOK = !(numberOne>2 && numberTwo>5) ? true: false;


        //Does not exist in java
        // Boolean equalsNumberTwo = ( numberOne === numberTwo);
        /**
         * Other operators
         * &=, ^=, |=, <<=, >>= , >>>=
         */

        /**
         * Assignment operators
         * *=, /=, %=
         */

        /**
         * Relationnal operators
         * instanceof, <, >, <=, >=
         */

        /**
         * Custom wrappers
         */


        //System.out.println(integerAuto.getClass().getName());

        String result = String.valueOf(int1>=int2 ?  "The maximum number is number one : " + int1 : "The maximum number is number two : " + int2);

        System.out.println("Preunrary operator : " + (++myInt));

        System.out.println("Postunary operator : " + (myInt++));

        System.out.println("The maximum number using ternary : " + result);

        System.out.println("Autoboxing : " + integerAuto);

        System.out.println("Unboxing : " + intUn);

        System.out.println("Verify if integer : " + isInteger);

        System.out.println("Does two numbers equals even if there a different types : " + equalsNumberOne);

        System.out.println("IsOrOk : " + isOrOK);

        System.out.println("IsAndOK : " + isAndOK);

        System.out.println("IsOrxOK : " + isOrxOK);

        System.out.println("IsNotOK : " + isNotOK);


    }
}
