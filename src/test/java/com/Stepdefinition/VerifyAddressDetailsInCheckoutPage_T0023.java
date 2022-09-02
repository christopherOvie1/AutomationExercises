package com.Stepdefinition;

import com.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyAddressDetailsInCheckoutPage_T0023 extends BaseClass{

    @Test
    public void verifyAddressDetailsInCheckoutPage() throws InterruptedException {

        String day= "23",month="May",year="2020";
        String firstName= "chris", lastName="john",company = "abc ltd",addressLn1="4",addressLn2= "abc st",country = "Canada",state= "ottawa",city="test",zipcode="23432",mobileNumber="123455";
        HomePage homePage = new HomePage(driver);
        NavigationPage navigation = new NavigationPage(driver);
        ProductDetailsPage productDetails= new ProductDetailsPage(driver);
        ProductPage product = new ProductPage(driver);
        CommonPage common = new CommonPage(driver);
        CartPage cart =new CartPage(driver);
        AddressPage address= new AddressPage(driver);
        AccountCreatedPage accountCreated= new AccountCreatedPage(driver);
        RegistrationPage register = new RegistrationPage(driver);

        LoginPage loginPage = new LoginPage(driver);


        //2
        driver.get(baseURL);

        //3. Verify that home page is visible successfully
        Assert.assertTrue(homePage.VerifyThatHomePageIsVisibleSuccessfully());

        //4 .Click on 'Signup / Login' button  //Signup / Login
        navigation.NavigateTo("Signup / Login");

        //5. Fill all details in Signup and create account
        loginPage.enterRandomString();
        loginPage.enterRandomEmailField();
        loginPage.loginIntoRegistrationPage();

        register.getRadioButtons();
        register.enterPassword("ahh65bgfd");
        register.selectDateOfBirth(day,month,year);
        register.enterAddressInfo(firstName,lastName, company,addressLn1,addressLn2,country,state,city,zipcode,mobileNumber);

        //6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        String actualAccCreatedText=  accountCreated.verifyThatACCOUNTCREATEDIsVisible();
        String expectedAccCreatedText = "ACCOUNT CREATED!";
        Assert.assertEquals(actualAccCreatedText,expectedAccCreatedText);

        accountCreated.clickContinueButton();

        //7. Verify ' Logged in as username' at top
        boolean status= loginPage.verifyThatLoggedusernameIsVisible();
        if(status){
            System.out.println("logged in user is visible");
        }
        else{
            System.out.println("logged in user is not visible");
        }
        Assert.assertTrue(loginPage.verifyThatLoggedusernameIsVisible());
//or
        boolean uname =  loginPage.verifyLoggedInUsernmameVisibility();
        System.out.println(uname);
        Assert.assertTrue(uname,"username is not displayed");

     //8. Add products to cart
        common.selectAnyProductAndLogIntoProductDetails();

        //9. Click 'Cart' button
        productDetails.clickAddToCartButton();
        product.clickViewCart();

        //10. Verify that cart page is displayed
        common.validatePageURL("cart");

        //11. Click Proceed To Checkout
        cart.clickProceedToCheckoutButton();

        //12. Verify that the delivery address is same address filled at the time registration of account
        boolean addressFound = address.validateAddressContents();
        System.out.println("Address found is  " + addressFound);
        Assert.assertTrue(addressFound, "Adrress found is wrong");

        //14. Click 'Delete Account' button
        navigation.NavigateTo("Delete Account");
    }
}
