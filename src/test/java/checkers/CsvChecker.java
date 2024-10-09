package checkers;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipInputStream;
import static org.assertj.core.api.Assertions.assertThat;

public class CsvChecker {

    public void checkCsv(ZipInputStream zis) throws IOException, CsvException {
        CSVReader csvReader = new CSVReader(new InputStreamReader(zis));
        List<String[]> csvs =  csvReader.readAll();
        String [] firstRow = {"Name", " Job", " State", " City"};
        String [] secondRow = {"John", " Designer", " WA", " Seattle"};
        String [] thirdRow = {"Edward", " Developer", " WA", " Seattle"};

        assertThat(csvs.size()).isEqualTo(3);
        assertThat(csvs.get(0)).isEqualTo(firstRow);
        assertThat(csvs.get(1)).isEqualTo(secondRow);
        assertThat(csvs.get(2)).isEqualTo(thirdRow);
    }
}