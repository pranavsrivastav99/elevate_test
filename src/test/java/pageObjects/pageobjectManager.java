package pageObjects;

import org.openqa.selenium.WebDriver;

public class pageobjectManager {
	
	
	
	
	public logInpage signInpage;
	
	public homePage hOmepage;
	public WebDriver driver;
	
	
	public pageobjectManager(WebDriver driver) {
		
		this.driver= driver;
		
		
	}
	
	public logInpage getsignInpage() {
		
		
		signInpage=new logInpage(driver);
		
		return signInpage;
		
		
	}
	
	
	public homePage homePage() {
		
		
	hOmepage=new homePage();
		
	return hOmepage;
	
	
		
	}

}
