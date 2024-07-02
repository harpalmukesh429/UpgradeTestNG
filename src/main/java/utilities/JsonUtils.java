package utilities;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JsonUtils {
    // Method to get JSONObject from a response using JSONPath
    public static JSONObject getJSONObject(Response response, String jsonPath) {
        return new JSONObject(response.jsonPath().getMap(jsonPath));
    }

    // Method to get JSONArray from a response using JSONPath
    public static JSONArray getJSONArray(Response response, String jsonPath) {
        return new JSONArray(response.jsonPath().getList(jsonPath));
    }

    // Method to read a value from JSON using JSONPath
    public static Object readJsonPath(Response response, String jsonPath) {
        return response.jsonPath().get(jsonPath);
    }

    // Method to convert JSONArray to List of Maps
    public static List<Map<String, Object>> convertJSONArrayToListOfMaps(JSONArray jsonArray) {
        return IntStream.range(0, jsonArray.length())
                .mapToObj(index -> jsonArray.getJSONObject(index).toMap())
                .collect(Collectors.toList());
    }

    // Method to get a value from JSONObject
    public static Object getJsonValue(JSONObject jsonObject, String key) {
        return jsonObject.get(key);
    }

    // Method to get multiple values from JSONObject
    public static List<Object> getJsonValues(JSONObject jsonObject, List<String> keys) {
        return keys.stream()
                .map(jsonObject::get)
                .collect(Collectors.toList());
    }

    // Method to update a value in JSONObject
    public static void updateJsonPath(JSONObject jsonObject, String key, Object newValue) {
        jsonObject.put(key, newValue);
    }
}
