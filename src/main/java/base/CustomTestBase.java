package base;

import com.ey.automation.base.Base;
import com.ey.automation.base.CurrentPageContext;
import com.ey.automation.base.TestInitialize;
import pages.AboutPage;
import pages.CommonPage;
import pages.LoginPage;
import pages.ProjectManagementPage;


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
}
