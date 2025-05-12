package Rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProductPage extends AbstractPage {

	 @FindBy(css = ".card-body b")
	    List<WebElement> productCards;

    @FindBy(css = ".ng-animating")
    private WebElement loadingOverlay;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addProductToCart(String productName) {
    	 WebElement target = productCards.stream()
    	            .filter(p -> p.getText().contains(productName))
    	            .findFirst().orElse(null);
            }
        
    

    public void waitForLoadingToFinish() {
    	 wait.until(ExpectedConditions.invisibilityOf(loadingOverlay));
    }

    public void clickCartButton(int index) {
        List<WebElement> cartButtons = driver.findElements(By.xpath("//button[@class='btn btn-custom']"));
        if (cartButtons.size() > index) {
            cartButtons.get(index).click();
        }
    }
}
