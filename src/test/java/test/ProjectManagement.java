package test;

import base.CustomTestBase;
import org.testng.annotations.Test;

public class ProjectManagement extends CustomTestBase {

    @Test
    public void runTest1()  {
        loginPage().login();
        projectManagementPage().clickAddButton();
    }
}
