package tek.bdd.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseSetup {

    //Encapsulation Concept of Java

    private static WebDriver driver;
    private final String APP_URL = "https://qa.insurance.tekschool-students.com";


    public void openBrowser() {
        //Targeting Chrome Browser.
        //Creating instance of Browser and navigate for Tek insurance APP

        //Add headless option to Chrome browser
        //Headless mode: Is and option when you run a test
        // you cannot see the open and close or
        // other step process with browser in front screen,
        // it will run in background.

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get(APP_URL);


    }

    // driver.close = (will close current tab only)
    // driver.quite = (will close entire browser)
    public void driverQuit(){
       if (driver != null)
           driver.quit();
    }

    // this is encapsulations
    // Read only Getter to read get Driver instance.
    // Java Encapsulation Concept.

    public WebDriver getDriver() {
        return driver;
    }

}

