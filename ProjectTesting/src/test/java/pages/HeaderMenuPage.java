package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderMenuPage extends PageBase {

    public HeaderMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    private By catalogButton = By.cssSelector("#site-menu [href='https://litecart.stqa.ru/en/rubber-ducks-c-1/']");

    public void goToCatalog() {
        driver.findElement(catalogButton).click();
    }
}
