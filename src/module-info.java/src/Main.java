public class Main {

    /**
     *
     * How to name modules:
     * --> Separate namespace like myFirstModule
     * --> One or more java identifiers separated by '.' can be my.first.module
     * --> Avoid terminal digit like myFirstModule2 ...
     */

    /**
     *
     * Compiling modules
     * --> javac -d out src/com/javamodularity/greeter/Main.java module-info.java testi.java i.e. compile the listed java files
     * --> javac -d out --module-source-path src -m greeter i.e. compiles the java files in the directory src
     *
     * Running java code
     * --> java -p out -m src/com.javamodularity.greeter.Main
     */
    /**
     * Exporting packages from module
     * In the module declaration we can add the tag exports e.g.
     * module mymodule{
     *     exports com.pluralsight;
     * }
     */

    /**
     *
     * @param args
     */


    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}