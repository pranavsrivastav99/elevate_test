package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.pageobjectManager;

public class Testcontextsetup {

	
	public WebDriver driver;
	
	public String loginpage;
	
	public pageobjectManager pageobjectmanager;
	
	public TestBase testbase;
	
	
	
	
	public Testcontextsetup() throws IOException {
		
		testbase= new TestBase();
		
		pageobjectmanager = new pageobjectManager(testbase.WebDriverManger());
		
	}
	
	
}
