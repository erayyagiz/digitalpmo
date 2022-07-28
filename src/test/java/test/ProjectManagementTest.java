package test;

import base.CustomTestBase;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class ProjectManagementTest extends CustomTestBase {
    //1533873
    @Test(priority =0)
    public void _1PMN_CreateNewProjectCloseButton(){
        commonPage().goToPage("Project Management");
        projectManagementPage().checkCloseButton();
    }

    //1533876
    @Test(priority =1)
    public void _2PMN_CreateNewProjectWithoutProjectName(){
        commonPage().goToPage("Project Management");
        projectManagementPage().createNewProject("12345","","Active","ISD","Xcharge","Yusuf","Signed",
                "Yusuf", "","","","","","",
                "2022-06-12","","");
        projectManagementPage().checkWarningMessages("Project Name is required");
    }

    //1533877
    @Test(priority =2)
    public void _3PMN_CreateNewProjectWithoutStatus(){
        commonPage().goToPage("Project Management");
        projectManagementPage().createNewProject("12345","TestY","","ISD","Xcharge","Yusuf","Signed",
                "Yusuf", "","","","","","",
                "2022-06-12","","");
        projectManagementPage().checkWarningMessages("Status is required");
    }

    //1533878
    @Test(priority =3)
    public void _4PMN_CreateNewProjectWithoutDC(){
        commonPage().goToPage("Project Management");
        projectManagementPage().createNewProject("12345","TestY","Active","","Xcharge","Yusuf","Signed",
                "Yusuf", "","","","","","",
                "2022-06-12","","");
        projectManagementPage().checkWarningMessages("DC is required");
    }

    //1534761
    @Test(priority =4)
    public void _5PMN_CreateNewProjectWithoutChargeMode(){
        commonPage().goToPage("Project Management");
        projectManagementPage().createNewProject("12345","TestY","Active","ISD","","Yusuf","Signed",
                "Yusuf", "","","","","","",
                "2022-06-12","","");
        projectManagementPage().checkWarningMessages("Charge Mode is required");
    }

    //1533879
    @Test(priority =5)
    public void _6PMN_CreateNewProjectWithoutCostTransferResponsible(){
        commonPage().goToPage("Project Management");
        projectManagementPage().createNewProject("12345","TestY","Active","ISD","Xcharge","","Signed",
                "Yusuf", "","","","","","",
                "2022-06-12","","");
        projectManagementPage().checkWarningMessages("Cost Transfer Responsible is required");
    }

    //1533880
    @Test(priority =6)
    public void _7PMN_CreateNewProjectWithoutChargeStatus(){
        commonPage().goToPage("Project Management");
        projectManagementPage().createNewProject("12345","TestY","Active","ISD","Xcharge","Yusuf","",
                "Yusuf", "","","","","","",
                "2022-06-12","","");
        projectManagementPage().checkWarningMessages("Charge Status is required");
    }

    //1533883
    @Test(priority =7)
    public void _8PMN_CreateNewProjectWithoutTurkeyRDPM(){
        commonPage().goToPage("Project Management");
        projectManagementPage().createNewProject("12345","TestY","Active","ISD","Xcharge","Yusuf","Signed",
                "", "","","","","","",
                "2022-06-12","","");
        projectManagementPage().checkWarningMessages("Turkey R&D PM is required");
    }

    //1533884
    @Test(priority =8)
    public void _9PMN_CreateNewProjectWithoutStartDate(){
        commonPage().goToPage("Project Management");
        projectManagementPage().createNewProject("12345","TestY","Active","ISD","Xcharge","Yusuf","Signed",
                "Yusuf", "","","","","","",
                "","","");
        projectManagementPage().checkWarningMessages("Start Date is required");
    }

    //1533885
    @Test(priority =9)
    public void _10PMN_CreateNewProjectWithoutTimesApprover(){
        commonPage().goToPage("Project Management");
        projectManagementPage().createNewProject("12345","TestY","Active","ISD","Times","Yusuf","Signed",
                "Yusuf", "","","","","","",
                "2022-06-12","","");
        projectManagementPage().checkWarningMessages("Times Approver is required");
    }

    //1533886
    @Test(priority =10)
    public void _11PMN_CreateNewProjectWithoutEndDate(){
        commonPage().goToPage("Project Management");
        projectManagementPage().createNewProject("12345","TestY","Terminated","ISD","Xcharge","Yusuf","Signed",
                "Yusuf", "","","","","","",
                "2022-06-12","","");
        projectManagementPage().checkWarningMessages("End Date is required");
    }


}

