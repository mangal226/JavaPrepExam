package src.secureCoding;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class ProtectingAgainstDenialServiceAttacks {
    /**
     * What is denial service attack? An attack that exhausts an application's resource memory(CPU, JVM ...)
     * preventing authorized access to the system
     * How to prevent it:
     * --> Define and enforce limits
     * --> Protect against overflow
     * --> Clean-up or pool resources
     * We have to types of memory in java : heap memory and stack memory
     * --> The heap memory is used for creating new objects. It has three type for objects memory allocation
     * young generation, old tenured generation and permanent generation
     * How to protect against denil service attacks:
     * --> Java defines limits on heap size i.e. 25% available memory up to 25GB
     * --> Javaxml defines and enforces a limit on entity expansion i.e? 64000
     */


    public static void main(String[] args){

    }

    public void testZipBomps() throws IOException {
        byte[] buffer = new byte[1024];
        OutputStream output = new OutputStream() {
            @Override
            public void write(int b) throws IOException {

            }
        };
        ZipFile zip = new ZipFile("test.zip");
        zip.stream().forEach(zipEntry -> {

            try {
                int read;
                InputStream input = zip.getInputStream(zipEntry);
                while ((read = input.read(buffer, 0, buffer.length)) != -1)
                    output.write(buffer, 0, read);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println(output.getClass().getName());

        /**
         * Java manages memory(garbage collector) but doesn't manage resources(files, database connection ...)
         * try with resources permit to open and close resource for all the cases
         * In java we have a security manager that grant permissions for the files i.e. java.io.FilePermission
         * e.g.
         * grant codeBase "file:/etc/deployment/libs/third-party.jar" {
         *     permission.java.io.FilePermission "/tracks/-" "write"
         * }
         * there we grant write permission for all the files in tracks directory
         * */


    }
}
