package ua.crow.home.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public interface ExcelPOIHelperService {

    ByteArrayInputStream writeExcel() throws IOException;

}
