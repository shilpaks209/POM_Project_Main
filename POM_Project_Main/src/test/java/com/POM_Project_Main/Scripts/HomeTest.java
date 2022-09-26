package com.POM_Project_Main.Scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.POM_Project_Main.constants.Constants;
import com.POM_Project_Main.pages.HomePage;

public class HomeTest extends BaseTest{
	HomePage home;
  @Test(priority=5,groups= {"Sanity Test"})
  public void addClient() {
	  
	  home=new HomePage(driver);
	  home.clickAddButton();
	  home.clickAddClientButton();
	  home.addClientDetails();
	  Assert.assertEquals(home.clientNameAddedScuceefully(),Constants.ClientName);
  }
}
