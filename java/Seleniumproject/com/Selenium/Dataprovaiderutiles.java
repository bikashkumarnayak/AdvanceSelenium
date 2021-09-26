package Seleniumproject.com.Selenium;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;

public class Dataprovaiderutiles {
	
	private static List<Map<String,String>> list=new ArrayList<>();
	@DataProvider
	public static Object[] getData(Method m) throws EncryptedDocumentException, IOException {
		String Testname=m.getName();
		if(list.isEmpty()) {
		list=Excelutils.getexceldata(0);
		}
		List<Map<String,String>> smallist=new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).get("Testname").equalsIgnoreCase(Testname) 
					&& list.get(i).get("execute").equalsIgnoreCase("yes")) {
				smallist.add(list.get(i));	
			}
		}
		return smallist.toArray();
	}
	

}
