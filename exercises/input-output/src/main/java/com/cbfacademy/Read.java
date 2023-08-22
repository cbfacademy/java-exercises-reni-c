package com.cbfacademy;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;

public class Read {
    public static void main(String[] args) {
        String filePath = "input-output/src/main/resources/exercise.txt";

        try(
            FileInputStream file = new FileInputStream(filePath);
            InputStreamReader streamReader = new InputStreamReader(file);
            LineNumberReader lineReader = new LineNumberReader(streamReader);
        ) {
            String outputLine = lineReader.readLine();
            while (outputLine != null) {
                System.out.printf("%d: %s%n", lineReader.getLineNumber(), outputLine);
                outputLine = lineReader.readLine();
            }      
        } catch (IOException e) {
            System.out.println("File reading exception: " + e.getMessage());
        }

        // String fileName = "exerciseNew.txt";
        String fileName = "input-output/src/main/resources/exerciseNew.txt";

        try(
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        ) {
            bufferedWriter.write(fileName);

            bufferedWriter.close();
            outputStreamWriter.close();
            fileOutputStream.close();
        } catch (IOException e) {
            System.out.println("File writing exception: " + e.getMessage());
        }
    }
}
