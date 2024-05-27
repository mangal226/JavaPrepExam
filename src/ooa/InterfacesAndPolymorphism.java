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
}
