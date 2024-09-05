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
     *
     * All the declarations have to finish with semicolons ;
     * Dependencies between modules
     * module mymodule{
     *     requires util;
     * }
     * module util{
     *     exports com.pluralsight.util;
     *     requires java.base;
     * }
     * Cyclic dependencies between modules are not allowed i.e. one module require the other and vice versa
     *
     * Openning packages
     * reflective access :
     * module mymodule{
     *     exports com.pluralsight;
     *     opens com.pluralsight.util; --> permits to get access to this packages to the other packages or modules
     * }
     *
     * We can also open modules to all the other modules in this case this module can be accessed with all its included packages
     * open module mymodule{}
     * what is the difference between open and export for modules
     * open is used only for the run time but export is used for both compile and run time
     */

    /**
     *
     * @param args
     */


    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}