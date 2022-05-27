package pages;

import com.ey.automation.base.BasePage;
import com.ey.automation.utilities.ReportListener;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    public void switchFrame(){
        try {
            LOGGER.info("switchFrame is started.");
            waitUntilFrameToBeAvailableAndSwitchToItByWebelement(frame);
            LOGGER.info("switchFrame is completed.");
        } catch (Exception e) {
            LOGGER.error("switchFrame is not completed. The reason: "+e.getMessage());
            Assert.fail("switchFrame is not completed. The reason: "+e.getMessage());
        }
    }

    @Step("Go to About Send Suggestion Page")
    public void goToAboutSendSuggestionPage(){
        try {
            ReportListener.info("goToAboutSendSuggestionPage is started.");
            LOGGER.info("goToAboutSendSuggestionPage is started.");
            waitUntilElementVisible(aboutMenuButton);
            aboutMenuButton.click();
            waitUntilElementVisible(sendSuggestionsSubMenuButton);
            sendSuggestionsSubMenuButton.click();
            switchFrame();
            ReportListener.pass("goToAboutSendSuggestionPage is completed.");
            LOGGER.info("goToAboutSendSuggestionPage is completed.");
        }catch (Exception e){
            ReportListener.fail("goToAboutSendSuggestionPage is not completed.");
            LOGGER.error("goToAboutSendSuggestionPage is not completed. The reason: "+e.getMessage());
            Assert.fail("goToAboutSendSuggestionPage is not completed. The reason: "+e.getMessage());
        }
    }
}
