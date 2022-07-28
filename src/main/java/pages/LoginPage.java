package pages;

import com.ey.automation.config.Settings;
import com.ey.automation.listener.ReportListener;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends CommonPage {
    @FindBy(how = How.XPATH, using="//input[@id='uid']")
    public WebElement username;
    @FindBy(how = How.XPATH, using="//input[@id='password']")
    public WebElement password;
    @FindBy(how = How.XPATH, using="//input[@name='Submit']")
    public WebElement loginButton;

    @Step("Login to the Digital PMO")
    public void login() {
        try {
            ReportListener.info("login is started.");
            waitUntilElementVisible(username);
            username.sendKeys(Settings.Username);
            password.sendKeys(Settings.Password);
            loginButton.click();
            waitForPageToLoad();
            ReportListener.pass("login is completed.");
        } catch (Exception e) {
            ReportListener.fail("login is not completed.");
            Assert.fail("login is not completed. The reason: "+e.getMessage());
        }

    }
}
