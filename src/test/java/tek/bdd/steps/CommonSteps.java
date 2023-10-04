package tek.bdd.steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import org.openqa.selenium.By;
import tek.bdd.pages.CommonPage;
import tek.bdd.utility.SeleniumUtility;


public class CommonSteps extends SeleniumUtility {

    @Given("Open browser and navigate")
    public void openBrowserAndNavigate(){
       // System.out.println("Open browser and navigate");
        openBrowser();
    }


    @Then("Validate application title should be {string}")
    public void validatePageTitle(String expectedPageTitle){
       // System.out.println("Validate application title should be "+ expectedPageTitle);

        //To Validate we can use JUnit Assert Class org.junit.Assert,
        String actualAppTitle = getDriver().getTitle();
        Assert.assertEquals("Application Title Validation",
                expectedPageTitle,
                actualAppTitle);


    }
    @Then("Close browser")
    public void closeBrowser(){
        driverQuit();
        //System.out.println("Close browser");
    }


    @Then("Validate the header title is {string}")
    public void validateHeaderTitle(String expectedPageTitle ) {
        //instead of this we have created a class (CommonPage) = (By pageTitleLocator = By.xpath("//mat-toolbar/span[1]"));
        String actualHeaderTitle = getElementText(CommonPage.pageTitle);
        Assert.assertEquals("Validate header title",
                            expectedPageTitle,
                            actualHeaderTitle);
        System.out.println("Test Pass - " + actualHeaderTitle);

    }
    @When("Wait {int} Second")
    public void waitInSecond(Integer seconds) {
        try {
            Thread.sleep(70 * 1000 );
        }catch (InterruptedException e){
            Assert.fail("Interrupted Exception Happened on wait step");
        }

    }
    @When("Click on {string} Link")
    public void clickOnLink(String linkTexts){
        By locator = CommonPage.getLinkLocator(linkTexts);
        clickOnElement(locator);

    }


}
