package Seleniumproject.com.Selenium;

public class Practice {

	public static void main(String[] args) {
		System.out.println("program started");
		
		try {
			Integer I=new Integer("abc");
			System.out.println("program complited");
		} catch (Exception e) {
			System.out.println("exception caught");
		}
	}

}
