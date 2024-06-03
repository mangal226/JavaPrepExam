package src.ooa;

import java.util.List;
import java.util.function.Predicate;

public class InterfacesAndPolymorphism implements MyFunctionalInterface{

    @Override
    public void greetingsInFunctional() {
    }

    static Predicate<String> startWithA = val -> {
        return val.startsWith("A");
    };

    public static void main(String[] args){
        List<String> aircraftsManufacturers = List.of("Boeing", "Airbus", "Embraer");
        aircraftsManufacturers.stream().filter(startWithA).forEach(System.out::println);
    }


    /**
     * Polymorphism:
     * permits to change behavior of an application at runtime even without recompiling your code
     * permits to reduces coupling because we can depend on abstractions, not concrete types
     * permits to use a single variable type to store many types
     *
     *
     * Difference between interfaces and abstract classes:
     * --> Abstract classes permit to offer some base functionality to subclasses, provide a template for future classes, create abstract members that are not public
     * --> Interfaces permit high level of abstraction, high level of loose coupling,
     */
}

