package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    protected WebDriver driver;
    String ulrLitecart = "https://litecart.stqa.ru/en/";
    WebDriverWait wait;

    @BeforeMethod
    public void methodSetup() {
        SafariOptions options = new SafariOptions();
        options.setAcceptInsecureCerts(true);
        driver = new SafariDriver(options);
        driver.manage().window().maximize();

        driver.get(ulrLitecart);
    }

    @AfterMethod
    public void methodTeardown() {
        driver.quit();
    }

    public WebDriverWait getWaitSecond(int time) {
        return new WebDriverWait(driver, Duration.ofSeconds(time));
    }
}
