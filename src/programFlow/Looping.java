package src.programFlow;

import java.util.Arrays;

public class Looping {

    public static void main(String[] args){
        whileLoopDays();
        whileLoopFactorial(10);
        forLoop();
        factorialWithForLoop(5);
        /**
         * Limitations of foreach
         * we can't work with two arrays together
         */

        int[] array1 = {1, 2, 3, 4};
        int[] array2 = {5, 6, 7, 8};
        sumOfArraysWithForLoop(array1,array2);
        nestingForLoop(array1);
        nestingForLoop(array2);

        int[][] doubleArray = {{1, 2}, {2, 3}, {4, 5}, {6, 7}, {8, 9}};
        nestedForLoop(doubleArray);

        int[][][] tripleArray = new int[2][8][11];
        System.out.println(tripleArray.length);

        loopPowerNotEvenContinue(10);
        System.out.println("Before function call");
        loopPowerNotEvenReturn(100);
        System.out.println("After function call");
    }

    private static void whileLoopDays(){
        enum days {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY};

        days [] values = days.values();
        int i = 0;
        while (i < values.length){
            System.out.println("The day printed is : " + values[i]);
            i++;
        }
    }

    private static void whileLoopFactorial(int number){
        int fact = 1;
        if (number == 0) fact = 1;
        if (number == 1) fact = 1;
        if(number<0) fact = -1;
        if (number> 1){
            int i = 1;
            do{
                fact = fact * i;
                i++;
            }while (i <=number);
        }

        System.out.println(fact);

    }

    private static void forLoop(){
        enum letters {A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z };
        letters[] table = letters.values();
        for(int i=0; i<table.length; i++)
                System.out.println("Printing the letter : " + table[i]);
        Arrays.stream(table).toList()
                .forEach(letter -> System.out.println("Printing the letter with stream : " + letter));

        for(letters letter : table){
            System.out.println("Printing letter with foreach : " + letter);
        }
    }

    private static void factorialWithForLoop(int number){
        int factorial = 1;
        if(number> 1) for(int i= 1; i<= number; i++) factorial = factorial*i;
        else if (number == 0 ) factorial =1;
        else if (number == 1) factorial = 1;
        else factorial = -1;

        System.out.println(factorial);
    }

    private static void sumOfArraysWithForLoop(int [] arrayOne, int[] arrayTwo){
        int[] sumReverseArray = new int[arrayTwo.length];
        for(int i=0, j= arrayTwo.length-1; i< arrayTwo.length; i++,j--)
            sumReverseArray[i]=arrayOne[i] + arrayTwo[j];

        System.out.println("The sum of reverse array is : ");
        for(int sum : sumReverseArray)
                System.out.println("The sum for this index is : " + sum);

    }

    /**
     * Nesting ps: using if-else in loop or vice-versa
     */
    private static void nestingForLoop(int[] array){
        int sumOfEven = 0;
        int sumOfOdd = 0;
        for(int number : array)
            if(number%2 == 0)
                sumOfEven += number;
            else sumOfOdd += number;

        System.out.println("Sum of even numbers : " + sumOfEven);
        System.out.println("Sum of odd numbers : " + sumOfOdd);
    }

    private static void nestedForLoop(int[][] array){
        System.out.println(array.length);
        for(int i=0; i< array.length; i++){
            for (int j=0; j<array[i].length; j++)
                System.out.println("We are at the line : " +i+ ", column : " +j);
        }
    }

    private static void loopPowerNotEvenContinue(int number){
        int sumOfPow = 1;
        int i =0;
        while (i<number){
            i++;
            System.out.println("The number is : " + i);
            if(i%2==0) sumOfPow += i*i;
            else continue;
            System.out.println("The sum for " + i + " is : " + sumOfPow);
            if(sumOfPow > 50) break;

        }
        System.out.println("The sum of power is : " + sumOfPow);
    }

    /**
     *
     * Difference between return and break:
     * return exit the function
     * break quit the looping process and continue the function
     */
    private static void loopPowerNotEvenReturn(int number){
        int sumOfPow = 1;
        int i =0;
        while (i<number){
            i++;
            System.out.println("The number is : " + i);
            if(i%2==0) sumOfPow += i*i;
            else continue;
            System.out.println("The sum for " + i + " is : " + sumOfPow);
            if(sumOfPow > 100) return;

        }
        System.out.println("The sum of power is : " + sumOfPow);
    }
}
