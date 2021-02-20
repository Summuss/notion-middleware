package top.summus.notionmiddleware.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

public class JsonUtil {
    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
    }

    @SneakyThrows
    public static String toJson(Object obj) {
        return objectMapper.writeValueAsString(obj);
    }

    @SneakyThrows
    public static <T> T toObj(String json, Class<T> clazz) {
        return objectMapper.readValue(json, clazz);
    }
}
