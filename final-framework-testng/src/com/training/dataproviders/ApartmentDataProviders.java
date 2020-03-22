package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.ApartmentBean;
import com.training.bean.LoginBean;
import com.training.dao.ApartmentDAO;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class ApartmentDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<ApartmentBean> list = new ApartmentDAO().getApartmentQueryDetails(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(ApartmentBean temp : list){
			Object[]  obj = new Object[4]; 
			obj[0] = temp.getYourName(); 
			obj[1] = temp.getYourEmail(); 
			obj[2] = temp.getSubject(); 
			obj[3] = temp.getMessage(); 

			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:/Users/Naveen/Desktop/Testing.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName); 
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1"); 
	}
	@DataProvider(name = "dataprovider_TC068")
	public Object[][] dataprovider_TC068(){
		String fileName ="C:\\Users\\SushmaPandey\\Desktop\\selenium\\TC_60_testdata.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName); 
	}
	@DataProvider(name = "dataprovider_TC069")
	public Object[][] dataprovider_TC069(){
		String fileName ="C:\\Users\\SushmaPandey\\Desktop\\selenium\\TC_61_testdata.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName); 
	}
	
}
