package utilities;

import org.testng.annotations.DataProvider;

import java.util.List;

public class DataProviderUtils {
    @DataProvider(name="invalidDOBdata")
    public static Object[][] invalidDobData()  {
//        return new Object[][]{
//                {"Harpal", "Singh", "2 North Central Avenue",
//                        "Arizona", "Phoenix", "85004", "12/07/198", "Please enter a valid date."};
        List<Object[]> data = ExcelUtils.getExcelData("src/TestData/testData.xlsx", "InvalidDOB");
//        List<Object[]> data = ExcelUtils.getExcelData("src/TestData/testData.xlsx","InvalidDOB");
        return data.toArray(new Object[0][]);
    }
    @DataProvider(name="validDOB")
    public static Object[][] validDobData()  {
        List<Object[]> data = ExcelUtils.getExcelData("src/TestData/testData.xlsx", "validDOB");
        return data.toArray(new Object[0][]);
    }
}
