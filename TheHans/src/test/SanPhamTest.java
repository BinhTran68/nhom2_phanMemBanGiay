package test;

import app.model.SanPham;
import app.service.SanPhamService;
import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class SanPhamTest {
    private SanPhamService thuocTinhService = new SanPhamService();


    @org.testng.annotations.Test(dataProvider = "productDataSPP")
    public void testAddSP(String maSP, String ten, int trangThaiXoa, String ngayTao, String ngaySuaCuoi) {
        try {
            int result = thuocTinhService.themSanPham(new SanPham(maSP, ten, trangThaiXoa, ngayTao, ngaySuaCuoi));
            Assert.assertEquals(1, result);
            Assert.assertFalse(result < 1);

        } catch (NullPointerException e) {
            Assert.fail("NullPointerException : " + e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            Assert.fail("IndexOutOfBoundsException : " + e.getMessage());
        } catch (IllegalArgumentException e) {
            Assert.fail("IllegalArgumentException : " + e.getMessage());
        } catch (Exception e) {
            Assert.fail("Cac Ngoai le khac: " + e.getMessage());
        }
    }

    @Test(dataProvider = "productUpdateDataSPP")
    public void testUpdateSP(String maSP, String ten, int trangThaiXoa, String ngayTao, String ngaySuaCuoi) {
        try {
            int result = thuocTinhService.suaSanPham(new SanPham(maSP, ten, trangThaiXoa, ngayTao, ngaySuaCuoi), maSP);
            Assert.assertTrue(result > 1);
            Assert.assertFalse(result < 1);
        } catch (NullPointerException e) {
            Assert.fail("NullPointerException : " + e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            Assert.fail("IndexOutOfBoundsException : " + e.getMessage());
        } catch (IllegalArgumentException e) {
            Assert.fail("IllegalArgumentException : " + e.getMessage());
        } catch (Exception e) {
            Assert.fail("Cac Ngoai le khac: " + e.getMessage());
        }
    }

    @DataProvider(name = "productDataSPP")
    public Object[][] productDataProviderSP() throws IOException {
        String excelFilePath = "D:\\@FPOLY\\SOF304\\sheet 1.xlsx";
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
                            if (numericValue == Math.floor(numericValue)) {
                                data[i][j] = (int) numericValue;
                            } else {
                                data[i][j] = numericValue;
                            }
                        }
                        break;
                    case BOOLEAN:
                        data[i][j] = cell.getBooleanCellValue();
                        break;
                    default:
                        break;
                }
            }
        }
        workbook.close();
        inputStream.close();
        return data;
    }

    @DataProvider(name = "productUpdateDataSPP")
    public Object[][] productUpdateDataProviderSP() throws IOException {
        String excelFilePath = "D:\\@FPOLY\\SOF304\\sheet 2.xlsx";
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
                            if (numericValue == Math.floor(numericValue)) {
                                data[i][j] = (int) numericValue;
                            } else {
                                data[i][j] = numericValue;
                            }
                        } else {

                        }
                        break;
                    case BOOLEAN:
                        data[i][j] = cell.getBooleanCellValue();
                        break;
                    default:
                        break;
                }
            }
        }
        workbook.close();
        inputStream.close();
        return data;
    }







}
