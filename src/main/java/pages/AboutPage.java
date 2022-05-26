package pages;

import com.ey.automation.base.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class AboutPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(AboutPage.class);
    @FindBy(how = How.XPATH, using = "//input[@name='input_1']")
    public WebElement suggestionTitleTextBox;
    @FindBy(how = How.XPATH, using = "//textarea[@name='textarea_1']")
    public WebElement contextTextBox;
    @FindBy(how = How.XPATH, using = "//button[@name='button_1']")
    public WebElement sendButton;
    @FindBy(how = How.XPATH, using = "//*[text()='Operation Successful']")
    public WebElement successPopup;
    @FindBy(how = How.XPATH, using = "//div[@class='ivu-form-item-error-tip']")
    public WebElement warningMessage;


    public void sendSuggestion(String title, String context) {
        try {
            LOGGER.info("sendSuggestion is started.");
            waitUntilElementVisible(suggestionTitleTextBox);
            suggestionTitleTextBox.sendKeys(title);
            contextTextBox.sendKeys(context);
            sendButton.click();
            LOGGER.info("sendSuggestion is completed.");
        } catch (Exception e) {
            LOGGER.error("sendSuggestion is not completed. The reason: "+e.getMessage());
            Assert.fail("sendSuggestion is not completed. The reason: "+e.getMessage());
        }
    }

    public void checkSuccessPopupSending() {
        try {
            LOGGER.info("checkSuccessPopupSending is started.");
            successPopup.isDisplayed();
            LOGGER.info("checkSuccessPopupSending is completed.");
        } catch (Exception e) {
            LOGGER.error("checkSuccessPopupSending is not completed. The reason: "+e.getMessage());
            Assert.fail("checkSuccessPopupSending is not completed. The reason: "+e.getMessage());
        }
    }


    public void checkWarningMessageSending() {
        try {
            LOGGER.info("checkWarningMessageSending is started.");
            String text = warningMessage.getText();
            if(text.equals("Suggestion Title is required") || text.equals("Context is required")){
                LOGGER.info("The warning message is displayed. The text: "+text);
            }else {
                LOGGER.error("The warning message is not displayed. The text: "+text);
                Assert.fail("The warning message is not displayed. The text: "+text);
            }
            LOGGER.info("checkWarningMessageSending is completed.");
        } catch (Exception e) {
            LOGGER.error("checkWarningMessageSending is not completed. The reason: "+e.getMessage());
            Assert.fail("checkWarningMessageSending is not completed. The reason: "+e.getMessage());
        }
    }

    public void checkSuggestionTitleMaximumCharacter() {
        try {
            LOGGER.info("checkSuggestionTitleMaximumCharacter is started.");
            waitUntilElementVisible(suggestionTitleTextBox);
            String randomString = generateRandom("ABCDEFGHIJKLMNOPQRSTUVWXYZ",300);
            suggestionTitleTextBox.sendKeys(randomString);
            int size = suggestionTitleTextBox.getAttribute("title").length();
            if(size > 255){
                LOGGER.error("The maximum character count is exceeded. The count: "+size);
                Assert.fail("The maximum character count is exceeded. The count: "+size);
            }
            LOGGER.info("checkSuggestionTitleMaximumCharacter is completed.");
        } catch (Exception e) {
            LOGGER.error("checkSuggestionTitleMaximumCharacter is not completed. The reason: "+e.getMessage());
            Assert.fail("checkSuggestionTitleMaximumCharacter is not completed. The reason: "+e.getMessage());
        }
    }

    public void checkContextMaximumCharacter() {
        try {
            LOGGER.info("checkContextMaximumCharacter is started.");
            waitUntilElementVisible(contextTextBox);
            String randomString = generateRandom("ABCDEFGHIJKLMNOPQRSTUVWXYZ",2500);
            contextTextBox.sendKeys(randomString);
            int size = contextTextBox.getAttribute("title").length();
            if(size > 2000){
                LOGGER.error("The maximum character count is exceeded. The count: "+size);
                Assert.fail("The maximum character count is exceeded. The count: "+size);
            }
            LOGGER.info("checkContextMaximumCharacter is completed.");
        } catch (Exception e) {
            LOGGER.error("checkContextMaximumCharacter is not completed. The reason: "+e.getMessage());
            Assert.fail("checkContextMaximumCharacter is not completed. The reason: "+e.getMessage());
        }
    }
}
