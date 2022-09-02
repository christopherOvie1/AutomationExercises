package com.Stepdefinition;

import com.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DownloadInvoiceAfterPurchaseOrder_T0024 extends BaseClass {

    @Test
    public void downloadInvoiceAfterPurchaseOrder() {

        String nameOfProduct = "Blue Top";
        String day = "23", month = "May", year = "2020";
        String firstName = "chris", lastName = "john", company = "abc ltd", addressLn1 = "4", addressLn2 = "abc st", country = "Canada", state = "ottawa", city = "test", zipcode = "23432", mobileNumber = "123455";

        HomePage homePage = new HomePage(driver);
        CartPage cart = new CartPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProductPage product = new ProductPage(driver);
        RegistrationPage register = new RegistrationPage(driver);
        NavigationPage navigation = new NavigationPage(driver);
        ProductDetailsPage productDetails = new ProductDetailsPage(driver);
        CommonPage common = new CommonPage(driver);
        AccountCreatedPage accountCreated = new AccountCreatedPage(driver);
        PaymentPage payment = new PaymentPage(driver);
        OrderPage order = new OrderPage(driver);
        AddressPage address = new AddressPage(driver);

        // 1 & 2
        driver.get(baseURL);
        //3. Verify that home page is visible successfully
        Assert.assertTrue(homePage.VerifyThatHomePageIsVisibleSuccessfully());

        //4. Add products to cart
        common.selectAnyProductAndLogIntoProductDetails();

        //5. Click 'Cart' button
        productDetails.clickAddToCartButton();
        product.clickViewCart();

        //6. Verify that cart page is displayed
        common.validatePageURL("cart");

        //7  7. Click Proceed To Checkout
        cart.clickProceedToCheckoutButton();

        //8. Click 'Register / Login' button
        cart.clickLoginAndRegisterLink();

//9. Fill all details in Signup and create account
        loginPage.enterRandomString();
        loginPage.enterRandomEmailField();
        loginPage.loginIntoRegistrationPage();

        register.getRadioButtons();
        register.enterPassword("ahh65bgfd");
        register.selectDateOfBirth(day, month, year);
        register.enterAddressInfo(firstName, lastName, company, addressLn1, addressLn2, country, state, city, zipcode, mobileNumber);

        // 10a. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        String actualAccCreatedText = accountCreated.verifyThatACCOUNTCREATEDIsVisible();
        String expectedAccCreatedText = "ACCOUNT CREATED!";
        Assert.assertEquals(actualAccCreatedText, expectedAccCreatedText);
        // 10a.and click 'Continue' button
        accountCreated.clickContinueButton();

        //11. Verify ' Logged in as username' at top
        boolean uname = loginPage.verifyLoggedInUsernmameVisibility();
        System.out.println(uname);
        Assert.assertTrue(uname, "username is not displayed");

        //12.Click 'Cart' button
        navigation.NavigateTo("Cart");

        //13. Click 'Proceed To Checkout' button
        cart.clickProceedToCheckoutButton();

        //14. Verify Address Details and Review Your Order
        boolean s = address.validateAddressContents();
        System.out.println("what i notice is " + s);
        Assert.assertTrue(s, "wrong");

        //15. Enter description in comment text area and click 'Place Order'
        cart.EnterDescriptionInCommentTextAreaAndClickPlaceOrder("no comment");


        //  16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        // 17. Click 'Pay and Confirm Order' button
        payment.enterEnterPaymentDetailsNameOnCardAndCardNumberCVCExpirationDate("john", "123", "34", "Jan", "2020");

        //19. Verify success message 'Your order has been placed successfully!'
        order.clickDownloadInvoiceButton();

        //20. Click 'Continue' button
        order.clickContinueButton();

        //21. Click 'Delete Account' button
        navigation.NavigateTo("Delete Account");

        //22. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        common.validatePageurl("delete_account");
    }
}