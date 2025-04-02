package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {
	
	
	public WebDriver driver;
	
	
	
	public WebDriver WebDriverManger() throws IOException
	
	{
		String projectpath = System.getProperty("user.dir"); // generating dynamic project path

		FileInputStream fis = new FileInputStream(projectpath + "/src/test/resources/global.properties");
		
		System.out.println("File path: " + System.getProperty("user.dir") + "/src/test/resources/global.properties");

		Properties prop = new Properties();
		
		prop.load(fis);
		
		String url=prop.getProperty("qaurl").trim();
		
		String browser = prop.getProperty("browser").trim();
		
		System.out.println("Browser value from properties file: [" + browser + "]");
		
			 if (driver == null) {
		            if (browser.equalsIgnoreCase("chrome")) {  // ✅ Use .equalsIgnoreCase() instead of ==
		            	WebDriverManager.chromedriver().setup();

		    			ChromeOptions options = new ChromeOptions();

		    			// options.addArguments("--headless");

		    			options.addArguments("--disable-notifications");

		    			options.addArguments("--disable-gpu");

		    			options.addArguments("--disable-extensions");

		    			options.addArguments("--no-sandbox");

		    			options.addArguments("--disable-dev-shm-usage");

		    			options.addArguments("--remote-allow-origins=*"); // this i added this and it worked, Thanks a ton xinchao
		    																// zhang !!

		    			DesiredCapabilities capabilities = new DesiredCapabilities();

		    			capabilities.setCapability(ChromeOptions.CAPABILITY, options);

		    			options.merge(capabilities);

		    			driver = new ChromeDriver(options);

		    			driver.manage().window().maximize();
		    			driver.get(url);
		            }
			
		            else if(browser.equalsIgnoreCase("firefox"))
				
			{
				//forfirefox browser
				
			}
			else {
                throw new IllegalArgumentException("Invalid browser name in global.properties:" + browser);
            }
		      driver.get(url);	
		
		 driver.manage().window().maximize();
		
		}
		
		
		
	
		return driver;
	

}}
