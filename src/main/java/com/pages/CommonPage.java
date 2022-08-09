package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class CommonPage {
    public static WebDriver driver;

    public CommonPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);}

    public boolean validatePageURL(String pageName) {;
        return  driver.getCurrentUrl().endsWith(pageName);
    }

        public boolean validatePageurl(String urlPart) {;
        return  driver.getCurrentUrl().contains(urlPart);
    }
    @FindBy(css ="div[class='productinfo text-center'] p")
    List<WebElement> viewAllItems;

    public void selectAnyProductAndLogIntoProductDetailsPge(String ele) {

        String itemsNeeded[]={"Blue Top","Men Tshirt","Sleeveless Dress","Stylish Dress","Winter Top"};
        List <String>myItemsNeededInList=Arrays.asList(itemsNeeded);
        List<WebElement> allProductsButton = viewAllItems;
    int f=    viewAllItems.size();

        for (int i = 0; i < allProductsButton.size(); i++) {
            allProductsButton.get(i).getText();
        }
       if (myItemsNeededInList.contains(ele)){
           //selecting the fifth product
           driver.findElements(By.xpath("//ul[@class='nav nav-pills nav-justified']/li")).get(4).click();
          // driver.findElement(By.xpath("//ul[@class='nav nav-pills nav-justified']/li")).click();
        }
    }
////div[@class='col-sm-6']//h2[contains(.,'Full-Fledged practice website for Automation Engineers')]
    public boolean validateURL(String url) {
       return driver.getCurrentUrl().endsWith(url);
    }

   public void AddtoCartJourneys() throws InterruptedException {
       String[] additems = {"Blue Top", "Men Tshirt"};
       //Get all your products in a list

       List<WebElement> allProduct=driver.findElements(By.cssSelector("div[class='productinfo text-center'] p"));
//Get all Products count
     int products_count =  allProduct.size();
       System.out.println("products_count is "+products_count );
       //iterate through products list
       for(int i=0; i<products_count;i++) {
       String x=    allProduct.get(i).getText();
           System.out.println(x);
}
  /*     if(products_count == 0){
   /* int a=0;
    while(a<3){
       // a++;
        //click add to cart element
        driver.findElement(By.cssSelector(".choose > .nav.nav-justified.nav-pills  a")).click();
        //a=3;
        a++;  */
           driver.findElement(By.cssSelector(".choose > .nav.nav-justified.nav-pills  a")).click();
          // System.out.println("Blue Top");
    //   }
           //click add to cart element if product found in index
       }


   public  void getDifferentProducts() {
        int j = 0;
       String[] expectedProducts = {"Blue Top", "Men Tshirt", "Sleeveless Dress"};
        List<WebElement> allProductName=driver.findElements(By.cssSelector("div[class='productinfo text-center'] p"));
       // ArrayList<String> obj = new ArrayList<String>(Arrays.asList(expectedProducts));
        //System.out.println("Elements Present in ArrayList are :"+obj);

        for(int i = 0;i<allProductName.size();i++){
            j++;
            String name=   allProductName.get(i).getText();

            if(name.contains("Blue Top")){
                driver.findElement(By.cssSelector(".choose > .nav.nav-justified.nav-pills  a")).click();
            }

            break;

        }
    }


}
