package src.src.preparationNotes;

import com.mysql.cj.protocol.Message;

import javax.swing.text.StyledEditorKit;
import java.io.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Exam1Exercises {

    public static void main(String [] args) throws IOException, ExecutionException, InterruptedException {

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

        /**
         * Question 19: the output using console reader
         * the expected result is it waits
         * the answer is compilation error with null pointer exception because the console is null
         */
        //testConsole();


        /**
         * Question 20: The expected result is 1, 2 ArithmeticException
         * the result is : 1 java.lang.ClassCastException
         */
        testException();

        /**
         * Question 21: the output of args parmater in main function
         * Result compilation error exeption catch must be disjoint not in the same line i.e. catch, then catch again
         */
        /*try {
            System.out.println(args.length);
        }catch (NullPointerException | RuntimeException ex){
            System.out.println("DONE");
        }*/

        /**
         * Question 22: what to put to have the right answer
         */
        A.voidA();

        /**
         * Question 23: result of message format
         * the format respect the order
         */
        String formatting = "LastName {1} FistName {0}";
        String result = MessageFormat.format(formatting, "Hamouda", "Damnar");
        System.out.println(result);

        /**
         * Question 24
         * the expected result is true
         */
        var df1 = new DecimalFormat("##, ##,#");
        var df2 = new DecimalFormat("##, ###,#");
        System.out.println(df1.format(1231).equals(df2.format(1231)));

        /**
         * Question 25
         * there is a compilation error in the below code because the method log is static
         */
        //class MyLogger extends Log implements ILog{}

        /**
         * Question 26: What is the output
         * Expected : the program compiles but nothing is printed
         * Result ok
         */
        ITester objI = () -> System.out.println("KEEP CALM");

        /**
         * Question 27: What is the output
         * Expected result : the program doesn't terminate but prints null, null
         * Result: the program terminates after printing Call, null
         */
        var es = Executors.newSingleThreadExecutor();
        var future = es.submit(new Caller("Call"));
        System.out.println(future.get());

        /**
         * Question 31:
         * Expected result : compilation error in test class
         * miss catch clause
         */
        try (AutoCloseable resource = new MyResource()){

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


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

    public static void testConsole() throws IOException {
      var console = System.console();
      console.writer().printf("Enter a number between 1 and 7 ");
      var num = Integer.parseInt("" + console.reader().read());
      var flag = IntStream.rangeClosed(1,7).anyMatch(i-> i == num);
      if(flag) console.printf("*".repeat(num));
      else console.writer().format("Invalid");
    }

    public static void testException(){
        try {
            checkException();
        }catch (RuntimeException e){
            System.out.println(e.getClass().getName());
        }
    }

    public static void checkException(){
        try {
            RuntimeException re = new RuntimeException();
            throw re;
        }catch (RuntimeException e){
            System.out.println(1);
            ArithmeticException ex = (ArithmeticException) e;
            System.out.println(2);
            throw  ex;
        }
    }

    public static class A{
        private static class B {
            private static void log(){
                System.out.println("BE THE CHANGE YOU WANT TO SEE IN THE WORLD");
            }
        }

        public static void voidA(){
         B b = new B();
         b.log();
         A.B ab = new A.B();
         ab.log();
         var abv = new A.B();
         abv.log();
        }
    }
    public interface ILog{
        default void log(){
            System.out.println("ILog");
        }
    }
    public abstract class Log{
        public static void log(){
            System.out.println("Log");
        }
    }

    public static interface ITester{
        void test();
    }

    public static class Caller implements Callable<Void>{
        String str;

        public Caller(String s){
            this.str = s;
        }

        @Override
        public Void call() throws Exception {
            System.out.println(str.toUpperCase());
            return null;
        }
    }

    public abstract class Animal{
        public String name;

        public String getName() {
            return name;
        }

        Animal(String name){
            this.name = name;
        }
    }

    public class Dog extends Animal{
        public String breed;

        public String getBreed() {
            return breed;
        }

        Dog(String name, String breed) {
            super(name);
            this.breed = breed;
        }

        //Dog(String breed){
          //  this.breed = breed;
        //}
    }

    public static class MyResource implements AutoCloseable{

        @Override
        public void close() throws Exception {
            System.out.println("Closing");
        }


    }





}
