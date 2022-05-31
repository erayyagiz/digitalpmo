package test;

import base.CustomTestBase;
import org.testng.annotations.Test;

public class ProjectManagementTest extends CustomTestBase {

    @Test
    public void runTest1()  {
        loginPage().login();
        projectManagementPage().clickAddButton();
    }
}
