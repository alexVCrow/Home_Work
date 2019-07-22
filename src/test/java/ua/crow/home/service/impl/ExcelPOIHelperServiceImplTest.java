package ua.crow.home.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ua.crow.home.service.ExcelPOIHelperService;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ExcelPOIHelperServiceImplTest {

    @Autowired
    private ExcelPOIHelperService excelPOIHelperService;

    @Test
    void writeExcel() throws IOException {
        excelPOIHelperService.writeExcel();
    }
}