package src.ooa;

public class AnonymousClass {


    /**
     * An anonymous class is like defining a constructor excepted that there are the definition
     * of the class inside
     * Anonymous classes are defined by interfaces
     * An anonymous class can access all the methods and variables of its enclosing class
     * In addition it can access the local variables specified in the scope but these
     * need to be final or effectively final
     * Anonymous classes can access the method parameters if these are defined with method
     * It can not have constructor
     * It can have extra methods
     * */
    public static void callAnonymous(){
        InterfaceForAnonymous ia = new InterfaceForAnonymous() {
            @Override
            public boolean convertUnits() {
                System.out.println("Inside Unit Converts");
                return false;
            }

            public void sayHello(){
                System.out.println("Hello world");
            }
        };



        System.out.println(ia.convertUnits());

    }


    public static void main(String[] args){
        callAnonymous();

    }
}
