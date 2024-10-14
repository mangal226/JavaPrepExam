package src.src.preparationNotes;

import java.io.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class Exam1Exercises {

    public static void main(String [] args){

        // Question 1 : testing strings
        String s1 = "Hello world";
        String s2 = "Hello world";

        // best option replace s1 and s2 with string s1 = "Hello world" and s2 = "Hello world"
        System.out.println(s2 == s1); // true the response is correct

        // Question 2
        Student.test();

        // Question 3 result is expected to be 1000
        /**
         * Result is 1999 because it has been instantiated a second time
         */
        Base base = new Derived();

        // Question 4 serialize
        // result expected null, 0, null
        // result is runtime exception i.e. no valid constructor why?
        //SubStudent.testSubStudent();

        /**
         * Question 5
         * result is expected to be 200
         * Result is 300 i.e. it has taken the num of the first i.e. even we don't have getter and setter
         * this because we are in there
          */
        M.testMN();

        /**
         * Question 6
         * expected result equal 12
         * result is not equal 12 : explanation we have the first number 10(num ++) and the
         * second number 11(num ++) but int the system.out.printn we have the 12 number because
         * the affectation is done
         */
        int num = 10;
        if(num++ == num++){
            System.out.println("EQUAL " + num);
        }else System.out.println("NOT EQUAL " + num);

        /**
         * Question 7 : what is the output for jdbc
         * result expected one line is added in the database for user with the values specified
         */
        Database.test();

    }

    static class Student{
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        protected String name;
        protected int age;

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        public boolean equals(Object o){
            if(o instanceof Student){
                Student newStud = (Student) o;
                return this.name.equals(newStud.name) && this.age == newStud.age;
            }
            return false;

        }

        Student(String name, int age){
            this.age = age;
            this.name = name;
        }

        public static void test(){
            Set<Student> students = new HashSet<>();
            students.add(new Student("Harry", 25));
            students.add(new Student("Harry", 25));
            students.add(new Student("Hamouda", 29));

            System.out.println(students.size()); // size is 2
            /**
             * Result is 3 but why?
             */
        }

    }

    static class M{
        int num = 100;

        static class N{
            int num2 = 200;
        }

        public static void testMN(){
            M m = new M();
            M.N n = new N();

            System.out.println(m.num + n.num2);
        }
    }

    static class Base{
        int id = 1000;

        Base(){
            Base();
        }

        void Base(){
            System.out.println(++id);
        }
    }

    static class Derived extends Base{
        int id = 2000;
        Derived(){
            Derived();
        }

        void Derived(){
            System.out.println(--id);
        }
    }

    static class SubStudent extends Student implements Serializable{
        String course;

        public String getCourse() {
            return course;
        }

        public SubStudent(String name, int age, String course){
            super(name, age);
            this.course = course;
        }

        public static void testSubStudent(){
            var stud = new SubStudent("Hamouda", 45, "Cloud Engineer");
            try (var oos = new ObjectOutputStream(new FileOutputStream("stud.ser")); var ois = new ObjectInputStream(new FileInputStream("stud.ser"));){
                oos.writeObject(stud);
                var s = (SubStudent) ois.readObject();
                System.out.printf("%s, %d, %s", s.getName(), s.getAge(), s.getCourse());
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }


        }


    }

    public static class Database{
        public static void test(){
            var url = "jdbc:mysql://localhost:3306/sakila";
            var user = "root";
            var password = "root";
            var query = "INSERT INTO ACTOR VALUES (?, ?, ?, ?)";
            try (var con = DriverManager.getConnection(url, user, password); var ps = con.prepareStatement(query);){
                ps.setInt(1, 101);
                ps.setString(2, "DAMNAR");
                ps.setString(3, "Hamouda");
                ps.setString(4, LocalDateTime.now().toString());
                ps.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }



}