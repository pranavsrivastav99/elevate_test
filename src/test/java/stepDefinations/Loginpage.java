package stepDefinations;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.var;
import pageObjects.pageobjectManager;
import pageObjects.logInpage;
import utils.Testcontextsetup;

public class Loginpage {

	

	Testcontextsetup testcontextsetup;
	
	pageobjectManager pageobjectmanager;
	
	
	

	public Loginpage(Testcontextsetup testcontextsetup) {

		this.testcontextsetup = testcontextsetup;
		
	

	}
	
	 @Given("I am on the Hardwood Technologies login page")
	    public void i_am_on_the_hardwood_technologies_login_page() {
		 
		 String expectedUrl="https://elevateqa.vercel.app/auth/sign-in";
		 
		
		 
		 String actualUrl=testcontextsetup.pageobjectmanager.driver.getCurrentUrl(); // Replace with actual URL
		 
		 Assert.assertEquals(expectedUrl, actualUrl);
		 
		 System.out.println("The user is on loginPage");
	    }
	

    @Then("I should see the {string} header")
    public void i_should_see_the_header(String expectedHeader) {
        WebElement header = testcontextsetup.pageobjectmanager.driver.findElement(By.xpath("//div[@class='px-4 sm:px-8 py-1 text-[30px] font-bold text-white']"));
        System.out.println(header.getText());
        Assert.assertEquals(expectedHeader, header.getText());
    }



    @Then("the i\\/p form should contain:")
    public void the_i_p_form_should_contain(io.cucumber.datatable.DataTable dataTable) {
    	 List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

    	    for (Map<String, String> row : rows) {
    	        String field = row.get("Field");
    	        String expectedPlaceholder = row.get("Placeholder").trim(); // Trim spaces

    	        WebElement inputField = testcontextsetup.pageobjectmanager.driver.findElement(By.name(field.toLowerCase()));

    	        // Retrieve placeholder and trim spaces
    	        String actualPlaceholder = inputField.getDomAttribute("placeholder");
    	        if (actualPlaceholder != null) {
    	            actualPlaceholder = actualPlaceholder.trim();
    	        }

//    	      Debugging: Print values again to check for hidden differences
//    	        System.out.println("Field: " + field);
//    	        System.out.println("Expected Placeholder: [" + expectedPlaceholder + "]");
//    	        System.out.println("Actual Placeholder: [" + actualPlaceholder + "]");

    	        // Assert after normalizing whitespace
    	        Assert.assertEquals(actualPlaceholder, expectedPlaceholder, 
    	            "Placeholder mismatch for field: " + field);
    	    }
    }
    

    @Then("I should see a {string} checkbox")
    public void i_should_see_a_checkbox(String checkboxLabel) {
        WebElement checkbox = testcontextsetup.pageobjectmanager.driver.findElement(By.xpath("//*[@role='checkbox']"));
        Assert.assertTrue(checkbox.isDisplayed());
    }

    @Then("I should see a {string} link")
    public void i_should_see_a_link(String linkText) {
        WebElement link = testcontextsetup.pageobjectmanager.driver.findElement(By.linkText(linkText));
        Assert.assertTrue(link.isDisplayed());
    }

    @Then("I should see a {string} button")
    public void i_should_see_a_button(String buttonText) {
        WebElement button = testcontextsetup.pageobjectmanager.driver.findElement(By.xpath("//*[@class='flex items-center justify-center']"));
        Assert.assertTrue(button.isDisplayed());
    }

    @Then("I should see an {string} in the password field")			
    public void i_should_see_an_icon_in_the_password_field(String icon) {
        WebElement eyeIcon = testcontextsetup.pageobjectmanager.driver.findElement(By.xpath("//*[name()='circle' and contains(@cx,'12')]"));
        Assert.assertTrue(eyeIcon.isDisplayed());
        System.out.println("Able to see eye iicon");
    }

    @When("I enter a password {string}")
    public void i_enter_a_password(String password) {
        WebElement passwordField = testcontextsetup.pageobjectmanager.driver.findElement(By.name("password"));
        passwordField.sendKeys(password);
    }

    @When("I click on the {string} in the password field")
    public void i_click_on_the_eye_icon_in_the_password_field(String icon) throws InterruptedException {
    	
    	
        WebElement eyeIcon = testcontextsetup.pageobjectmanager.driver.findElement(By.xpath("//*[name()='circle' and contains(@cx,'12')]"));
    
        eyeIcon.click();
    }

    @Then("the password should be visible as plain text")
    public void the_password_should_be_visible_as_plain_text() {
        WebElement passwordField = testcontextsetup.pageobjectmanager.driver.findElement(By.name("password"));
        Assert.assertEquals("text", passwordField.getDomAttribute("type"));
    }

    @Then("the password should be masked as dots or asterisks")
    public void the_password_should_be_masked_as_dots_or_asterisks() {
        WebElement passwordField = testcontextsetup.pageobjectmanager.driver.findElement(By.name("password"));
        Assert.assertEquals("password", passwordField.getDomAttribute("type"));
    }

    @When("I enter a valid email {string}")
    public void i_enter_a_valid_email(String email) {
        WebElement emailField = testcontextsetup.driver.findElement(By.name("email"));
        emailField.sendKeys(email);
    }

    @When("I enter a valid password {string}")
    public void i_enter_a_valid_password(String password) {
        WebElement passwordField = testcontextsetup.driver.findElement(By.name("password"));
        passwordField.sendKeys(password);
    }

    @When("I click on the {string} button")
    public void i_click_on_the_button(String buttonText) {
        WebElement button = testcontextsetup.driver.findElement(By.xpath("//button[text()='" + buttonText + "']"));
        button.click();
    }

    @Then("I should be redirected to the dashboard")
    public void i_should_be_redirected_to_the_dashboard() {
        Assert.assertEquals("https://example.com/dashboard", testcontextsetup.driver.getCurrentUrl());
    }

    @When("I enter an invalid email {string}")
    public void i_enter_an_invalid_email(String email) {
        WebElement emailField = testcontextsetup.driver.findElement(By.name("email"));
        emailField.sendKeys(email);
    }

    @When("I enter an invalid password {string}")
    public void i_enter_an_invalid_password(String password) {
        WebElement passwordField = testcontextsetup.driver.findElement(By.name("password"));
        passwordField.sendKeys(password);
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String expectedMessage) {
        WebElement errorMsg = testcontextsetup.driver.findElement(By.cssSelector(".error-message"));
        Assert.assertEquals(expectedMessage, errorMsg.getText());
    }

    @When("I leave the email field empty")
    public void i_leave_the_email_field_empty() {
        WebElement emailField = testcontextsetup.driver.findElement(By.name("email"));
        emailField.clear();
    }

    @When("I leave the password field empty")
    public void i_leave_the_password_field_empty() {
        WebElement passwordField = testcontextsetup.driver.findElement(By.name("password"));
        passwordField.clear();
    }

    @When("I check the {string} checkbox")
    public void i_check_the_checkbox(String checkboxLabel) {
        WebElement checkbox = testcontextsetup.driver.findElement(By.id("remember-me"));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    @Then("my login session should be remembered")
    public void my_login_session_should_be_remembered() {
        // Verify session persistence (may need cookies or localStorage verification)
        Assert.assertTrue(testcontextsetup.driver.manage().getCookies().size() > 0);
    }

    @When("I click on the {string} link")
    public void i_click_on_the_link(String linkText) {
        WebElement link = testcontextsetup.driver.findElement(By.linkText(linkText));
        link.click();
    }

    @Then("I should be redirected to the password recovery page")
    public void i_should_be_redirected_to_the_password_recovery_page() {
        Assert.assertEquals("https://example.com/forgot-password", testcontextsetup.driver.getCurrentUrl());
    }

    @When("I click on {string}")
    public void i_click_on(String linkText) {
        WebElement link = testcontextsetup.driver.findElement(By.linkText(linkText));
        link.click();
    }

    @Then("I should be redirected to the signup page")
    public void i_should_be_redirected_to_the_signup_page() {
        Assert.assertEquals("https://example.com/signup", testcontextsetup.driver.getCurrentUrl());
    }
    
    @When("I click on the {string} again")
    public void i_click_on_the_eye_icon_again(String icon) {
        WebElement eyeIcon = testcontextsetup.driver.findElement(By.cssSelector(".password-eye-icon"));
        eyeIcon.click();
    }

}
