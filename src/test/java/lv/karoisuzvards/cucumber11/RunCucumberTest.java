package lv.karoisuzvards.cucumber11;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "json:build/reports/cucumber.json"},
        features = "src/test/resources/features",
        glue = "lv.karoisuzvards.cucumber11.stepdefs"
)
public class RunCucumberTest {
}