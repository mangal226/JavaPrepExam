package src.ooa;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class StaticFieldsMethodsClasses {

    /**
     * static fields: class variables  go to see static fields in FlightPlan
     * they are not accessed with the keyword this we can use access modifiers with them to limit access to their values
     * static elements are usually called with the class name i.e. Thread.sleep(), StaticMethodsClasses.numberOfCalls, Math.max, Character.toUpperCase(), String.format() ...
     * instance method or instance variables are used to instanciate the class: theyr can access instance and non instance variables and method see line 19 when
     * we call non instance variable
     * non-instance class and variables can not access to instance variables and methods see line 41
     */

    private String className; // instance varia
    private static int numberOfCalls; // static field


    public StaticFieldsMethodsClasses(){
        this.className = StaticFieldsMethodsClasses.class.getName();
        numberOfCalls += 1; // no access modifier
    }

    /**
     * Static initializer
     */
    static {
        numberOfCalls = 10;
    }



    public static void main(String[] args){
        StaticFieldsMethodsClasses firstCall = new StaticFieldsMethodsClasses();
        System.out.println(StaticFieldsMethodsClasses.numberOfCalls);
        StaticFieldsMethodsClasses secondCall = new StaticFieldsMethodsClasses();
        System.out.println(numberOfCalls);
        StaticFieldsMethodsClasses.MyStaticClass.MySubclass mySubclass = new StaticFieldsMethodsClasses.MyStaticClass.MySubclass();
        System.out.println(mySubclass.className);
        System.out.println(mySubclass.id);
    }

    public static void sayHello(){
        System.out.println("Hell world");
        //className;
    }

    /**
     * Static nested class is a hight level class that has been nested in another top-level class for convenience
     * the static nested class can interract with the other classes that are static and non static instance member and non instance members
     */

    public static class  MyStaticClass{
        private LocalDateTime ldt;
        private String staticClassName;

        private String pckgName;

        private Class<?>[] classesNames;


        public MyStaticClass(){
            this.ldt = LocalDateTime.now();
            this.staticClassName = MyStaticClass.class.getCanonicalName();
            this.pckgName = MyStaticClass.class.getPackageName();
            this.classesNames = MyStaticClass.class.getClasses();
        }

        private static class MySubclass{
            private String id;
            private String className;

            public MySubclass(){
                this.id = String.valueOf(UUID.randomUUID());
                this.className = MySubclass.class.getName();
            }


        }
    }

    /**
     * Recap:
     * static members belong to the class not individual instances
     * static methods can not access instance members directly, only through an object reference
     * a static nested class is a normal class that has been declared inside a class for convenience
     */


    /**
     * abstract classes are used to create template for future classes, but let them provide the actual implementation
     * they permit to share functionality with future subclasses
     */
    public abstract class  Aircraft{

        private int altitude;

        public abstract void land();

        public abstract void takeoff();

        public int getAltitude(){
            return this.altitude;
        }

    }

    public class Helicopter extends Aircraft{

        @Override
        public void land() {

        }

        @Override
        public void takeoff() {

        }
    }

    public class Glider extends Aircraft{

        @Override
        public void land() {

        }

        @Override
        public void takeoff() {

        }
    }

}

