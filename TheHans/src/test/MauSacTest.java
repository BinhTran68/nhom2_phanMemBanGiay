package test;

import app.model.MauSac;
import app.service.ThuocTinhService;
import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;


public class MauSacTest {
    private ThuocTinhService thuocTinhService = new ThuocTinhService();


    ///ThemMoi
    @Test(dataProvider = "productData")
    public void testAddMauSac(String maMauSac, String ten, int trangThaiXoa, String ngayTao, String ngaySuaCuoi) {
        try{
            int result = thuocTinhService.addMauSac(new MauSac(maMauSac, ten, trangThaiXoa, ngayTao, ngaySuaCuoi));
            Assert.assertEquals(1,result);
            Assert.assertFalse(result<1);

        }catch (IllegalArgumentException e){
            Assert.fail(e.getMessage());
        }catch (NullPointerException e){
            Assert.fail(e.getMessage());
        }
    }
    @DataProvider(name = "productData")
    public Object[][] productDataProvider() throws IOException {
        String excelFilePath = "C:\\Users\\ACER\\Downloads\\sheet 1.xlsx";
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            Row row = sheet.getRow(i + 1);
            for (int j = 0; j < colCount; j++) {
                Cell cell = row.getCell(j);
                switch (cell.getCellType()) {
                    case STRING:
                        data[i][j] = cell.getStringCellValue();
                        break;
                    case NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell)) {
                            // Process date
                        } else if (cell.getCellType() == CellType.NUMERIC) {
                            double numericValue = cell.getNumericCellValue();
                            if (numericValue == Math.floor(numericValue)) { // Kiểm tra xem giá trị là một số nguyên
                                data[i][j] = (int) numericValue; // Chuyển đổi sang kiểu int
                            } else {
                                data[i][j] = numericValue; // Giữ nguyên giá trị double nếu không phải số nguyên
                            }
                        } else {

                        }
                        break;
                    case BOOLEAN:
                        data[i][j] = cell.getBooleanCellValue();
                        break;
                    default:
                        // Handle other cell types as needed
                        break;
                }
            }
        }
        workbook.close();
        inputStream.close();
        return data;
    }

///CapNHat
@Test(dataProvider = "updateData")
public void testUpdateMauSac(String maMauSac, String ten, int trangThaiXoa, String ngayTao, String ngaySuaCuoi) {
    try {
        int result = thuocTinhService.suaMauSac(new MauSac(maMauSac, ten, trangThaiXoa, ngayTao, ngaySuaCuoi), maMauSac);
        // Kiểm tra kết quả trả về từ phương thức cập nhật
        Assert.assertEquals(0, result); // Nếu cập nhật thành công, kỳ vọng kết quả trả về là 1
    } catch (IllegalArgumentException e) {
        Assert.fail(e.getMessage());
    } catch (NullPointerException e) {
        Assert.fail(e.getMessage());
    }
}

    @DataProvider(name = "updateData")
    public Object[][] updateDataProvider() throws IOException {
        String excelFilePath = "C:\\Users\\ACER\\Downloads\\sheet 1.xlsx";
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            Row row = sheet.getRow(i + 1);
            for (int j = 0; j < colCount; j++) {
                Cell cell = row.getCell(j);
                switch (cell.getCellType()) {
                    case STRING:
                        data[i][j] = cell.getStringCellValue();
                        break;
                    case NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell)) {
                            // Process date
                        } else if (cell.getCellType() == CellType.NUMERIC) {
                            double numericValue = cell.getNumericCellValue();
                            if (numericValue == Math.floor(numericValue)) { // Kiểm tra xem giá trị là một số nguyên
                                data[i][j] = (int) numericValue; // Chuyển đổi sang kiểu int
                            } else {
                                data[i][j] = numericValue; // Giữ nguyên giá trị double nếu không phải số nguyên
                            }
                        } else {

                        }
                        break;
                    case BOOLEAN:
                        data[i][j] = cell.getBooleanCellValue();
                        break;
                    default:
                        // Handle other cell types as needed
                        break;
                }
            }
        }
        workbook.close();
        inputStream.close();
        return data;    }
}
