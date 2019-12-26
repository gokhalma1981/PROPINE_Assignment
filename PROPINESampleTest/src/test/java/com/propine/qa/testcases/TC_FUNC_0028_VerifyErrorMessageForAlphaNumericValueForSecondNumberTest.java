package com.propine.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.propine.qa.base.TestBase;
import com.propine.qa.pages.PropineAdditionCalculatorPage;
import com.propine.qa.util.TestUtil;

public class TC_FUNC_0028_VerifyErrorMessageForAlphaNumericValueForSecondNumberTest extends TestBase{
	
	PropineAdditionCalculatorPage propAddCalPage;
	String sheetName = "TC_FUNC_0028";
	
	public TC_FUNC_0028_VerifyErrorMessageForAlphaNumericValueForSecondNumberTest(){
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
	public void TC_FUNC_0028_verifyErrorMessageForAlphaNumericValueForSecondNumberTest(String first_num, String second_num, String error_message) throws InterruptedException{
		String errorMessage = propAddCalPage.addTwoNumbers(first_num, second_num);
		//System.out.println(error_message);		
		//System.out.println(errorMessage);
		
		Assert.assertEquals(errorMessage, error_message, "Error Message verification for alpha-numeric value for Second Number - FAILED");
	}	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}	

}
