package utils;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;








public class Genericutils {
	
	public WebDriver driver;
	
	public Genericutils(WebDriver driver) {
		
		
		this.driver = driver;

		PageFactory.initElements(driver, this);
		
		
		// TODO Auto-generated constructor stub
	}


	public String currentpageurl() {
		return driver.getCurrentUrl();
	}

	

public void compareToUrl(String expected) {
    
    // 1. Wait until URL contains the expected part (or you can use urlToBe if it's full match)
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    wait.until(ExpectedConditions.urlContains(expected));

    // 2. Get the current URL
    String actual = driver.getCurrentUrl();
    System.out.println("Actual URL: " + actual);
    System.out.println("Expected URL Part: " + expected);

    // 3. Assert it contains the expected value
    Assert.assertTrue(actual.contains(expected), 
        "Current URL does not contain the expected value.");
}
	public void toverifygiventextisPlaintext(String string) throws InterruptedException {
		
		
	
		WebElement passwordField=driver.findElement(By.xpath(string));
		
		
		String fieldType = passwordField.getDomAttribute("type");
	    System.out.println("Field type is: " + fieldType);
		
	    Assert.assertTrue(
	            fieldType.equalsIgnoreCase("text") || fieldType.equalsIgnoreCase("password"), "Expected type to be either 'text' or 'password', but found: " + fieldType);
		   
		
		}
	
	public void toverifyUserabletoseelinkText(String string) {
		
		
		WebElement link = driver.findElement(By.linkText(string));
		
		Assert.assertTrue(link.isDisplayed());
		
	}
public void toverifyUserabletoseecheckbox() {
		
		
		WebElement checkbox = driver.findElement(By.xpath("//*[@role='checkbox']"));
		
		Assert.assertTrue(checkbox.isDisplayed());
		
	}

public void toVerifyIPFieldsAreAvailable(io.cucumber.datatable.DataTable dataTable) {// to verify if all the input fields are avaliable or not on the given screen
    List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

    for (Map<String, String> row : rows) {
        String field = row.get("Field").trim();
        String expectedPlaceholder = row.get("Placeholder").trim();

        try {
            // Convert field name to lowercase to match the 'name' attribute
            WebElement inputField = driver.findElement(By.name(field.toLowerCase()));

            String actualPlaceholder = inputField.getDomAttribute("placeholder");
            if (actualPlaceholder != null) {
                actualPlaceholder = actualPlaceholder.trim();
            }

            Assert.assertEquals(actualPlaceholder, expectedPlaceholder,
                    "Mismatch in placeholder for field: " + field);
        } catch (NoSuchElementException e) {
            Assert.fail("Input field with name '" + field.toLowerCase() + "' not found.");
        }
    }
}


public void verifythetoastMessage(String string) {
	
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	 
	 
	 WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Invalid email or password')]")));

	
	
	
	Assert.assertEquals(string, errorMsg.getText());
	
	
}






	
	
	
	



}
