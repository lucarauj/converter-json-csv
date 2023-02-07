import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.File;
import java.io.IOException;

public class ConverterDadosCsvJson {

    public static void main(String[] args) throws IOException {

        CsvSchema orderLineSchema = CsvSchema.emptySchema().withHeader();
        CsvMapper csvMapper = new CsvMapper();
        MappingIterator<OrderLine> orderLines = csvMapper.readerFor(OrderLine.class)
                .with(orderLineSchema)
                .readValues(new File("C:\\Users\\luc_c\\Desktop\\Diversos\\Programação\\ConverterCsvJson\\ConverterJsonCsv\\src\\main\\resources\\lista.csv"));

        new ObjectMapper()
                .configure(SerializationFeature.INDENT_OUTPUT, true)
                .writeValue(new File("C:\\Users\\luc_c\\Desktop\\Diversos\\Programação\\ConverterCsvJson\\ConverterJsonCsv\\src\\main\\resources\\novaLista.json"), orderLines.readAll());
    }

}
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class OrderLine {
    private Long id;
    private String codigo;
    private String titulo;
    private String descricao;
    private String imagem;
    private double preco;
    private int quantidade;
    private String categoria;

}
