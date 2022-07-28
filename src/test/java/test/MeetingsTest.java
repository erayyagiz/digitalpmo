package test;

import base.CustomTestBase;
import org.testng.annotations.Test;

public class MeetingsTest extends CustomTestBase {

    //1534627
    @Test
    public void _1PM_CreateNewMeetingPlanWithoutYear() {
        commonPage().goToPage("Meeting Plan");
        meetingPage().createNewMeetingPlan("meeting","owner","Bi-Weekly","","TEST TEST");
        meetingPage().checkWarningMessage("You must select a value for Year");
    }

    //1534630
    @Test
    public void _2PM_CreateNewMeetingPlanWithoutMeetingName() {
        commonPage().goToPage("Meeting Plan");
        meetingPage().createNewMeetingPlan("","owner","Bi-Weekly","2025","TEST TEST");
        meetingPage().checkWarningMessage("You must enter a Name");
    }

    //1534632
    @Test
    public void _3PM_CreateNewMeetingPlanWithoutFrequency() {
        commonPage().goToPage("Meeting Plan");
        meetingPage().createNewMeetingPlan("meeting","owner","","2025","TEST TEST");
        meetingPage().checkWarningMessage("You must select a value for Frequency");
    }

    //1534634
    @Test
    public void _4PM_CreateNewMeetingPlanWithoutOwner() {
        commonPage().goToPage("Meeting Plan");
        meetingPage().createNewMeetingPlan("meeting","","Bi-Weekly","2025","TEST TEST");
        meetingPage().checkWarningMessage("You must enter an Owner");
    }

    //1534636
    @Test
    public void _5PM_CreateNewMeetingPlanWithoutProject() {
        commonPage().goToPage("Meeting Plan");
        meetingPage().createNewMeetingPlan("meeting","owner","Bi-Weekly","2025","");
        meetingPage().checkWarningMessage("You must select a Project");
    }

}
