package tests;

import base.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CatalogPage;
import pages.HeaderMenuPage;

public class CatalogTest extends TestBase {

    @Test
    public void testCatalogQuantityGoods() {
        HeaderMenuPage headerMenuPage = new HeaderMenuPage(driver);
        headerMenuPage.goToCatalog();

        WebDriverWait wait = getWaitSecond(3);
        wait.until(ExpectedConditions.presenceOfElementLocated(headerMenuPage.containsText("Rubber Ducks | My Store")));

        CatalogPage catalogPage = new CatalogPage(driver);
        Assert.assertEquals(catalogPage.getElementsCatalog().size(), 5);
    }
}
