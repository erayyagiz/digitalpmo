package pages;

import com.ey.automation.listener.ReportListener;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AboutPage extends CommonPage {
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
    @FindBy(how = How.XPATH, using = "//pdf-viewer[@id='viewer']")
    public WebElement userGuidePdf;

    @Step("Send suggestion")
    public void sendSuggestion(String title, String context) {
        try {
            ReportListener.info("sendSuggestion is started.");
            waitUntilElementVisible(suggestionTitleTextBox);
            suggestionTitleTextBox.sendKeys(title);
            contextTextBox.sendKeys(context);
            sendButton.click();
            ReportListener.pass("sendSuggestion is completed.");
        } catch (Exception e) {
            ReportListener.fail("sendSuggestion is not completed.");
            Assert.fail("sendSuggestion is not completed. The reason: " + e.getMessage());
        }
    }

    @Step("Check that success popup is displayed")
    public void checkSuccessPopupSending() {
        try {
            ReportListener.info("checkSuccessPopupSending is started.");
            successPopup.isDisplayed();
            ReportListener.pass("checkSuccessPopupSending is completed.");
        } catch (Exception e) {
            ReportListener.fail("checkSuccessPopupSending is not completed.");
            Assert.fail("checkSuccessPopupSending is not completed. The reason: " + e.getMessage());
        }
    }

    @Step("Check that warning popup is displayed")
    public void checkWarningMessageSending(String expectedErrorMessage) {
        try {
            ReportListener.info("checkWarningMessageSending is started.");
            waitUntilElementVisible(warningMessage);
            String currentErrorMessage = warningMessage.getText();
            if (!currentErrorMessage.contains(expectedErrorMessage)) {
                ReportListener.fail("The error message is not correct. Current Error Message: " + currentErrorMessage + "; Expected Error Message: " + expectedErrorMessage);
                Assert.fail("The error message is not correct. Current Error Message: " + currentErrorMessage + "; Expected Error Message: " + expectedErrorMessage);
            }
            ReportListener.pass("checkWarningMessageSending is completed.");
        } catch (Exception e) {
            ReportListener.fail("checkWarningMessageSending is not completed.");
            Assert.fail("checkWarningMessageSending is not completed. The reason: " + e.getMessage());
        }
    }

    @Step("Check that suggestion title is maximum character")
    public void checkSuggestionTitleMaximumCharacter() {
        try {
            ReportListener.info("checkSuggestionTitleMaximumCharacter is started.");
            waitUntilElementVisible(suggestionTitleTextBox);
            String randomString = generateRandom("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 300);
            suggestionTitleTextBox.sendKeys(randomString);
            int size = suggestionTitleTextBox.getAttribute("title").length();
            if (size > 255) {
                ReportListener.fail("The maximum character count is exceeded. The count: " + size);
                Assert.fail("The maximum character count is exceeded. The count: " + size);
            }
            ReportListener.pass("checkSuggestionTitleMaximumCharacter is completed.");
        } catch (Exception e) {
            ReportListener.fail("checkSuggestionTitleMaximumCharacter is not completed.");
            Assert.fail("checkSuggestionTitleMaximumCharacter is not completed. The reason: " + e.getMessage());
        }
    }

    @Step("Check that context is maximum character")
    public void checkContextMaximumCharacter() {
        try {
            ReportListener.info("checkContextMaximumCharacter is started.");
            waitUntilElementVisible(contextTextBox);
            String randomString = generateRandom("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 2500);
            contextTextBox.sendKeys(randomString);
            int size = contextTextBox.getAttribute("title").length();
            if (size > 2000) {
                ReportListener.fail("The maximum character count is exceeded. The count: " + size);
                Assert.fail("The maximum character count is exceeded. The count: " + size);
            }
            ReportListener.pass("checkContextMaximumCharacter is completed.");
        } catch (Exception e) {
            ReportListener.fail("checkContextMaximumCharacter is not completed.");
            Assert.fail("checkContextMaximumCharacter is not completed. The reason: " + e.getMessage());
        }
    }

    @Step("Check that user guide pdf is opened")
    public void checkUserGuide() {
        try {
            ReportListener.info("checkUserGuide is started.");
            waitForPageToLoad();
            if(!checkElementIsDisplayed(userGuidePdf)){
                ReportListener.fail("User Guide is not displayed.");
                Assert.fail("User Guide is not displayed.");
            }
            ReportListener.pass("checkUserGuide is completed.");
        } catch (Exception e) {
            ReportListener.fail("checkUserGuide is not completed.");
            Assert.fail("checkUserGuide is not completed. The reason: " + e.getMessage());
        }
    }


}
