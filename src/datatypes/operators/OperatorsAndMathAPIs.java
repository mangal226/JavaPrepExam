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

        int numberTwo = 2;

        //Does not exist in java
        // Boolean equalsNumberTwo = ( numberOne === numberTwo);

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


    }
}
