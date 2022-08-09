package com.Stepdefinition;

import com.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DownloadInvoiceAfterPurchaseOrder_T0024 extends BaseClass{

    @Test
    public void downloadInvoiceAfterPurchaseOrder(){

        String nameOfProduct="Blue Top";

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProductPage product = new ProductPage(driver);
        RegistrationPage register = new RegistrationPage(driver);
        NavigationPage navigation = new NavigationPage(driver);

        //2
        driver.get(baseURL);
        //3. Verify that home page is visible successfully
        Assert.assertTrue(homePage.VerifyThatHomePageIsVisibleSuccessfully());

      //4. Add products to cart
       // product.typeProductNameInSearchBar(nameOfProduct);
        product.addProductToCart();

    }
}
