package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Rahulshettyacademy.config.ConfigReader;
import Rahulshettyacademy.pageobjects.CheckoutPage;
import Rahulshettyacademy.pageobjects.LoginPage;
import Rahulshettyacademy.pageobjects.ProductPage;

public class PlaceOrderTest extends BaseTest {

    @Test
    public void testAddProductToCart() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));

        ProductPage productPage = new ProductPage(driver);
        productPage.addProductToCart("ZARA");
        productPage.waitForLoadingToFinish();

        productPage.clickCartButton(2); // navigates to cart
        Assert.assertTrue(driver.getCurrentUrl().contains("cart"), "Not navigated to cart!");
    }

    @Test(dependsOnMethods = "testAddProductToCart")
    public void testCheckoutAndPlaceOrder() throws InterruptedException {
    	LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));
    }
}

