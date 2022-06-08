package test;

import base.CustomTestBase;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class AboutTest extends CustomTestBase {

    @Ignore
    public void _1H_OpenDigitalPMOUserGuide(){
        loginPage().login();
        commonPage().goToAboutPage("Help");
        aboutPage().checkUserGuide();
    }

    @Test
    public void _1SS_SendSuggestionWithoutSuggestionTitle() {
        loginPage().login();
        commonPage().goToAboutPage("Send Suggestion");
        aboutPage().sendSuggestion("","TEST");
        aboutPage().checkWarningMessageSending();
    }

    @Test
    public void _2SS_SendSuggestionWithoutContext() {
        loginPage().login();
        commonPage().goToAboutPage("Send Suggestion");
        aboutPage().sendSuggestion("TEST","");
        aboutPage().checkWarningMessageSending();
    }

    @Test
    public void _3SS_CheckSuggestionTitleMaximumCharacterCount() {
        loginPage().login();
        commonPage().goToAboutPage("Send Suggestion");
        aboutPage().checkSuggestionTitleMaximumCharacter();
    }

    @Test
    public void _4SS_CheckContextMaximumCharacterCount() {
        loginPage().login();
        commonPage().goToAboutPage("Send Suggestion");
        aboutPage().checkContextMaximumCharacter();
    }

    @Test
    public void _5SS_SendSuggestion() {
        loginPage().login();
        commonPage().goToAboutPage("Send Suggestion");
        aboutPage().sendSuggestion("TEST","TEST");
        aboutPage().checkSuccessPopupSending();
    }
}
