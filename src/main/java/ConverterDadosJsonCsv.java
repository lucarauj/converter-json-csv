import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;

public class ConverterDadosJsonCsv {

    public static void main(String[] args) throws IOException {

        //Leitura do arquivo.json
        JsonNode jsonTree = new ObjectMapper().readTree(new File("C:\\Users\\luc_c\\Desktop\\Diversos\\Programação\\ConverterCsvJson\\ConverterJsonCsv\\src\\main\\resources\\lista.json"));

        //Cria o CsvSchema com cabeçalho
        CsvSchema.Builder csvSchemaBuilder = CsvSchema.builder();
        JsonNode firstObject = jsonTree.elements().next();
        firstObject.fieldNames().forEachRemaining(fieldName -> {
            csvSchemaBuilder.addColumn(fieldName);
        });
        CsvSchema csvSchema = csvSchemaBuilder.build().withHeader();

        //Cria o CsvMapper e grava o jsonTree no arquivo csv
        CsvMapper csvMapper = new CsvMapper();
        csvMapper.writerFor(JsonNode.class)
                .with(csvSchema)
                .writeValue(new File("C:\\Users\\luc_c\\Desktop\\Diversos\\Programação\\ConverterCsvJson\\ConverterJsonCsv\\src\\main\\resources\\lista.csv"), jsonTree);

    }
}
