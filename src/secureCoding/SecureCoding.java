package src.secureCoding;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Pattern;

public class SecureCoding {
    /**
     * How to prevent from a class to be extended :
     * --> Make it final
     * --> Make the constructor private
     * We can all put the method final or the variable
     */

    /**
     * To verify immutability
     * --> Set the collection with element before the begining
     * --> Verify if we add element that the element is not added
     */

    /**
     *
     * Use of iterator to only show the next element of a list without offering the opportunity to modify it
     * Use of clonable to clone object and its attributes: clonable copies the object and all what has been done even if the add elements later
     * If we want to make sure that the element copied is only the first object we have to modify clone to clone the constructor
     */

    /**
     * Interface serializable breaks encapsulation by bypassing the constructor
     */

    /**
     *
     * @param args
     */


    public static void main(String[] args) throws IOException {
        Person person = new Person("Ali", "45", Arrays.asList("green", "yellow"));
        person.shirts.add("orange");
        System.out.println(person.toString());
        Iterator<String> listOfColor = person.getShirts();
        while (listOfColor.hasNext()) {
            System.out.println(listOfColor.next());
        }
        // verify encapsulation
        person.testEncapsulationSerializable();

    }

    static class Person implements Cloneable, Serializable{
         private String name;
         private String age;
         private final Pattern ALLOWLIST = Pattern.compile("[A-Za-z0-9'\\-]+");
         private  Collection<String> shirts;

         Person(String name, String age, Collection<String> shirts){
             this.name = name;
             this.age = age;
             this.shirts = new ArrayList<>(shirts);
             if(Integer.parseInt(age)< 13) throw new IllegalArgumentException("Error in the age, it has to be highter than 13");
             if(Integer.parseInt(age) > 120) throw new IllegalArgumentException("Error in the age it has to be lower than 120");
             if(!ALLOWLIST.matcher(name).matches()) throw new IllegalArgumentException("The name does not match the pattern");
             //this.shirts.add("orange");

        }
        Person(String name, String age){
            this.name = name;
            this.age = age;
            if(Integer.parseInt(age)< 13) throw new IllegalArgumentException("Error in the age, it has to be highter than 13");
            if(Integer.parseInt(age) > 120) throw new IllegalArgumentException("Error in the age it has to be lower than 120");
            if(!ALLOWLIST.matcher(name).matches()) throw new IllegalArgumentException("The name does not match the pattern");
            //this.shirts.add("orange");
        }

        public Person clone() throws CloneNotSupportedException {

             //return (Person) super.clone();
            // if we want to clone all the object and make it immutable we need to use the second method to clone
             return new Person(this.name, this.age, this.shirts);
        }

        void testEncapsulationSerializable() throws IOException {
             Person a = new Person("zoubeida", "45");
             ByteArrayOutputStream baos = new ByteArrayOutputStream();
             try (ObjectOutputStream oos = new ObjectOutputStream(baos)){
                oos.writeObject(a);
             }
             byte[] bytes = baos.toByteArray();
             bytes[237] = 12;
             try (ObjectInputStream ois = new ObjectInputStream( new ByteArrayInputStream(bytes))){
                Person b = (Person) ois.readObject();
                System.out.println(a);
                System.out.println(b);
             } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
             }
        }
        Iterator<String> getShirts(){
             return this.shirts.iterator();
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age='" + age + '\'' +
                    ", shirts=" + shirts +
                    '}';
        }
    }

}
