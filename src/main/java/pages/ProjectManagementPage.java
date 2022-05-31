package pages;

import com.ey.automation.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProjectManagementPage extends BasePage {
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
    @FindBy(how = How.XPATH, using="//button[@name='button_1']//span[text()='Reset']")
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
    @FindBy(how = How.XPATH, using="//button[@class='ivu-btn ivu-btn-ghost']//span[text()='Upload File']")
    public WebElement uploadFileButton;
    @FindBy(how = How.XPATH, using="//button[@name='button_4']//span[text()='Save']")
    public WebElement saveButton;
    @FindBy(how = How.XPATH, using="//button[@name='button_5']//span[text()='Reset']")
    public WebElement resetButton;
    @FindBy(how = How.XPATH, using="//i[@class='ivu-icon ivu-icon-ios-close-empty']")
    public WebElement closeXButton;
    @FindBy(how = How.XPATH, using="//div[@class='ivu-page-options']//div[@class='ivu-select-selection']")
    public WebElement paginationButton;



}
