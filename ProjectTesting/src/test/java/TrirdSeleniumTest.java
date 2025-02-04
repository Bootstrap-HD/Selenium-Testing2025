import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class TrirdSeleniumTest {

    WebDriver driver;

    @BeforeMethod
    public void methodSetup() {
        SafariOptions options = new SafariOptions();
        options.setAcceptInsecureCerts(true);
        driver = new SafariDriver(options);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void methodTeardown() {
        driver.quit();
    }

    @Test
    public void testAutorization() {
        driver.get("https://litecart.stqa.ru/en/");

        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("vata66@tut.by");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@name='login']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".notice")));

        WebElement message = driver.findElement(By.cssSelector(".notice"));

        assertEquals(message.getText(), " You are now logged in as Viktar Iliukovich.");
    }

    @Test
    public void testLogOut() {
        driver.get("https://litecart.stqa.ru/en/");

        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("vata66@tut.by");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@name='login']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),' You are now logged in as Viktar Iliukovich.')]")));

        driver.findElement(By.xpath("//*[contains(text(),'Logout')]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),' You are now logged out.')]")));

        WebElement message = driver.findElement(By.cssSelector(".notice"));

        assertEquals(message.getText(), " You are now logged out.");
    }

    @Test
    public void testCartQuantityItems() {
        driver.get("https://litecart.stqa.ru/en/rubber-ducks-c-1/purple-duck-p-5");
        driver.findElement(By.name("add_cart_product")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.textToBe(By.cssSelector("span.quantity"), "1"));

        Assert.assertEquals(driver.findElement(By.cssSelector("span.quantity")).getText(), "1");
    }

    @Test
    public void testCartValidateGood() {
        driver.get("https://litecart.stqa.ru/en/rubber-ducks-c-1/purple-duck-p-5");
        driver.findElement(By.name("add_cart_product")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.textToBe(By.cssSelector("span.quantity"), "1"));

        driver.findElement(By.cssSelector("a.content")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'[SKU: RD005]')]")));

        Assert.assertEquals(driver.findElement(By.xpath("//*[contains(text(),'[SKU: RD005]')]")).getText(), "[SKU: RD005]");
    }

    @Test
    public void testCatalogQuantityGoods() {
        driver.get("https://litecart.stqa.ru/en/");
        driver.findElement(By.cssSelector("#site-menu [href='https://litecart.stqa.ru/en/rubber-ducks-c-1/']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Rubber Ducks | My Store')]")));

        List<WebElement> goods = driver.findElements(By.cssSelector("ul.products li"));
        Assert.assertEquals(goods.size(), 5);
    }
}
