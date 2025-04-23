package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.Testcontextsetup;

public class logInpage {

	public WebDriver driver;
	
	public Testcontextsetup testcontextsetup;
	

	@FindBy(xpath = "//button[@type='submit']")
	WebElement buttonClick;

	@FindBy(xpath = "//div[@class='px-4 sm:px-8 py-1 text-[30px] font-bold text-white']")
	WebElement header;

	@FindBy(name = "password")
	WebElement passwordField;

	@FindBy(xpath = "//button[@class='absolute right-2 top-1/2 -translate-y-1/2 transform text-muted-foreground']//*[name()='svg']")
	WebElement eyeIcon;

	@FindBy(xpath="//button[@class='absolute right-2 top-1/2 -translate-y-1/2 transform text-muted-foreground']//*[name()='svg']")
	WebElement passWordeyeIcon;

	@FindBy(xpath="//button[@type='submit']")
	WebElement signInbutton;

	@FindBy(name="email")
	WebElement emailinputField;



	public logInpage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	public void abletoSeesignInbutton() {


		Assert.assertTrue(signInbutton.isDisplayed());

	}

	public void eyeIconclick() throws InterruptedException {

		eyeIcon.click();

//		Thread.sleep(4000);
	}

	public void passwordEyeIconclick() {

		passWordeyeIcon.click();
	}

	public void loginButton(String string) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		buttonClick.click();

//		Thread.sleep(3000);

	}

	public String getHeadertet() {

		String headerText = header.getText();

		return headerText;

	}

	public void enterPassword(String string) {

		passwordField.sendKeys(string);

	}

	public void emailinputfiledx(String string) {

		emailinputField.sendKeys(string);

	}

	public void passwordinputfield(String string) {


		passwordField.sendKeys(string);


	}
	
public void closeandReopenbrowser() {
	
	driver.quit();
	
	testcontextsetup.driver.get("https://elevateqa.vercel.app/");
	
	testcontextsetup.driver.getCurrentUrl();
	
	
	
	
}

}
