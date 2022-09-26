package com.POM_Project_Main.Scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.POM_Project_Main.constants.Constants;
import com.POM_Project_Main.pages.HomePage;



public class SanityTest extends BaseTest{
	HomePage objHome;
	  @Test(priority=3)
	  public void addClient() {
		  
		  objHome=new HomePage(driver);
		  objHome.clickAddButton();
		  objHome.clickAddClientButton();
		  objHome.addClientDetails();
		  Assert.assertEquals(objHome.clientNameAddedScuceefully(),Constants.ClientName);
	  }
}
