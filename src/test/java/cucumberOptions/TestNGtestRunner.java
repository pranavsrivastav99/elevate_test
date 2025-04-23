package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features",glue="stepDefinations",monochrome=true,dryRun=false,tags="@test",

plugin = { "html:target/cucumber.html", "json:target/cucumber.json",
"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" 

})

public class TestNGtestRunner extends AbstractTestNGCucumberTests {

}
