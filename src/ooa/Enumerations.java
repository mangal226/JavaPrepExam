package src.ooa;

import java.util.UUID;

public enum Enumerations {

    /**
     * An enumeration can have body which can include fields and methods
     * It can have properties assigned to each of its values
     * It can have constructor to define its values
     */

    /**
     * Constants of the enumeration
     */
    FIRST_NAME(20),
    LAST_NAME(15),
    AGE(10),
    GENDER(10);


    /**
     * Property assigned to the constant
     */
    private String ID;

    /**
     * The constructor must be private or package private
     */
    Enumerations(int id){
       this.ID = UUID.randomUUID().toString();
    }

    public String getID(){
        return this.ID;
    }

    public String returnID(Enumerations enumerations){
        return this.getID();
    }

    public static void main(String[] args){
        Enumerations enumerations = Enumerations.AGE;
        enumerations.returnID(enumerations);
    }


}
