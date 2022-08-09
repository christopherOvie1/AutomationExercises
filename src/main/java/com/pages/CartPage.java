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
        PageFactory.initElements(driver,this)

        ;}
    //disabled

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

    @FindBy(xpath="//div[@class='col-xs-12 col-sm-6']")
    WebElement addresses;

    @FindBy(xpath="//div[@class='col-xs-12 col-sm-6'][1]")
    WebElement billingAddress;

    @FindBy(css="div[id='cart_info']")
    WebElement reviewYourOrderField;

    @FindBy(xpath="//*[@name='message']")
    WebElement commentSection;

    //a[contains(.,'Place Order')]

    @FindBy(xpath="//a[contains(.,'Place Order')]")
    WebElement placeOrderButton;

    @FindBy(css="input[name='name_on_card']")
    WebElement nameOfCard;

    @FindBy(css="input[name='card_number']")
    WebElement cardNumber;

    @FindBy(css="input[name='cvc']")
    WebElement cvcNumber;

    @FindBy(css="input[name='expiry_month']")
    WebElement monthExpiration;

    @FindBy(css="input[name='expiry_year']")
    WebElement yearExpiration;

    @FindBy(id="submit")
    WebElement payAndConfirmOrder;

    @FindBy(xpath="//p[contains(.,'Congratulations! Your order has been confirmed!')]")
    WebElement successMessage;

    @FindBy(css="i[class='fa fa-times']")
    WebElement xButton;



    @FindBy(xpath="//span[@id='empty_cart']//b[.='Cart is empty!']")
    WebElement productRemovedText;

    //b
    @FindBy(xpath="//ul[@id='address_delivery']/li[@class='address_firstname address_lastname']")
    WebElement firsNameAddressDelivery;

    @FindBy(xpath="//ul[@id='address_delivery']/li[@class='address_firstname address_lastname']")
    WebElement firsNameAddressDeliveryAndBilling;

    @FindBy(xpath="//ul[@id='address_delivery']/li[@class='address_city address_state_name address_postcode']")
    WebElement cityAndPostCodeAddressDelivery;















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

    public String confirmsBillingAddressSameAsDeliveryAddress(){
     deliveryAddress.getText();
    return billingAddress.getText();
      // deliveryAddress.sendKeys(DeliverAdd);
    }
    public void verifyBillingAddress(){
       billingAddress.getText();

    }

    public CartPage verifyDeliveryAddress2(String user1,String user2){
firsNameAddressDelivery.getText().equalsIgnoreCase(user1);
        cityAndPostCodeAddressDelivery.getText().equalsIgnoreCase(user2);
        return this;

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

public void enterEnterPaymentDetailsNameOnCardAndCardNumberCVCExpirationDate(String name,String cardNum,String cvc,String months,String yr){
nameOfCard.sendKeys(name);
cardNumber.sendKeys(cardNum);
    cvcNumber.sendKeys(cvc);
    monthExpiration.sendKeys(months);
    yearExpiration.sendKeys(yr);
    payAndConfirmOrder.click();
}
public String verifySuccessMessage(){
       return successMessage.getText();
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

    WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
 String f= wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='empty_cart']//b[.='Cart is empty!']"))).getText();
return f;
   // System.out.println(productRemovedText.getText());
     //  wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@id='empty_cart']//b[.='Cart is empty!']"))).
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

public void verifyAddressDelivery(String user1){
    firsNameAddressDelivery.getText().equalsIgnoreCase(user1);
    }

}
