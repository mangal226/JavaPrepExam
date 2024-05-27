package src.ooa;

import java.io.IOException;
import java.util.Arrays;

public class ClassesAndObjects implements MyInterface{
    public static void main(String[] args){
        MyFirstClass[] humans = {new MyFirstClass(45,"Hamouda", "Sandid",  true), new MyFirstClass(30,"Halima", "Bourgiba",  false),
                new MyFirstClass(25,"Stephane", "Maguire",  true), new MyFirstClass(25,"Stefy", "Delacour",  false) };
        Arrays.stream(humans).forEach(human -> {
            System.out.println("We are on the thread : " + Thread.currentThread().getId());
            human.printUser();
        });
    }

    @Override
    public void setLanguage() {

    }

    @Override
    public void setCareer() {

    }

    @Override
    public void greetings() {
        MyInterface.super.greetings();
    }

    @Override
    public void currentThread() {
        MyInterface.super.currentThread();
    }
}

class MyFirstClass implements MyInterface{
    int age;
    String firstName;
    String lastName;

    boolean isMan;

    MyInterface myInterface;



    public MyFirstClass(int age){this.age = age;}

    /**
     * We can use two differents constructors when the second is an extension of the first
     * @param age
     * @param prenom
     * @param nom
     * @param estMasculin
     */

    /**
     * difference between static and non static. Static is used to initialize static fiels and non
     * static to initialize instance fields
     */
    public MyFirstClass(int age, String prenom, String nom,  boolean estMasculin){
        this(age);
        this.firstName = prenom;
        this.lastName = nom;
        this.isMan = estMasculin;
    }


    /**
     * Object are destroyed with garbage collector there are automatically deleted
     * GC find the unreferenced objects and delete them
     * Packages are used to
     */

    @Override
    public String toString() {
        return this.toString();
    }

    public void printUser(){
        System.out.printf("The person firstname is : %s, his lastname is  %s, his age is  %s, is he/she masculine %s", this.firstName, this.lastName, this.age, this.isMan);
    }
    public void definePerson() {};
    public void makeCall(){};

    @Override
    public void setLanguage() {

    }

    @Override
    public void setCareer() {

    }

    @Override
    public void greetings() {
        MyInterface.super.greetings();
    }

    @Override
    public void currentThread() {
        MyInterface.super.currentThread();
    }

}
