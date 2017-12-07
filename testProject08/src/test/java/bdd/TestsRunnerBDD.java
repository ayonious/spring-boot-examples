package bdd;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "bdd",
        strict = true,
        snippets = SnippetType.CAMELCASE,
        tags = {"~@ignore"},
        plugin = {"pretty", "html:target/cucumber", "junit:target/surefire-reports/bdd.xml"}
)
public class TestsRunnerBDD {

}