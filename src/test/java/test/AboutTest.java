package test;

import base.CustomTestBase;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class AboutTest extends CustomTestBase {

    //1534682
    @Ignore
    public void _1H_OpenDigitalPMOUserGuide(){
        commonPage().goToPage("About Help");
        aboutPage().checkUserGuide();
    }

    //1534685
    @Test
    public void _1SS_SendSuggestionWithoutSuggestionTitle() {
        commonPage().goToPage("Send Suggestion");
        aboutPage().sendSuggestion("","TEST");
        aboutPage().checkWarningMessageSending("Suggestion Title is required");
    }

    //1534687
    @Test
    public void _2SS_SendSuggestionWithoutContext() {
        commonPage().goToPage("Send Suggestion");
        aboutPage().sendSuggestion("TEST","");
        aboutPage().checkWarningMessageSending("Context is required");
    }

    //1534691
    @Test
    public void _3SS_CheckSuggestionTitleMaximumCharacterCount() {
        commonPage().goToPage("Send Suggestion");
        aboutPage().checkSuggestionTitleMaximumCharacter();
    }

    //1534693
    @Test
    public void _4SS_CheckContextMaximumCharacterCount() {
        commonPage().goToPage("Send Suggestion");
        aboutPage().checkContextMaximumCharacter();
    }

    //1534697
    @Test
    public void _5SS_SendSuggestionWithMandatoryInputs() {
        commonPage().goToPage("Send Suggestion");
        aboutPage().sendSuggestion("TEST","TEST");
        aboutPage().checkSuccessPopupSending();
    }
}
