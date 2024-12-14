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
        String inputFilePath = "input-output/src/main/resources/exercise.txt";
        String outputFilePath = "input-output/src/main/resources/exerciseNew.txt";
 
        try(
            FileInputStream inputFile = new FileInputStream(inputFilePath);
            InputStreamReader inputStreamReader = new InputStreamReader(inputFile);
            LineNumberReader lineReader = new LineNumberReader(inputStreamReader);

            FileOutputStream outputFile = new FileOutputStream(outputFilePath);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputFile);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        ) {
            String outputLine = lineReader.readLine();

            while (outputLine != null) {
                System.out.printf("%d: %s%n", lineReader.getLineNumber(), outputLine);
                bufferedWriter.write(outputLine);
                bufferedWriter.newLine();
                outputLine = lineReader.readLine();

                //bufferedWriter.close();
                //outputStreamWriter.close();
                //fileOutputStream.close(); 
        }      

        } catch (IOException e) {
            System.out.println("File writing exception: " + e.getMessage());
        }
    }
}