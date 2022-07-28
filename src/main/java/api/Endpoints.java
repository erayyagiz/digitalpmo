package api;

import com.ey.automation.base.BasePage;
import com.ey.automation.listener.ReportListener;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import java.util.List;
import static io.restassured.RestAssured.given;

public class Endpoints extends BasePage {
    public static String baseURL = "https://app-test.rnd.huawei.com";

    public void getCsrfToken() {
        try {
            ReportListener.info("getCsrfToken is started.");
            RestAssured.baseURI = baseURL;

            Response response = given()
                    .contentType("application/json")
                    .accept(ContentType.JSON)
                    .header("cookie", "access-token=" + api.Response.getAccessToken())
                    .when()
                    .log().all()
                    .request("POST", "/u-route/baas/sys/v1.0/csrf/get")
                    .then()
                    .extract().response();
            Assert.assertEquals(response.getStatusCode(), 200);
            String result = response.jsonPath().getString("result");
            Assert.assertNotEquals(result, "");
            ReportListener.pass("getCsrfToken is completed.");
            api.Response.setCsrfToken(response.jsonPath().getString("result"));
        } catch (Exception e) {
            Assert.fail("getCsrfToken cannot be completed. The reason: " + e.getMessage());
            ReportListener.fail("getCsrfToken cannot be completed.");
        }
    }


    public String createNewResourceAndCostPlan(String allCostValues, String firstCustomStartDate, String firstCustomEndDate, String firstCustomValues, String secondCustomStartDate, String secondCustomEndDate, String secondCustomValues) {
        try {
            ReportListener.info("createNewResourceAndCostPlan is started.");
            RestAssured.baseURI = baseURL;
            String customCostArray = "";
            if (firstCustomStartDate != null) {
                customCostArray = "{\n" +
                        "         \"StartMonth\":" + firstCustomStartDate + ",\n" +
                        "         \"EndMonth\":" + firstCustomEndDate + ",\n" +
                        "         \"UniqueHWL1Cost\":" + firstCustomValues + ",\n" +
                        "         \"UniqueHWL2Cost\":" + firstCustomValues + ",\n" +
                        "         \"UniqueHWL3Cost\":" + firstCustomValues + ",\n" +
                        "         \"UniqueOTL1Cost\":" + firstCustomValues + ",\n" +
                        "         \"UniqueOTL2Cost\":" + firstCustomValues + ",\n" +
                        "         \"UniqueOTL3Cost\":" + firstCustomValues + ",\n" +
                        "         \"UniqueCPCost\":" + firstCustomValues + "\n" +
                        "      },\n" +
                        "      {\n" +
                        "         \"StartMonth\":" + secondCustomStartDate + ",\n" +
                        "         \"EndMonth\":" + secondCustomEndDate + ",\n" +
                        "         \"UniqueHWL1Cost\":" + secondCustomValues + ",\n" +
                        "         \"UniqueHWL2Cost\":" + secondCustomValues + ",\n" +
                        "         \"UniqueHWL3Cost\":" + secondCustomValues + ",\n" +
                        "         \"UniqueOTL1Cost\":" + secondCustomValues + ",\n" +
                        "         \"UniqueOTL2Cost\":" + secondCustomValues + ",\n" +
                        "         \"UniqueOTL3Cost\":" + secondCustomValues + ",\n" +
                        "         \"UniqueCPCost\":" + secondCustomValues + "\n" +
                        "      }";
            }
            String body = "{\n" +
                    "   \"year\":\"2029\",\n" +
                    "   \"projectId\":\"cZ9U000000uY7aQefaCG\",\n" +
                    "   \"costTransferPlan\":1,\n" +
                    "   \"CustomCostArray\":[\n"
                    + customCostArray +
                    "   ],\n" +
                    "   \"HW_jan\":{\n" +
                    "      \"level1\":" + allCostValues + ",\n" +
                    "      \"level2\":" + allCostValues + ",\n" +
                    "      \"level3\":" + allCostValues + "\n" +
                    "   },\n" +
                    "   \"OT_jan\":{\n" +
                    "      \"level1\":" + allCostValues + ",\n" +
                    "      \"level2\":" + allCostValues + ",\n" +
                    "      \"level3\":" + allCostValues + "\n" +
                    "   },\n" +
                    "   \"CP_jan\":" + allCostValues + ",\n" +
                    "   \"HW_feb\":{\n" +
                    "      \"level1\":" + allCostValues + ",\n" +
                    "      \"level2\":" + allCostValues + ",\n" +
                    "      \"level3\":" + allCostValues + "\n" +
                    "   },\n" +
                    "   \"OT_feb\":{\n" +
                    "      \"level1\":" + allCostValues + ",\n" +
                    "      \"level2\":" + allCostValues + ",\n" +
                    "      \"level3\":" + allCostValues + "\n" +
                    "   },\n" +
                    "   \"CP_feb\":" + allCostValues + ",\n" +
                    "   \"HW_mar\":{\n" +
                    "      \"level1\":" + allCostValues + ",\n" +
                    "      \"level2\":" + allCostValues + ",\n" +
                    "      \"level3\":" + allCostValues + "\n" +
                    "   },\n" +
                    "   \"OT_mar\":{\n" +
                    "      \"level1\":" + allCostValues + ",\n" +
                    "      \"level2\":" + allCostValues + ",\n" +
                    "      \"level3\":" + allCostValues + "\n" +
                    "   },\n" +
                    "   \"CP_mar\":" + allCostValues + ",\n" +
                    "   \"HW_apr\":{\n" +
                    "      \"level1\":" + allCostValues + ",\n" +
                    "      \"level2\":" + allCostValues + ",\n" +
                    "      \"level3\":" + allCostValues + "\n" +
                    "   },\n" +
                    "   \"OT_apr\":{\n" +
                    "      \"level1\":" + allCostValues + ",\n" +
                    "      \"level2\":" + allCostValues + ",\n" +
                    "      \"level3\":" + allCostValues + "\n" +
                    "   },\n" +
                    "   \"CP_apr\":" + allCostValues + ",\n" +
                    "   \"HW_may\":{\n" +
                    "      \"level1\":" + allCostValues + ",\n" +
                    "      \"level2\":" + allCostValues + ",\n" +
                    "      \"level3\":" + allCostValues + "\n" +
                    "   },\n" +
                    "   \"OT_may\":{\n" +
                    "      \"level1\":" + allCostValues + ",\n" +
                    "      \"level2\":" + allCostValues + ",\n" +
                    "      \"level3\":" + allCostValues + "\n" +
                    "   },\n" +
                    "   \"CP_may\":" + allCostValues + ",\n" +
                    "   \"HW_jun\":{\n" +
                    "      \"level1\":" + allCostValues + ",\n" +
                    "      \"level2\":" + allCostValues + ",\n" +
                    "      \"level3\":" + allCostValues + "\n" +
                    "   },\n" +
                    "   \"OT_jun\":{\n" +
                    "      \"level1\":" + allCostValues + ",\n" +
                    "      \"level2\":" + allCostValues + ",\n" +
                    "      \"level3\":" + allCostValues + "\n" +
                    "   },\n" +
                    "   \"CP_jun\":" + allCostValues + ",\n" +
                    "   \"HW_jul\":{\n" +
                    "      \"level1\":" + allCostValues + ",\n" +
                    "      \"level2\":" + allCostValues + ",\n" +
                    "      \"level3\":" + allCostValues + "\n" +
                    "   },\n" +
                    "   \"OT_jul\":{\n" +
                    "      \"level1\":" + allCostValues + ",\n" +
                    "      \"level2\":" + allCostValues + ",\n" +
                    "      \"level3\":" + allCostValues + "\n" +
                    "   },\n" +
                    "   \"CP_jul\":" + allCostValues + ",\n" +
                    "   \"HW_aug\":{\n" +
                    "      \"level1\":" + allCostValues + ",\n" +
                    "      \"level2\":" + allCostValues + ",\n" +
                    "      \"level3\":" + allCostValues + "\n" +
                    "   },\n" +
                    "   \"OT_aug\":{\n" +
                    "      \"level1\":" + allCostValues + ",\n" +
                    "      \"level2\":" + allCostValues + ",\n" +
                    "      \"level3\":" + allCostValues + "\n" +
                    "   },\n" +
                    "   \"CP_aug\":" + allCostValues + ",\n" +
                    "   \"HW_sept\":{\n" +
                    "      \"level1\":" + allCostValues + ",\n" +
                    "      \"level2\":" + allCostValues + ",\n" +
                    "      \"level3\":" + allCostValues + "\n" +
                    "   },\n" +
                    "   \"OT_sept\":{\n" +
                    "      \"level1\":" + allCostValues + ",\n" +
                    "      \"level2\":" + allCostValues + ",\n" +
                    "      \"level3\":" + allCostValues + "\n" +
                    "   },\n" +
                    "   \"CP_sept\":" + allCostValues + ",\n" +
                    "   \"HW_oct\":{\n" +
                    "      \"level1\":" + allCostValues + ",\n" +
                    "      \"level2\":" + allCostValues + ",\n" +
                    "      \"level3\":" + allCostValues + "\n" +
                    "   },\n" +
                    "   \"OT_oct\":{\n" +
                    "      \"level1\":" + allCostValues + ",\n" +
                    "      \"level2\":" + allCostValues + ",\n" +
                    "      \"level3\":" + allCostValues + "\n" +
                    "   },\n" +
                    "   \"CP_oct\":" + allCostValues + ",\n" +
                    "   \"HW_nov\":{\n" +
                    "      \"level1\":" + allCostValues + ",\n" +
                    "      \"level2\":" + allCostValues + ",\n" +
                    "      \"level3\":" + allCostValues + "\n" +
                    "   },\n" +
                    "   \"OT_nov\":{\n" +
                    "      \"level1\":" + allCostValues + ",\n" +
                    "      \"level2\":" + allCostValues + ",\n" +
                    "      \"level3\":" + allCostValues + "\n" +
                    "   },\n" +
                    "   \"CP_nov\":" + allCostValues + ",\n" +
                    "   \"HW_dec\":{\n" +
                    "      \"level1\":" + allCostValues + ",\n" +
                    "      \"level2\":" + allCostValues + ",\n" +
                    "      \"level3\":" + allCostValues + "\n" +
                    "   },\n" +
                    "   \"OT_dec\":{\n" +
                    "      \"level1\":" + allCostValues + ",\n" +
                    "      \"level2\":" + allCostValues + ",\n" +
                    "      \"level3\":" + allCostValues + "\n" +
                    "   },\n" +
                    "   \"CP_dec\":" + allCostValues + "\n" +
                    "}";
            Response response = given()
                    .contentType("application/json")
                    .accept(ContentType.JSON)
                    .header("cookie", "access-token=" + api.Response.getAccessToken())
                    .header("csrf-token", api.Response.getCsrfToken())
                    .body(body)
                    .when()
                    .log().all()
                    .request("POST", "/service/ADACA__DigitalPMO/1.0.0/createResourceAndCostPlanByLevel")
                    .then()
                    .extract().response();
            Assert.assertEquals(response.getStatusCode(), 200);
            ReportListener.pass("createNewResourceAndCostPlan is completed.");
            api.Response.setResponse(response.jsonPath().getString("result.projectPlanByLevelId"));
            return api.Response.getResponse();
        } catch (Exception e) {
            Assert.fail("createNewResourceAndCostPlan cannot be completed. The reason: " + e.getMessage());
            ReportListener.fail("ceateNewResourceAndCostPlan cannot be completed.");
            return null;
        }
    }

    public void deleteNewResourceAndCostPlan(String projectPlanId) {
        try {
            ReportListener.info("deleteNewResourceAndCostPlan is started.");
            RestAssured.baseURI = baseURL;
            String body = "{\n" +
                    "    \"projectPlanId\":\"" + projectPlanId + "\"\n" +
                    "}";
            Response response = given()
                    .contentType("application/json")
                    .accept(ContentType.JSON)
                    .header("cookie", "access-token=" + api.Response.getAccessToken())
                    .header("csrf-token", api.Response.getCsrfToken())
                    .body(body)
                    .when()
                    .log().all()
                    .request("DELETE", "/service/ADACA__DigitalPMO/1.0.0/deleteResourceAndCostPlanByLevel")
                    .then()
                    .extract().response();
            Assert.assertEquals(response.getStatusCode(), 200);
            Assert.assertEquals(response.jsonPath().getString("resMsg"), "success");
            ReportListener.pass("deleteNewResourceAndCostPlan is completed.");
        } catch (Exception e) {
            Assert.fail("deleteNewResourceAndCostPlan cannot be completed. The reason: " + e.getMessage());
            ReportListener.fail("deleteNewResourceAndCostPlan cannot be completed.");
        }
    }

    public List<String> getResourceAndCostPlans(boolean resetFlag, String filterType, String filterValue) {
        try {
            ReportListener.info("getResourceAndCostPlans is started.");
            RestAssured.baseURI = baseURL;

            Response response = given()
                    .header("cookie", "access-token=" + api.Response.getAccessToken())
                    .header("csrf-token", api.Response.getCsrfToken())
                    .when()
                    .log().all()
                    .request("GET", "/service/ADACA__DigitalPMO/0.1.1/ queryResourceAndCostLevelsPlan?start=0&limit=100")
                    .then()
                    .extract().response();
            Assert.assertEquals(response.getStatusCode(), 200);
            String getBody = response.getBody().asString();
            List<String> values;
            String jsonPath;
            if (resetFlag) {
                jsonPath = "$..resourceAndCostPlanList..project.value";
            } else {
                jsonPath = "$..resourceAndCostPlanList[?(@." + filterType + "=='" + filterValue + "')].project.value";

            }
            values = JsonPath.read(getBody, jsonPath);
            ReportListener.pass("getResourceAndCostPlans is completed.");
            return values;
        } catch (Exception e) {
            Assert.fail("getResourceAndCostPlans cannot be completed. The reason: " + e.getMessage());
            ReportListener.fail("getResourceAndCostPlans cannot be completed.");
            return null;
        }
    }
}
