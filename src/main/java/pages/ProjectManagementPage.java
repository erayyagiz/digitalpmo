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



    public void clickAddButton() {
        waitUntilElementVisible(filterProjectName);
        filterProjectName.sendKeys("TEST TEST");
    }
}
