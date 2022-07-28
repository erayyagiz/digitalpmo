package base;

import api.Endpoints;
import api.Response;
import com.ey.automation.base.Base;
import com.ey.automation.base.CurrentPageContext;
import com.ey.automation.base.DriverContext;
import com.ey.automation.base.TestInitialize;
import org.testng.annotations.*;
import pages.AboutPage;
import pages.CommonPage;
import pages.LoginPage;
import pages.ProjectManagementPage;
import pages.MeetingPage;

import pages.MetricsDashboardPage;
import pages.ManagementDashboardPage;
import pages.ReportPage;
import pages.ResourceAndCostPage;

import java.lang.reflect.Method;

public class CustomTestBase extends TestInitialize {

    @BeforeMethod
    public void beforeMethod(Method method) {
        loginPage().login();
        DriverContext driverContext = new DriverContext();
        Response.setAccessToken(driverContext.getCookieName("access-token"));
        endpoints().getCsrfToken();
        if(method.getName().equals("_25PRC_EditThePlannedResourceAndCostPlanRemoveCustomCost")){
            endpoints().createNewResourceAndCostPlan("1","0","11","10000",null,null,null);
        }
        else if (method.getName().contains("EditThePlannedResourceAndCostPlan") ||
                    method.getName().contains("DeleteThePlannedResourceAndCost")) {
            endpoints().createNewResourceAndCostPlan("0",null,null,null,null,null,null);
        }
    }

    @AfterMethod
    public void afterMethod(Method method) {
        if (method.getName().equals("_7PRC_CreateNewResourceAndCostPlanWithGeneralCosts") ||
                method.getName().equals("_9PRC_CreateNewResourceAndCostPlanWithMultipleCosts") ||
                method.getName().equals("_19PRC_EditThePlannedResourceAndCostPlanWithGeneralCosts") ||
                method.getName().equals("_21PRC_EditThePlannedResourceAndCostPlanWithMultipleCosts")) {
            commonPage().removeAllGeneralCustomCost();
        }
        if (method.getName().contains("EditThePlannedResourceAndCostPlan")) {
            endpoints().deleteNewResourceAndCostPlan(Response.getResponse());
        }
    }

    public Endpoints endpoints() {
        Base base = new Base();
        CurrentPageContext.setCurrentPage(base.GetInstance(Endpoints.class));
        Endpoints endpoints = CurrentPageContext.getCurrentPage().As(Endpoints.class);
        return endpoints;
    }

    public CommonPage commonPage() {
        Base base = new Base();
        CurrentPageContext.setCurrentPage(base.GetInstance(CommonPage.class));
        CommonPage commonPage = CurrentPageContext.getCurrentPage().As(CommonPage.class);
        return commonPage;
    }

    public ProjectManagementPage projectManagementPage() {
        Base base = new Base();
        CurrentPageContext.setCurrentPage(base.GetInstance(ProjectManagementPage.class));
        ProjectManagementPage projectManagementPage = CurrentPageContext.getCurrentPage().As(ProjectManagementPage.class);
        return projectManagementPage;
    }

    public LoginPage loginPage() {
        Base base = new Base();
        CurrentPageContext.setCurrentPage(base.GetInstance(LoginPage.class));
        LoginPage loginPage = CurrentPageContext.getCurrentPage().As(LoginPage.class);
        return loginPage;
    }

    public AboutPage aboutPage() {
        Base base = new Base();
        CurrentPageContext.setCurrentPage(base.GetInstance(AboutPage.class));
        AboutPage aboutPage = CurrentPageContext.getCurrentPage().As(AboutPage.class);
        return aboutPage;
    }

    public MeetingPage meetingPage() {
        Base base = new Base();
        CurrentPageContext.setCurrentPage(base.GetInstance(MeetingPage.class));
        MeetingPage meetingPage = CurrentPageContext.getCurrentPage().As(MeetingPage.class);
        return meetingPage;
    }

    public ManagementDashboardPage managementDashboardPage() {
        Base base = new Base();
        CurrentPageContext.setCurrentPage(base.GetInstance(ManagementDashboardPage.class));
        ManagementDashboardPage managementDashboardPage = CurrentPageContext.getCurrentPage().As(ManagementDashboardPage.class);
        return managementDashboardPage;
    }

    public MetricsDashboardPage metricsDashboardPage() {
        Base base = new Base();
        CurrentPageContext.setCurrentPage(base.GetInstance(MetricsDashboardPage.class));
        MetricsDashboardPage metricsDashboardPage = CurrentPageContext.getCurrentPage().As(MetricsDashboardPage.class);
        return metricsDashboardPage;
    }

    public ReportPage reportPage() {
        Base base = new Base();
        CurrentPageContext.setCurrentPage(base.GetInstance(ReportPage.class));
        ReportPage reportPage = CurrentPageContext.getCurrentPage().As(ReportPage.class);
        return reportPage;
    }

    public ResourceAndCostPage resourceAndCostPage() {
        Base base = new Base();
        CurrentPageContext.setCurrentPage(base.GetInstance(ResourceAndCostPage.class));
        ResourceAndCostPage resourceAndCostPage = CurrentPageContext.getCurrentPage().As(ResourceAndCostPage.class);
        return resourceAndCostPage;
    }
}
