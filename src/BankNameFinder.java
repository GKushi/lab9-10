import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class BankNameFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input three numbers of bank account number: ");
        String inputPrefix = scanner.nextLine().trim();

        if (inputPrefix.length() != 3) {
            System.out.println("You must input 3 numbers only!");
            return;
        }

        String fileUrl = "https://ewib.nbp.pl/plewibnra?dokNazwa=plewibnra.txt";

        boolean found = false;

        try (
                InputStream is = new URL(fileUrl).openStream();
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(is, StandardCharsets.UTF_8))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split("\t");

                if (columns.length < 2) {
                    continue;
                }

                String shortBankNumber = columns[0].trim();
                String bankName = columns[1].trim();

                if (shortBankNumber.equals(inputPrefix)) {
                    System.out.println("Bank name: " + bankName);

                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error while reading text file: " + e.getMessage());
            e.printStackTrace();
        }

        if (!found) {
            System.out.println("Bank not found!");
        }
    }
}
