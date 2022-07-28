package pages;

import api.Endpoints;
import com.ey.automation.listener.ReportListener;
import io.qameta.allure.Step;
import org.apache.commons.text.CaseUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResourceAndCostPage extends CommonPage {

    public By dropdownList = By.xpath("//div[contains(@class,'menuable__content__active')]//div[@class='v-list-item__title']");
    public By tableRowYearList = By.xpath("//div[@id='dataTable']//tbody/tr/td[1]");
    public By tableRowProjectList = By.xpath("//div[@id='dataTable']//tbody/tr/td[2]");
    public By tableRowDCList = By.xpath("//div[@id='dataTable']//tbody/tr/td[3]");
    public By tableColumnList = By.xpath("//div[@id='dataTable']//tbody/tr[1]/td");
    public By customCostValueList = By.xpath("(//div[@class='row centeredItems justify-center'])[last()]//input[@id='modalCustomCost']");
    public By allCostValueList = By.xpath("//input[contains(@id,'hwl') or contains(@id,'otl') or @id='cpall']");

    @FindBy(how = How.XPATH, using = "//p[text()=' No Data']")
    public WebElement noDataText;
    @FindBy(how = How.XPATH, using = "//input[@id='year']")
    public WebElement filterYear;
    @FindBy(how = How.XPATH, using = "//input[@id='project']")
    public WebElement filterProject;
    @FindBy(how = How.XPATH, using = "//input[@id='dc']")
    public WebElement filterDC;
    @FindBy(how = How.XPATH, using = "//label[@for='chargeMode']/following-sibling::div[@class='v-select__selections']")
    public WebElement filterChargeMode;
    @FindBy(how = How.XPATH, using = "//label[@for='chargeStatus']/following-sibling::div[@class='v-select__selections']")
    public WebElement filterChargeStatus;
    @FindBy(how = How.XPATH, using = "//button[@type='button']//span[text()=' Reset ']")
    public WebElement filterResetButton;
    @FindBy(how = How.XPATH, using = "//button[@type='button']//span[text()=' Add ']")
    public WebElement addResourceAndCostButton;
    @FindBy(how = How.XPATH, using = "//button[@type='button']//span[text()=' Export ']")
    public WebElement exportResourceAndCostButton;
    @FindBy(how = How.XPATH, using = "(//button[@type='button']//span[text()=' Edit '])[1]")
    public WebElement editFirstResourceAndCostButton;
    @FindBy(how = How.XPATH, using = "(//button[@type='button']//span[text()=' Delete '])[1]")
    public WebElement deleteFirstResourceAndCostButton;
    @FindBy(how = How.XPATH, using = "//div[@class='v-card v-sheet theme--light']//button[@type='button']//span[text()='Delete']")
    public WebElement deleteConfirmResourceAndCostButton;
    @FindBy(how = How.XPATH, using = "//div[@class='v-card v-sheet theme--light']//button[@type='button']//span[text()='Close']")
    public WebElement deleteCloseResourceAndCostButton;
    @FindBy(how = How.XPATH, using = "//div[@class='v-data-footer__select']//div[@class='v-select__selections']")
    public WebElement paginationDropdown;
    @FindBy(how = How.XPATH, using = "//div[@role='document']//button[@type='button']//span[text()='Close']")
    public WebElement closeResourceAndCostButton;
    @FindBy(how = How.XPATH, using = "//div[@role='document']//button[@type='button']//span[text()=' Save ']")
    public WebElement saveResourceAndCostButton;
    @FindBy(how = How.XPATH, using = "//div[@role='document']//button[@type='button']//span[text()=' Reset ']")
    public WebElement resetResourceAndCostButton;
    @FindBy(how = How.XPATH, using = "//input[@id='modalYear']")
    public WebElement yearResourceAndCostDropdown;
    @FindBy(how = How.XPATH, using = "//input[@id='modalProject']")
    public WebElement projectResourceAndCostDropdown;
    @FindBy(how = How.XPATH, using = "(//div[@role='listbox']//div[@class='v-list-item__title']/span)[1]")
    public WebElement firstProjectResourceAndCostDropdown;
    @FindBy(how = How.XPATH, using = "//input[@id='musd']")
    public WebElement costTransferPlanesourceAndCostTextbox;
    @FindBy(how = How.XPATH, using = "//div[@role='document']//button[@type='button']//span[text()=' Add Custom Cost ']")
    public WebElement addCustomCostResourceAndCostButton;
    @FindBy(how = How.XPATH, using = "//div[@role='document']//button[@type='button']//span[text()=' Add ']")
    public WebElement addMultipleCustomCostResourceAndCostButton;
    @FindBy(how = How.XPATH, using = "//div[@role='document']//button[@type='button']//span[text()=' Remove ']")
    public WebElement removeMultipleCustomCostResourceAndCostButton;
    @FindBy(how = How.XPATH, using = "(//input[@id='customStartMonth'])[last()]")
    public WebElement startMonthCustomCostResourceAndCostTextbox;
    @FindBy(how = How.XPATH, using = "(//input[@id='customEndMonth'])[last()]")
    public WebElement endMonthCustomCostResourceAndCostTextbox;
    @FindBy(how = How.XPATH, using = "//div[@class='v-card v-sheet theme--light']//label[@for='modalYear']/following-sibling::*//button[@aria-label='clear icon']")
    public WebElement removeYearButton;
    @FindBy(how = How.XPATH, using = "//div[@class='v-card v-sheet theme--light']//label[@for='modalProject']/following-sibling::*//button[@aria-label='clear icon']")
    public WebElement removeProjectButton;
    @FindBy(how = How.XPATH, using = "//div[@role='status']/strong[text()=' Plan updated successfully']")
    public WebElement plannedSuccessMessage;
    @FindBy(how = How.XPATH, using = "//div[@role='status']/strong")
    public WebElement plannedFailedMessage;

    @Step("Close and check the project tab")
    public void closeAndCheckProjectTab(String type) {
        try {
            ReportListener.info("closeAndCheckProjectTab is started.");
            if (type.equals("Add")) {
                waitUntilElementVisible(addResourceAndCostButton);
                addResourceAndCostButton.click();
            } else if (type.equals("Edit")) {
                waitUntilElementVisible(editFirstResourceAndCostButton);
                editFirstResourceAndCostButton.click();
            }
            waitUntilElementVisible(closeResourceAndCostButton);
            closeResourceAndCostButton.click();
            waitUntilElementInVisible(closeResourceAndCostButton);
            ReportListener.pass("closeAndCheckProjectTab is completed.");
        } catch (Exception e) {
            ReportListener.fail("closeAndCheckProjectTab is not completed.");
            Assert.fail("closeAndCheckProjectTab is not completed. The reason: " + e.getMessage());
        }
    }

    @Step("Create a resource and cost plan")
    public void createResourceAndCostPlan(String year, String projectName, String costTransferPlan, String allCostValues) {
        try {
            ReportListener.info("createResourceAndCostPlan is started.");
            waitUntilElementVisible(addResourceAndCostButton);
            addResourceAndCostButton.click();
            waitUntilElementVisible(closeResourceAndCostButton);
            removeYearButton.click();
            yearResourceAndCostDropdown.sendKeys(year);
            if (!projectName.equals("")) {
                projectResourceAndCostDropdown.sendKeys(projectName);
                Assert.assertEquals(firstProjectResourceAndCostDropdown.getText(), projectName);
                firstProjectResourceAndCostDropdown.click();
            }
            costTransferPlanesourceAndCostTextbox.sendKeys(costTransferPlan);
            if (!allCostValues.equals("")) {
                List<WebElement> allCosts = presenceOfAllWait(allCostValueList, 30);
                for (WebElement allCost : allCosts) {
                    allCost.sendKeys(allCostValues);
                }
            }
            ReportListener.pass("createResourceAndCostPlan is completed.");
        } catch (Exception e) {
            ReportListener.fail("createResourceAndCostPlan is not completed.");
            Assert.fail("createResourceAndCostPlan is not completed. The reason: " + e.getMessage());
        }
    }

    @Step("Create a custom cost plan")
    public void createCustomCostPlan(String startMonth, String endMonth, String costs) {
        try {
            ReportListener.info("createCustomCostPlan is started.");
            if (checkElementIsDisplayed(addMultipleCustomCostResourceAndCostButton))
                addMultipleCustomCostResourceAndCostButton.click();
            else
                addCustomCostResourceAndCostButton.click();
            startMonthCustomCostResourceAndCostTextbox.sendKeys(startMonth);
            endMonthCustomCostResourceAndCostTextbox.sendKeys(endMonth);
            List<WebElement> customCostValues = presenceOfAllWait(customCostValueList, 30);
            for (WebElement customCostValue : customCostValues)
                customCostValue.sendKeys(costs);
            ReportListener.pass("createCustomCostPlan is completed.");
        } catch (Exception e) {
            ReportListener.fail("createCustomCostPlan is not completed.");
            Assert.fail("createCustomCostPlan is not completed. The reason: " + e.getMessage());
        }
    }

    @Step("Check that the project is planned")
    public void checkResourceAndCostPlanned(String expectedYear, String expectedProjectName, String expectedCostTransferPlan, String expectedCosts, String expectedHalfYearResult, String expectedFullYearResult) {
        try {
            ReportListener.info("checkResourceAndCostPlanned is started.");
            saveResourceAndCostButton.click();
            waitUntilElementVisible(plannedSuccessMessage);
            filterResetButton.click();
            waitUntilElementVisible(editFirstResourceAndCostButton);
            List<WebElement> firstColumnValues = presenceOfAllWait(tableColumnList, 30);
            String currentProjectName = firstColumnValues.get(1).getText();
            String currentYear = firstColumnValues.get(0).getText();
            String currentCostTransferPlan = firstColumnValues.get(97).getText();
            String currentHalfYearResult = firstColumnValues.get(95).getText();
            String currentFullYearResult = firstColumnValues.get(96).getText();
            if (!currentCostTransferPlan.equals(expectedCostTransferPlan)) {
                ReportListener.fail("Current Cost Transfer Plan: " + currentCostTransferPlan + "; Expected Cost Transfer Plan: " + expectedCostTransferPlan);
                Assert.fail("Current Cost Transfer Plan: " + currentCostTransferPlan + "; Expected Cost Transfer Plan: " + expectedCostTransferPlan);
            }
            if (!currentProjectName.equals(expectedProjectName)) {
                ReportListener.fail("Current Project Name: " + currentProjectName + "; Expected Project Name: " + expectedProjectName);
                Assert.fail("Current Project Name: " + currentProjectName + "; Expected Project Name: " + expectedProjectName);
            }
            if (!currentYear.equals(expectedYear)) {
                ReportListener.fail("Current Year: " + currentYear + "; Expected Year: " + expectedYear);
                Assert.fail("Current Year: " + currentYear + "; Expected Year: " + expectedYear);
            }
            if (!expectedFullYearResult.equals(currentFullYearResult) || !expectedHalfYearResult.equals(currentHalfYearResult)) {
                ReportListener.fail("Current Half Year Result: " + currentHalfYearResult + "; Expected Half Year Result: " + expectedHalfYearResult + " and Current Full Year Result: " + currentFullYearResult + "; Expected Full Year Result: " + expectedFullYearResult);
                Assert.fail("Current Half Year Result: " + currentHalfYearResult + "; Expected Half Year Result: " + expectedHalfYearResult + " and Current Full Year Result: " + currentFullYearResult + "; Expected Full Year Result: " + expectedFullYearResult);
            }
            for (int i = 5; i < 88; i++) {
                String currentCostValue = firstColumnValues.get(i).getText();
                if (!currentCostValue.equals(expectedCosts)) {
                    ReportListener.fail("Current Cost Value: " + currentCostValue + "; Expected Cost Value: " + expectedCosts + " on " + i + ". column.");
                    Assert.fail("Current Cost Value: " + currentCostValue + "; Expected Cost Value: " + expectedCosts + " on " + i + ". column.");
                }
            }
            ReportListener.pass("checkResourceAndCostPlanned is completed.");
        } catch (Exception e) {
            ReportListener.fail("checkResourceAndCostPlanned is not completed.");
            Assert.fail("checkResourceAndCostPlanned is not completed. The reason: " + e.getMessage());
        }
    }

    @Step("Check that the warning message is displayed")
    public void checkProjectNotPlannedWarningMessage(String expectedErrorMessage) {
        try {
            ReportListener.info("checkProjectNotPlannedWarningMessage is started.");
            saveResourceAndCostButton.click();
            waitUntilElementVisible(plannedFailedMessage);
            String currentErrorMessage = plannedFailedMessage.getText();
            if (!currentErrorMessage.contains(expectedErrorMessage)) {
                ReportListener.fail("The error message is not correct. Current Error Message: " + currentErrorMessage + "; Expected Error Message: " + expectedErrorMessage);
                Assert.fail("The error message is not correct. Current Error Message: " + currentErrorMessage + "; Expected Error Message: " + expectedErrorMessage);
            }
            ReportListener.pass("checkProjectNotPlannedWarningMessage is completed.");
        } catch (Exception e) {
            ReportListener.fail("checkProjectNotPlannedWarningMessage is not completed.");
            Assert.fail("checkProjectNotPlannedWarningMessage is not completed. The reason: " + e.getMessage());
        }
    }

    @Step("Check all the cost values")
    public void checkAllCostValuesWhenReset() {
        try {
            ReportListener.info("checkAllCostValuesWhenReset is started.");
            waitUntilElementVisible(resetResourceAndCostButton);
            resetResourceAndCostButton.click();
            waitFor(1);
            List<WebElement> allCostValues = presenceOfAllWait(allCostValueList, 30);
            for (WebElement allCostValue : allCostValues) {
                String costValue = allCostValue.getAttribute("costvalue");
                if (!costValue.equals("0")) {
                    ReportListener.fail("All cost values cannot be resetted!");
                    Assert.fail("All cost values cannot be resetted!");
                }
            }
            ReportListener.pass("checkAllCostValuesWhenReset is completed.");
        } catch (Exception e) {
            ReportListener.fail("checkAllCostValuesWhenReset is not completed.");
            Assert.fail("checkAllCostValuesWhenReset is not completed. The reason: " + e.getMessage());
        }
    }

    @Step("Check that all the cost values are resetted")
    public void checkAllCostValuesAfterReset() {
        try {
            ReportListener.info("checkAllCostValuesAfterReset is started.");
            saveResourceAndCostButton.click();
            waitUntilElementVisible(plannedSuccessMessage);
            filterResetButton.click();
            waitUntilElementVisible(editFirstResourceAndCostButton);
            List<WebElement> firstColumnValues = presenceOfAllWait(tableColumnList, 30);
            for (int i = 5; i < 88; i++) {
                String currentCostValue = firstColumnValues.get(i).getText();
                if (!currentCostValue.equals("0")) {
                    ReportListener.fail("Current Cost Value: " + currentCostValue + "; Expected Cost Value: 0 on " + i + ". column.");
                    Assert.fail("Current Cost Value: " + currentCostValue + "; Expected Cost Value: 0 on " + i + ". column.");
                }
            }
            ReportListener.pass("checkAllCostValuesAfterReset is completed.");
        } catch (Exception e) {
            ReportListener.fail("checkAllCostValuesAfterReset is not completed.");
            Assert.fail("checkAllCostValuesAfterReset is not completed. The reason: " + e.getMessage());
        }
    }

    @Step("Remove a resource and cost plan's parameter")
    public void removeResourceAndCostPlanParameter(String year, String costTransferPlan, String customCostValues, String allCostValues) {
        try {
            ReportListener.info("removeResourceAndCostPlanParameter is started.");
            filterResetButton.click();
            waitUntilElementVisible(editFirstResourceAndCostButton);
            editFirstResourceAndCostButton.click();
            waitUntilElementVisible(closeResourceAndCostButton);
            if (year.equals("Removed"))
                removeYearButton.click();
            if (costTransferPlan.equals("Removed"))
                deleteTextbox(costTransferPlanesourceAndCostTextbox);
            if (customCostValues.equals("Removed")) {
                while (checkElementIsDisplayed(removeMultipleCustomCostResourceAndCostButton)) {
                    removeMultipleCustomCostResourceAndCostButton.click();
                }
            }
            if (allCostValues.equals("Removed"))
                resetResourceAndCostButton.click();
            ReportListener.pass("removeResourceAndCostPlanParameter is completed.");
        } catch (Exception e) {
            ReportListener.fail("removeResourceAndCostPlanParameter is not completed.");
            Assert.fail("removeResourceAndCostPlanParameter is not completed. The reason: " + e.getMessage());
        }
    }

    @Step("Edit a resource and cost plan")
    public void editResourceAndCostPlan(String year, String costTransferPlan, String allCostValues) {
        try {
            ReportListener.info("editResourceAndCostPlan is started.");
            waitUntilElementVisible(filterResetButton);
            filterResetButton.click();
            waitUntilElementVisible(editFirstResourceAndCostButton);
            List<WebElement> firstColumnValues = presenceOfAllWait(tableColumnList, 30);
            String expectedProjectName = firstColumnValues.get(1).getText();
            String expectedProjectYear = firstColumnValues.get(0).getText();
            editFirstResourceAndCostButton.click();
            waitUntilElementVisible(closeResourceAndCostButton);
//            String currentProjectName = projectResourceAndCostDropdown.getAttribute("projectname");
            String currentProjectYear = yearResourceAndCostDropdown.getAttribute("yearval");
//            if(!currentProjectName.equals(expectedProjectName)){
//                ReportListener.fail("Current Project Name: "+currentProjectName+"; Expected Project Name: "+expectedProjectName);
//                Assert.fail("Current Project Name: "+currentProjectName+"; Expected Project Name: "+expectedProjectName);
//            }
            if (!currentProjectYear.equals(expectedProjectYear)) {
                ReportListener.fail("Current Project Year: " + currentProjectYear + "; Expected Project Year: " + expectedProjectYear);
                Assert.fail("Current Project Year: " + currentProjectYear + "; Expected Project Year: " + expectedProjectYear);
            }
            while (checkElementIsDisplayed(removeMultipleCustomCostResourceAndCostButton)) {
                removeMultipleCustomCostResourceAndCostButton.click();
            }
            SimpleDateFormat formatter = new SimpleDateFormat("MM");
            SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy");
            Date date = new Date();
            int currentMonth = Integer.parseInt(formatter.format(date));
            String currentYear = formatter1.format(date);
            int disabledMonthCount = (currentMonth - 1) * 7;
            yearResourceAndCostDropdown.sendKeys(year);
            deleteTextbox(costTransferPlanesourceAndCostTextbox);
            costTransferPlanesourceAndCostTextbox.sendKeys(costTransferPlan);
            if (!allCostValues.equals("")) {
                List<WebElement> allCosts = presenceOfAllWait(allCostValueList, 30);
                if (currentYear.equals(year)) {
                    for (int i = 0; i < disabledMonthCount; i++) {
                        if (allCosts.get(i).isEnabled()) {
                            ReportListener.fail("The cost values whose time passed cannot be displayed as disabled.");
                            Assert.fail("The cost values whose time passed cannot be displayed as disabled.");
                        }
                    }
                    for (int i = disabledMonthCount; i < allCosts.size(); i++) {
                        allCosts.get(i).sendKeys(allCostValues);
                    }
                } else {
                    for (int i = 0; i < allCosts.size(); i++) {
                        allCosts.get(i).sendKeys(allCostValues);
                    }
                }
            }
            ReportListener.pass("editResourceAndCostPlan is completed.");
        } catch (Exception e) {
            ReportListener.fail("editResourceAndCostPlan is not completed.");
            Assert.fail("editResourceAndCostPlan is not completed. The reason: " + e.getMessage());
        }
    }

    @Step("Check that resource and cost plan is deleted")
    public void deleteResourceAndCostPlan(String toDeleteProjectName) {
        try {
            ReportListener.info("deleteResourceAndCostPlan is started.");
            waitUntilElementVisible(filterResetButton);
            filterResetButton.click();
            waitUntilElementVisible(deleteFirstResourceAndCostButton);
            List<WebElement> firstColumnValues = presenceOfAllWait(tableColumnList, 30);
            String currentProjectName = firstColumnValues.get(1).getText();
            if (!currentProjectName.equals(toDeleteProjectName)) {
                ReportListener.fail("Current Project Name: " + currentProjectName + "; To Delete Project Name: " + toDeleteProjectName);
                Assert.fail("Current Project Name: " + currentProjectName + "; To Delete Project Name: " + toDeleteProjectName);
            }
            deleteFirstResourceAndCostButton.click();
            waitUntilElementVisible(deleteConfirmResourceAndCostButton);
            deleteConfirmResourceAndCostButton.click();
            waitFor(1);
            waitUntilElementVisible(deleteFirstResourceAndCostButton);
            List<WebElement> firstColumnValues2 = presenceOfAllWait(tableColumnList, 30);
            String currentProjectName2 = firstColumnValues2.get(1).getText();
            if (currentProjectName2.equals(toDeleteProjectName)) {
                ReportListener.fail(currentProjectName + " project plan cannot be deleted!");
                Assert.fail(currentProjectName + " project plan cannot be deleted!");
            }
            ReportListener.pass("deleteResourceAndCostPlan is completed.");
        } catch (Exception e) {
            ReportListener.fail("deleteResourceAndCostPlan is not completed.");
            Assert.fail("deleteResourceAndCostPlan is not completed. The reason: " + e.getMessage());
        }
    }

    @Step("Check that resource and cost plan is filtered according to {filterType}")
    public void filterResourceAndPlan(String filterType) {
        try {
            ReportListener.info("filterResourceAndPlan is started.");
            waitUntilElementVisible(filterResetButton);
            filterResetButton.click();
            waitUntilElementVisible(paginationDropdown);
            findAndScrollWebElement(paginationDropdown);
            paginationDropdown.click();
            List<WebElement> pagination = presenceOfAllWait(dropdownList, 30);
            pagination.get(3).click();
            if (filterType.equals("Year")) {
                String selectedYear = generateRandomInteger(2021, 2030).toString();
                filterYear.sendKeys(selectedYear);
                List<WebElement> yearList = presenceOfAllWait(tableRowYearList, 30);
                for (WebElement year : yearList) {
                    if (!(year.getText().equals(selectedYear) || year.getText().contains("No Data"))) {
                        ReportListener.fail("Current Year: " + year.getText() + "; Expected Year: " + selectedYear);
                        Assert.fail("Current Year: " + year.getText() + "; Expected Year: " + selectedYear);
                    }
                }
            }
            if (filterType.equals("Project")) {
                filterProject.click();
                List<WebElement> filterProjects = presenceOfAllWait(dropdownList, 30);
                int randomFilterProject = generateRandomInteger(1, filterProjects.size());
                findAndScrollWebElement(filterProjects.get(randomFilterProject));
                String selectedProjectName = filterProjects.get(randomFilterProject).getText();
                filterProjects.get(randomFilterProject).click();
                List<WebElement> projectList = presenceOfAllWait(tableRowProjectList, 30);
                for (WebElement project : projectList) {
                    if (!(project.getText().equals(selectedProjectName) || project.getText().contains("No Data"))) {
                        ReportListener.fail("Current Project: " + project.getText() + "; Expected Project: " + selectedProjectName);
                        Assert.fail("Current Project: " + project.getText() + "; Expected Project: " + selectedProjectName);
                    }
                }
            }
            if (filterType.equals("DC")) {
                filterDC.click();
                List<WebElement> filterDCs = presenceOfAllWait(dropdownList, 30);
                int randomFilterDC = generateRandomInteger(1, filterDCs.size());
                findAndScrollWebElement(filterDCs.get(randomFilterDC));
                String selectedDC = filterDCs.get(randomFilterDC).getText().toUpperCase();
                filterDCs.get(randomFilterDC).click();
                List<WebElement> dcList = presenceOfAllWait(tableRowDCList, 30);
                for (WebElement dc : dcList) {
                    if (!(dc.getText().equals(selectedDC) || dc.getText().contains("No Data"))) {
                        ReportListener.fail("Current DC: " + dc.getText() + "; Expected DC: " + selectedDC);
                        Assert.fail("Current DC: " + dc.getText() + "; Expected DC: " + selectedDC);
                    }
                }
            }
            if (filterType.equals("Charge Mode")) {
                filterChargeMode.click();
                List<WebElement> filterChargeMode = presenceOfAllWait(dropdownList, 30);
                int randomFilterChargeMode = generateRandomInteger(0, filterChargeMode.size() - 1);
                findAndScrollWebElement(filterChargeMode.get(randomFilterChargeMode));
                waitFor(1);
                String selectedChargeMode = CaseUtils.toCamelCase(filterChargeMode.get(randomFilterChargeMode).getText(), false, ' ');
                filterChargeMode.get(randomFilterChargeMode).click();
                waitFor(1);
                Endpoints endpoints = new Endpoints();
                List<String> projectsByComingApi = endpoints.getResourceAndCostPlans(false, "chargeMode", selectedChargeMode);
                if (checkElementIsDisplayed(noDataText)) {
                    if (!projectsByComingApi.isEmpty()) {
                        ReportListener.fail("Projects by coming API cannot be displayed on the table while selected '" + selectedChargeMode + "' charge mode.");
                        Assert.fail("Projects by coming API cannot be displayed on the table while selected '" + selectedChargeMode + "' charge mode.");
                    }
                } else {
                    List<WebElement> projectListByTable = presenceOfAllWait(tableRowProjectList, 30);
                    ArrayList projectsByApi = new ArrayList<>();
                    ArrayList projectsByTable = new ArrayList<>();
                    for (WebElement projects : projectListByTable) {
                        projectsByTable.add(CaseUtils.toCamelCase(projects.getText(), false, ' '));
                    }
                    for (int i = 0; i < projectsByComingApi.size(); i++) {
                        projectsByApi.add(CaseUtils.toCamelCase(projectsByComingApi.get(i), false, ' '));
                    }
                    ReportListener.info("Projects by coming API: " + projectsByApi);
                    ReportListener.info("Projects by coming TABLE: " + projectsByTable);
                    if (!projectsByTable.equals(projectsByApi)) {
                        ReportListener.fail(selectedChargeMode + " charge mode cannot be find in the current projects.");
                        Assert.fail(selectedChargeMode + " charge mode cannot be find in the current projects.");
                    }
                }
            }
            if (filterType.equals("Charge Status")) {
                filterChargeStatus.click();
                List<WebElement> filterChargeStatus = presenceOfAllWait(dropdownList, 30);
                int randomFilterChargeStatus = generateRandomInteger(0, filterChargeStatus.size() - 1);
                findAndScrollWebElement(filterChargeStatus.get(randomFilterChargeStatus));
                waitFor(1);
                String selectedChargeStatus = CaseUtils.toCamelCase(filterChargeStatus.get(randomFilterChargeStatus).getText(), false, ' ');
                filterChargeStatus.get(randomFilterChargeStatus).click();
                waitFor(1);
                Endpoints endpoints = new Endpoints();
                List<String> projectsByComingApi = endpoints.getResourceAndCostPlans(false, "chargeStatus", selectedChargeStatus);
                if (checkElementIsDisplayed(noDataText)) {
                    if (!projectsByComingApi.isEmpty()) {
                        ReportListener.fail("Projects by coming API cannot be displayed on the table while selected '" + selectedChargeStatus + "' charge status.");
                        Assert.fail("Projects by coming API cannot be displayed on the table while selected '" + selectedChargeStatus + "' charge status.");
                    }
                } else {
                    List<WebElement> projectListByTable = presenceOfAllWait(tableRowProjectList, 30);
                    ArrayList projectsByApi = new ArrayList<>();
                    ArrayList projectsByTable = new ArrayList<>();
                    for (WebElement projects : projectListByTable) {
                        projectsByTable.add(CaseUtils.toCamelCase(projects.getText(), false, ' '));
                    }
                    for (int i = 0; i < projectsByComingApi.size(); i++) {
                        projectsByApi.add(CaseUtils.toCamelCase(projectsByComingApi.get(i), false, ' '));
                    }
                    ReportListener.info("Projects by coming API: " + projectsByApi);
                    ReportListener.info("Projects by coming TABLE: " + projectsByTable);
                    if (!projectsByTable.equals(projectsByApi)) {
                        ReportListener.fail(selectedChargeStatus + " charge status cannot be find in the current projects.");
                        Assert.fail(selectedChargeStatus + " charge status cannot be find in the current projects.");
                    }
                }
            }
            if (filterType.equals("Reset")) {
                Endpoints endpoints = new Endpoints();
                List<String> projectsByComingApi = endpoints.getResourceAndCostPlans(true, null, null);
                List<WebElement> projectListByTable = presenceOfAllWait(tableRowProjectList, 30);
                ArrayList projectsByApi = new ArrayList<>();
                ArrayList projectsByTable = new ArrayList<>();
                for (WebElement projects : projectListByTable) {
                    projectsByTable.add(CaseUtils.toCamelCase(projects.getText(), false, ' '));
                }
                for (int i = 0; i < projectsByComingApi.size(); i++) {
                    projectsByApi.add(CaseUtils.toCamelCase(projectsByComingApi.get(i), false, ' '));
                }
                ReportListener.info("Projects by coming API: " + projectsByApi);
                ReportListener.info("Projects by coming TABLE: " + projectsByTable);
                if (!projectsByTable.equals(projectsByApi)) {
                    ReportListener.fail("All the projects cannot be displayed!.");
                    Assert.fail("All the projects cannot be displayed!.");
                }
            }
            ReportListener.pass("filterResourceAndPlan is completed.");
        } catch (Exception e) {
            ReportListener.fail("filterResourceAndPlan is not completed.");
            Assert.fail("filterResourceAndPlan is not completed. The reason: " + e.getMessage());
        }
    }

    @Step("Check the pagination")
    public void checkThePagination() {
        try {
            ReportListener.info("checkThePagination is started.");
            waitUntilElementVisible(filterResetButton);
            filterResetButton.click();
            waitUntilElementVisible(paginationDropdown);
            paginationDropdown.click();
            List<WebElement> pagination = presenceOfAllWait(dropdownList, 30);
            int randomPagination = generateRandomInteger(0, pagination.size() - 1);
            findAndScrollWebElement(pagination.get(randomPagination));
            waitFor(1);
            int selectedPagination = Integer.parseInt(pagination.get(randomPagination).getText());
            pagination.get(randomPagination).click();
            waitFor(1);
            List<WebElement> projectListByTable = presenceOfAllWait(tableRowProjectList, 30);
            if (projectListByTable.size() > selectedPagination) {
                ReportListener.fail("Selected Pagination Value: "+selectedPagination+"; Listed Project Size: "+projectListByTable.size());
                Assert.fail("Selected Pagination Value: "+selectedPagination+"; Listed Project Size: "+projectListByTable.size());
            }
            ReportListener.pass("checkThePagination is completed.");
        } catch (Exception e) {
            ReportListener.fail("checkThePagination is not completed.");
            Assert.fail("checkThePagination is not completed. The reason: " + e.getMessage());
        }
    }

}
