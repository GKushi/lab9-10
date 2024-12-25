import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CopyFileWithSpacesReplaced {
    public static void main(String[] args) {
        String inputFileName = "input.txt";
        String outputFileName = "output.txt";

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
                PrintWriter writer = new PrintWriter(new FileWriter(outputFileName))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.replace(' ', '-');
                writer.println(line);
            }
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
