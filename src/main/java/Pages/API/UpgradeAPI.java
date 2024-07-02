package Pages.API;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UpgradeAPI {
    static String baseURI = "https://reqres.in/";
    static String basePath = "api/";
    String fullURL;
    public Response getUsers(int page) {
        String get_ListUsers = "users?page=%s";
        fullURL= baseURI+basePath+ String.format(get_ListUsers,page);
        return given()
                .header("Content-Type", "application/json")
                .when()
                .get(fullURL);
    }

    public Response getUserById(String id) {
        String get_ListUsers = "users/%s";
        fullURL= baseURI+basePath+ String.format(get_ListUsers,id);
        return given()
                .header("Content-Type", "application/json")
                .when()
                .get(fullURL);
    }
    public Response postcreateUser(String name, String job) {
        String crete_LUsers = "users";
        fullURL= baseURI+basePath+ crete_LUsers;
        String requestBody = String.format("{\"name\": \"%s\", \"job\": \"%s\"}", name, job);
        return given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post(fullURL);
    }
}
