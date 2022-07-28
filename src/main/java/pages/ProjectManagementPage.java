package pages;

import com.ey.automation.listener.ReportListener;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import java.util.List;

public class ProjectManagementPage extends CommonPage {
    @FindBy(how = How.XPATH, using="//input[@title='Enter Project Name' and @name='input_0']")
    public WebElement filterProjectName;
    @FindBy(how = How.XPATH, using="//input[@title='Enter Project Code' and @name='input_1']")
    public WebElement filterProjectCode;
    @FindBy(how = How.XPATH, using="//input[@title='Enter Responsible' and @name='input_2']")
    public WebElement filterCostTransferResponsible;
    @FindBy(how = How.XPATH, using="(//input[@placeholder='Select DC'])[1]")
    public WebElement filterDC;
    @FindBy(how = How.XPATH, using="(//input[@placeholder='Select Charge Mode'])[1]")
    public WebElement filterChargeMode;
    @FindBy(how = How.XPATH, using="(//input[@placeholder='Select Report'])[1]")
    public WebElement filterWeeklyReport;
    @FindBy(how = How.XPATH, using="(//input[@placeholder='Select Charge Status'])[1]")
    public WebElement filterChargeStatus;
    @FindBy(how = How.XPATH, using="(//input[@placeholder='Enter Turkey R&D PM'])[1]")
    public WebElement filterTurkeyRDPM;
    @FindBy(how = How.XPATH, using="//input[@title='Enter Times Approver' and @name='input_4']")
    public WebElement filterTimesApprover;
    @FindBy(how = How.XPATH, using="//input[@title='Enter Business Manager' and @name='input_5']")
    public WebElement filterBusinessManager;
    @FindBy(how = How.XPATH, using="//input[@title='Enter Business Department Director' and @name='input_6']")
    public WebElement filterBusinessDepartmentDirector;
    @FindBy(how = How.XPATH, using="(//input[@placeholder='Select Status'])[1]")
    public WebElement filterStatus;
    @FindBy(how = How.XPATH, using="(//input[@placeholder='Select Start Date'])[1]")
    public WebElement filterStartDate;
    @FindBy(how = How.XPATH, using="(//input[@placeholder='End Start Date'])[1]")
    public WebElement filterEndDate;
    @FindBy(how = How.XPATH, using="//button[@name='button_0']//span[text()='Search']")
    public WebElement filterSearchButton;
    @FindBy(how = How.XPATH, using="//button[@name='button_1']//span[text()='Reset']")
    public WebElement filterResetButton;
    @FindBy(how = How.XPATH, using="//button[@name='button_2']//span[text()='Add']")
    public WebElement addButton;
    @FindBy(how = How.XPATH, using="//button[@name='button_3']//span[text()='Delete']")
    public WebElement multipleDeleteButton;
    @FindBy(how = How.XPATH, using="//button[@name='button_6']//span[text()='Export']")
    public WebElement exportButton;
    @FindBy(how = How.XPATH, using="//tr[@class='ivu-table-row ivu-table-row-0']//button//span[text()='Edit']")
    public WebElement firstProjectEditButton;
    @FindBy(how = How.XPATH, using="//tr[@class='ivu-table-row ivu-table-row-0']//button//span[text()='Delete']")
    public WebElement firstProjectDeleteButton;
    @FindBy(how = How.XPATH, using="//div[@class='ivu-modal']//input[@title='Enter Project Code']")
    public WebElement projectCodeTextbox;
    @FindBy(how = How.XPATH, using="//div[@class='ivu-modal']//input[@title='Enter Project Name']")
    public WebElement projectNameTextbox;
    @FindBy(how = How.XPATH, using="//div[@class='ivu-modal']//input[@placeholder='Select Status']")
    public WebElement statusDropdown;
    public By DropdownListsPathForAddProjectBy = By.xpath("//div[@class='ivu-select ivu-select-visible ivu-select-single']//ul[@class='ivu-select-dropdown-list']//li");
    @FindBy(how = How.XPATH, using="//div[@class='ivu-modal']//input[@placeholder='Select DC']")
    public WebElement dcDropdown;
    @FindBy(how = How.XPATH, using="//div[@class='ivu-modal']//input[@placeholder='Select Charge Mode']")
    public WebElement chargeModeDropdown;
    @FindBy(how = How.XPATH, using="//div[@class='ivu-modal']//input[@title='Enter Responsible']")
    public WebElement responsibleTextbox;
    @FindBy(how = How.XPATH, using="//div[@class='ivu-modal']//input[@placeholder='Select Charge Status']")
    public WebElement chargeStatusDropdown;
    @FindBy(how = How.XPATH, using="//div[@class='ivu-modal']//input[@title='Enter Turkey R&D PM']")
    public WebElement turkeyPMTextbox;
    @FindBy(how = How.XPATH, using="//span[@class='ivu-switch ivu-switch-checked ivu-switch-default']")
    public WebElement biweeklyReportSwitch;
    @FindBy(how = How.XPATH, using="//div[@class='ivu-modal']//input[@title='Enter Business Manager']")
    public WebElement businessManagerTextbox;
    @FindBy(how = How.XPATH, using="//div[@class='ivu-modal']//input[@title='Enter Business Department Director']")
    public WebElement businessDepartmentDirectorTextbox;
    @FindBy(how = How.XPATH, using="//div[@class='ivu-modal']//input[@title='Enter Times Approver']")
    public WebElement timesApproverTextbox;
    @FindBy(how = How.XPATH, using="//div[@class='ivu-modal']//input[@title='Enter BTK Project Code']")
    public WebElement btkProjectCodeTextbox;
    @FindBy(how = How.XPATH, using="//div[@class='ivu-modal']//input[@title='Enter BTK Project Name']")
    public WebElement btkProjectNameTextbox;
    @FindBy(how = How.XPATH, using="//div[@class='ivu-modal']//input[@title='Enter Project Knowledge Base']")
    public WebElement projectKnowledgeBaseTextbox;
    @FindBy(how = How.XPATH, using="//div[@class='ivu-modal']//input[@title='Select Start Date']")
    public WebElement startDateCalendar;
    @FindBy(how = How.XPATH, using="//div[@class='ivu-modal']//input[@title='Select End Date']")
    public WebElement endDateCalendar;
    @FindBy(how = How.XPATH, using="//div[@class='ivu-modal']//input[@placeholder='Select Type']")
    public WebElement projectTypeDropdown;
    public By projectTypeListBy = By.xpath("//div[@class='ivu-select-dropdown vxe-table--ignore-clear ivu-select-dropdown-transfer']//ul[@class='ivu-select-dropdown-list']//li");
    @FindBy(how = How.XPATH, using="//button[@class='ivu-btn ivu-btn-ghost']//span[text()='Upload File']")
    public WebElement uploadFileButton;
    @FindBy(how = How.XPATH, using="//button[@name='button_4']//span[text()='Save']")
    public WebElement saveButton;
    @FindBy(how = How.XPATH, using="//button[@name='button_5']//span[text()='Reset']")
    public WebElement resetButton;
    @FindBy(how = How.XPATH, using="//a[@class='ivu-modal-close']")
    public WebElement closeXButton;
    @FindBy(how = How.XPATH, using="//div[@class='ivu-page-options']//div[@class='ivu-select-selection']")
    public WebElement paginationButton;
    @FindBy(how = How.XPATH, using="//div[@class='ivu-modal-content']//div[@title='Create New Project']")
    public WebElement createNewProjectFormHeading;
    @FindBy(how = How.XPATH, using="//form[@layoutid='1622031118666070']//div[@class='ivu-form-item-error-tip']")
    public WebElement createNewProjectWarningMessages;
    @FindBy(how = How.XPATH, using="//span[@title='Project Management']")
    public WebElement projectManagementHeading;


    @Step("Create new project")
    public void createNewProject(String projectCode, String projectName, String status, String DC, String ChargeMode,
                                 String responsible, String chargeStatus, String turkeyPm,String businessManager,
                                 String departmentDirector, String timesApprover, String BTKProjectCode,
                                 String BTKProjectName, String projectKnowledgeBase, String startDate,
                                 String endDate, String projectType ){
        try{
            ReportListener.info("CreateNewProject is started.");
            waitUntilElementVisible(addButton);
            addButton.click();
            waitUntilElementVisible(projectCodeTextbox);
            projectCodeTextbox.sendKeys(projectCode);
            projectNameTextbox.sendKeys(projectName);
            if (!status.equals("")) {
                statusDropdown.click();
                List<WebElement> tempList = presenceOfAllWait(DropdownListsPathForAddProjectBy, 30);
                for(WebElement element:tempList){
                    if (element.getAttribute("title").equals(status)){
                        findAndScrollWebElement(element);
                        element.click();
                        break;
                    }
                }
            }
            if (!DC.equals("")) {
                dcDropdown.click();
                List<WebElement> tempList = presenceOfAllWait(DropdownListsPathForAddProjectBy, 30);
                for(WebElement element:tempList){
                    if (element.getAttribute("title").equals(status)){
                        findAndScrollWebElement(element);
                        element.click();
                        break;
                    }
                }
            }
            if (!ChargeMode.equals("")) {
                chargeModeDropdown.click();
                List<WebElement> tempList = presenceOfAllWait(DropdownListsPathForAddProjectBy, 30);
                for(WebElement element:tempList){
                    if (element.getAttribute("title").equals(status)){
                        findAndScrollWebElement(element);
                        element.click();
                        break;
                    }
                }
            }
            responsibleTextbox.sendKeys(responsible);
            if (!chargeStatus.equals("")) {
                chargeStatusDropdown.click();
                List<WebElement> tempList = presenceOfAllWait(DropdownListsPathForAddProjectBy, 30);
                for(WebElement element:tempList){
                    if (element.getAttribute("title").equals(status)){
                        findAndScrollWebElement(element);
                        element.click();
                        break;
                    }
                }
            }
            waitFor(1);
            turkeyPMTextbox.sendKeys(turkeyPm);
            businessManagerTextbox.sendKeys(businessManager);
            businessDepartmentDirectorTextbox.sendKeys(departmentDirector);
            timesApproverTextbox.sendKeys(timesApprover);
            btkProjectCodeTextbox.sendKeys(BTKProjectCode);
            btkProjectNameTextbox.sendKeys(BTKProjectName);
            projectKnowledgeBaseTextbox.sendKeys(projectKnowledgeBase);
            startDateCalendar.sendKeys(startDate);
            endDateCalendar.sendKeys(endDate);
            if (!projectType.equals("")) {
                statusDropdown.click();
                List<WebElement> tempList = presenceOfAllWait(projectTypeListBy, 30);
                for(WebElement element:tempList){
                    if (element.getAttribute("title").equals(status)){
                        findAndScrollWebElement(element);
                        element.click();
                        break;
                    }
                }
            }
            ReportListener.pass("createNewProject is completed.");
        }catch(Exception e){
            ReportListener.fail("createNewProject is not completed");
            Assert.fail("createNewProject is not completed. The reason: " + e.getMessage());
        }
    }

    @Step("Check close button")
    public void checkCloseButton(){
        try{
            ReportListener.info("checkCloseButton is started.");
            waitUntilElementVisible(addButton);
            addButton.click();
            waitUntilElementVisible(closeXButton);
            closeXButton.click();
            waitFor(2);
            if(checkElementIsDisplayed(createNewProjectFormHeading)){
                ReportListener.fail("Create project form can not be closed successfully.");
                Assert.fail("Create project form can not be closed successfully.");
            }
            ReportListener.info("checkCloseButton is completed.");
        }catch(Exception e){
            ReportListener.fail("checkCloseButton is not completed.");
            Assert.fail("checkCloseButton is not completed. The reason: " + e.getMessage());
        }
    }

    @Step("Check warning messages")
    public void checkWarningMessages(String expectedWarningMessage){
        try{
            saveButton.click();
            ReportListener.info("checkWarningMessages is started.");
            waitUntilElementVisible(createNewProjectWarningMessages);
            String currentWarningMessage = createNewProjectWarningMessages.getText();
            if(!currentWarningMessage.equals(expectedWarningMessage)){
                ReportListener.fail("Current warning message: " + currentWarningMessage+ "; Expected warning message: " + expectedWarningMessage);
                Assert.fail("Current warning message: " + currentWarningMessage+ "; Expected warning message: " + expectedWarningMessage);
            }
            ReportListener.info("checkWarningMessages is completed.");
        }catch(Exception e){
            ReportListener.fail("checkWarningMessages is not completed.");
            Assert.fail("checkWarningMessages is not completed. The reason: " + e.getMessage());
        }
    }


}
