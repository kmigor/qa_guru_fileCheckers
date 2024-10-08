package checkers;

import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static com.google.common.io.Files.getFileExtension;

public class ZipChecker {

    ClassLoader cl = ZipChecker.class.getClassLoader();

    private final CsvChecker csvChecker = new CsvChecker();
    private final PdfChecker pdfChecker = new PdfChecker();
    private final XlsxChecker xlsxChecker = new XlsxChecker();

    public void checkZip (String zipName) throws IOException , CsvException {

        try (ZipInputStream zis = new ZipInputStream(cl.getResourceAsStream(zipName))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.isDirectory()) continue;
                String fileExtension = getFileExtension(entry.getName());
                switch (fileExtension) {
                    case "csv" -> csvChecker.checkCsv(zis);
                    case "pdf" -> pdfChecker.checkPdf(zis);
                    case "xlsx" -> xlsxChecker.checkXlsx(zis);
                    default -> System.out.println("Неизвестный формат ." + fileExtension);
                }
            }
        }

    }
}
