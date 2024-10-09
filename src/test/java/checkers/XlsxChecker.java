package checkers;

import com.codeborne.xlstest.XLS;
import org.apache.poi.ss.usermodel.Sheet;
import java.io.IOException;
import java.util.zip.ZipInputStream;
import static org.assertj.core.api.Assertions.assertThat;

public class XlsxChecker {

    public void checkXlsx (ZipInputStream zis) throws IOException {
        XLS xls = new XLS(zis);
        Sheet sheet = xls.excel.getSheetAt(0);

        assertThat(sheet.getRow(7).getCell(1).getStringCellValue()).contains("Marketing");
        assertThat(sheet.getRow(7).getCell(2).getStringCellValue()).contains("Content Creation");
        assertThat(sheet.getRow(7).getCell(3).getStringCellValue()).contains("Bob");
        assertThat(sheet.getRow(7).getCell(4).getDateCellValue()).hasDayOfMonth(14)
                                                                                .hasMonth(1)
                                                                                .hasYear(2024);
        assertThat(sheet.getRow(7).getCell(5).getNumericCellValue()).isEqualTo(14.0);
        assertThat(sheet.getRow(7).getCell(6).getDateCellValue()).hasDayOfMonth(28)
                                                                                .hasMonth(1)
                                                                                .hasYear(2024);
        assertThat(sheet.getRow(7).getCell(7).getNumericCellValue()).isEqualTo(1.0);
    }
}