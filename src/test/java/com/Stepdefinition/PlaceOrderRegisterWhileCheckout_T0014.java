package com.Stepdefinition;

import com.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaceOrderRegisterWhileCheckout_T0014 extends BaseClass{



    @Test
    public void placeOrderRegisterWhileCheckout() throws InterruptedException {

        //Test data
        String day= "23",month="May",year="2020";
        String firstName= "chris", lastName="john",company = "abc ltd",addressLn1="4",addressLn2= "abc st",country = "Canada",state= "ottawa",city="test",zipcode="23432",mobileNumber="123455";
        String nameOnCard ="John", cardNumber = "345",cvc="123",expirationMonth ="January",expirationYear ="2023";
        String gender = "Mr";

        HomePage homePage = new HomePage(driver);
        NavigationPage navigation = new NavigationPage(driver);
        ProductPage product = new ProductPage(driver);
        CommonPage common = new CommonPage(driver);
        CartPage cart =new CartPage(driver);
        AccountCreatedPage accountCreated= new AccountCreatedPage(driver);
        RegistrationPage register = new RegistrationPage(driver);
        ProductDetailsPage productDetails= new ProductDetailsPage(driver);
        AddressPage address = new AddressPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        PaymentPage payment = new PaymentPage(driver);

        //1 &2 Navigate to url 'http://automationexercise.com'
        driver.get(baseURL);

        //3  Verify that home page is visible successfully
        System.out.println(homePage.VerifyThatHomePageIsVisibleSuccessfully());
        Assert.assertTrue(homePage.VerifyThatHomePageIsVisibleSuccessfully());

          //4. Add products to cart
        common.selectAnyProductAndLogIntoProductDetails();
        productDetails.clickAddToCartButton();

        //. 5. Click 'Cart' button
        product.clickViewCart();

        //7 Verify that cart page is displayed
        //common.validatePageURL("view_cart");
        common.validatePageURL("cart");

        //7. Click Proceed To Checkout
        cart.clickProceedToCheckoutButton();

        //8. Click 'Register / Login' button
        cart.clickLoginAndRegisterLink();

        //9a Fill all details in Signup and create account
        loginPage.enterRandomString();
        loginPage.enterRandomEmailField();

        //9b Fill all details in Signup and create account
        loginPage.loginIntoRegistrationPage();

        address.clickMrOrMrsRadioButton(gender);
        register.enterPassword("ahh65bgfd");

        register.selectDateOfBirth(day,month,year);
        register.enterAddressInfo(firstName,lastName, company,addressLn1,addressLn2,country,state,city,zipcode,mobileNumber);

      //10 . Verify 'ACCOUNT CREATED!' and click 'Continue' button
        String actualAccCreatedText=  accountCreated.verifyThatACCOUNTCREATEDIsVisible();
        String expectedAccCreatedText = "ACCOUNT CREATED!";
        Assert.assertEquals(actualAccCreatedText,expectedAccCreatedText);
        accountCreated.clickContinueButton();


        //11. Verify ' Logged in as username' at top
        boolean status= loginPage.verifyThatLoggedusernameIsVisible();
        if(status){
            System.out.println("logged in user is visible");
        }
        else{
            System.out.println("logged in user is not visible");
        }
        Assert.assertTrue(loginPage.verifyThatLoggedusernameIsVisible());

        //12.Click 'Cart' button
        navigation.NavigateTo("Cart");

        //13. Click 'Proceed To Checkout' button
        cart.clickProceedToCheckoutButton();


        //14. Verify Address Details and Review Your Order
        boolean addressFound = address.validateAddressContents();
        System.out.println("Address found is  " + addressFound);
        Assert.assertTrue(addressFound, "Adrress found is wrong");

        // 15. Enter description in comment text area and click 'Place Order'
        cart.EnterDescriptionInCommentTextAreaAndClickPlaceOrder("no comment");

        //16&17 Enter payment details: Name on Card, Card Number, CVC, Expiration date
        payment.enterEnterPaymentDetailsNameOnCardAndCardNumberCVCExpirationDate(nameOnCard, cardNumber, cvc, expirationMonth, expirationYear);

        //18. Verify success message 'Your order has been placed successfully!'
       // Thread.sleep(5000);
     // String succMessage=  cart.verifySuccessMessaging();
      // System.out.println(succMessage);

     //19. Click 'Delete Account' button
        navigation.NavigateTo("Delete Account");
    }


}
