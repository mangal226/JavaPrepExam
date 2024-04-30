package src.datatypes.variables;

public class Variables {

    public static void main(String [] args){
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
}
