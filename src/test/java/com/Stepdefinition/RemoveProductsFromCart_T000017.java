package com.Stepdefinition;

//import com.pages.HomePage;
//import com.pages.NavigationPage;
import com.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveProductsFromCart_T000017 extends BaseClass{

    @Test
    public void removeProductsFromCart() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        CommonPage common = new CommonPage(driver);
        NavigationPage navigation = new NavigationPage(driver);
        // ContactUsPage contactUs = new ContactUsPage(driver);
        CartPage cart =new CartPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProductPage product = new ProductPage(driver);
        ProductDetailsPage productDetails= new ProductDetailsPage(driver);

        //HomePage homePage = new HomePage(driver);
       ///// NavigationPage navigation = new NavigationPage(driver);
//1 &2 Navigate to url 'http://automationexercise.com'
        driver.get(baseURL);

        //3  Verify that home page is visible successfully
        System.out.println(homePage.VerifyThatHomePageIsVisibleSuccessfully());
        Assert.assertTrue(homePage.VerifyThatHomePageIsVisibleSuccessfully());
//4. Add products to cart
        common.selectAnyProductAndLogIntoProductDetailsPge("Blue Top");

        //5. Click 'Cart' button
        productDetails.clickAddToCartButton();
        product.clickViewCart();

        //6. Verify that cart page is displayed
        common.validatePageURL("cart");
        //Thread.sleep(5000);
        //7. Click 'X' button corresponding to particular product
        cart.ClickXButtonCorrespondingToParticularProduct();

//8. Verify that product is removed from the cart

        System.out.println(cart.verifyRemoval());
      String actualMessage=  cart.verifyRemoval();
      String expectedMessage= "Cart is empty!";
      Assert.assertEquals(actualMessage,expectedMessage,actualMessage + "does not match" + expectedMessage);

    }
}
