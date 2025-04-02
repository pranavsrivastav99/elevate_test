package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features",glue="stepDefinations",monochrome=true,dryRun=false,tags="@test")
public class TestNGtestRunner extends AbstractTestNGCucumberTests{
	
	

	
	
}
