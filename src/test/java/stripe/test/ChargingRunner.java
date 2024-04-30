package stripe.test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

    @CucumberOptions(
            features = "src/test/java/stripe/test/Charging.feature",
            glue = {"stripe/test"},
            plugin = {"html:reports/Charging-Report.html"},
            monochrome = true
    )

    public class ChargingRunner  extends AbstractTestNGCucumberTests {
    }

