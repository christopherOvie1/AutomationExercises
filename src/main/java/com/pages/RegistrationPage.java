package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RegistrationPage {

    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//b[text() = 'Enter Account Information']")
    WebElement EnterAccountInformationText;

    @FindBy(css = "input[type='radio']")
    List<WebElement> radioButtons;

    @FindBy(css="#password")
    WebElement  passwordButton;
     //days
    @FindBy(xpath="//select[@id='days']")
    WebElement  dayDropdown;
    //months
    @FindBy(xpath="//select[@id='months']")
    WebElement  monthDropdown;
//years
    @FindBy(xpath="//select[@id='years']")
    WebElement  yearDropdown;
//company
    @FindBy(css="#first_name")
    WebElement  firstNameField;

    @FindBy(css="#last_name")
    WebElement  lastNameField;

    @FindBy(css="#company")
    WebElement  companyField;

    @FindBy(css="#address1")
    WebElement  addressField1;

    @FindBy(css="#address2")
    WebElement  addressField2;

    @FindBy(css="#country")
    WebElement  countryDropdown;

    @FindBy(css="#state")
    WebElement  stateField;

    @FindBy(css="#city")
    WebElement  cityField;

    @FindBy(css="#zipcode")
    WebElement  zipcodeField;

    @FindBy(css="#mobile_number")
    WebElement  mobileNumberField;

    @FindBy(xpath="//button[contains(.,'Create Account')]")
    WebElement  createAccountButton;

    //Create Action
    public void getRadioButtons() {

        //List<WebElement> radioButtons=	driver.findElements(By.cssSelector("input[type='radio']"));

        for (int i = 0; i < radioButtons.size(); i++) {
            WebElement rad = radioButtons.get(i);
            String radio = rad.getAttribute("value");
            if (radio.equalsIgnoreCase("Mr")) {
                rad.click();
                break;
            }
        }
    }

    public boolean VerifyThatENTERACCOUNTINFORMATIONisVisible() {
     return    EnterAccountInformationText.isDisplayed();
    }
    public void enterPassword(String password) {
        passwordButton.sendKeys(password);
    }
/*public void selectDay(String days){
    WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
    w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='days']")));

    Select day = new Select(dayDropdown);
    day.selectByVisibleText(days);

}*/
    public void selectDateOfBirth(String days,String months,String years) {
        Select day = new Select(dayDropdown);
        day.selectByValue(days);
        Select month = new Select(monthDropdown);
        month.selectByVisibleText(months);
        Select year = new Select(yearDropdown);
        year.selectByValue(years);

    }

    public void enterAddressInfo(String firstNm,String lastNm,String company,String address1,String address2,String countries,String state,String city,String zipcode,String mobileNumber){
        firstNameField.sendKeys(firstNm);
        lastNameField.sendKeys(lastNm);
        companyField.sendKeys(company);
       addressField1.sendKeys(address1);
        addressField2.sendKeys(address2);
        Select contry = new Select(countryDropdown);
        contry.selectByVisibleText(countries);
        stateField.sendKeys(state);
        cityField.sendKeys(city);
        zipcodeField.sendKeys(zipcode);
        mobileNumberField.sendKeys(mobileNumber);
        createAccountButton.click();


    }


}
