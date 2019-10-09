package lv.karoisuzvards.cucumber11;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "pretty",
        features = "src/test/resources/features",
        glue = "lv.karoisuzvards.cucumber11.stepdefs"
)
@ComponentScan("lv.karoisuzvards.cucumber11")
public class RunCucumberTest
{
}