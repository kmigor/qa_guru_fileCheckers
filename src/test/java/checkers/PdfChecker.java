package checkers;

import com.codeborne.pdftest.PDF;

import java.io.IOException;
import java.util.zip.ZipInputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class PdfChecker {

    public void checkPdf (ZipInputStream zis) throws IOException {
        PDF pdf = new PDF(zis);

        assertThat(pdf.numberOfPages).isEqualTo(10);
        assertThat(pdf.text).contains("Sample PDF Document");

    }
}
