package king.drug.common.enums;

import lombok.Getter;

/**
 * 公共枚举类
 * @author: hemenghao
 * @date: 2022/3/23 14:59
 */
public enum CommonEnum {
    STATUS_SUCCESS("SUCCESS", "成功"),

    STATUS_FAIL("FAIL", "失败"),
    LOGIN_COMPETENCE_NO("01", "权限不足！请先登录~"),

    DRUG_NOT_EXIST("02", "出库失败，该药品不存在！"),


    ;

    /**
     * 编码
     */
    @Getter
    private final String code;

    /**
     * 描述
     */
    @Getter
    private final String message;

    CommonEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
