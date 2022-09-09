package com.Stepdefinition;

import com.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaceOrderRegisterBeforeCheckout_T0015 extends BaseClass{


    @Test
    public void placeOrderRegisterBeforeCheckout() throws InterruptedException {

        //Test data
        String clothes = "Fancy Green Top";
        String day= "23",month="May",year="2020";
        String firstName= "chris", lastName="john",company = "abc ltd",addressLn1="4",addressLn2= "abc st",country = "Canada",state= "ottawa",city="test",zipcode="23432",mobileNumber="123455";
        String nameOnCard ="John", cardNumber = "345",cvc="123",expirationMonth ="January",expirationYear ="2023";
        String gender = "Mr";

        HomePage homePage = new HomePage(driver);
        NavigationPage navigation = new NavigationPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProductPage product = new ProductPage(driver);
        CommonPage common = new CommonPage(driver);
        CartPage cart =new CartPage(driver);
        AccountCreatedPage accountCreated= new AccountCreatedPage(driver);
        RegistrationPage register = new RegistrationPage(driver);
        ProductDetailsPage productDetails= new ProductDetailsPage(driver);
        AddressPage address = new AddressPage(driver);
        PaymentPage payment = new PaymentPage(driver);
        OrderPage order = new OrderPage(driver);


        //2
        driver.get(baseURL);
        //3. Verify that home page is visible successfully
        Assert.assertTrue(homePage.VerifyThatHomePageIsVisibleSuccessfully());

        //4 .Click on 'Signup / Login' button  //Signup / Login
        /// homePage.goToLoginPage();
        navigation.NavigateTo("Signup / Login");

        //5. Fill all details in Signup and create account
        loginPage.enterRandomString();
        loginPage.enterRandomEmailField();
        //7 click sign up button
        loginPage.loginIntoRegistrationPage();


        //6 AND 7 Verify 'ACCOUNT CREATED!' and click 'Continue' button


        address.clickMrOrMrsRadioButton(gender);
        register.enterPassword("ahh65bgfd");

        register.selectDateOfBirth(day,month,year);
        register.enterAddressInfo(firstName,lastName, company,addressLn1,addressLn2,country,state,city,zipcode,mobileNumber);

        String actualAccCreatedText=  accountCreated.verifyThatACCOUNTCREATEDIsVisible();
        String expectedAccCreatedText = "ACCOUNT CREATED!";
        Assert.assertEquals(actualAccCreatedText,expectedAccCreatedText);

        accountCreated.clickContinueButton();

// 8. Verify ' Logged in as username' at top
        loginPage.verifyThatLoggedusernameIsVisible();

        //8 Add products to cart
        common.selectAnyProductAndLogIntoProductDetails();
        productDetails.clickAddToCartButton();


      //9. Click 'Cart' button
        product.clickViewCart();

        //10. Verify that cart page is displayed
        common.validatePageURL("cart");

        //11. Click Proceed To Checkout
        cart.clickProceedToCheckoutButton();

        //12a. Verify Address Details and Review Your Order
        boolean addressFound = address.validateAddressContents();
        System.out.println("Address found is  " + addressFound);
        Assert.assertTrue(addressFound, "Adrress found is wrong");

        //12b order.reviewYourOrderText();
        Assert.assertTrue(order.reviewYourOrderText());
        System.out.println(order.reviewYourOrderText());

        //12. Enter description in comment text area and click 'Place Order'
        cart.EnterDescriptionInCommentTextAreaAndClickPlaceOrder("no comment");

 //14. & 15 Enter payment details: Name on Card, Card Number, CVC, Expiration date
        payment.enterEnterPaymentDetailsNameOnCardAndCardNumberCVCExpirationDate(nameOnCard, cardNumber, cvc, expirationMonth, expirationYear);

//16. Verify success message 'Your order has been placed successfully!'
        /*String actualSuccessMessage=  cart.verifySuccessMessage();
        String expectedSuccessMessage= "Your order has been placed successfully!";
        System.out.println(actualSuccessMessage);*/
    //Assert.assertEquals(actualSuccessMessage,expectedSuccessMessage);

      //  payment.verifySuccessMessages();

        //17. Click 'Delete Account' button
        navigation.NavigateTo("Delete Account");
    }
}
