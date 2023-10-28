package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "src/test/java/features/checkout",
	glue = "stepDef/checkout",
	plugin = {"html:target/checkout/HTML_Checkout_report.html"},
	tags = "@Regression"
)
public class runCheckout {

}
