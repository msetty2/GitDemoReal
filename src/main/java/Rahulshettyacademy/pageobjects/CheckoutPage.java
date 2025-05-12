package Rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends AbstractPage {

    @FindBy(css = ".totalRow button")
    private WebElement checkoutBtn;

    @FindBy(css = "input[placeholder='Select Country']")
    private WebElement countryInput;

    @FindBy(css = ".ta-results button:nth-of-type(1)")
    private WebElement firstCountryOption;

    @FindBy(css = ".action__submit")
    private WebElement placeOrderBtn;

    @FindBy(css = ".hero-primary")
    private WebElement confirmationMessage;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void proceedToCheckout() {
        checkoutBtn.click();
    }

    public void selectCountry(String country) {
        countryInput.sendKeys(country);
        firstCountryOption.click();
    }

    public void placeOrder() {
        placeOrderBtn.click();
    }

    public String getConfirmationMessage() {
        return confirmationMessage.getText();
    }
}
