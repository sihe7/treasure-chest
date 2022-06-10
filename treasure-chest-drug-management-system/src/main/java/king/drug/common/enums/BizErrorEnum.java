package king.drug.common.enums;

import lombok.Getter;

/**
 * 错误码枚举类
 * @author: hemenghao
 * @date: 2022/3/23 17:53
 */
@Getter
public enum BizErrorEnum implements ErrorCode {

    /**
     * 成功
     */
    SUCCESS("000000", "成功"),

    //    =======================系统错误码======================
    /**
     * 参数校验不通过
     */
    PARAMETER_VALID_NOT_PASS("BZ0001", "参数校验不通过"),

    /**
     * 接口调用失败
     */
    REMOTE_SERVICE_INVOKE_FAIL("BZ0002", "休息一下。。请您等会儿再来"),
    /**
     * 接口调用RPC异常
     */
    DUBBO_RPC_EXCEPTION("BZ0003", "接口调用RPC异常"),

    /**
     * 接口调用超时
     */
    DUBBO_RPC_TIMEOUT("BZ0004", "远程调用失败"),

    /**
     * 数据获取失败
     */
    DATABASE_SELECT_FAILED("BZ0005", "数据获取失败"),
    /**
     * 数据插入失败
     */
    DATABASE_INSERT_FAILED("BZ0006", "数据插入失败"),
    /**
     * 数据更新失败
     */
    DATABASE_UPDATE_FAILED("BZ0007", "数据更新失败"),
    /**
     * 数据删除失败
     */
    DATABASE_DELETE_FAILED("BZ0008", "数据删除失败"),
    /**
     * 用户账号不存在
     */
    USER_ACCOUNT_NOEXIST_ERROR("BZ0009", "用户账号不存在！"),
    /**
     * 用户账号被停用
     */
    USER_STATUS_DISABLE_ERROR("BZ0010", "对不起，您的账号已停用！"),
    /**
     * 该错误码一般是在系统内部处理过程中，出现不需要外部
     * 系统明确了解（如模型转化错误，非对外服务参数校验不
     * 同，内部BUG）时，设定的错误码
     */
    SYSTEM_INNER_ERROR("BZ9999", "系统异常，请稍候重试"),



    ;

    /**
     * 构造方法
     */
    BizErrorEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private final String code;

    private final String desc;

}
