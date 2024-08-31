package src.secureCoding;

public class HandlingSensitiveDatas {
    /**
     *What is serialization: it is the concept of converting an object into byte stream and deserialization is the opposite
     * When we make any variable transient then this variable is not serializable
     * To protect a password we can make it transient
     * The sensitive data like user, password or email have to be hashed or hidden
     * If there is no possibility it has to be stored in char array it is safer
     * Do not share untrusted exception messages and globally do not show exceptions
     * Practices for handling sensitive data in logs, memory and exceptions
     * Do not log unnecesssarily information
     * Avoid logging sensitive information
     * Use log correlators or hashed info
     * Audit logging entire objects and printf
     * All data from heap memory is visible
     * Do not cache unnecesseraly, avoid sensitive information
     * Do not show exceptions
     * Replace untrusted exception messages
     * Use transient or ObjectStreamField
     */


    public static void main(String[] args){

    }
}
