package tek.bdd.steps;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import tek.bdd.pages.AccountsPage;
import tek.bdd.utility.SeleniumUtility;

import java.util.List;

public class AccountSteps extends SeleniumUtility {

        @Then("Validate accounts table have {int} rows")
        public void validateAccountTableRows(int expectedRows) {
            List<WebElement>  tableRowsElements = getListOfElements(AccountsPage.TABLE_ROWS);
            Assert.assertEquals("Validate Account Table row " ,
                    expectedRows,
                    tableRowsElements.size());

    }

    @When("change item per page to {string}")
    public void ChangeItemPerPage(String itemPerPage) {
            //first  click  to open dropdown
       clickOnElement(AccountsPage.ITEM_PER_PAGE_SELECT);
      List<WebElement> itemPerPageOptions = getListOfElements(AccountsPage.ITEM_PER_PAGE_OPTION);

      for (WebElement element : itemPerPageOptions){
          System.out.println(element.getText());
          if (element.getText().contains(itemPerPage)) {
              element.click();
                  System.out.println("Test test test");
          }
      }


    }


}

