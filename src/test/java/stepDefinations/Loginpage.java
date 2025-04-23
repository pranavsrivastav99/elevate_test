package stepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.logInpage;
import pageObjects.pageobjectManager;
import utils.Genericutils;
import utils.Testcontextsetup;

public class Loginpage {

	Testcontextsetup testcontextsetup;

	pageobjectManager pageobjectmanager;

	logInpage loginpage;

	Genericutils genericUtils;

	public Loginpage(Testcontextsetup testcontextsetup) {

		this.testcontextsetup = testcontextsetup;

		this.loginpage = testcontextsetup.pageobjectmanager.getsignInpage();

	}

	@Given("I am on the DL6 Technologies login page")
	public void i_am_on_the_dl6_technologies_login_page() {

		String expectedUrl = "https://elevateqa.vercel.app/auth/sign-in";

		String actualUrl = testcontextsetup.genericutils.currentpageurl(); // Replace with actual URL

		Assert.assertEquals(expectedUrl, actualUrl);

		System.out.println("The user is on loginPage");
	}

	@Then("I should see the {string} header")
	public void i_should_see_the_header(String expectedHeader) {

		String actualurl = loginpage.getHeadertet();

		Assert.assertEquals(expectedHeader, actualurl);
	}

	@Then("the i\\/p form should contain:")

	public void the_i_p_form_should_contain(DataTable dataTable) {
		testcontextsetup.genericutils.toVerifyIPFieldsAreAvailable(dataTable);

	}

	@Then("I should see a {string} checkbox")
	public void i_should_see_a_checkbox(String checkboxLabel) {

		testcontextsetup.genericutils.toverifyUserabletoseecheckbox();

		System.out.println("The user is able to see the remember me checkbox");
	}

	@Then("I should see a {string} link")
	public void i_should_see_a_link(String linkText) {

		testcontextsetup.genericutils.toverifyUserabletoseelinkText(linkText);

	}

	@Then("I should see a {string} button")
	public void i_should_see_a_button(String buttonText) {

		loginpage.abletoSeesignInbutton();
	}

	@Then("I should see an {string} in the password field")
	public void i_should_see_an_icon_in_the_password_field(String icon) {
		WebElement eyeIcon = testcontextsetup.pageobjectmanager.driver
				.findElement(By.xpath("//*[name()='circle' and contains(@cx,'12')]"));
		Assert.assertTrue(eyeIcon.isDisplayed());
		System.out.println("Able to see eye iicon");
	}

	@When("I enter a password {string}")
	public void i_enter_a_password(String password) {
		loginpage.enterPassword(password);

	}

	@When("I click on the {string} in the password field")
	public void i_click_on_the_eye_icon_in_the_password_field(String icon) throws InterruptedException {

		loginpage.eyeIconclick();
	}

	@Then("the password should be visible as plain text")
	public void the_password_should_be_visible_as_plain_text() throws InterruptedException {

		testcontextsetup.genericutils.toverifygiventextisPlaintext("//input[@type='text']");

	}

	@Then("the password should be masked as dots or asterisks")
	public void the_password_should_be_masked_as_dots_or_asterisks() throws InterruptedException {
		testcontextsetup.genericutils.toverifygiventextisPlaintext("//input[@id=':Rkvfbqbb:-form-item']");
	}

	@When("I enter a valid email {string}")
	public void i_enter_a_valid_email(String email) {

		loginpage.emailinputfiledx(email);
	}

	@When("I enter a valid password {string}")
	public void i_enter_a_valid_password(String password) {

		loginpage.passwordinputfield(password);
	}

	@When("I click on the {string} button")
	public void i_click_on_the_button(String buttonText) throws InterruptedException {

		loginpage.loginButton(buttonText);

//		Thread.sleep(3000);
	}

	@Then("I should be redirected to the dashboard")
	public void i_should_be_redirected_to_the_dashboard() {


		testcontextsetup.genericutils.compareToUrl("https://elevateqa.vercel.app/organization");


	}

	@When("I enter an invalid email {string}")
	public void i_enter_an_invalid_email(String email) {
		loginpage.emailinputfiledx(email);
	}

	@When("I enter an invalid password {string}")
	public void i_enter_an_invalid_password(String password) {

		loginpage.passwordinputfield(password);
	}

	@Then("I should see an error message {string}")
	public void i_should_see_an_error_message(String expectedMessage) {

		testcontextsetup.genericutils.verifythetoastMessage(expectedMessage);

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
		
		testcontextsetup.genericutils.checkBoxcheck(checkboxLabel);
		
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

		loginpage.passwordEyeIconclick();
	}
	
	@Then("I should be logged in successfully")
	public void i_should_be_logged_in_successfully() {
	    // Write code here that turns the phrase above into concrete actions
		testcontextsetup.genericutils.compareToUrl("https://elevateqa.vercel.app/organization");
		
		
	}
	@When("I close and reopen the browser")
	public void i_close_and_reopen_the_browser() {
	    // Write code here that turns the phrase above into concrete actions
		loginpage.closeandReopenbrowser();
	}
	@When("I navigate to the DL6 Technologies home page")
	public void i_navigate_to_the_dl6_technologies_home_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("I should still be logged in")
	public void i_should_still_be_logged_in() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
