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
     *
     * Before the modular JDK there was only one jar called rt. i.e. rt = runtime
     * java --list-modules permits to list all the modules included in the JDK
     *
     * Why does java.sql module requires java.logging module?
     * package java.sql
     * import java.util.logging.Logger
     * public interface Driver{
     *     public Logger getParentLogger();
     * }
     * Because the java.util needed by java.sql requires java.logging
     * What does require transitive means?
     * mymodule requires java.sql
     * java.sql requires transitive java.logging
     * --> this means mymodule requires java.logging i.e. a transitive require has been applicated
     *
     * Packaging a module
     * jar --create --file=mods/pluralsight.jar -C out/ .
     *
     * Decoupling with Services
     * Supposed that we have two
     *
     * In compiling multiple modules and listing them mind not to add space after the commas when listing
     * e.g. javac -d out --module-source-path src -m greeter.cli,greeter.hello,greeter.friendly
     * when you add , and space it won't compile
     *
     * How to run multiple modules in java:
     * $ java --module-path "out;mods/greeter.grumpy.jar" -m greeter.cli/greeter.cli.Main
     * Hello from a module!
     * Grumpy greetings from a module!
     * Friendly greetings from a module!
     * It runs the modules in out and the module in greeter.grumpy.jar
     *
     * Using jdeps: jdeps permits to know which module is used as dependency for a specific jar file
     * jdeps -s app-storage.jar
     * app-storage.jar -> java.base
     * app-storage.jar -> java.sql
     * We can generate module-info.java for a module also using jdeps
     * jdeps --generate-module-info . app-storage.jar
     * Module migration: we have to method to migrate modules: top-down migration and bottom-up migration
     */

    /**
     *
     * @param args
     */


    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}