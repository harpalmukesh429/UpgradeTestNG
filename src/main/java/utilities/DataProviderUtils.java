package utilities;

import org.testng.annotations.DataProvider;

import java.util.List;

public class DataProviderUtils {
    @DataProvider(name="invalidDOBdata")
    public static Object[][] invalidDobData() {
        return getDataFromExcel("src/TestData/testData.xlsx", "InvalidDOB");
    }
    @DataProvider(name = "validDOB")
    public static Object[][] validDobData() {
        return getDataFromExcel("src/TestData/testData.xlsx", "validDOB");
    }

    @DataProvider(name = "getUsersAPIValidDetails")
    public static Object[][] validUsers() {
        return getDataFromExcel("src/TestData/testData.xlsx", "getUsersAPIValidDetails");
    }
    private static Object[][] getDataFromExcel(String filePath, String sheetName) {
        List<Object[]> data = ExcelUtils.getExcelData(filePath, sheetName);
        return data.toArray(new Object[0][]);
    }

}
