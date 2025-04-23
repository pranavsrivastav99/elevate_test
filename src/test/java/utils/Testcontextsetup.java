package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.logInpage;
import pageObjects.pageobjectManager;

public class Testcontextsetup {


	public WebDriver driver;

	public logInpage Loginpage;

	public pageobjectManager pageobjectmanager;

	public TestBase testbase;

	public Genericutils genericutils;






	public Testcontextsetup() throws IOException {

		testbase= new TestBase();

		pageobjectmanager = new pageobjectManager(testbase.WebDriverManger());

		genericutils = new Genericutils(testbase.WebDriverManger());

	}


}
