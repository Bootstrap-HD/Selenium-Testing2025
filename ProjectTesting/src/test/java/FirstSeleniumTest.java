import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FirstSeleniumTest {
    @Test
    public void FirstSeleniumTest() {
        WebDriver driver = new SafariDriver();
        driver.get("https://the-internet.herokuapp.com");
        ArrayList<WebElement> element = new ArrayList<>(driver.findElements(By.tagName("a")));
        element.get(10).click();
        driver.quit();
    }
}
