package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageBase {
    protected WebDriver driver;

    public By containsText(String text) {
        return By.xpath(String.format("//*[contains(text(),'%s')]", text));
    }
}
