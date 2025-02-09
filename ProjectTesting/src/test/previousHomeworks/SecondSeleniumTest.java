package previousHomeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SecondSeleniumTest {

    @Test
    public void testGoToLinkHomePage() {
        SafariOptions options = new SafariOptions();
        options.setAcceptInsecureCerts(true);
        WebDriver driver = new SafariDriver(options);
        driver.get("https://litecart.stqa.ru/en/");
        driver.manage().window().maximize();
        WebElement homePageButton = driver.findElement(By.cssSelector("#site-menu [href='https://litecart.stqa.ru/en/']"));
        homePageButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Online Store | My Store')]")));

        assertEquals(driver.getTitle(), "Online Store | My Store");
        driver.quit();
    }

    @Test
    public void testGoToLinkRubberDucks() {
        SafariOptions options = new SafariOptions();
        options.setAcceptInsecureCerts(true);
        WebDriver driver = new SafariDriver(options);
        driver.get("https://litecart.stqa.ru/en/");
        driver.manage().window().maximize();
        WebElement rubberDuckButton = driver.findElement(By.cssSelector("#site-menu [href='https://litecart.stqa.ru/en/rubber-ducks-c-1/']"));
        rubberDuckButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Rubber Ducks | My Store')]")));

        assertEquals(driver.getTitle(), "Rubber Ducks | My Store");
        driver.quit();
    }

    @Test
    public void testActionMoveToElement() {
        SafariOptions options = new SafariOptions();
        options.setAcceptInsecureCerts(true);
        WebDriver driver = new SafariDriver(options);
        driver.get("https://litecart.stqa.ru/en/");
        driver.manage().window().maximize();
        WebElement onlineStoreButton = driver.findElement(By.cssSelector("#site-menu .category-1"));

        Actions action = new Actions(driver);
        action.moveToElement(onlineStoreButton).perform();

       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='category-2']")));

        assertTrue(driver.findElement(By.xpath("//*[@class='category-2']")).isDisplayed());

        driver.quit();
    }
}