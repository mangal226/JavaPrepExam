package src.src.preparationNotes;

import javax.swing.text.StyledEditorKit;
import java.io.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
         * result observerd : runtime exception with a duplicate entry for the primary key
         */
        //Database.test();

        /**
         * Question 8 the output for the loop
         * expected result : 101
         */
        loop();

        /**
         * Question 9:
         * expected result The output should be 97
         * result is 97
         */
        testChar();

        /**
         * Functional interface
         * the line to add is Calculator.add(i,j);
         * it is the correct answer
         */
        FunctionalInterface.testOperator();

        /**
         * Question 11: which phase of software development is affected by modules
         * all the options
         */

        /**
         * Question 12:
         * The output is compilation error if we don't have the ","
         */
        Directions.NORTH.getNotation();

        /**
         * Question 13
         * the output sould be null:null
         * Yes it is true
         */
        Boolean boolArray[] = new Boolean[2];
        System.out.println(boolArray[0] + ": " + boolArray[1]);

        /**
         * Question 14 : the best way to instantiate record
         */
        //Record.Ticket.class;

        /**
         * Question 15 : the period between two dates
         * the output should be P-10D
         * the output is P10D
         */
        LocalDate startDate = LocalDate.of(2023, Month.MARCH, 1);
        LocalDate endDate = LocalDate.of(2023, Month.MARCH, 11);
        System.out.println(Period.between(startDate, endDate));

        /**
         * Question 16: the output should be P1000M that means 1000 Months with M majuscule
         */
        Period period = Period.of(0,1000, 0);
        System.out.println(period);

        /**
         * Records in Java are a new kind of class that serve as nominal types,
         * meaning they are transparent carriers for immutable data.
         * It came in java 17
         */

        /**
         * Question 17 : the best way to instantiate a date function
         * The best way to instantiate is supplier
         */
        Supplier<Date> obj = Date::new;
        Date date = obj.get();
        System.out.println(date);

        /**
         * Question 18 : the expected result of a map of color using record
         * the expected result is 5 yes the result is 5
         */
        Ropero.testRecordRope();



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

    public static void loop(){
        int ctr = 100;
        one: for(var i=0; i<10; i++){
            two: for (var j=0; j<7; j++){
                three: while(true){
                    ctr++;
                    if(i>j){
                        break one;
                    } else if(i==j){
                        break two;
                    }else break three;
                }
            }
        }

        System.out.println(ctr);
    }

    public static void testChar(){
        char c1 = 'a';
        int i1 = c1;

        System.out.println(i1);
    }

    public static class FunctionalInterface{
      @java.lang.FunctionalInterface
      interface Operator{
          void operate(int i, int j);
      }

      public class Calculator{
          public static void add(int i, int j){
              System.out.println(i+j);
          }
      }

      public static void testOperator(){
          Operator opr = (i,j) ->
                  //System.out.println(i+j);
                  Calculator.add(i, j);
          opr.operate(15,25);
      }

    }

    public enum Directions{
        NORTH("N"), SOUTH("S"), EAST("E"), WEST("W");

        private String notation;

        public String getNotation() {
            return notation;
        }

        Directions(String notation){
            this.notation = notation;
        }
    }

    public static class Record{
        record Ticket(int id, LocalDate localDate){
            Ticket (int id, LocalDate localDate){
                if(id<10001 || id>100001){
                    throw new IllegalArgumentException(String.format("id : %s is not valid", id));
                }
                if(localDate.isBefore(LocalDate.of(2022,12, 31)) || localDate.isAfter(LocalDate.of(2023,1,1))){
                    throw new IllegalArgumentException(String.format("date %s is not valid", localDate.toString()));
                }
                this.id = id;
                this.localDate = localDate;
            }

        }
    }


    public class Ropero{
        enum Color{RED,GREEN,BLUE};

        record Rope(int length, Color color){}
        record Group(Map<Color, List<Rope>> map1, Map<Integer, List<Rope>> map2){};

        public static void testRecordRope(){
            var ropes = Stream.of(
                    new Rope(100, Color.RED),
                    new Rope(200, Color.BLUE),
                    new Rope(300, Color.RED),
                    new Rope(200, Color.RED),
                    new Rope(100, Color.BLUE)
            );

            var results = ropes.collect(
                    Collectors.teeing(
                    Collectors.groupingBy(Rope::color),
                    Collectors.groupingBy(Rope::length),
                    Group::new)
            );

            System.out.println(results.map1.size() + results.map2.size());
        }
    }





}
