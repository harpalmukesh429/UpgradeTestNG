package utilities;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ExcelUtils {
    public static void main(String[] args) {
        getExcelData("src/TestData/testData.xlsx","InvalidDOB");
    }
    public static List<Object[]> getExcelData(String filePath, String sheetName) {
        List<Object[]> data = new ArrayList<Object[]>();
        try {
            FileInputStream file = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheet(sheetName);
            for (Row row : sheet) {
                if (row.getRowNum() > 0) {
                    Object[] rowData = new Object[row.getLastCellNum()];
                    for (int i = 0; i < row.getLastCellNum(); i++) {
                        rowData[i] = row.getCell(i).toString();
                    }
                    data.add(rowData);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}
