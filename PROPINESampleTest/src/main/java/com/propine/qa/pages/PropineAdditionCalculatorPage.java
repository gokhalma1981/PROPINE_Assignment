package com.propine.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.propine.qa.base.TestBase;

public class PropineAdditionCalculatorPage extends TestBase {
	
	
	//Page Factory or OR:
	@FindBy(css="input[name=firstNumber]") //css=tag[attribute=value]
	WebElement firstNumber;
	
	@FindBy(css="input[name=secondNumber]")
	WebElement secondNumber;
	
	@FindBy(css="input[type=submit]") 
	WebElement submitButton;
	
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]")
	WebElement resultsSum;
	
	
	//Initializing the Page Objects:
	public PropineAdditionCalculatorPage(){
		PageFactory.initElements(driver, this);		
	}
	
	//Actions	
	public void enterFirstNumber(String num1){
		firstNumber.sendKeys(num1);		
	}
	
	public void enterSecondNumber(String num1){
		secondNumber.sendKeys(num1);		
	}
	
	public String getFirstNumber(){
		//String firstNumberValue = firstNumber.getText();
		//String firstNumberValue = firstNumber.getAttribute("value");
		return firstNumber.getAttribute("value");
	}	
	
	public String getSecondNumber(){
		//String secondNumberValue = secondNumber.getText();
		//String secondNumberValue = secondNumber.getAttribute("value");
		return secondNumber.getAttribute("value");
	}	
	
	public String addTwoNumbers(String num1, String num2) throws InterruptedException{
		firstNumber.sendKeys(num1);
		secondNumber.sendKeys(num2);
		submitButton.click();
		Thread.sleep(2000);
		return resultsSum.getText();		
	}

	public String verifyErrorMessageForNullValueForFirstNumber(String num2) throws InterruptedException{
		//firstNumber.sendKeys(num1);
		secondNumber.sendKeys(num2);
		submitButton.click();
		Thread.sleep(2000);
		return resultsSum.getText();		
	}
	
	public String verifyErrorMessageForNullValueForSecondNumber(String num1) throws InterruptedException{
		firstNumber.sendKeys(num1);
		//secondNumber.sendKeys(num2);
		submitButton.click();
		Thread.sleep(2000);
		return resultsSum.getText();		
	}
	
	public String verifyErrorMessageForNullValuesForFirstNumberAndSecondNumber() throws InterruptedException{
		//firstNumber.sendKeys(num1);
		//secondNumber.sendKeys(num2);
		submitButton.click();
		Thread.sleep(2000);
		return resultsSum.getText();		
	}
	
}
