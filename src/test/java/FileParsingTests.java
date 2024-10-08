import checkers.JsonChecker;
import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import checkers.ZipChecker;

import java.io.IOException;

public class FileParsingTests {

    @Test
    @DisplayName("Чтение и проверка файлов из ZIP-архива")
    void checkZipFileTest() throws IOException, CsvException {
        String zipName = "files.zip";
        ZipChecker zipChecker = new ZipChecker();
        zipChecker.checkZip(zipName);
    }

    @Test
    @DisplayName("Чтение и проверка файлов из json")
    void checkJsonTest() throws IOException {
        String jsonName = "JSON.json";
        JsonChecker jsonChecker = new JsonChecker();
        jsonChecker.checkJson(jsonName);
    }


}
