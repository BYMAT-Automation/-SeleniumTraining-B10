package testPackage;

import co.in.bymat.seleniumTraining.ExcelReader;

public class ReadingExcelFile {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		//ExcelReader excel = new ExcelReader("D:\\BYMAT-Learn_Automation\\WorkSpace\\WorkSpace_Photon\\SeleniumTraining_B10_B11_MVN\\src\\test\\resources\\testData\\Master_Sheet.xlsx");
		// System.out.println(System.getProperty("user.dir"));
		
	ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\Master_Sheet.xlsx");
		
		System.out.println(excel.getColumnCount("Test_Data"));
		
		//excel.addColumn("TestData", "NewColumn1");

	//  excel.addSheet("NewSheet");
	
//		System.out.println(excel.getCellData("TestData", 3, 2));
//		
//		System.out.println(excel.getCellData("TestData", 3, 4));
//		
//		System.out.println(excel.getCellData("TestData", "Phone_Numer", 3));
//		
//		excel.setCellData("TestData", "Phone_Numer", 4, "99999999");
		
	//	excel.removeSheet("Test_Data");
	}

}
