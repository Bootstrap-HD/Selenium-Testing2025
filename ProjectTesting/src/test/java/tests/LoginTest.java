package tests;

import base.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginMessagePage;
import pages.LoginPage;

public class LoginTest extends TestBase {

    String email = "vata66@tut.by";
    String password = "123456";
    String name = "Viktar Iliukovich";

    @Test
    public void testAutorization() {
        LoginPage loginPage = new LoginPage(driver);
        LoginMessagePage loginMessagePage = new LoginMessagePage(driver);

        loginPage.login(email, password);

        getWaitSecond(3).until(ExpectedConditions.visibilityOfElementLocated(loginMessagePage.messageElement));

        Assert.assertEquals(loginMessagePage.getTextMessageElement(), String.format(loginMessagePage.loginSuccessMessage, name));
    }

    @Test
    public void testLogOut() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);
        LoginMessagePage loginMessagePage = new LoginMessagePage(driver);

        WebDriverWait wait = getWaitSecond(3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.containsText(String.format(loginMessagePage.loginSuccessMessage, name))));

        loginPage.logout();

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.containsText(loginMessagePage.logoutMessage)));

        Assert.assertEquals(loginMessagePage.getTextMessageElement(), loginMessagePage.logoutMessage);
    }
}
