package king.drug.common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Json工具类
 * 作用：全局gson
 * 序列化json
 * 反序列化json
 */
public final class JsonUtil {

    /**
     * 私有构建函数
     */
    private JsonUtil() {
    }

    /**
     * 初始化Gson
     */
    private static Gson gson = new Gson();

    /**
     * 序列化json
     *
     * @param json   json字符串
     * @param classz 类
     * @param <T>    泛型
     * @return 结果
     */
    public static <T> T fromJson(String json, Class<T> classz) {
        return gson.fromJson(json, classz);
    }

    /**
     * 反序列化json
     *
     * @param object
     * @return json
     */
    public static String toJson(Object object) {
        return gson.toJson(object);
    }
    
    /**
     * java对象转换成json字符串(统一消息中心专用)
     *
     * @param obj Object 对象
     * @return json 字符串
     */
    public static String toJsonForMessCenter(Object obj) {
    	// 使用Gson进行序列化时，请使用下面方法创建gson对象，否则会出现日期序列化失败的问题
		Gson gson = new GsonBuilder().setDateFormat(DateUtil.SETTLE_PATTERN).create();
		return gson.toJson(obj);
    }
    
    public static String toJsonFomater(Object object) {
    	Gson gson = new GsonBuilder().serializeNulls().create();
		return gson.toJson(object);
    }
    public static <T> T jsonByBean(String json, Class<T> type){
        Gson gson = new Gson();
        return gson.fromJson(json, type);
    }
}
