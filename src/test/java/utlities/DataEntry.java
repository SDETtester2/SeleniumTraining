package utlities;

import org.testng.annotations.DataProvider;

public class DataEntry {

	@DataProvider (name = "register")
	public Object[][] dataset(){
		
		return new Object[][] {{"tester1","tester1@gmail.com"},{"tester2","tester2@gmail.com"}};
	
	}
	
}
