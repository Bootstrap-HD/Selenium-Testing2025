package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends PageBase {

    public By textCartButton = By.cssSelector("span.quantity");
    public By cartButton = By.cssSelector("a.content");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToCart() {
        driver.findElement(cartButton).click();
    }
}
