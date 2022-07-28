package api;

public class Response {
    public Response() {
    }

    public static String response;
    public static String accessToken;
    public static String csrfToken;

    public static String getAccessToken() {
        return accessToken;
    }

    public static void setAccessToken(String accessToken) {
        Response.accessToken = accessToken;
    }

    public static String getCsrfToken() {
        return csrfToken;
    }

    public static void setCsrfToken(String csrfToken) {
        Response.csrfToken = csrfToken;
    }

    public static String getResponse() {
        return response;
    }

    public static void setResponse(String response) {
        Response.response = response;
    }
}
