package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CatalogPage extends PageBase {

    public HeaderMenuPage headerMenuPage;
    private By elementsCatalogLi = By.cssSelector("ul.products li");

    public CatalogPage(WebDriver driver) {
        this.driver = driver;
        headerMenuPage = new HeaderMenuPage(driver);
    }

    public By getCatalogElementSelector(String text) {
        return By.cssSelector(String.format(".listing-wrapper.products a[href*='%s']",text));
    }

    public void catalogElementClick(String text) {
        driver.findElement(getCatalogElementSelector(text)).click();
    }

    public List<WebElement> getElementsCatalog() {
        return driver.findElements(elementsCatalogLi);
    }
}
