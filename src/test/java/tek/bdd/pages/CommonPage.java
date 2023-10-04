package tek.bdd.pages;

import org.openqa.selenium.By;

public class CommonPage {

 public final static By pageTitle = By.xpath("//mat-toolbar/span[1]");

 //Static method that returns By object
 public static By getLinkLocator(String linkText){
  return By.partialLinkText(linkText);



 }

 }
