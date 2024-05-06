package src.datatypes.variables;

import java.util.Random;

public class Variables {
    /**
     *
     * field variables : in the class, they can be static
     * they are not necessarily initialised
     * the local variables need to be initialised before being used
     * primitives are : int, long, double, float they are necessary initialised before being used
     * references are : String they don't need to be initialised before being used
     */
    int myClassInt = 23;
    String myClassString = "Hello world";

    static Boolean myStaticClassBoolean;

    /**
     *
     * static initializer are not members as well as contructors
     * field variable are members even those marked with static
     * static { static initialize; not member}
     * { instance initializer not member}
     * public MemberAndScope not member
     */

    /**
     *
     * Variable scope
     *
     */
    private int i; // accessible only in the class
    int j ; // only accessible in the class and the same package it is call package private
    protected int k; // acessible in the class subclass and package
    public int l; // acessible in the class, subclass, package and module;


    /**
     * Variable naming rule
     * [A-Za-z0-9]
     * $ and _ can be used to
     */

    /**
    *type inference
     * when a var is used it has to be initialised and when initialised it can't be changed
     */
    int x = 1;
    //var y = 2; --> why does the compiler doesn't retrieve it
    //var z = 3.14f;




    /**
     *
     * @param args
     */
    public static void main(String [] args){
        /*ù
        / local variable in main
         */
        int myInt = 2;

        String myString = "Hello";

        System.out.println("The content of the variable myString main before calling the function is : " + myString);

        System.out.println("The content of the variable myInt main before calling the function is : " + myInt);

        myFunction(myString, myInt);

        System.out.println("The content of the variable myString main after calling the function is : " + myString);

        System.out.println("The content of the variable myInt main after calling the function is : " + myInt);



    }

    public static void myFunction(String content, int intNumber){
        System.out.println("Inside the function");

        content = "Changed";

        ++intNumber;

        System.out.println("The content of the variable inside the function is : " + content);

        System.out.println("The content of the int variable inside the function is : " + intNumber);
    }

    public static  void myFunctionTwo(){
        Random random = new Random();
        Boolean randomValue = random.nextBoolean();
        long variable_x;

        if(randomValue) variable_x = 100L;
        else variable_x = -100L;
        System.out.println(variable_x);
    }

    /**
     * varagrs presentation
     */
    public static void myFunctionThree(int ... nums){

    }

    public static void myFunctionFour(String ... strings){

    }

    public static void myFunctionFive(Boolean ... booleans){

    }

    public static void myFunctionSix(String[] args){

    }
}
