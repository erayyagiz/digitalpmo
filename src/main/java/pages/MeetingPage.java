package pages;

import com.ey.automation.listener.ReportListener;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import java.util.List;

public class MeetingPage extends CommonPage {
    private static final Logger LOGGER = LogManager.getLogger(AboutPage.class);
    @FindBy(how = How.XPATH, using = "//button[@type='button']//span[text()='Add']")
    public WebElement addButton;
    @FindBy(how = How.XPATH, using = "//div[@class='ivu-select-selection']//input[@placeholder='Select Year']")
    public WebElement selectYearDropDownAdd;
    @FindBy(how = How.XPATH, using = "//div[@class='ivu-form-item-content']//input[@title='Enter Meeting Name']")
    public WebElement meetingNameTextBoxAdd;
    @FindBy(how = How.XPATH, using = "//input[@placeholder='Select Frequency']")
    public WebElement selectFrequencyDropDownAdd;
    @FindBy(how = How.XPATH, using = "//div[@class='ivu-form-item-content']//input[@title='Enter Owner']")
    public WebElement ownerTextBoxAdd;
    @FindBy(how = How.XPATH, using = "//div[@class='ivu-form-item-content']//input[@placeholder='Select Project']")
    public WebElement selectProjectDropDownAdd;
    @FindBy(how = How.XPATH, using = "//div[@class='ivu-modal-content']//button[@type='button']//span[text()='Save']")
    public WebElement saveButton;
    @FindBy(how = How.XPATH, using = "//div[@class='ivu-modal-content']//button[@type='button']//span[text()='Reset']")
    public WebElement resetButton;
    @FindBy(how = How.XPATH, using = "//div[@class='ivu-message']//div[@class='ivu-message-notice']")
    public WebElement plannedFailedMessage;

    private final By frequenyValues = By.xpath("//div[@class='ivu-select ivu-select-visible ivu-select-single']//ul[@class='ivu-select-dropdown-list']//li");
    private final By years = By.xpath("//div[@class='ivu-select ivu-select-visible ivu-select-single']//ul[@class='ivu-select-dropdown-list']//li");
    private final By projects = By.xpath("//div[@class='ivu-form-item-content']//ul[@class='ivu-select-dropdown-list']//li");
    private final By allWarnings = By.xpath("//div[@class='ivu-message']");

    @Step("Create a new meeting")
    public void createNewMeetingPlan(String meetingName, String owner, String frequency, String year, String project) {
        try {
            ReportListener.info("createNewMeetingPlan is started.");
            waitUntilElementVisible(addButton);
            addButton.click();
            waitUntilElementVisible(meetingNameTextBoxAdd);
            meetingNameTextBoxAdd.click();
            meetingNameTextBoxAdd.sendKeys(meetingName);
            ownerTextBoxAdd.click();
            ownerTextBoxAdd.sendKeys(owner);
            if(!frequency.equals("")){
                selectFrequencyDropDownAdd.click();
                List<WebElement> listFre = presenceOfAllWait(frequenyValues, 5);
                for (WebElement frequenylist : listFre) {
                    if (frequenylist.getText().equals(frequency)) {
                        findAndScrollWebElement(frequenylist);
                        frequenylist.click();
                        break;
                    }
                }
            }
            if (!year.equals("")) {
                selectYearDropDownAdd.click();
                List<WebElement> listYear = presenceOfAllWait(years, 5);
                for (WebElement yearlist : listYear) {
                    if (yearlist.getText().equals(year)) {
                        findAndScrollWebElement(yearlist);
                        yearlist.click();
                        break;
                    }
                }
            }
            if(!project.equals("")){
                selectProjectDropDownAdd.click();
                List<WebElement> listProj = presenceOfAllWait(projects, 5);
                for (WebElement projectlist : listProj) {
                    if (projectlist.getText().equals(project)) {
                        findAndScrollWebElement(projectlist);
                        projectlist.click();
                        break;
                    }
                }
            }
            saveButton.click();
            ReportListener.pass("createNewMeetingPlan is completed.");
        } catch (Exception e) {
            ReportListener.fail("createNewMeetingPlan is not completed.");
            Assert.fail("createNewMeetingPlan is not completed. The reason: " + e.getMessage());
        }
    }

    @Step("Check that the warning message")
    public void checkWarningMessage(String warningMessage) {
        try {
            ReportListener.info("checkWarningMessage is started.");
            waitUntilElementVisible(plannedFailedMessage);
            String currentWarningMessage = plannedFailedMessage.getText();
            if (!currentWarningMessage.equals(warningMessage)) {
                ReportListener.fail("Current error message: " + currentWarningMessage + "; Expected error message: " + warningMessage);
                Assert.fail("Current error message: " + currentWarningMessage + "; Expected error message: " + warningMessage);
            }
            ReportListener.pass("checkWarningMessage is completed.");
        } catch (Exception e) {
            ReportListener.fail("checkWarningMessage is not completed.");
            Assert.fail("checkWarningMessage is not completed. The reason: " + e.getMessage());
        }
    }
}





