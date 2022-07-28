    package test;

    import base.CustomTestBase;
    import org.testng.annotations.Test;

    public class ReportTest extends CustomTestBase {

        //1534623
        @Test
        public void _1PR_CreateNewReportPlanWithoutYear() {
            commonPage().goToPage("Report Plan");
            reportPage().createReportPlan("", "TEST TEST", "TEST", "TEST", "Weekly");
            reportPage().checkReportWarningMessage("You must select a value for Year");
        }

        //1534626
        @Test
        public void _2PR_CreateNewReportPlanWithoutProject() {
            commonPage().goToPage("Report Plan");
            reportPage().createReportPlan("2022", "", "TEST", "TEST", "Weekly");
            reportPage().checkReportWarningMessage("You must select a Project");
        }

        //1534628
        @Test
        public void _3PR_CreateNewReportPlanWithoutReportName(){
            commonPage().goToPage("Report Plan");
            reportPage().createReportPlan("2023","TEST TEST","","TEST","Weekly");
            reportPage().checkReportWarningMessage("You must enter a Name");
        }

        //1534631
        @Test
        public void _4PR_CreateNewReportPlanWithoutOwner(){
            commonPage().goToPage("Report Plan");
            reportPage().createReportPlan("2023","TEST TEST","TEST","","Weekly");
            reportPage().checkReportWarningMessage("You must enter an Owner");
        }

        //1534633
        @Test
        public void _5PR_CreateNewReportPlanWithoutFrequency(){
            commonPage().goToPage("Report Plan");
            reportPage().createReportPlan("2024","TEST TEST","TEST","TEST","");
            reportPage().checkReportWarningMessage("You must select a value for Frequency");
        }

        //1534635
        @Test
        public void _6PR_CreateNewReportPlan(){
            commonPage().goToPage("Report Plan");
            reportPage().createReportPlan("2022", "TEST TEST", "TEST", "TEST", "Weekly");
            reportPage().checkReportPlanIsAdded("2022", "TEST TEST", "TEST", "TEST", "Weekly");
        }

        //1534635
        @Test
        public void _7PR_EditTheReportPlanCancelButton(){
            commonPage().goToPage("Report Plan");
            reportPage().cancelReportPlan("Edit");
        }

        //1534639
        @Test
        public void _8PR_EditTheReportPlanWithoutYear(){
            commonPage().goToPage("Report Plan");
            reportPage().removeReportPlanParameter("Removed", "Not Removed", "Not Removed","Not Removed","Not Removed");
            reportPage().checkReportWarningMessage("You must select a value for Year");
        }

        //1534643
        @Test
        public void _9PR_EditTheReportPlanWithoutProject(){
            commonPage().goToPage("Report Plan");
            reportPage().removeReportPlanParameter("Not Removed", "Removed", "Not Removed","Not Removed","Not Removed");
            reportPage().checkReportWarningMessage("You must select a Project");
        }

        //1534646
        @Test
        public void _10PR_EditTheReportPlanWithoutReportName(){
            commonPage().goToPage("Report Plan");
            reportPage().removeReportPlanParameter("Not Removed", "Not Removed", "Removed","Not Removed","Not Removed");
            reportPage().checkReportWarningMessage("You must enter a Name");
        }

        //1534648
        @Test
        public void _11PR_EditTheReportPlanWithoutOwner(){
            commonPage().goToPage("Report Plan");
            reportPage().removeReportPlanParameter("Not Removed", "Not Removed", "Not Removed","Removed","Not Removed");
            reportPage().checkReportWarningMessage("You must enter an Owner");
        }

        //1534650
        @Test
        public void _12PR_EditTheReportPlanWithoutFrequency(){
            commonPage().goToPage("Report Plan");
            reportPage().removeReportPlanParameter("Not Removed", "Not Removed", "Not Removed","Not Removed","Removed");
            reportPage().checkReportWarningMessage("You must select a value for Frequency");
        }






    }