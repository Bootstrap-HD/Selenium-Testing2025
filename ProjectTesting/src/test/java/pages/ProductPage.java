package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends PageBase {
    public HeaderMenuPage headerMenuPage;
    private By addProductButton = By.name("add_cart_product");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        headerMenuPage = new HeaderMenuPage(driver);
    }

    public void setAddProductInCart() {
        driver.findElement(addProductButton).click();
    }
}
