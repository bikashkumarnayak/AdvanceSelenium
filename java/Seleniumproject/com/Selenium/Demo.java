package Seleniumproject.com.Selenium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Demo {

	public static void main(String[] args) {
		String a = "AMAZONORDERID-12345678";
		String count=a.replaceAll("\\s", "");
		String[] split=a.split("");
		List<String> list=Arrays.asList(split);
//		Map<String,Integer>=new HashMap<K, V>();
		Map<String, Long> map=list.stream().
				collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(map);


	}

}
