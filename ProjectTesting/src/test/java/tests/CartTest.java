package tests;

import base.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CatalogPage;
import pages.HeaderMenuPage;
import pages.ProductPage;

public class CartTest extends TestBase {

    @Test
    public void testCartQuantityItems() {
        HeaderMenuPage headerMenuPage = new HeaderMenuPage(driver);
        headerMenuPage.goToCatalog();

        //productPage.headerMenuPage.goToCatalog();

        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.catalogElementClick("-p-5");

        WebDriverWait wait = getWaitSecond(5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(catalogPage.containsText("Add To Cart")));

        ProductPage productPage = new ProductPage(driver);
        productPage.setAddProductInCart();

        CartPage cartPage = new CartPage(driver);
        wait.until(ExpectedConditions.textToBe(cartPage.textCartButton, "1"));

        Assert.assertEquals(driver.findElement(cartPage.textCartButton).getText(), "1");
    }

    @Test
    public void testCartValidateGood() {
        HeaderMenuPage headerMenuPage = new HeaderMenuPage(driver);
        headerMenuPage.goToCatalog();

        //productPage.headerMenuPage.goToCatalog();

        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.catalogElementClick("-p-5");

        WebDriverWait wait = getWaitSecond(3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(catalogPage.containsText("Add To Cart")));

        ProductPage productPage = new ProductPage(driver);
        productPage.setAddProductInCart();

        CartPage cartPage = new CartPage(driver);
        wait.until(ExpectedConditions.textToBe(cartPage.textCartButton, "1"));

        cartPage.goToCart();
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartPage.containsText("[SKU: RD005]")));

        Assert.assertEquals(driver.findElement(cartPage.containsText("[SKU: RD005]")).getText(), "[SKU: RD005]");
    }
}
