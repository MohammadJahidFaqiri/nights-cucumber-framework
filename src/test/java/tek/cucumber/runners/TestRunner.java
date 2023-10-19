package tek.cucumber.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features", // location of feature files.
        glue = "tek.bdd.steps", // package for steps definitions
        tags = "@US_04",

       // dryRun = true, // if true wont run steps just check for un implemented steps

        dryRun = false, // if true wont run steps just check for un implemented steps

        plugin = {

                "html:target/html_Reports/report.html", // location of html report
                "json:target/jsonReports/report.json"
        }
)
public class TestRunner {

}
