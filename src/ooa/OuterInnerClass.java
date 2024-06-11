package src.ooa;

import java.rmi.server.UID;
import java.util.UUID;

public class OuterInnerClass {

    private String ID;

    OuterInnerClass(){
        this.ID = UUID.randomUUID().toString();
    }

    private int createLocalClass(){
        /**
         * A local class can be utilized only in the the method where it has been declared
         * it is not available outside
         * A local class can access all the members of its enclosing class
         * In addition to that a local class can access the local variables defined in the
         * same scope; but these variables need to be final or effectively final
         * Local classes can access the method parameters if they are defined within a method
         * Difference between final and effectively final??
         * Local classes can not contain static members, except constants
         * You can not declare interfaces in a block just classes
         */
        class LocalClass{
           private String name;

           LocalClass(){
               this.name = LocalClass.class.getName();
           }
        }
        return 0;
    }

    class InnerClass{
        String name;

        /**
         * It has directly access to the outer object class fields and methods
         * Because it is associated with an instance of the enclosing class it can not
         * contain any static member
         * To instantiate an inner class you must first instantiate the outer class then
         * you can create an inner class object using the outer class object
         */
        InnerClass(){
            this.name = InnerClass.class.getName().toString();
        }
    }

    /**
     * To instantiate inner class we need to instantiate the outer class first
     * @param args
     */
    public static void main(String[] args){
        OuterInnerClass oiclass = new OuterInnerClass();
        InnerClass innerClass = oiclass.new InnerClass();
        System.out.println(innerClass.name);
        /**
         * LocalClass does not exist here
         */
    }
}
