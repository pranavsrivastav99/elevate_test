package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class logInpage {

	public WebDriver driver;
	
	public logInpage(WebDriver driver) {
		
		
		this.driver=driver;
		
		
	}
	
	By login = By.xpath("//button[@type='submit']");	
	
	
	
	public void loginButon(String string) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(login).click();
		
		Thread.sleep(3000);

	}
	
	
	
	public void inputFieldonThegiveninputNamebox(String string1,String string2) {
		
		
		driver.findElement(By.name(string2)).sendKeys(string1);
		
		
		
	}
}
