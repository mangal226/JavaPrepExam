package src.programFlow;

import java.util.Arrays;

public class Looping {

    public static void main(String[] args){
        whileLoopDays();
        whileLoopFactorial(10);
        forLoop();

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
            System.out.println("Printing letter with element in for : " + letter);
        }
    }
}
