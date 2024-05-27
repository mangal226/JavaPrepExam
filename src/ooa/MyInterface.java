package src.ooa;

public interface MyInterface {
    enum skinColor {black, white, yellow};
    enum language {french, english, spanish, deutsche};
    enum career {computer_science_engineer, mechanical_engineer, electrical_engineer, process_engineer};
    default void setLanguage(){};
    default void setCareer(){};

    default void currentThread(){
        System.out.println(Thread.currentThread().getId());
    }



}