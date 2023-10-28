package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "src/test/java/features/cart",
	glue = "stepDef/cart",
	plugin = {"html:target/cart/HTML_Cart_report.html"},
	tags = "@Regression"
)

public class runCart {

}
