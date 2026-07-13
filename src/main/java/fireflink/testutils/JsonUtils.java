package fireflink.testutils;

import java.nio.file.Files;
import java.nio.file.Paths;

import com.jayway.jsonpath.JsonPath;

import fireflink.components.BaseClass;

public class JsonUtils extends BaseClass {

	public String getJsonValue(String fileName, String jsonPath) throws Throwable {
		String json = Files.readString(Paths.get("src/test/resources/fireflink/testdata/" + fileName + ".json"));

		String jsonValue = JsonPath.read(json, jsonPath);

		return jsonValue;
	}

}

