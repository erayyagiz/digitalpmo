package test;

import base.CustomTestBase;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class AboutTest extends CustomTestBase {

    //1534682
    @Ignore
    public void _1H_OpenDigitalPMOUserGuide(){
        loginPage().login();
        commonPage().goToAboutPage("Help");
        aboutPage().checkUserGuide();
    }

    //1534685
    @Test
    public void _1SS_SendSuggestionWithoutSuggestionTitle() {
        loginPage().login();
        commonPage().goToAboutPage("Send Suggestion");
        aboutPage().sendSuggestion("","TEST");
        aboutPage().checkWarningMessageSending();
    }

    //1534687
    @Test
    public void _2SS_SendSuggestionWithoutContext() {
        loginPage().login();
        commonPage().goToAboutPage("Send Suggestion");
        aboutPage().sendSuggestion("TEST","");
        aboutPage().checkWarningMessageSending();
    }

    //1534691
    @Test
    public void _3SS_CheckSuggestionTitleMaximumCharacterCount() {
        loginPage().login();
        commonPage().goToAboutPage("Send Suggestion");
        aboutPage().checkSuggestionTitleMaximumCharacter();
    }

    //1534693
    @Test
    public void _4SS_CheckContextMaximumCharacterCount() {
        loginPage().login();
        commonPage().goToAboutPage("Send Suggestion");
        aboutPage().checkContextMaximumCharacter();
    }

    //1534697
    @Test
    public void _5SS_SendSuggestionWithMandatoryInputs() {
        loginPage().login();
        commonPage().goToAboutPage("Send Suggestion");
        aboutPage().sendSuggestion("TEST","TEST");
        aboutPage().checkSuccessPopupSending();
    }
}
