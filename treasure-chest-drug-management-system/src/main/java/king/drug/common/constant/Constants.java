package king.drug.common.constant;

/**
 * 通用常量信息
 *
 * @author WangXiaojun
 */
public class Constants {
    //防止类被实例化
    private Constants() {
        throw new IllegalAccessError("Utility class");
    }
    
    /**
     * 字符串0
     */
    public static final String SYSTEM_CONSTANT_ZERO = "0";

    /**
     * 字符串1
     */
    public static final String SYSTEM_CONSTANT_ONE = "1";
    
    /**
     * 字符串2
     */
    public static final String SYSTEM_CONSTANT_TWO = "2";

    /**
     * 字符串3
     */
    public static final String SYSTEM_CONSTANT_THREE = "3";
    
    /**
     * 下划线分隔符
     */
    public static final String UNDERLINE_SEPARATOR = "\\_";

    /**
     * UTF-8 字符集
     */
    public static final String UTF8 = "UTF-8";

    /**
     * GBK 字符集
     */
    public static final String GBK = "GBK";

    /**
     * http请求
     */
    public static final String HTTP = "http://";

    /**
     * https请求
     */
    public static final String HTTPS = "https://";
    
    public static final String DEFAULT_AREA_CODE = "999900";

    public static final String SYSTEM_NAME = "drug-management-system";
    

}
