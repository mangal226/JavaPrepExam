package src.ooa;

public interface MyInterface {

    /**
     * An interface is a reference type that contain method signatures, default methods, static methods, nested types and constants
     * An interface:
     * --> Can not be instantiated
     * --> Can not contain a constructor
     * --> Has method that usually do not have body
     * what the defaut is used for??
     * interface methods are by default abstract and public
     * interfaces can also contain constants
     */
    enum skinColor {black, white, yellow};
    enum language {french, english, spanish, deutsche};
    enum career {computer_science_engineer, mechanical_engineer, electrical_engineer, process_engineer};
    void setLanguage();
    void setCareer();

    /**
     * A default method is a method that has implementation i.e. not void. it allows interface to evolve but don't force changes to classes that implement those
     * interfaces
     * We are no obliged to modify a default method because we already have a default value
     * If needed we can override the default method but it is not obliged as we have a default value
     * Interface can have multiple methods(static, abstracts, defaults ...)
     * A functional interface is an interface that has only one method it can't have plus
     */
    default void greetings(){};

    static void greetings2(){
        System.out.println("Hello I am in the interface");
    };

    default void currentThread(){
        System.out.println(Thread.currentThread().getId());
    }



}
