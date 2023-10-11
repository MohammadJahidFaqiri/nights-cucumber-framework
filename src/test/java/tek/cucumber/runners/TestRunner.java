package tek.cucumber.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features", // location of feature files.
        glue = "tek.bdd.steps", // package for steps definitions
        tags = "@Smoke",
<<<<<<< HEAD
        dryRun = true, // if true wont run steps just check for un implemented steps
=======
        dryRun = false, // if true wont run steps just check for un implemented steps
>>>>>>> 04519ccbf85d6ba455ceb3f153e64d4257b5e802
        plugin = {
                "pretty",
                "html:target/htmlReports/cucumber-pretty.html" // location of html report
        }
)
public class TestRunner {

}
