package src.src.preparationNotes;

import java.util.ArrayList;
import java.util.List;

public class Exam2Exercises {

    public static void main(String[] args){

        /**
         * Question 1: Using enum
         * Expected : Hello is printed 3 times (thrice)
         * Result : hello is printed once
         * Explication : enum is a class and Flags is the constructor so it is only called once
         */
        enum Flags{TRUE;
        Flags(){System.out.println("Hello");}}

        Flags f1 = Flags.TRUE;
        Flags f2 = Flags.TRUE;
        Flags f3 = Flags.TRUE;

        /**
         * Question 2 : expected output for rectangle class
         * Expected answer compilation error: we can not have a private variable into a public class or method
         */
        /*private int i = 200;
        private int j = 100;
        Rectangle rectangle = new Rectangle(i,j);
        System.out.println(rectangle.getHeight()+","+ rectangle.getWidth());*/

        /**
         * Question 3 which can be used as constructor:
         * public Planet(String str){};
         */

        /**
         * Question 4: which of the access modifier can be used for a top level interface
         * protected
         */

        /**
         * Question 5 : Does modular JDK improves performance and security: YES
         */

        /**
         * Question 6 : Expected result for grade
         * Compilation error : we can not have operators 50 <= score < 60 it is 50 <= score && score < 60
         */
        var score = 30;
        var grade = 'F';
        //if(50 <= score < 60) grade = 'D';

        /**
         * Question 7 : manipulating list
         * expected result 2, 1 : yes it is true
         */
        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(1);
        list.add(0);
        list.remove(list.indexOf(0));

        System.out.println(list);

        /**
         * Question 8 : access modifiers for class Food
         * Expected answer : make the getCalories method of Food class public
         * Result : make the getCalories of JunkFood class public
         */

        /**
         * Question 9 : printing "A", "B", "C"
         * Expected result : Only the third and it is true
         */
        //System.out.println(""""A",\"B",\"C".\""");
        //System.out.println("""\"A\",\"B\",\"C\".\""");
        System.out.println(String.join(",", "\"A\"","\"B\"","\"C\"") + ".");


    }

    public static class Rectangle{
        private int height;
        private int width;

        public Rectangle(int height, int width){
            this.height = height;
            this.width = width;
        }

        public int getHeight(){
            return this.height;
        }

        public int getWidth(){
            return this.width;
        }
    }

    public class Planet{
        public Planet(String str){};
    }

    abstract class Food{
        protected abstract double getCalories();
    }

    class JunkFood extends Food{

        public double getCalories() {
            return 200.0;
        }
    }

}
