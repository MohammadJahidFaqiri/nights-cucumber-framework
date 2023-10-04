package tek.bdd.steps;


import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import tek.bdd.utility.SeleniumUtility;



public class Hooks extends SeleniumUtility {

    //annotate (@Before)(@After)
    //This Hook will be executed by cucumber
    //Before and After scenario.

    @Before
    public void setUpTest(){

        openBrowser();
    }

   // This Hook will run after each step and attach screenshot to the report.
   // @AfterStep
   // public void takeScreenshotAfterEachStep(Scenario scenario){
   //byte[] screenshot = takeScreenshot();
    // scenario.attach(screenshot, "image/png","screenshot");
    // }

    @After
    public void cleanUpTest(Scenario scenario){

        if (scenario.isFailed()) {
           // Somehow attached screenshot of failure
           // Step 1) Take Screenshot with selenium.
         TakesScreenshot screenshot = (TakesScreenshot) getDriver();

           // for cucumber reports output type should Byte[]
         byte[] picture = screenshot.getScreenshotAs(OutputType.BYTES);


           // Step 2) Attached screenshot to scenario
          scenario.attach(picture, "image/png", "Screenshot");
        }

        driverQuit();
   }
}
