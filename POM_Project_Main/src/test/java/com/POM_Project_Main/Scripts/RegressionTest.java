package com.POM_Project_Main.Scripts;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.POM_Project_Main.Utilities.ExcelRead;
import com.POM_Project_Main.constants.Constants;
import com.POM_Project_Main.pages.LoginPage;



public class RegressionTest extends BaseTest {
	LoginPage objLogin;
	 @Test(dataProvider= "InvalidUserInvalidPass",priority=1)
	  public void verifysigninInvalidEmailInvalidPassword(String email1,String password1) 
	  {
		  objLogin=new LoginPage(driver);
			objLogin.setEmail(email1);
			objLogin.setPassword(password1);
			objLogin.clickSignin();
			SoftAssert s=new SoftAssert();//Used soft Assert
			s.assertEquals(objLogin.getMessage(),Constants.infomessage);
			s.assertAll();
	  }
	  
	  
	  @Test(dataProvider= "ValiduserValidPass",priority=2)
	  public void verifysigninValidEmailValidPassword(String email1,String password1) 
	  {
		  objLogin=new LoginPage(driver);
			objLogin.setEmail(email1);
			objLogin.setPassword(password1);
			
			objLogin.clickSignin();	
			Assert.assertEquals(objLogin.sucessMessage(),Constants.sucessmessage);//Assertion
	  }
	   
  @DataProvider
  public Object[][] InvalidUserInvalidPass() throws Exception
  {
		Object[][] data=ExcelRead.getDataFromExcel(Constants.LoginCases, "InvaliduserInvalidpass");
		return data;
  }
 
  @DataProvider
  public Object[][] ValiduserValidPass() throws Exception
  {
		Object[][] data=ExcelRead.getDataFromExcel(Constants.LoginCases, "ValiduserValidpass");
		return data;
  }
}
