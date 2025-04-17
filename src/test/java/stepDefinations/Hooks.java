package stepDefinations;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.Testcontextsetup;

public class Hooks {

	Testcontextsetup textcontextsetup;

	public Hooks(Testcontextsetup testcontextsetup) {

		this.textcontextsetup = testcontextsetup;

	}

	@After
	public void AfterScenario() throws IOException {// it'll close the browser after every scenario

		textcontextsetup.testbase.WebDriverManger().quit();

	}

	@AfterStep // for run the bellow screenshot method for every step so it capture if any test
	// case fail
	public void AddScreenshot(Scenario scenario) throws IOException// method to capture the screenshot for the test
	// failure

	{

		WebDriver driver = textcontextsetup.testbase.WebDriverManger();

		if (scenario.isFailed()) {

			/* scenario.log("scenario failed"); */
// screenshot
			File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(fileContent, "image/png", "image");
		}

	}

}
