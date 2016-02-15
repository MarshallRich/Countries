import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Countries {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        ArrayList<Country> countries = new ArrayList<>();
        HashMap<String, ArrayList<Country>> countryMap = new HashMap<>();

        System.out.println("Please enter the first letter of a country's name.");
        String userIn = scanner.nextLine();

        if (userIn.length() > 1){
            throw new Exception("Only enter one character please.");
        }

           String firstLetter = String.valueOf(userIn.charAt(0));


        File f = new File("countries.txt");
        Scanner fileScanner = new Scanner(f);
        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] columns = line.split("\\|");
            Country country = new Country(columns[0], columns[1]);

            if (firstLetter.equalsIgnoreCase(String.valueOf(columns[0].charAt(0))) ) {
                countries.add(country);
            }
        }

        countryMap.put(firstLetter, countries);

        writeFile(firstLetter + "_countries.txt", countries);

    }

    static void writeFile(String fileName, ArrayList<Country> fileContent) throws IOException {
        File f = new File(fileName);
        FileWriter fw = new FileWriter(f);
        fw.write(String.valueOf(fileContent));
        fw.close();
    }
}
