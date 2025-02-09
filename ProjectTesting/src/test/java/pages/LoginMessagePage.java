package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginMessagePage extends PageBase {

    public By messageElement = By.cssSelector("#notices>.notice");

    public String loginSuccessMessage = " You are now logged in as %s.";
    public String logoutMessage = " You are now logged out.";

    public LoginMessagePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTextMessageElement() {
        return driver.findElement(messageElement).getText();
    }
}
