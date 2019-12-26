package com.propine.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.propine.qa.base.TestBase;
import com.propine.qa.pages.PropineAdditionCalculatorPage;
import com.propine.qa.util.TestUtil;

public class TC_FIELD_0001_VerifyFirstNumberForNumericValuesTest extends TestBase{
	
	PropineAdditionCalculatorPage propAddCalPage;
	String sheetName = "TC_FIELD_0001";
	
	public TC_FIELD_0001_VerifyFirstNumberForNumericValuesTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		propAddCalPage = new PropineAdditionCalculatorPage();	
	}
	
	
	@DataProvider
	public Object[][] getTestData(){
		Object data [][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider="getTestData")
	public void TC_FIELD_0001_verifyFirstNumberForNumericValuesTest(String first_num) throws InterruptedException{
		propAddCalPage.enterFirstNumber(first_num);
		//Thread.sleep(3000);
		String firstNumberValue = propAddCalPage.getFirstNumber();
		//System.out.println("Entered Number is " + firstNumberValue);
		Assert.assertEquals(firstNumberValue, first_num, "Field verification for Numeric Values - FAILED");
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}	
	

}
