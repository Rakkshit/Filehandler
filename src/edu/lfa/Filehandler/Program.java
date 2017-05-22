
package edu.lfa.Filehandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Program {
    
    public static void main(String[] args) {
        String path = "h:/Automate/Generated/";
        String filename = "h:/Automate/Autoread.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = " ";
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(";");
                FileWriter writer = new FileWriter(path + tokens[0] + ".java");
                writer.write("public class " + tokens[0] + "{\r\n");
                if (tokens.length > 1) {
                    String[] attrs = tokens[1].split("% ");
                    for (String attr : attrs) {
                        System.out.println(attr);
                    }
                }
                writer.write("\r\n }");
                writer.close();
            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
    
}
