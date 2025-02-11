package previousHomeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class FirstSeleniumTest {
    @Test
    public void FirstSeleniumTest() {
        WebDriver driver = new SafariDriver();
        driver.get("https://the-internet.herokuapp.com");
        ArrayList<WebElement> element = new ArrayList<>(driver.findElements(By.tagName("a")));
        element.get(9).click();
        driver.quit();
    }
    @Test
    public void secondTest() {
        SafariOptions options = new SafariOptions();
        options.setAcceptInsecureCerts(true);
        WebDriver driver = new SafariDriver(options);
        driver.get("https://litecart.stqa.ru/en/");
        driver.manage().window().maximize();
        driver.quit();
    }
}
