package src.ooa;

public class ClassesAndObjects {
    public static void main(String[] args){
        MyFirstClass human = new MyFirstClass(45,"Hamouda", "Sandid",  true);
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

    @Override
    public String toString() {
        return this.toString();
    }

    public void definePerson() {};
    public void makeCall(){};
}
