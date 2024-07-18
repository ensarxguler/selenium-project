package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

// In this class, we will be creating the re-usable logic to read from configuration,properties file
public class ConfigurationReader {

    // 1- Instantiate the Properties class. (create object)
    // Make it "private" so we are limiting access to the object
    // "static" is to make sure it's created and loaded before everything else.
    private static Properties properties = new Properties();

    static {

        try {

            // 2- Open file using FileInputStream object. (open file)
            FileInputStream file = new FileInputStream("configuration.properties");

            // 3- Load the "file" to "properties" object. (load properties)
            properties.load(file);

            // Close the file in the memory
            file.close();

        } catch (IOException e) {
            System.out.println("FILE NOT FOUND WITH GIVEN PATH!!!");
            e.printStackTrace();
        }

    }

    // Create a method to use the object to read
    // 4- Use "properties" object to read value from the file (read properties.
    
    public static String getProperty(String keyword) {
        return properties.getProperty(keyword);
    }
    
}
