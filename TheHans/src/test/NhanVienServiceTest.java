package test;

import app.model.NhanVien;
import app.service.NhanVienService;
import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;


public class NhanVienServiceTest {
    private NhanVienService nhanVienService = new NhanVienService();

    @Test(dataProvider = "productData")
    public void testAddKhachHang(int id, String maNV, String hoTen, Date ngaySinh, int gioiTinh, String diaChi, String sdt, String email, String matKhau, String vaiTro, boolean trangThaiXoa, Date ngayTao, Date ngaySuaCuoi) {
        try {
            int result = nhanVienService.insertNV(new NhanVien(id, maNV, hoTen, ngaySinh, gioiTinh, diaChi, sdt, email, matKhau, vaiTro, trangThaiXoa, ngayTao, ngaySuaCuoi));
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
    public void testUpdateKhachHang(int id, String maNV, String hoTen, Date ngaySinh, int gioiTinh, String diaChi, String sdt, String email, String matKhau, String vaiTro, boolean trangThaiXoa, Date ngayTao, Date ngaySuaCuoi) {
        try {
            int result = nhanVienService.updateNhanVien(maNV, new NhanVien(id, maNV, hoTen, ngaySinh, gioiTinh, diaChi, sdt, email, matKhau, vaiTro, trangThaiXoa, ngayTao, ngaySuaCuoi));
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

//    @Test
//    public void testUpdateNhanVien() {
//        try {
//            NhanVien nv = new NhanVien("NV010", "HIHIHI", new Date(), 1, "HN", "123456789", "abc@gmail.com", "Nhan Vien");
//            int result = nhanVienService.updateNhanVien("NV123", nv);
//            assertEquals(0, result);
//        } catch (Exception e) {
//            fail("Exception thrown: " + e.getMessage());
//        }
//    }
//
//    @Test
//    public void testInsertNVWithNullValues() {
//        try {
//            NhanVien nv = new NhanVien(null, null, null, null, null, null, null, null);
//            int result = nhanVienService.insertNV(nv);
//            assertEquals(0, result); // We expect insertion to fail
//        } catch (Exception e) {
//            fail("Exception thrown: " + e.getMessage());
//        }
//    }

    @DataProvider(name = "productData")
    public Object[][] productDataProvider() throws IOException {
        String excelFilePath = "D:\\@FPOLY\\SOF304\\NhanVien.xlsx";
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
        String excelFilePath = "D:\\@FPOLY\\SOF304\\NhanVien1.xlsx";
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
}