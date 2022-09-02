package com.Stepdefinition;

import com.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaceOrderLoginBeforeCheckout_T0016 extends BaseClass{


   @Test
    public void placeOrderLoginBeforeCheckout() {


       String email = "christophodibo@yahoo.com";
       String password= "Father60";
       String clothes = "Fancy Green Top";
       String nameOnCard ="John", cardNumber = "345",cvc="123",expirationMonth ="January",expirationYear ="2023";


       HomePage homePage = new HomePage(driver);
      CommonPage common = new CommonPage(driver);
       NavigationPage navigation = new NavigationPage(driver);
       CartPage cart =new CartPage(driver);
      LoginPage loginPage = new LoginPage(driver);
       ProductPage product = new ProductPage(driver);
      ProductDetailsPage productDetails= new ProductDetailsPage(driver);
      PaymentPage payment = new PaymentPage(driver);


       //1 &2 Navigate to url 'http://automationexercise.com'
       driver.get(baseURL);


       //3  Verify that home page is visible successfully
       System.out.println(homePage.VerifyThatHomePageIsVisibleSuccessfully());
       Assert.assertTrue(homePage.VerifyThatHomePageIsVisibleSuccessfully());
//4. Click 'Signup / Login' button
       navigation.NavigateTo("Signup / Login");

      // 5. Fill email, password and click 'Login' button
       loginPage.loginAsValidUser(email,password);

       //6. Verify 'Logged in as username' at top
       loginPage.verifyThatLoggedusernameIsVisible();

       //7. Add products to cart
       product.AddProductsToCart();

       //8. Click 'Cart' button
       productDetails.clickAddToCartButton();
       product.clickViewCart();

     //  9. Verify that cart page is displayed
       common.validatePageURL("cart");
       //10. Click Proceed To Checkout
       cart.clickProceedToCheckoutButton();

//11. Verify Address Details and Review Your Order
       String add= cart.confirmsBillingAddressSameAsDeliveryAddress();
       System.out.println(add);
       String v=  cart.validateReviewYourOrder();
       System.out.println(v);

       // 12. Enter description in comment text area and click 'Place Order'
       cart.EnterDescriptionInCommentTextAreaAndClickPlaceOrder("no comment");

  //13&14 Enter payment details: Name on Card, Card Number, CVC, Expiration date
       payment.enterEnterPaymentDetailsNameOnCardAndCardNumberCVCExpirationDate(nameOnCard, cardNumber, cvc, expirationMonth, expirationYear);


       //15. Verify success message 'Your order has been placed successfully!'

       String actualSuccessMessage=  cart.verifySuccessMessage();
       String expectedSuccessMessage = "Congratulations! Your order has been confirmed!";
       System.out.println(actualSuccessMessage);
       Assert.assertEquals(expectedSuccessMessage,actualSuccessMessage);

       //16. Click 'Delete Account' button
       navigation.NavigateTo("Delete Account");
   }
}
