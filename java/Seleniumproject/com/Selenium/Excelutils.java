package Seleniumproject.com.Selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class Excelutils {
	
	
	
	public static List<Map<String, String>> getexceldata(int sheetnum) throws EncryptedDocumentException, IOException {
		List<Map<String, String>> list = null;
		FileInputStream excelToRead = null;
		try {
			excelToRead = new FileInputStream("C:\\Users\\user\\Desktop\\AutoIT\\Demo.xlsx");
			Workbook workBook =WorkbookFactory.create(excelToRead);
//			Sheet sheet = workBook.getSheet(sheetname);
			Sheet sheet = workBook.getSheetAt(sheetnum);
			DataFormatter formatter = new DataFormatter();
			Map<String, String> map = null;
			list = new ArrayList<Map<String, String>>();
			int lastRowNum = sheet.getLastRowNum();
			System.out.println(lastRowNum);
			int lastColNum = sheet.getRow(0).getLastCellNum();
			System.out.println(lastColNum);
			for (int i = 1; i <= lastRowNum; i++) {
				map = new HashMap<String,String>();
				for (int j = 0; j < lastColNum; j++) {
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
//					String value=sheet.getRow(i).getCell(j).getStringCellValue();
					String value=formatter.formatCellValue(sheet.getRow(i).getCell(j));
					map.put(key, value);
					System.out.println(map.put(key, value));
				}
				list.add(map);
				System.out.println(list.add(map));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (Objects.nonNull(excelToRead))
				try {
					excelToRead.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return list;
	
	}
	public static void main(String []args) throws EncryptedDocumentException, IOException {
		Excelutils.getexceldata(0);
	}

}
