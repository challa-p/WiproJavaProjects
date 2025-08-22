package Selenium_TestNG;

import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileInputStream;

public class ExcelUtils {
    public static Object[][] getTableArray(String filePath, String sheetName) {
        try {
            FileInputStream file = new FileInputStream(new File(filePath));
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

            Object[][] data = new Object[rowCount - 1][colCount];

            for (int i = 1; i < rowCount; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < colCount; j++) {
                    Cell cell = row.getCell(j);
                    data[i - 1][j] = cell.toString();
                }
            }
            workbook.close();
            return data;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

