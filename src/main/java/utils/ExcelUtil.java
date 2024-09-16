package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public final class ExcelUtil {

	private ExcelUtil() {}
	
	public List<Map<String, String>> getData(String sheetName) {
		List<Map<String, String>> list = null;
		
		try {
			FileInputStream excelfile = new FileInputStream("");
			try (XSSFWorkbook workbook = new XSSFWorkbook(excelfile)) {
				XSSFSheet sheet = workbook.getSheet(sheetName);
				
				int rowLastNum = sheet.getLastRowNum();
				int colLastNum = sheet.getRow(0).getLastCellNum();
				DataFormatter format = new DataFormatter();
				
				list = new ArrayList<>();
				Map<String, String> map;
				
				for(int row=1; row<=rowLastNum; row++) {
					map = new HashMap<>();
					for(int col=0; col<colLastNum; col++) {
						String key = sheet.getRow(0).getCell(col).toString();
						String value = format.formatCellValue(sheet.getRow(row).getCell(col));
						map.put(key, value);
					}
					list.add(map);
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;		
	}
}
