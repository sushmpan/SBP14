package com.training.sanity.tests;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.ApartmentBean;
import com.training.connection.GetConnection;
import com.training.dao.ApartmentDAO;
import com.training.utility.LoadDBDetails;

public class LoginDBTest
{  public static void main(String args[])throws IOException 
	{
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
	System.out.println(result);
	for(Object[] a:result)
	{
		for(Object b:a)
		{
			System.out.println(b);
		}
	
} }
public List<ApartmentBean> getApartmentQueryDetails() throws IOException{
	Properties properties = new Properties();
	FileInputStream inStream = new FileInputStream("./resources/sql.properties");
	properties.load(inStream);
	String sql = properties.getProperty("get.apartmentDetails"); 
	
	GetConnection gc  = new GetConnection(); 
	List<ApartmentBean> list = null;
	try {
		gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
		list = new ArrayList<ApartmentBean>(); 
		
		gc.rs1 = gc.ps1.executeQuery(); 
		
		while(gc.rs1.next()) {
		
			ApartmentBean temp = new ApartmentBean(); 
			temp.setYourName(gc.rs1.getString(1));
			temp.setYourEmail(gc.rs1.getString(2));
			temp.setSubject(gc.rs1.getString(3));
			temp.setMessage(gc.rs1.getString(4));


			list.add(temp); 
			
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return list; 
}



} 


