package com.propine.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.propine.qa.base.TestBase;
import com.propine.qa.pages.PropineAdditionCalculatorPage;
import com.propine.qa.util.TestUtil;

public class TC_FUNC_0013_VerifyAdditionOfPositiveIntAndPositiveFloatNumbersTest extends TestBase{
	
	PropineAdditionCalculatorPage propAddCalPage;
	String sheetName = "TC_FUNC_0013";
	
	public TC_FUNC_0013_VerifyAdditionOfPositiveIntAndPositiveFloatNumbersTest(){
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
	public void TC_FUNC_0013_verifyAdditionOfPositiveIntAndPositiveFloatNumbersTest(String first_num, String second_num, String sum) throws InterruptedException{
		String resultsSum = propAddCalPage.addTwoNumbers(first_num, second_num);
		//System.out.println(sum);		
		//System.out.println(resultsSum);
		
		Assert.assertEquals(resultsSum, sum, "Addition of positive integer and positive float numbers - FAILED");
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}	

}
