package com.cbfacademy;

// second attempt at the file reader task
// java.io.* provides classes for file input and output operation
import java.io.*;

public class FileReader {
    public static void main(String[] args) {

        // file paths defined
        String filePath = "input-output/src/main/resources/exercise.txt";
        String newFilePath = "input-output/src/main/resources/newexercise.txt";

        /* the try block ensures that the resources (file readers and writers) are automatically closed when they are no longer needed
        inside the try block, the program reads each item from the input file using a BufferedReader 
        then it writes the line to the output file using a BufferedWriter */
        try(
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter(newFilePath);
            BufferedWriter bufferedWriter = BufferedWriter(fileWriter);
        ) { 
            // the newLine() method is used to add a newLine character after each line in the output file
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }

        System.out.println(line);
        
        // in case any IOException occurs during the file operations, it will be caught and the exception details will be ordered
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
