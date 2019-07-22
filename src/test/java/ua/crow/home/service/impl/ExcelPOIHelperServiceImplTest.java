package ua.crow.home.service.impl;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ua.crow.home.service.ExcelPOIHelperService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ExcelPOIHelperServiceImplTest {

    @Autowired
    private ExcelPOIHelperService excelPOIHelperService;

    @Test
    void writeExcel() throws IOException {
        Workbook wb = WorkbookFactory.create(excelPOIHelperService.writeExcel());
        Sheet sheet = wb.getSheetAt(0);
        Map<Integer, List<String>> data = new HashMap<>();
        int i = 0;
        for (Row row : sheet) {
            data.put(i, new ArrayList<String>());
            for (Cell cell : row) {
                System.out.println(cell.getStringCellValue());
            }
            i++;
        }
    }
}