package com.xujian.utility.util;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Json序列化相关工具类
 */
public class JsonUtil {
    private static final ObjectMapper om = new ObjectMapper();

    private JsonUtil() {
    }

    static {
        om.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        om.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        om.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        om.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        om.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        om.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        //jackson对要求属性首字母小写, 这里设定为忽略，否则反序列化之后属性为空,也可通过增加@JsonProperty("Result")来处理
        //处理后首字母大写的序列化之后，会自动生成两个属性：首字母大写、首字母小写，但不影响使用
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
    }

    public static ObjectMapper getInstance() {
        return om;
    }

    /**
     * javaBean,list,array convert to json string
     */
    public static String toJson(Object obj) {
        if (obj == null) return "";
        try {
            return om.writeValueAsString(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    //输出漂亮的JSON串
    public static String toPrettyJson(Object obj) {
        if (obj == null) return "";
        try {
            return om.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * json string convert to javaBean
     */
    public static <T> T fromJson(String json, Class<T> clazz) {
        if (json == null || json.isEmpty()) return null;
        try {
            return om.readValue(json, clazz);
            //JavaType javaType = TypeFactory.defaultInstance().constructType(clazz);
            //return om.readValue(json, javaType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T fromJson(String json, TypeReference<T> typeReference) {
        if (json == null || json.isEmpty()) return null;
        try {
            return (T) om.readValue(json, typeReference);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * json string convert to map
     */
    public static <T> Map<String, Object> toMap(String json)
            throws Exception {
        if (json == null || json.isEmpty()) return null;
        return om.readValue(json, Map.class);
    }

    /**
     * json string convert to map with javaBean
     */
    public static <T> Map<String, T> toMap(String json, Class<T> clazz)
            throws Exception {
        Map<String, Map<String, Object>> map = om.readValue(json,
                new TypeReference<Map<String, T>>() {
                });
        Map<String, T> result = new HashMap<String, T>();
        for (Map.Entry<String, Map<String, Object>> entry : map.entrySet()) {
            result.put(entry.getKey(), fromJson(entry.getValue(), clazz));
        }
        return result;
    }

    /**
     * json array string convert to list with javaBean
     */
    public static <T> List<T> toList(String json, Class<T> clazz) {
        List<T> result = new ArrayList<T>();
        try {
            List list = om.readValue(json, new TypeReference<List<T>>() {
            });
            if (list != null) {
                result.addAll(list);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * map convert to javaBean
     */
    public static <T> T fromJson(Map map, Class<T> clazz) {
        if (map == null) return null;
        return om.convertValue(map, clazz);
    }

    /**
     * get json node from json
     */
    public static JsonNode parseObject(String json) {
        try {
            return om.readValue(json, JsonNode.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将一个对象转换为JSONObject
     */
    public static Object toJsonObject(Object object) {
        try {
            String json = toJson(object);
            return fromJson(json, Object.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * get json object via node
     */
    public static String getString(String json, String key) {
        JsonNode node = parseObject(json);
        if (node != null) {
            return node.get(key).asText("");
        }
        return "";
    }

    public static int getInt(String json, String key) {
        JsonNode node = parseObject(json);
        if (node != null) {
            return node.get(key).asInt(-1);
        }
        return -1;
    }

    public static Boolean getBoolean(String json, String key) {
        JsonNode node = parseObject(json);
        if (node != null) {
            return node.get(key).asBoolean(false);
        }
        return false;
    }

    public static long getLong(String json, String key) {
        JsonNode node = parseObject(json);
        if (node != null) {
            return node.get(key).asLong(0L);
        }
        return 0L;
    }

    public static double getDouble(String json, String key) {
        JsonNode node = parseObject(json);
        if (node != null) {
            return node.get(key).asDouble(0);
        }
        return 0;
    }
}
