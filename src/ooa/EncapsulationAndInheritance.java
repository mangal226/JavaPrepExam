package src.ooa;

import java.util.UUID;

public class EncapsulationAndInheritance {

    /**
     * class that are not previous with public are default i.e. package private. They are only accessible to the package
     * go to oracle : docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html
     */

    protected String uuid;
    protected String inheritedClass;

    public String sayHello(){
        return "Hello world";
    }

    public EncapsulationAndInheritance(){
        this.uuid = UUID.randomUUID().toString();
        this.inheritedClass = EncapsulationAndInheritance.class.getCanonicalName();
    }

    class AccessModifier{
        private String uuid;
        private String className;

        public AccessModifier(){
            this.uuid = UUID.randomUUID().toString();
            this.className = AccessModifier.class.getCanonicalName();
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }
    }

    /**
     * A subclass can override an existing method in the mother class
     */
    class InheritedClass extends EncapsulationAndInheritance{
        private String className;
        private String concatenateClassName;
        public InheritedClass(){
            super();
            this.className = InheritedClass.class.getCanonicalName();
            this.concatenateClassName = super.inheritedClass + this.className;
        }


        /**
         *
         * The version of the method that get return after the call is determined at runtime, by the object that is
         * used to invoke it --> we can call it polymorphism
         * we can prevent overriding methods by using final in the method as if the methode won't be overriden
         * we can prevent modifying classes by using final in the class declaration
         */
        @Override
        public String sayHello(){
            return "Hello world I am a sublcass";
        }
    }



}
