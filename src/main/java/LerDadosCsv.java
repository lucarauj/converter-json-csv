import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LerDadosCsv {

    public static void main(String[] args) {

        String path = "C:\\Users\\luc_c\\Desktop\\Diversos\\Programação\\ConverterCsvJson\\ConverterJsonCsv\\src\\main\\resources\\lista.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();

            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

