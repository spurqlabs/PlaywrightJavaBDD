package utilities;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

public class JsonReaderUtil {

    public static JsonNode readJson(String fileName) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = JsonReaderUtil.class
                    .getClassLoader()
                    .getResourceAsStream("testdata/" + fileName);

            if (is == null) {
                throw new RuntimeException("JSON file not found: " + fileName);
            }

            return mapper.readTree(is);
        } catch (Exception e) {
            throw new RuntimeException("Failed to read JSON file: " + fileName, e);
        }
    }
}

