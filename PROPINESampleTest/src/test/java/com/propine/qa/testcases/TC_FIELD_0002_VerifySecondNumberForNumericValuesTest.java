package com.propine.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.propine.qa.base.TestBase;
import com.propine.qa.pages.PropineAdditionCalculatorPage;
import com.propine.qa.util.TestUtil;

public class TC_FIELD_0002_VerifySecondNumberForNumericValuesTest extends TestBase{
	
	PropineAdditionCalculatorPage propAddCalPage;
	String sheetName = "TC_FIELD_0002";
	
	public TC_FIELD_0002_VerifySecondNumberForNumericValuesTest(){
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
	public void TC_FIELD_0002_verifySecondNumberForNumericValuesTest(String second_num) throws InterruptedException{
		propAddCalPage.enterSecondNumber(second_num);
		//Thread.sleep(3000);
		String secondNumberValue = propAddCalPage.getSecondNumber();
		//System.out.println("Entered Number is " + secondNumberValue);
		Assert.assertEquals(secondNumberValue, second_num, "Field verification for Numeric Values - FAILED");
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}	

}
