package basemodule;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
									features="src/test/resources/features",
									plugin={"pretty","html:target/cucumber-html-report","json:target/cucmber-json-report.json"},
									tags={})
public class RuncukeTest {

}
