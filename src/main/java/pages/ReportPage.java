package pages;

import com.ey.automation.listener.ReportListener;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import java.util.List;

public class ReportPage extends CommonPage {

    public By projectDropdownList = By.xpath("//label[@title='Project']/following-sibling::*//div[@class='ivu-select-dropdown vxe-table--ignore-clear']/ul[@class='ivu-select-dropdown-list']/li");
    public By yearDropdownList = By.xpath("//label[@title='Year']/following-sibling::*//div[@class='ivu-select-dropdown vxe-table--ignore-clear']/ul[@class='ivu-select-dropdown-list']/li");
    public By frequencyDropdownList = By.xpath("//label[@title='Frequency']/following-sibling::*//div[@class='ivu-select-dropdown vxe-table--ignore-clear']/ul[@class='ivu-select-dropdown-list']/li");

    public By columnTableList = By.xpath("//div[@class='ivu-table-viewer']//tbody/tr[1]/td");

    @FindBy(how = How.XPATH, using = "//div[@class='contents']//input[@placeholder='']")
    public WebElement yearDropdown;
    @FindBy(how = How.XPATH, using = "//div[@class='contents']//input[@placeholder='SelectDC']")
    public WebElement dcDropdown;
    @FindBy(how = How.XPATH, using = "//div[@class='contents']//input[@placeholder='Select Project']")
    public WebElement projectDropdown;
    @FindBy(how = How.XPATH, using = "//div[@class='ivu-input-wrapper ivu-input-type']//input[@placeholder='Enter Report Name']")
    public WebElement editreportNameTextbox;
    @FindBy(how = How.XPATH, using = "//div[@class='contents']//input[@placeholder='Enter Owner']")
    public WebElement ownerTextbox;
    @FindBy(how = How.XPATH, using = "//button[@type='button']//span[text()='Reset']")
    public WebElement filterSearchButton;
    @FindBy(how = How.XPATH, using = "//button[@name='searchResetButton']")
    public WebElement resetButton;
    @FindBy(how = How.XPATH, using = "//button[@name='AddButton']")
    public WebElement addButton;
    @FindBy(how = How.XPATH, using = "//button[@name='deleteButton']")
    public WebElement deleteMultipleButton;
    @FindBy(how = How.XPATH, using = "//button[@name='button_0']")
    public WebElement exportButton;
    @FindBy(how = How.XPATH, using = "//button[@name='button_13'and@layoutid=\"1621940842286073_undefined_0\"]")
    public WebElement firstReportEditButton;
    @FindBy(how = How.XPATH, using = "//button[@name='button_17'and@layoutid=\"1621940842286077_undefined_0\"]")
    public WebElement firstReportDeleteButton;
    @FindBy(how = How.XPATH, using = "//div[@class='ivu-form-item-content']//input[@placeholder='Select Year']")
    public WebElement addSelectYearDropdown;
    @FindBy(how = How.XPATH, using = "//div[@class='ivu-form-item-content']//input[@placeholder='Select Project']")
    public WebElement addSelectProjectDropdown;
    @FindBy(how = How.XPATH, using = "//div[@class='ivu-form-item-content']//input[@placeholder='Enter Report Name']")
    public WebElement addReportNameTextbox;
    @FindBy(how = How.XPATH, using = "//div[@class='ivu-form-item-content']//input[@placeholder='Enter Owner']")
    public WebElement addOwnerNameTextbox;
    @FindBy(how = How.XPATH, using = "//div[@class='ivu-form-item-content']//input[@placeholder='Select Frequency']")
    public WebElement addSelectFrequencyDropdown;
    @FindBy(how = How.XPATH, using = "//div[@class='ivu-select-dropdown vxe-table--ignore-clear']//li[@title='Weekly']/span)[1]")
    public WebElement firstFrequencyDropDown;
    @FindBy(how = How.XPATH, using = "//button[@name='saveButton']")
    public WebElement addSaveButton;
    @FindBy(how = How.XPATH, using = "//button[@name='cancelButton']")
    public WebElement addCancelButton;
    @FindBy(how = How.XPATH, using = "//button[@type='button']//span[text()='Edit']")
    public WebElement editReportButton;
    @FindBy(how = How.XPATH, using = "//div[@class='ivu-modal']//i[@class='ivu-icon ivu-icon-ios-close-empty']")
    public WebElement addCloseButton;
    @FindBy(how = How.XPATH, using = "//div[@class='ivu-form-item-content']//i[2]")
    public WebElement editYearDropdown;
    @FindBy(how = How.XPATH, using = "//div[@class='ivu-form-item-content']//div[@layoutid='1645655443585000']//i[2]")
    public WebElement editProjectDropdown;
    @FindBy(how = How.XPATH, using = "//div[@class='ivu-input-wrapper ivu-input-type']//input[@placeholder='Enter Report Name']")
    public WebElement editReportNameTextbox;
    @FindBy(how = How.XPATH, using = "//div[@class='ivu-form-item-content']//div[@layoutid='1621940842286061']//i[2]")
    public WebElement editFrequencyDropDown;
    @FindBy(how = How.XPATH, using = "//div[@class='ivu-page-options']//div[@class='ivu-select-selection']")
    public WebElement paginationButton;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'message-error')]//span")
    public WebElement ReportFailedMessage;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'message-success')]//span")
    public WebElement ReportSuccessMessage;
    @FindBy(how = How.XPATH, using = "//div[@class='ivu-select-selection']/i[@class='ivu-icon ivu-icon-arrow-down-b ivu-select-arrow']")
    public WebElement removeYearButton;

    @Step("Create a report plan")
    public void createReportPlan(String year, String projectName, String reportName, String owner, String frequency) {
        try {
            ReportListener.info("createReportPlan is started.");
            waitUntilElementVisible(addButton);
            addButton.click();
            waitUntilElementVisible(addCancelButton);
            if (!year.equals("")) {
                addSelectYearDropdown.click();
                List<WebElement> listYearr = presenceOfAllWait(yearDropdownList, 5);
                for (WebElement yearListt : listYearr) {
                    if (yearListt.getText().equals(year)) {
                        findAndScrollWebElement(yearListt);
                        yearListt.click();
                        break;
                    }
                }
            }
            if (!projectName.equals("")) {
                addSelectProjectDropdown.click();
                List<WebElement> listProject = presenceOfAllWait(projectDropdownList, 5);
                for (WebElement projectList : listProject) {
                    if (projectList.getText().equals(projectName)) {
                        findAndScrollWebElement(projectList);
                        projectList.click();
                        break;
                    }
                }
            }
            addReportNameTextbox.sendKeys(reportName);
            addOwnerNameTextbox.sendKeys(owner);
            addSelectFrequencyDropdown.sendKeys(frequency);
            if (!frequency.equals("")) {
                addSelectFrequencyDropdown.click();
                List<WebElement> listFrequency = presenceOfAllWait(frequencyDropdownList, 5);
                for (WebElement frequencyListt : listFrequency) {
                    if (frequencyListt.getText().equals(frequency)) {
                        findAndScrollWebElement(frequencyListt);
                        frequencyListt.click();
                        break;
                    }
                }
            }
            ReportListener.pass("createReportPlan is completed.");
        } catch (Exception e) {
            ReportListener.fail("createReportPlan is not completed.");
            Assert.fail("createReportPlan is not completed.The reason:" + e.getMessage());
        }
    }

    @Step("Check that the report warning message is displayed")
    public void checkReportWarningMessage(String expectedErrorMessage) {
        try {
            ReportListener.info("checkReportWarningMessage is started.");
            addSaveButton.click();
            waitUntilElementVisible(ReportFailedMessage);
            String currentErrorMessage = ReportFailedMessage.getText();
            if (!currentErrorMessage.contains(expectedErrorMessage)) {
                ReportListener.fail("The error message is not correct.CurrentErrorMessage:" + currentErrorMessage + ";ExpectedErrorMessage:" + expectedErrorMessage);
                Assert.fail("The error message is not correct.CurrentErrorMessage:" + currentErrorMessage + ";ExpectedErrorMessage:" + expectedErrorMessage);
            }
            ReportListener.pass("checkReportWarningMessage is completed.");
        } catch (Exception e) {
            ReportListener.fail("checkReportWarningMessage is not completed.");
            Assert.fail("checkReportWarningMessage is not completed.The reason:" + e.getMessage());
        }
    }

    @Step("Check that the report is added")
    public void checkReportPlanIsAdded(String expectedYear, String expectedProject, String expectedReportName, String expectedOwner, String expectedFrequency) {
        try {
            ReportListener.info("checkReportPlanIsAdded is started.");
            addSaveButton.click();
            resetButton.click();
            waitFor(5);
            waitUntilElementVisible(editReportButton);

            List<WebElement> firstColumnValue = presenceOfAllWait(columnTableList, 30);
            String currentYear = firstColumnValue.get(1).getText();
            String currentProject = firstColumnValue.get(3).getText();
            String currentReportName = firstColumnValue.get(4).getText();
            String currentOwner = firstColumnValue.get(6).getText();
            String currentFrequency = firstColumnValue.get(5).getText();

            if (!currentYear.equals(expectedYear)) {
                ReportListener.fail("Current Year: " + currentYear + "; Expected Year: " + expectedYear);
                Assert.fail("Current Year: " + currentYear + "; Expected Year: " + expectedYear);
            }
            if (!currentProject.equals(expectedProject)) {
                ReportListener.fail("Current Project: " + currentProject + "; Expected Project: " + expectedProject);
                Assert.fail("Current Project: " + currentProject + "; Expected Project: " + expectedProject);
            }
            if (!currentReportName.equals(expectedReportName)) {
                ReportListener.fail("Current Report Name: " + currentReportName + "; Expected Report Name: " + expectedReportName);
                Assert.fail("Current Report Name: " + currentReportName + "; Expected Report Name: " + expectedReportName);
            }
            if (!currentOwner.equals(expectedOwner)) {
                ReportListener.fail("Current Owner: " + currentOwner + "; Expected Owner: " + expectedOwner);
                Assert.fail("Current Owner: " + currentOwner + "; Expected Owner: " + expectedOwner);
            }
            if (!currentFrequency.equals(expectedFrequency)) {
                ReportListener.fail("Current Frequency: " + currentFrequency + "; Expected Frequency: " + expectedFrequency);
                Assert.fail("Current Frequency: " + currentFrequency + "; Expected Frequency: " + expectedFrequency);
            }
            ReportListener.pass("checkReportPlanIsAdded is completed");
        } catch (Exception e) {
            ReportListener.fail("checkReportPlanIsAdded is not completed");
            Assert.fail("checkReportPlanIsAdded is not completed. The reason: " + e.getMessage());
        }
    }

    @Step("Cancel the Report Plan")
    public void cancelReportPlan(String tip) {
        try {
            ReportListener.info("cancelReportPlan is started.");
            if (tip.equals("Add")) {
                waitUntilElementVisible(addButton);
                addButton.click();
            } else if (tip.equals("Edit")) {
                waitUntilElementVisible(editReportButton);
                editReportButton.click();
            }
            waitUntilElementVisible(addCancelButton);
            addCancelButton.click();
            waitUntilElementInVisible(addCancelButton);
            ReportListener.pass("cancelReportPlan is completed.");
        } catch (Exception e) {
            ReportListener.fail("cancelReportPlan is not completed.");
            Assert.fail("cancelReportPlan is not completed. The reason: " + e.getMessage());
        }
    }

    @Step("Remove a Report Plan")
    public void removeReportPlanParameter(String year, String projectName, String reportName, String owner, String frequency) {
        try {
            ReportListener.info("removeReportPlan is started.");
            resetButton.click();
            waitUntilElementVisible(editReportButton);
            editReportButton.click();
            waitUntilElementVisible(addCancelButton);

            if (year.equals("Removed"))
                editYearDropdown.click();
            if (projectName.equals("Removed"))
                editProjectDropdown.click();
            if(reportName.equals("Removed"))
                deleteTextbox(addReportNameTextbox);
            if(owner.equals("Removed"))
                deleteTextbox(addOwnerNameTextbox);
            if(frequency.equals("Removed"))
                editFrequencyDropDown.click();
            ReportListener.pass("removeReportPlan is completed.");
        } catch (Exception e) {
            ReportListener.fail("removeReportPlan is not completed.");
            Assert.fail("removeReportPlan is not completed.The reason: " + e.getMessage());

        }
    }

}
