package com.Stepdefinition;

import com.pages.*;
import org.apache.commons.compress.utils.OsgiUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartFromRecommendedItems_T0022 extends BaseClass{

    @Test
    public void addToCartFromRecommendedItems() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        ProductPage product = new ProductPage(driver);
        ProductDetailsPage productDetails= new ProductDetailsPage(driver);
        CartPage cart =new CartPage(driver);


        //1 &2 Navigate to url 'http://automationexercise.com'
        driver.get(baseURL);

        //3. Scroll down to footer
        homePage.ScrollDownToFooter();

        //4. Verify 'RECOMMENDED ITEMS' are visible
      productDetails.validateRECOMMENDEDITEMSAreVisible("recommended items");
      System.out.println(productDetails.validateRECOMMENDEDITEMSAreVisible("recommended items"));

      //5. Click on 'Add To Cart' on Recommended product
        productDetails.clickRecommendedAddToCartButton();

       // 6. Click on 'View Cart' button
        product.clickviewCartLink();

        //7. Verify that product is displayed in cart page
        cart.verifyThatProductIsDisplayedInCartPage();
        System.out.println(cart.verifyThatProductIsDisplayedInCartPage());

        




    }
}
