package test;

import app.model.ChatLieu;
import app.model.Hang;
import app.model.KichCo;
import app.model.MauSac;
import app.service.ThuocTinhService;
import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;


public class ThuocTinhServiceTest {
    private ThuocTinhService thuocTinhService = new ThuocTinhService();

    @Test(dataProvider = "productDataMS")
    public void testAddMauSac(String maMauSac, String ten, int trangThaiXoa, String ngayTao, String ngaySuaCuoi) {
        try {
            int result = thuocTinhService.addMauSac(new MauSac(maMauSac, ten, trangThaiXoa, ngayTao, ngaySuaCuoi));
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

    @Test(dataProvider = "productUpdateDataMS")
    public void testUpdate(String maMauSac, String ten, int trangThaiXoa, String ngayTao, String ngaySuaCuoi) {
        try {
            int result = thuocTinhService.suaMauSac(new MauSac(maMauSac, ten, trangThaiXoa, ngayTao, ngaySuaCuoi), maMauSac);
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

    @DataProvider(name = "productDataMS")
    public Object[][] productDataProvider() throws IOException {
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

    @DataProvider(name = "productUpdateDataMS")
    public Object[][] productUpdateDataProvider() throws IOException {
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

    // KT

    @Test(dataProvider = "productDataKT")
    public void testAddKT(String maKichCo, String ten, int trangThaiXoa, String ngayTao, String ngaySuaCuoi) {
        try {
            int result = thuocTinhService.addKichCo(new KichCo(maKichCo, ten, trangThaiXoa, ngayTao, ngaySuaCuoi));
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

    @Test(dataProvider = "productUpdateDataKT")
    public void testUpdateKT(String maKichCo, String ten, int trangThaiXoa, String ngayTao, String ngaySuaCuoi) {
        try {
            int result = thuocTinhService.suaKichCo(new KichCo(maKichCo, ten, trangThaiXoa, ngayTao, ngaySuaCuoi), maKichCo);
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

    @DataProvider(name = "productDataKT")
    public Object[][] productDataProviderKT() throws IOException {
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

    @DataProvider(name = "productUpdateDataKT")
    public Object[][] productUpdateDataProviderKT() throws IOException {
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

    @Test(dataProvider = "productDataH")
    public void testAddH(String maHang, String ten, int trangThaiXoa, String ngayTao, String ngaySuaCuoi) {
        try {
            int result = thuocTinhService.addHang(new Hang(maHang, ten, trangThaiXoa, ngayTao, ngaySuaCuoi));
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

    @Test(dataProvider = "productUpdateDataH")
    public void testUpdateH(String maHang, String ten, int trangThaiXoa, String ngayTao, String ngaySuaCuoi) {
        try {
            int result = thuocTinhService.suaHang(new Hang(maHang, ten, trangThaiXoa, ngayTao, ngaySuaCuoi), maHang);
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

    @DataProvider(name = "productDataH")
    public Object[][] productDataProviderH() throws IOException {
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

    @DataProvider(name = "productUpdateDataH")
    public Object[][] productUpdateDataProviderH() throws IOException {
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

    @Test(dataProvider = "productDataCL")
    public void testAddCL(String maChatLieu, String ten, int trangThaiXoa, String ngayTao, String ngaySuaCuoi) {
        try {
            int result = thuocTinhService.addChatLieu(new ChatLieu(maChatLieu, ten, trangThaiXoa, ngayTao, ngaySuaCuoi));
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

    @Test(dataProvider = "productUpdateDataCL")
    public void testUpdateCL(String maChatLieu, String ten, int trangThaiXoa, String ngayTao, String ngaySuaCuoi) {
        try {
            int result = thuocTinhService.suaChatLieu(new ChatLieu(maChatLieu, ten, trangThaiXoa, ngayTao, ngaySuaCuoi), maChatLieu);
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

    @DataProvider(name = "productDataCL")
    public Object[][] productDataProviderCL() throws IOException {
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

    @DataProvider(name = "productUpdateDataCL")
    public Object[][] productUpdateDataProviderCL() throws IOException {
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