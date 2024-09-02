package src.javamodulesystem;

public class Modules {
    /*
    * levels: statements->methods->classes->packages->modules
    * Generally modules have all the information needed to work independent and if refers to other modules
    * there are enough information for accessing the dependencies
    * A jar file is not a module
    * Limits of jar file:
    * ---> it groups code but without access control
    * ---> it does not describe its dependencies
    * ---> it has a name which disappears at run-time
    */

    /**
     * why modules?
     * --> understandability: explicit boundaries and dependencies
     * --> maintainability: hiding implementation details
     * --> flexibility: decoupling of parts of your system
     * Tenets of modularity:
     * --> Strong encapsulation
     * --> Well defined interfaces
     * --> Explicit dependencies
     * The first use of module in java is the jdk itself
     */


}
