package test;

import base.CustomTestBase;
import org.testng.annotations.Test;

public class About extends CustomTestBase {

    @Test
    public void _1SS_SendSuggestionWithoutSuggestionTitle() {
        loginPage().login();
        commonPage().goToAboutSendSuggestionPage();
        aboutPage().sendSuggestion("","TEST");
        aboutPage().checkWarningMessageSending();
    }


    public void _2SS_SendSuggestionWithoutContext() {
        loginPage().login();
        commonPage().goToAboutSendSuggestionPage();
        aboutPage().sendSuggestion("TEST","");
        aboutPage().checkWarningMessageSending();
    }


    public void _3SS_CheckSuggestionTitleMaximumCharacterCount() {
        loginPage().login();
        commonPage().goToAboutSendSuggestionPage();
        aboutPage().checkSuggestionTitleMaximumCharacter();
    }


    public void _4SS_CheckContextMaximumCharacterCount() {
        loginPage().login();
        commonPage().goToAboutSendSuggestionPage();
        aboutPage().checkContextMaximumCharacter();
    }


    public void _5SS_SendSuggestion() {
        loginPage().login();
        commonPage().goToAboutSendSuggestionPage();
        aboutPage().sendSuggestion("TEST","TEST");
        aboutPage().checkSuccessPopupSending();
    }
}
