package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CartPage {

    public static WebDriver driver;
   WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver=driver;
        wait= new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver,this);
    }

//web elements
    @FindBy(css="button[class='disabled']")
    WebElement exactQuantity;

    @FindBy(xpath="h2[class='title text-center']> b")
    WebElement bothAddedProducts;

    @FindBy(xpath="//u[contains(.,'Register / Login')]")
    WebElement loginAndRegisterLink;

    @FindBy(css="a[class='btn btn-default check_out']")
    WebElement proceedToCheckoutButton;

    @FindBy(xpath="//div[@class='col-xs-12 col-sm-6'][1]")
    WebElement deliveryAddress;

    @FindBy(xpath="//div[@class='col-xs-12 col-sm-6'][1]")
    WebElement billingAddress;

    @FindBy(css="div[id='cart_info']")
    WebElement reviewYourOrderField;

    @FindBy(xpath="//*[@name='message']")
    WebElement commentSection;

    @FindBy(xpath="//a[contains(.,'Place Order')]")
    WebElement placeOrderButton;

    @FindBy(xpath="//div[contains(.,'Your order has been placed successfully!')]")
   // @FindBy(xpath="//p[contains(.,'Congratulations! Your order has been confirmed!')]")
   // @FindBy(xpath="//div[contains(.,'Your order has been placed successfully!')]//div[@class='alert-success alert']")
    WebElement successMessage;
    //div[contains(.,'Your order has been placed successfully!')]

    @FindBy(css="i[class='fa fa-times']")
    WebElement xButton;

    @FindBy(xpath="//span[@id='empty_cart']//b[.='Cart is empty!']")
    WebElement productRemovedText;

    @FindBy(css = "td[class='cart_description']")
    WebElement displayedProduct;


//actions
   public boolean verifyBothProductsAreAddedToCart() {

        List<WebElement> bothAddedProduct = driver.findElements(By.xpath("//tbody/tr"));
       System.out.println("bothAddedProduct.size : "+bothAddedProduct.size());
        boolean contentTypeAllMatch = true;
        for (WebElement itemsAdded : bothAddedProduct) {

      /*   if (itemsAdded.isDisplayed()) {
             System.out.println("product added products are found");
             System.out.println("items found are "+ "  "+itemsAdded.getText());
         }*/
    if(itemsAdded.getText().equalsIgnoreCase("Blue Top && Men Tshirt"))
        itemsAdded.isDisplayed();
            System.out.println("items found are "+ "  "+itemsAdded.getText());
        }
        return contentTypeAllMatch;
    }
public void clickLoginAndRegisterLink(){
       loginAndRegisterLink.click();
}

public String verifythatproductisdisplayedincartpagewithexactquantity(){
    return   exactQuantity.getText();
    }


    public void verifyBillingAddress(){
       billingAddress.getText();

    }

    public void verifyDeliveryAddress(){
       deliveryAddress.getText();
    }
    public void verifyAddressIsSame(String addressType){
       switch (addressType.toLowerCase()){
           case "billingAddress":
               verifyBillingAddress();

           case "deliveryAddress":
               verifyDeliveryAddress();
           default:
               System.out.println("not implemented");
       }
    }
public  List<String> getAddressSectionList(){

       List<String> addressList= new ArrayList<>();
       List<WebElement> addressHeaderList =driver.findElements(By.xpath("//div[@class='col-xs-12 col-sm-6']"));
       for(WebElement e: addressHeaderList){
     String text=   e.getText();
           System.out.println(text);
           addressList.add(text);
       }
       return addressList;
}

    public String validateReviewYourOrder(){
      return reviewYourOrderField.getText();
    }
public void clickProceedToCheckoutButton(){
       proceedToCheckoutButton.click();
}


public void EnterDescriptionInCommentTextAreaAndClickPlaceOrder(String message){
    commentSection.sendKeys(message);
    placeOrderButton.click();
}

public String verifySuccessMessage(){
    // return   successMessage.getText();
    return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(.,'Your order has been placed successfully!')]//div[@class='alert-success alert']"))).getText();

}

public void verifySuccessfulText(){
        //successMessage.isDisplayed();
}
public void  ClickXButtonCorrespondingToParticularProduct(){
  //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
  //  WebElement elem_gplay_btn = wait.until(ExpectedConditions.elementToBeClickable(xButton));
  //  elem_gplay_btn.click();
    wait.until(ExpectedConditions.elementToBeClickable(xButton)).click();

}
public String verifyThatProductIsRemovedFromTheCart(){
 //  String x=  productRemovedText.getText();
 // return x;

    WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
 String f= wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='empty_cart']//b[.='Cart is empty!']"))).getText();
return f;

}

public String vaidateRemoved(){
    WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
    String element= wait3.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='empty_cart']//b[.='Cart is empty!']"))).getText();
    return element;
}

public  String  verifyRemoval(){

     // wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@id='empty_cart']//b[.='Cart is empty!']")))
   return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='empty_cart']//b[.='Cart is empty!']"))).getText();
}

    public  String verifySuccessMessageThankYouForYourReview(){
return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='form-row']"))).getText();
    }

    public String verifyThatProductIsDisplayedInCartPage(){
       String c=displayedProduct.getText();
        System.out.println(c);
        return c;
    }

    public String verifySuccessfulMessageText(){
        String d = successMessage.getText();
        System.out.println(d);
        return d;
    }
}
