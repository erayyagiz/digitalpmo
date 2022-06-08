package base;

import com.ey.automation.base.Base;
import com.ey.automation.base.CurrentPageContext;
import com.ey.automation.base.TestInitialize;
import pages.AboutPage;
import pages.CommonPage;
import pages.LoginPage;
import pages.ProjectManagementPage;
import pages.MeetingPage;

import pages.MetricsDashboardPage;
import pages.ManagementDashboardPage;
import pages.ReportPage;
import pages.ResourceAndCostPage;

public class CustomTestBase extends TestInitialize {

    public CommonPage commonPage(){
        Base base = new Base();
        CurrentPageContext.setCurrentPage(base.GetInstance(CommonPage.class));
        CommonPage commonPage = CurrentPageContext.getCurrentPage().As(CommonPage.class);
        return commonPage;
    }

    public ProjectManagementPage projectManagementPage(){
        Base base = new Base();
        CurrentPageContext.setCurrentPage(base.GetInstance(ProjectManagementPage.class));
        ProjectManagementPage projectManagementPage = CurrentPageContext.getCurrentPage().As(ProjectManagementPage.class);
        return projectManagementPage;
    }

    public LoginPage loginPage(){
        Base base = new Base();
        CurrentPageContext.setCurrentPage(base.GetInstance(LoginPage.class));
        LoginPage loginPage = CurrentPageContext.getCurrentPage().As(LoginPage.class);
        return loginPage;
    }

    public AboutPage aboutPage(){
        Base base = new Base();
        CurrentPageContext.setCurrentPage(base.GetInstance(AboutPage.class));
        AboutPage aboutPage = CurrentPageContext.getCurrentPage().As(AboutPage.class);
        return aboutPage;
    }

    public MeetingPage meetingPage(){
        Base base = new Base();
        CurrentPageContext.setCurrentPage(base.GetInstance(MeetingPage.class));
        MeetingPage meetingPage = CurrentPageContext.getCurrentPage().As(MeetingPage.class);
        return meetingPage;
    }

    public ManagementDashboardPage managementDashboardPage(){
        Base base = new Base();
        CurrentPageContext.setCurrentPage(base.GetInstance(ManagementDashboardPage.class));
        ManagementDashboardPage managementDashboardPage = CurrentPageContext.getCurrentPage().As(ManagementDashboardPage.class);
        return managementDashboardPage;
    }

    public MetricsDashboardPage metricsDashboardPage(){
        Base base = new Base();
        CurrentPageContext.setCurrentPage(base.GetInstance(MetricsDashboardPage.class));
        MetricsDashboardPage metricsDashboardPage = CurrentPageContext.getCurrentPage().As(MetricsDashboardPage.class);
        return metricsDashboardPage;
    }

    public ReportPage reportPage(){
        Base base = new Base();
        CurrentPageContext.setCurrentPage(base.GetInstance(ReportPage.class));
        ReportPage reportPage = CurrentPageContext.getCurrentPage().As(ReportPage.class);
        return reportPage;
    }

    public ResourceAndCostPage resourceAndCostPage(){
        Base base = new Base();
        CurrentPageContext.setCurrentPage(base.GetInstance(ResourceAndCostPage.class));
        ResourceAndCostPage resourceAndCostPage = CurrentPageContext.getCurrentPage().As(ResourceAndCostPage.class);
        return resourceAndCostPage;
    }
}
