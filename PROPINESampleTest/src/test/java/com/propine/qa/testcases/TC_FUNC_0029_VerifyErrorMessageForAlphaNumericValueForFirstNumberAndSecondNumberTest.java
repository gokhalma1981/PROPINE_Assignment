package com.propine.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.propine.qa.base.TestBase;
import com.propine.qa.pages.PropineAdditionCalculatorPage;
import com.propine.qa.util.TestUtil;

public class TC_FUNC_0029_VerifyErrorMessageForAlphaNumericValueForFirstNumberAndSecondNumberTest extends TestBase{
	
	PropineAdditionCalculatorPage propAddCalPage;
	String sheetName = "TC_FUNC_0029";
	
	public TC_FUNC_0029_VerifyErrorMessageForAlphaNumericValueForFirstNumberAndSecondNumberTest(){
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
	public void TC_FUNC_0029_verifyErrorMessageForAlphaNumericValueForFirstNumberAndSecondNumberTest(String first_num, String second_num, String error_message1, String error_message2) throws InterruptedException{
		String errorMessage = propAddCalPage.addTwoNumbers(first_num, second_num);
		//System.out.println(error_message);		
		//System.out.println(errorMessage1);
		//System.out.println(errorMessage2);
		
		Assert.assertTrue(errorMessage.contains(error_message1), "Error Message verification for alpha-numeric value for First Number - FAILED");
		Assert.assertTrue(errorMessage.contains(error_message2), "Error Message verification for alpha-numeric value for Second Number - FAILED");
	}	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}	

}
