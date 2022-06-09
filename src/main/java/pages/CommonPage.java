package pages;

import com.ey.automation.base.BasePage;
import com.ey.automation.listener.ReportListener;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CommonPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(CommonPage.class);
    @FindBy(how = How.XPATH, using="//*[@class='portal-tab-content__body menu-top']")
    public WebElement frame;
    @FindBy(how = How.XPATH, using="//i[@title='About']/parent::div")
    public WebElement aboutMenuButton;
    @FindBy(how = How.XPATH, using="//span[@title='Help']")
    public WebElement helpSubMenuButton;
    @FindBy(how = How.XPATH, using="//span[@title='Send Suggestions']")
    public WebElement sendSuggestionsSubMenuButton;

    @Step("Switch to the frame")
    public void switchFrame(){
        try {
            ReportListener.info("switchFrame is started.");
            LOGGER.info("switchFrame is started.");
            waitUntilFrameToBeAvailableAndSwitchToItByWebelement(frame);
            ReportListener.pass("switchFrame is completed.");
            LOGGER.info("switchFrame is completed.");
        } catch (Exception e) {
            ReportListener.fail("switchFrame is not completed.");
            LOGGER.error("switchFrame is not completed. The reason: "+e.getMessage());
            Assert.fail("switchFrame is not completed. The reason: "+e.getMessage());
        }
    }

    @Step("Go to About {page} Page")
    public void goToAboutPage(String page){
        try {
            ReportListener.info("goToAboutPage is started.");
            LOGGER.info("goToAboutPage is started.");
            waitUntilElementVisible(aboutMenuButton);
            aboutMenuButton.click();
            if(page.equals("Send Suggestion")){
                waitUntilElementVisible(sendSuggestionsSubMenuButton);
                sendSuggestionsSubMenuButton.click();
            } else if (page.equals("Help")){
                waitUntilElementVisible(helpSubMenuButton);
                helpSubMenuButton.click();
            }
            switchFrame();
            ReportListener.pass("goToAboutPage is completed.");
            LOGGER.info("goToAboutPage is completed.");
        }catch (Exception e){
            ReportListener.fail("goToAboutPage is not completed.");
            LOGGER.error("goToAboutPage is not completed. The reason: "+e.getMessage());
            Assert.fail("goToAboutPage is not completed. The reason: "+e.getMessage());
        }
    }
}
