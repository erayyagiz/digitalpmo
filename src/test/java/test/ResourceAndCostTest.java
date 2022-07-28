package test;

import base.CustomTestBase;
import org.testng.annotations.Test;

public class ResourceAndCostTest extends CustomTestBase {

    //1534525
    @Test
    public void _1PRC_CreateNewResourceAndCostPlanCloseButton() {
        commonPage().goToPage("Planned Resource and Cost");
        resourceAndCostPage().closeAndCheckProjectTab("Add");
    }

    //1534526
    @Test
    public void _2PRC_CreateNewResourceAndCostPlanWithoutYear() {
        commonPage().goToPage("Planned Resource and Cost");
        resourceAndCostPage().createResourceAndCostPlan("", "TEST TEST", "1", "");
        resourceAndCostPage().checkProjectNotPlannedWarningMessage("Year is required.");
    }

    //1534529
    @Test
    public void _3PRC_CreateNewResourceAndCostPlanWithoutProject() {
        commonPage().goToPage("Planned Resource and Cost");
        resourceAndCostPage().createResourceAndCostPlan("2024", "", "1", "");
        resourceAndCostPage().checkProjectNotPlannedWarningMessage("Project is required.");
    }

    //1534530
    @Test
    public void _4PRC_CreateNewResourceAndCostPlanWithoutCostTransferPlan() {
        commonPage().goToPage("Planned Resource and Cost");
        resourceAndCostPage().createResourceAndCostPlan("2024", "TEST TEST", "", "");
        resourceAndCostPage().checkProjectNotPlannedWarningMessage("Musd is required.");
    }

    //1534532
    @Test
    public void _5PRC_CreateNewResourceAndCostPlanWithoutLevelInputs() {
        commonPage().goToPage("Planned Resource and Cost");
        resourceAndCostPage().createResourceAndCostPlan("2023", "TEST TEST", "1", "");
        resourceAndCostPage().checkResourceAndCostPlanned("2023", "TEST TEST", "1", "0", "0.000", "0.000");
    }

    //1534534
    @Test
    public void _6PRC_CreateNewResourceAndCostPlanWithSystemCosts() {
        commonPage().goToPage("Planned Resource and Cost");
        resourceAndCostPage().createResourceAndCostPlan("2024", "TEST TEST", "1", "1");
        resourceAndCostPage().checkResourceAndCostPlanned("2024", "TEST TEST", "1", "1", "0.294", "0.588");
    }

    //1534535
    @Test
    public void _7PRC_CreateNewResourceAndCostPlanWithGeneralCosts() {
        commonPage().createGeneralCustomCost("2029", "11", "200");
        commonPage().goToPage("Planned Resource and Cost");
        resourceAndCostPage().createResourceAndCostPlan("2029", "TEST TEST", "1", "1");
        resourceAndCostPage().checkResourceAndCostPlanned("2029", "TEST TEST", "1", "1", "0.008", "0.017");
    }

    //1534537
    @Test
    public void _8PRC_CreateNewResourceAndCostPlanWithCustomCosts() {
        commonPage().goToPage("Planned Resource and Cost");
        resourceAndCostPage().createResourceAndCostPlan("2025", "TEST TEST", "1", "1");
        resourceAndCostPage().createCustomCostPlan("January", "December", "10000");
        resourceAndCostPage().checkResourceAndCostPlanned("2025", "TEST TEST", "1", "1", "0.420", "0.840");
    }

    //1534539
    @Test
    public void _9PRC_CreateNewResourceAndCostPlanWithMultipleCosts() {
        commonPage().createGeneralCustomCost("2029", "8", "200");
        commonPage().goToPage("Planned Resource and Cost");
        resourceAndCostPage().createResourceAndCostPlan("2029", "TEST TEST", "1", "1");
        resourceAndCostPage().createCustomCostPlan("January", "March", "300");
        resourceAndCostPage().createCustomCostPlan("November", "December", "10000");
        resourceAndCostPage().checkResourceAndCostPlanned("2029", "TEST TEST", "1", "1", "0.010", "0.204");
    }

    //1534541
    @Test
    public void _10PRC_CreateNewResourceAndCostPlanWithoutCustomCostStartMonth() {
        commonPage().goToPage("Planned Resource and Cost");
        resourceAndCostPage().createResourceAndCostPlan("2029", "TEST TEST", "1", "");
        resourceAndCostPage().createCustomCostPlan("", "March", "300");
        resourceAndCostPage().checkProjectNotPlannedWarningMessage("Custom Costs must be filled before save.");
    }

    //1534542
    @Test
    public void _11PRC_CreateNewResourceAndCostPlanWithoutCustomCostEndMonth() {
        commonPage().goToPage("Planned Resource and Cost");
        resourceAndCostPage().createResourceAndCostPlan("2029", "TEST TEST", "1", "");
        resourceAndCostPage().createCustomCostPlan("January", "", "300");
        resourceAndCostPage().checkProjectNotPlannedWarningMessage("Custom Costs must be filled before save.");
    }

    //1534544
    @Test
    public void _12PRC_CreateNewResourceAndCostPlanWithoutCustomCostLevelCosts() {
        commonPage().goToPage("Planned Resource and Cost");
        resourceAndCostPage().createResourceAndCostPlan("2029", "TEST TEST", "1", "");
        resourceAndCostPage().createCustomCostPlan("January", "March", "");
        resourceAndCostPage().checkProjectNotPlannedWarningMessage("Custom Costs must be filled before save.");
    }

    //1534547
    @Test
    public void _13PRC_CreateNewResourceAndCostPlanReset() {
        commonPage().goToPage("Planned Resource and Cost");
        resourceAndCostPage().createResourceAndCostPlan("2026", "TEST TEST", "1", "1");
        resourceAndCostPage().createCustomCostPlan("January", "March", "300");
        resourceAndCostPage().checkAllCostValuesWhenReset();
        resourceAndCostPage().checkResourceAndCostPlanned("2026", "TEST TEST", "1", "0", "0.000", "0.000");
    }

    //1534548
    @Test
    public void _14PRC_EditThePlannedResourceAndCostPlanCloseButton() {
        commonPage().goToPage("Planned Resource and Cost");
        resourceAndCostPage().closeAndCheckProjectTab("Edit");
    }

    //1534549
    @Test
    public void _15PRC_EditThePlannedResourceAndCostPlanWithoutYear() {
        commonPage().goToPage("Planned Resource and Cost");
        resourceAndCostPage().removeResourceAndCostPlanParameter("Removed", "Not Removed", "Not Removed", "Not Removed");
        resourceAndCostPage().checkProjectNotPlannedWarningMessage("Year is required.");
    }

    //1534550
    @Test
    public void _16PRC_EditThePlannedResourceAndCostPlanWithoutCostTransferPlan() {
        commonPage().goToPage("Planned Resource and Cost");
        resourceAndCostPage().removeResourceAndCostPlanParameter("Not Removed", "Removed", "Not Removed", "Not Removed");
        resourceAndCostPage().checkProjectNotPlannedWarningMessage("Musd is required.");
    }

    //1534552
    @Test
    public void _17PRC_EditThePlannedResourceAndCostPlanWithoutLevelInputs() {
        commonPage().goToPage("Planned Resource and Cost");
        resourceAndCostPage().removeResourceAndCostPlanParameter("Not Removed", "Not Removed", "Not Removed", "Removed");
        resourceAndCostPage().checkAllCostValuesAfterReset();
    }

    //1534553
    @Test
    public void _18PRC_EditThePlannedResourceAndCostPlanWithSystemCosts() {
        commonPage().goToPage("Planned Resource and Cost");
        resourceAndCostPage().editResourceAndCostPlan("2029", "3", "10");
        resourceAndCostPage().checkResourceAndCostPlanned("2029", "TEST TEST", "3", "10", "2.939", "5.879");
    }

    //1534554
    @Test
    public void _19PRC_EditThePlannedResourceAndCostPlanWithGeneralCosts() {
        commonPage().createGeneralCustomCost("2029", "11", "200");
        commonPage().goToPage("Planned Resource and Cost");
        resourceAndCostPage().editResourceAndCostPlan("2029", "4", "20");
        resourceAndCostPage().checkResourceAndCostPlanned("2029", "TEST TEST", "4", "20", "0.168", "0.336");
    }

    //1534557
    @Test
    public void _20PRC_EditThePlannedResourceAndCostPlanWithCustomCosts() {
        commonPage().goToPage("Planned Resource and Cost");
        resourceAndCostPage().editResourceAndCostPlan("2029", "5", "30");
        resourceAndCostPage().createCustomCostPlan("January", "December", "10000");
        resourceAndCostPage().checkResourceAndCostPlanned("2029", "TEST TEST", "5", "30", "12.600", "25.200");
    }

    //1534559
    @Test
    public void _21PRC_EditThePlannedResourceAndCostPlanWithMultipleCosts() {
        commonPage().createGeneralCustomCost("2029", "8", "200");
        commonPage().goToPage("Planned Resource and Cost");
        resourceAndCostPage().editResourceAndCostPlan("2029", "6", "40");
        resourceAndCostPage().createCustomCostPlan("January", "March", "300");
        resourceAndCostPage().createCustomCostPlan("November", "December", "10000");
        resourceAndCostPage().checkResourceAndCostPlanned("2029", "TEST TEST", "6", "40", "0.420", "8.148");
    }

    //1534560
    @Test
    public void _22PRC_EditThePlannedResourceAndCostPlanWithoutCustomCostStartMonth() {
        commonPage().goToPage("Planned Resource and Cost");
        resourceAndCostPage().editResourceAndCostPlan("2029", "1", "");
        resourceAndCostPage().createCustomCostPlan("", "March", "300");
        resourceAndCostPage().checkProjectNotPlannedWarningMessage("Custom Costs must be filled before save.");
    }

    //1534562
    @Test
    public void _23PRC_EditThePlannedResourceAndCostPlanWithoutCustomCostEndMonth() {
        commonPage().goToPage("Planned Resource and Cost");
        resourceAndCostPage().editResourceAndCostPlan("2029", "1", "");
        resourceAndCostPage().createCustomCostPlan("January", "", "300");
        resourceAndCostPage().checkProjectNotPlannedWarningMessage("Custom Costs must be filled before save.");
    }

    //1534564
    @Test
    public void _24PRC_EditThePlannedResourceAndCostPlanWithoutCustomCostLevelCosts() {
        commonPage().goToPage("Planned Resource and Cost");
        resourceAndCostPage().editResourceAndCostPlan("2029", "1", "");
        resourceAndCostPage().createCustomCostPlan("January", "March", "");
        resourceAndCostPage().checkProjectNotPlannedWarningMessage("Custom Costs must be filled before save.");
    }

    //1534565
    @Test
    public void _25PRC_EditThePlannedResourceAndCostPlanRemoveCustomCost() {
        commonPage().goToPage("Planned Resource and Cost");
        resourceAndCostPage().removeResourceAndCostPlanParameter("Not Removed", "Not Removed", "Removed", "Not Removed");
        resourceAndCostPage().checkResourceAndCostPlanned("2029", "TEST TEST", "1", "1", "0.294", "0.588");
    }

    //1534566
    @Test
    public void _26PRC_EditThePlannedResourceAndCostPlanReset() {
        commonPage().goToPage("Planned Resource and Cost");
        resourceAndCostPage().editResourceAndCostPlan("2026", "3", "100");
        resourceAndCostPage().checkAllCostValuesWhenReset();
        resourceAndCostPage().checkResourceAndCostPlanned("2026", "TEST TEST", "3", "0", "0.000", "0.000");
    }

    //1534567
    @Test
    public void _27PRC_DeleteThePlannedResourceAndCost() {
        commonPage().goToPage("Planned Resource and Cost");
        resourceAndCostPage().deleteResourceAndCostPlan("TEST TEST");
    }

    //1534568
    @Test
    public void _28PRC_FilterYear() {
        commonPage().goToPage("Planned Resource and Cost");
        resourceAndCostPage().filterResourceAndPlan("Year");
    }

    //1534569
    @Test
    public void _29PRC_FilterProject() {
        commonPage().goToPage("Planned Resource and Cost");
        resourceAndCostPage().filterResourceAndPlan("Project");
    }

    //1534570
    @Test
    public void _30PRC_FilterDC() {
        commonPage().goToPage("Planned Resource and Cost");
        resourceAndCostPage().filterResourceAndPlan("DC");
    }

    //1534571
    @Test
    public void _31PRC_FilterChargeMode() {
        commonPage().goToPage("Planned Resource and Cost");
        resourceAndCostPage().filterResourceAndPlan("Charge Mode");
    }

    //1534572
    @Test
    public void _32PRC_FilterChargeStatus() {
        commonPage().goToPage("Planned Resource and Cost");
        resourceAndCostPage().filterResourceAndPlan("Charge Status");
    }

    //1534573
    @Test
    public void _33PRC_FilterReset() {
        commonPage().goToPage("Planned Resource and Cost");
        resourceAndCostPage().filterResourceAndPlan("Reset");
    }

    //1534578
    @Test
    public void _34PRC_SetThePagination() {
        commonPage().goToPage("Planned Resource and Cost");
        resourceAndCostPage().checkThePagination();
    }
}
