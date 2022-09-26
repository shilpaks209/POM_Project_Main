package com.POM_Project_Main.Scripts;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.POM_Project_Main.Utilities.ExcelRead;
import com.POM_Project_Main.constants.Constants;
import com.POM_Project_Main.pages.LoginPage;






public class LoginTest extends BaseTest 
{
	LoginPage login;
	  @Test(dataProvider= "validUserInvalidPass",priority=1)
	  public void verifysigninValidEmailInvalidPassword(String email1,String password1) 
	  {
		login=new LoginPage(driver);
		login.setEmail(email1);
		login.setPassword(password1);
		login.clickSignin();
		
Assert.assertEquals(login.getMessage(),Constants.infomessage);
		
	  }
	  @Test(dataProvider= "InvalidUserValidPass",priority=2)
	  public void verifysigninInvalidEmailValidPassword(String email1,String password1) 
	  {
		  login=new LoginPage(driver);
		  login.setEmail(email1);
		  login.setPassword(password1);
		  login.clickSignin();
			Assert.assertEquals(login.getMessage(),Constants.infomessage);
			
	  }
	  @Test(dataProvider= "InvalidUserInvalidPass",groups= {"Sanity Test"},priority=3)
	  public void verifysigninInvalidEmailInvalidPassword(String email1,String password1) 
	  {
		  login=new LoginPage(driver);
		  login.setEmail(email1);
		  login.setPassword(password1);
		  login.clickSignin();
			SoftAssert s=new SoftAssert();//Used soft Assert
			s.assertEquals(login.getMessage(),Constants.infomessage);
			s.assertAll();
	  }
	  
	  
	  @Test(dataProvider= "ValiduserValidPass",groups= {"Sanity Test"},priority=4)
	  public void verifysigninValidEmailValidPassword(String email1,String password1) 
	  {
		  login=new LoginPage(driver);
		  login.setEmail(email1);
		  login.setPassword(password1);
			
		  login.clickSignin();	
			Assert.assertEquals(login.sucessMessage(),Constants.sucessmessage);//Assertion
	  }
	   
	  @DataProvider
	  public Object[][] validUserInvalidPass() throws Exception
	  {
			Object[][] data=ExcelRead.getDataFromExcel(Constants.LoginCases, "ValiduserInvalidpass");
			return data;
	}
	  @DataProvider
	  public Object[][] InvalidUserValidPass() throws Exception
	  {
			Object[][] data=ExcelRead.getDataFromExcel(Constants.LoginCases, "InvaliduserValidPass");
			return data;
	  }
	  @DataProvider
	  public Object[][] InvalidUserInvalidPass() throws Exception
	  {
			Object[][] data=ExcelRead.getDataFromExcel(Constants.LoginCases, "InvaliduserInvalidpass");
			return data;
	  }
	  @DataProvider
	  public Object[][] BlankUser() throws Exception
	  {
			Object[][] data=ExcelRead.getDataFromExcel(Constants.LoginCases, "Blank");
			return data;
	  }
	  @DataProvider
	  public Object[][] ValiduserValidPass() throws Exception
	  {
			Object[][] data=ExcelRead.getDataFromExcel(Constants.LoginCases, "ValiduserValidpass");
			return data;
	  }
	}  
	  
  

