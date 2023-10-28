package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "src/test/java/features/login",
	glue = "stepDef/login",
	plugin = {"html:target/login/HTML_Login_report.html"},
	tags = "@Regression"
)

public class runLogin {
	
}