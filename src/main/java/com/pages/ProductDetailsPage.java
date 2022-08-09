package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductDetailsPage {

    public static WebDriver driver;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "div[class='single-products']")
    WebElement searchedProduct;

    @FindBy(css = "div[class='product-information']>h2")
    WebElement productName;

    @FindBy(css = "div[class='product-information']>p")
    WebElement productCategory;

    @FindBy(css = "span > span")
    WebElement productPrice;

    @FindBy(xpath = "//p[contains(.,'Availability: In Stock')]")
    WebElement productAvailability;
////*[contains(text(),'(New)')]
    // @FindBy(xpath="//div[2]/div/p[3]/text()")

    @FindBy(xpath = "//p[contains(.,'Condition: New')]")
    WebElement productCondition;

    @FindBy(xpath = "//p[contains(.,'Brand: Polo')]")
    WebElement productBrand;

    @FindBy(css = "li[class='active']>a")
    WebElement writeYourReviewText;
////h2[contains(.,'recommended items')]
    //Subscription   //h2[contains(.,'Subscription')]

    @FindBy(css = "#name")
    WebElement nameField;

    @FindBy(css = "#email")
    WebElement emailField;

    @FindBy(css = "#review")
    WebElement reviewField;

    @FindBy(css = "button[class*='btn-default cart']")
    WebElement addToCartButton;

    @FindBy(css = "h2[class='title text-center']")
    WebElement womenTopProductText;



    public void isProductDetailsVisible() {
        productName.isDisplayed();
        // String productNam =  productName.getText();
        //System.out.println(productNam);
        System.out.println(productName.getText());

        productCategory.isDisplayed();
        System.out.println(productCategory.getText());

        productPrice.isDisplayed();
        System.out.println(productPrice.getText());

        productAvailability.isDisplayed();
        System.out.println(productAvailability.getText());

        productCondition.isDisplayed();
        System.out.println(productCondition.getText());

        productBrand.isDisplayed();
        System.out.println(productBrand.getText());
    }


    public boolean VerifySEARCHEDPRODUCTSisVisible() {
        return searchedProduct.isDisplayed();
    }

    public String verifyWriteYourReviewText() {
        return writeYourReviewText.getText();
    }

    public void EnterNameEmailAndReview(String names, String emails, String reviews) {
        nameField.sendKeys(names);
        emailField.sendKeys(emails);
        reviewField.sendKeys(reviews);
    }

    public String validateRECOMMENDEDITEMSAreVisible(String section) {
        // Reporting.Log.AppendLine("Navigating to " + section);
        //WebElement sectionSelector = By.XPath("//span[contains(.,'" + section + "')]");
        // Interactions.Click(sectionSelector);
        WebElement homePageElement = driver.findElement(By.xpath("//h2[contains(.,'" + section + "')]"));
        return homePageElement.getText();
    }

    /*  public void  verifyAllTheProductsRelatedToSearchAreVisible(String topSection)
      {
  //div[class='product-image-wrapper']>div>div>p
          List<WebElement> allBrand =  driver.findElements(By.xpath("//p[contains(.,'" + topSection + "')] "));
         // allBrand.get(i).getText();
          for(WebElement Item: allBrand){
              Item.getText();
          }*/
    //}
    public void getAllSimilarProductNames() {


        List<WebElement> itemNeeded = driver.findElements(By.xpath("//p[contains(.,'Top')]"));
        boolean contentTypeAllMatch = true;
        // Printing all similar items Without stream
        for (WebElement item : itemNeeded) {
             System.out.println(item.getText());
        }

    }
    public void clickAddToCartButton(){
        addToCartButton.click();
    }

    public String confirmTextWOMENTOPSPRODUCTS(){
      return  womenTopProductText.getText();
    }

}
