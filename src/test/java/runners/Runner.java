package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:src/test/resources/reports/default-cucumber-reports.html",//html:target/default-cucumber-reports.html
                "json:src/test/resources/reports/json-reports/cucumber.json",//json:target/json-reports/cucumber.json
                "junit:src/test/resources/reports/xml-report/cucumber.xml",//junit:target/xml-report/cucumber.xml
                "rerun:src/test/resources/reports/failed_scenarios.txt"//rerun:target/failed_scenarios.txt
        },
        monochrome = true,
        features = "./src/test/resources/features/UI_features",
        glue = {"stepdefinitions","hooks"},
        tags = "@homepage",
        dryRun = false
)

public class Runner {

}
