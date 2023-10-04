package tek.bdd.steps;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import tek.bdd.pages.LoginPage;
import tek.bdd.utility.SeleniumUtility;

public class LoginSteps extends SeleniumUtility {

    @Then("Validate login section title {string}")
    public void validLoginSectionTitle(String expectedLoginTitle){
        String actualLoginTitle = getElementText(LoginPage.SECTION_TITLE);
        Assert.assertEquals("Validate login title section",
                            expectedLoginTitle,
                            actualLoginTitle);
        System.out.println("Test Pass - "+ actualLoginTitle);
    }

    @Then("Validate login button is {string}")
    public void validateLoginButtonDisabledOrEnabled(String expectedCondition){
     boolean actualCondition = isElementEnabled(LoginPage.LOGIN_BUTTON);

     if (expectedCondition.equalsIgnoreCase("enabled")){
         Assert.assertTrue("Login button should be enabled", actualCondition);
     } else if (expectedCondition.equalsIgnoreCase("disabled")){
         Assert.assertFalse("Login button should be disabled", actualCondition);
     }
        System.out.println("Test Pass- "+ actualCondition);
    }


    @When("Enter username as {string}")
    public void enterUsername(String username) {
        enterValue(LoginPage.USERNAME, username);
    }

    @When("Enter password as {string}")
    public void enterPassword(String password) {
        enterValue(LoginPage.PASSWORD, password);
    }

    @When("Click on login button")
    public void clickOnLoginButton() throws InterruptedException {
         clickOnElement(LoginPage.LOGIN_BUTTON);
         Thread.sleep(1000);
    }

    @Then("Validate logged in username is {string}")
    public void validateLoggedInUsername(String expectedUsername){
       String actualUsername = getElementText(LoginPage.LOGGED_IN_USERNAME);
       String actualUsernameReplaced = actualUsername.replace("account_circle", "").trim();
       Assert.assertEquals("Validate logged in username",
            expectedUsername,
            actualUsernameReplaced);

    }

    @Then("Validate error message {string}")
    public void validateErrorMessage (String expectedErrorMessage){
        String actualErrorMessage = getElementText(LoginPage.ERROR_BANNER);
        Assert.assertEquals("Validate error message",
                expectedErrorMessage,
                actualErrorMessage);
        System.out.println("Expected Error Message is - "+actualErrorMessage);

    }
    // In this step you can add all 3 step in one
    @Given("Login with username as {string} and password as {string}")
    public void loginWithUsernameAndPassword(String username, String password){
        enterValue(LoginPage.USERNAME,username);
        enterValue(LoginPage.PASSWORD,password);
        clickOnElement(LoginPage.LOGIN_BUTTON);
    }


}
