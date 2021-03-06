package com.propine.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.propine.qa.base.TestBase;
import com.propine.qa.pages.PropineAdditionCalculatorPage;
import com.propine.qa.util.TestUtil;

public class TC_FUNC_0018_VerifyAdditionOfNegativeFloatAndNegativeIntNumbersTest extends TestBase{
	
	PropineAdditionCalculatorPage propAddCalPage;
	String sheetName = "TC_FUNC_0018";
	
	public TC_FUNC_0018_VerifyAdditionOfNegativeFloatAndNegativeIntNumbersTest(){
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
	public void TC_FUNC_0018_verifyAdditionOfNegativeFloatAndNegativeIntNumbersTest(String first_num, String second_num, String sum) throws InterruptedException{
		String resultsSum = propAddCalPage.addTwoNumbers(first_num, second_num);
		//System.out.println(sum);		
		//System.out.println(resultsSum);
		
		Assert.assertEquals(resultsSum, sum, "Addition of negative float and negative integer numbers - FAILED");
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}	


}
