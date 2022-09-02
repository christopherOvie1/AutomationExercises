package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class ProductDetailsPage {

    public static WebDriver driver;
  WebDriverWait wait;
    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//web elements
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

    @FindBy(css = "#button-review")
    WebElement submitButton;





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

//web actions
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
    public void clickSubmitButton(){
        submitButton.click();
    }


    public void clickRecommendedAddToCartButton(){

        List<WebElement> recommendedAddToClick = driver.findElements(By.xpath("//div[@id='recommended-item-carousel']//a[@class='btn btn-default add-to-cart']"));
        Random rand= new Random();
     int randomRecommendedAddToClick = rand.nextInt(recommendedAddToClick.size());//getting a random value between 0 and size
        recommendedAddToClick.get(randomRecommendedAddToClick).click();
    }

}
