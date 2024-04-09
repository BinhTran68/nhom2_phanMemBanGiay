package test;

import app.model.KhachHang;
import app.service.KhachHangService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;


public class KhachHangServiceTest {
    private KhachHangService khachHangService = new KhachHangService();


    @Test(dataProvider = "productData")
    public void testAddKhachHang(int id, String maKH, String hoTen, Date ngaySinh, int gioiTinh, String diaChi, String sdt, String email, String capBac, boolean trangThaiXoa, Date ngayTao, Date ngaySuaCuoi) {
        try {

            int result = khachHangService.insertKH(new KhachHang(id, maKH, hoTen, ngaySinh, gioiTinh, diaChi, sdt, email, capBac, trangThaiXoa, ngayTao, ngaySuaCuoi));
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

    @Test(dataProvider = "productUpdateData")
    public void testUpdateKH(int id, String maKH, String hoTen, Date ngaySinh, int gioiTinh, String diaChi, String sdt, String email, String capBac, boolean trangThaiXoa, Date ngayTao, Date ngaySuaCuoi) {
        try {
            int result = khachHangService.updateKhachHang(maKH, new KhachHang(id, maKH, hoTen, ngaySinh, gioiTinh, diaChi, sdt, email, capBac, trangThaiXoa, ngayTao, ngaySuaCuoi));
            Assert.assertTrue(result > 0, "Cập nhật khách hàng thành công");
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


    @DataProvider(name = "productData")
    public Object[][] productDataProvider() throws IOException {
        String excelFilePath = "D:\\@FPOLY\\SOF304\\KhachHang1.xlsx";
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
                            Date date = cell.getDateCellValue();
                            data[i][j] = date;
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

    @DataProvider(name = "productUpdateData")
    public Object[][] productUpdateDataProvider() throws IOException {
        String excelFilePath = "D:\\@FPOLY\\SOF304\\KhachHang2.xlsx";
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
                            Date date = cell.getDateCellValue();
                            data[i][j] = date;
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
}