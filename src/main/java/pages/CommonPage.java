package pages;

import com.ey.automation.base.BasePage;
import com.ey.automation.listener.ReportListener;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.List;

public class CommonPage extends BasePage {

    public By generalCustomCostInputList = By.xpath("//div[@class='ivu-modal-content']//input[@name='inputnumber_1644837478299']");

    @FindBy(how = How.XPATH, using="(//*[@class='portal-tab-content__body menu-top'])[last()]")
    public WebElement frame;
    @FindBy(how = How.XPATH, using="//i[@title='Project Management']/parent::div")
    public WebElement projectManagementMenuButton;
    @FindBy(how = How.XPATH, using="//i[@title='Resource And Cost']/parent::div")
    public WebElement resourceAndCostMenuButton;
    @FindBy(how = How.XPATH, using="//span[@title='Planned Resource and Cost']")
    public WebElement plannedResourceAndCostSubMenuButton;
    @FindBy(how = How.XPATH, using="//span[@title='Actual Resource and Cost']")
    public WebElement actualResourceAndCostSubMenuButton;
    @FindBy(how = How.XPATH, using="//h4[@class='ml-4']")
    public WebElement advancePagesTitle;
    @FindBy(how = How.XPATH, using="(//div[@class='ivu-title-heading1']/span)[1]")
    public WebElement standartPagesTitle;
    @FindBy(how = How.XPATH, using="//i[@title='Meeting']/parent::div")
    public WebElement meetingMenuButton;
    @FindBy(how = How.XPATH, using="//span[@title='Planned Meetings']")
    public WebElement plannedMeetingsSubMenuButton;
    @FindBy(how = How.XPATH, using="//span[@title='Actual Meetings']")
    public WebElement actualMeetingsSubMenuButton;
    @FindBy(how = How.XPATH, using="//i[@title='Reporting']/parent::div")
    public WebElement reportingMenuButton;
    @FindBy(how = How.XPATH, using="//span[@title='Planned Reports']")
    public WebElement plannedReportsSubMenuButton;
    @FindBy(how = How.XPATH, using="//span[@title='Actual Reports']")
    public WebElement actualReportsSubMenuButton;
    @FindBy(how = How.XPATH, using="//i[@title='Metrics Dashboard']/parent::div")
    public WebElement metricsDashboardMenuButton;
    @FindBy(how = How.XPATH, using="//i[@title='Management Dashboard']/parent::div")
    public WebElement managementDashboardMenuButton;
    @FindBy(how = How.XPATH, using="//i[@title='About']/parent::div")
    public WebElement aboutMenuButton;
    @FindBy(how = How.XPATH, using="//span[@title='Help']")
    public WebElement helpSubMenuButton;
    @FindBy(how = How.XPATH, using="//span[@title='Send Suggestions']")
    public WebElement sendSuggestionsSubMenuButton;
    @FindBy(how = How.XPATH, using="//button[@type='button']//span[text()='Add']")
    public WebElement addGeneralCustomCostButton;
    @FindBy(how = How.XPATH, using="//div[@class='ivu-modal-footer xview-container']//button[@type='button']//span[text()='Save']")
    public WebElement saveGeneralCustomCostButton;
    @FindBy(how = How.XPATH, using="(//button[@type='button']//span[text()='Delete'])[1]")
    public WebElement deleteGeneralCustomCostsButton;
    @FindBy(how = How.XPATH, using="//button[@type='button']//span[text()='Confirm']")
    public WebElement confirmDeleteGeneralCustomCostsButton;
    @FindBy(how = How.XPATH, using="(//span[@class='ivu-checkbox'])[1]")
    public WebElement allSelectGeneralCustomCostCheckbox;
    @FindBy(how = How.XPATH, using="//tr[@class='ivu-table-row ivu-table-row-0']")
    public WebElement generalCustomCost;

    @Step("Switch to the frame")
    public void switchFrame(){
        try {
            ReportListener.info("switchFrame is started.");
            waitUntilFrameToBeAvailableAndSwitchToItByWebelement(frame);
            ReportListener.pass("switchFrame is completed.");
        } catch (Exception e) {
            ReportListener.fail("switchFrame is not completed.");
            Assert.fail("switchFrame is not completed. The reason: "+e.getMessage());
        }
    }

    @Step("Go to {expectedPage} Page")
    public void goToPage(String expectedPage){
        try {
            ReportListener.info("goToPage is started.");
            waitFor(2);
            if(expectedPage.equals("Project Management Page")){
                waitUntilElementVisible(projectManagementMenuButton);
                projectManagementMenuButton.click();
            }
            if(expectedPage.equals("Planned Resource and Cost")){
                waitUntilElementVisible(resourceAndCostMenuButton);
                resourceAndCostMenuButton.click();
                waitFor(1);
                plannedResourceAndCostSubMenuButton.click();
            }
            if(expectedPage.equals("Actual Resource and Cost")){
                waitUntilElementVisible(resourceAndCostMenuButton);
                resourceAndCostMenuButton.click();
                waitFor(1);
                actualResourceAndCostSubMenuButton.click();
            }
            if(expectedPage.equals("Meeting Plan")){
                waitUntilElementVisible(meetingMenuButton);
                meetingMenuButton.click();
                waitFor(1);
                plannedMeetingsSubMenuButton.click();
            }
            if(expectedPage.equals("Actual Meetings")){
                waitUntilElementVisible(meetingMenuButton);
                meetingMenuButton.click();
                waitFor(1);
                actualMeetingsSubMenuButton.click();
            }
            if(expectedPage.equals("Report Plan")){
                waitUntilElementVisible(reportingMenuButton);
                reportingMenuButton.click();
                waitFor(1);
                plannedReportsSubMenuButton.click();
            }
            if(expectedPage.equals("Actual Reports")){
                waitUntilElementVisible(reportingMenuButton);
                reportingMenuButton.click();
                waitFor(1);
                actualReportsSubMenuButton.click();
            }
            if(expectedPage.equals("Metrics Dashboard" )){
                waitUntilElementVisible(metricsDashboardMenuButton);
                metricsDashboardMenuButton.click();
            }
            if(expectedPage.equals("Management Dashboard" )){
                waitUntilElementVisible(managementDashboardMenuButton);
                managementDashboardMenuButton.click();
            }
            if(expectedPage.equals("Help")){
                waitUntilElementVisible(aboutMenuButton);
                aboutMenuButton.click();
                waitFor(1);
                helpSubMenuButton.click();
            }
            if(expectedPage.equals("Send Suggestion")){
                waitUntilElementVisible(aboutMenuButton);
                aboutMenuButton.click();
                waitFor(1);
                sendSuggestionsSubMenuButton.click();
            }
            switchFrame();
            waitFor(3);
            String currentPageTitle=null;
            try {
                currentPageTitle = standartPagesTitle.getText();
            } catch (Exception e) {
                currentPageTitle = advancePagesTitle.getText();
            }
            if(!currentPageTitle.contains(expectedPage)){
                ReportListener.fail("Expected Page: "+expectedPage+" ;Current Page: "+currentPageTitle);
                Assert.fail("Expected Page: "+expectedPage+" ;Current Page: "+currentPageTitle);
            }
            ReportListener.pass("goToPage is completed.");
        }catch (Exception e){
            ReportListener.fail("goToPage is not completed.");
            Assert.fail("goToPage is not completed. The reason: "+e.getMessage());
        }
    }

    @Step("Create a general custom cost")
    public void createGeneralCustomCost(String year, String toMonth, String costs) {
        try {
            ReportListener.info("createGeneralCustomCost is started.");
            removeAllGeneralCustomCost();
            waitUntilElementVisible(addGeneralCustomCostButton);
            addGeneralCustomCostButton.click();
            List<WebElement> generalCustomCostInputs = presenceOfAllWait(generalCustomCostInputList, 30);
            generalCustomCostInputs.get(0).sendKeys(toMonth);
            for(int i=1;i<=7;i++){
                generalCustomCostInputs.get(i).sendKeys(costs);
            }
            generalCustomCostInputs.get(8).sendKeys(year);
            saveGeneralCustomCostButton.click();
            waitUntilElementVisible(generalCustomCost);
            switchTabByGivenTitle("Digital PMO");
            ReportListener.pass("createGeneralCustomCost is completed.");
        } catch (Exception e) {
            ReportListener.fail("createGeneralCustomCost is not completed.");
            Assert.fail("createGeneralCustomCost is not completed. The reason: " + e.getMessage());
        }
    }

    @Step("Remove all general custom costs")
    public void removeAllGeneralCustomCost() {
        try {
            ReportListener.info("removeAllGeneralCustomCost is started.");
            openNewTabAndNavigateToURL("https://app-test.rnd.huawei.com/besBaas/page#/__layout__HTRDC__PMO_PreviewsGeneralCustomCosts__CST__records");
            waitUntilElementVisible(deleteGeneralCustomCostsButton);
            if(checkElementIsDisplayed(generalCustomCost)){
                allSelectGeneralCustomCostCheckbox.click();
                deleteGeneralCustomCostsButton.click();
                waitUntilElementVisible(confirmDeleteGeneralCustomCostsButton);
                confirmDeleteGeneralCustomCostsButton.click();
            }
            waitUntilElementInVisible(generalCustomCost);
            ReportListener.pass("removeAllGeneralCustomCost is completed.");
        } catch (Exception e) {
            ReportListener.fail("removeAllGeneralCustomCost is not completed.");
            Assert.fail("removeAllGeneralCustomCost is not completed. The reason: " + e.getMessage());
        }
    }
}
