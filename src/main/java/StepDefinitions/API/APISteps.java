//package StepDefinitions.API;
//
//
//import io.restassured.RestAssured;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;
//import org.testng.Assert;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class APISteps {
//
//    static String baseURI = "https://reqres.in";
//    static String basePath = "api";
//    static String get_ListUsers = "users?page=2";
//    static String post_CreateUsers = "users";
//    static RestAssured restAssured = null;
//
//    public static void main(String[] args) {
////        getListUsersApi();
//        postCreateUserApi();
//    }
//
//    public static void getListUsersApi() {
//        System.out.println("Get API");
//        String fullUrl = "https://reqres.in/api/users?page=2";
//        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
////        requestSpecBuilder.setBaseUri("https://reqres.in/api/users?page=2");
//
////        Response response = restAssured.given().spec(requestSpecBuilder.build()).when().get();
//        Response response = RestAssured.given().baseUri(baseURI).basePath(basePath).when().get(get_ListUsers);
//        System.out.println(response.getBody().prettyPrint());
//        Assert.assertEquals(200, response.getStatusCode());
//        JsonPath jsonPath = response.jsonPath();
//        List<Object> AllNames = jsonPath.getList("data.findAll{it.id<10}.collect {it.first_name + ' ' + it.last_name}");
//        System.out.println(AllNames);
//        List<Object> FilterNames = jsonPath.getList("data.findAll{it.id<10}.first_name");
//        System.out.println(FilterNames);
//
//    }
//
//    public static void postCreateUserApi() {
//        String requestBody = "{\n" +
//                "    \"name\": \"morpheus\",\n" +
//                "    \"job\": \"leader\"\n" +
//                "}";
//        Response response= RestAssured.given().baseUri(baseURI).basePath(basePath).body(requestBody).when().post(post_CreateUsers);
//        System.out.println(response.getBody().prettyPrint());
//        System.out.println(response.getStatusCode());
//
//    }
//}
