package king.drug.common.utils;

import java.util.List;
import java.util.Set;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import king.drug.common.enums.BizErrorEnum;
import king.drug.common.exception.BaseServiceException;
import org.apache.commons.lang3.StringUtils;
import com.google.common.base.Strings;

import lombok.extern.slf4j.Slf4j;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

/**
 * 参数校验服务
 * <p>
 * 1、请求参数非空、格式验证，请求对象
 * 2、校验参数是否非空
 * 3、字符串参数是否非空
 * 4、检查数据库记录操作数
 * </p>
 *
 */
@Slf4j
public class VerifyUtil {

    private VerifyUtil(){}

    private static Validator validator = new Validator();

    private static final ValidatorFactory FACTORY = Validation.buildDefaultValidatorFactory();

    /**
     * 请求参数非空、格式验证，请求对象
     *
     * @param object 请求校验参数
     */
    public static void validateObject(Object object) throws BaseServiceException {
        List<ConstraintViolation> list = validator.validate(object);
        if (null != list && !list.isEmpty()) {
            throw new BaseServiceException(BizErrorEnum.PARAMETER_VALID_NOT_PASS.getCode(),
                    list.get(0).getMessage());
        }
    }

    /**
     * 请求参数基本校验
     *
     * @param validateModel 待校验的 model
     */
    public static <T> void validateParams(T validateModel) {
        javax.validation.Validator validator = FACTORY.getValidator();
        Set<javax.validation.ConstraintViolation<T>> violations = validator.validate(validateModel);
        if (violations.size() == 0) {
            return;
        }
        StringBuilder buf = new StringBuilder();
        for (javax.validation.ConstraintViolation<T> violation : violations) {
            buf.append(violation.getMessage()).append("&");
        }
        if (violations.size() >= 1 && !Strings.isNullOrEmpty(buf.toString())) {
            buf.deleteCharAt(buf.length() - 1);
        }
        throw new BaseServiceException(BizErrorEnum.PARAMETER_VALID_NOT_PASS.getCode(),
                buf.toString());
    }

    /**
     * 校验参数是否非空
     *
     * @param object 待验证对象
     * @throws BaseServiceException 参数为空
     */
    public static void validateNull(Object object) throws BaseServiceException {
        if (object == null) {
            log.error("参数为空，异常");
            throw new BaseServiceException(BizErrorEnum.PARAMETER_VALID_NOT_PASS);
        }
    }

    /**
     * 字符串参数是否非空
     *
     * @param params 待验证参数
     * @throws BaseServiceException 参数为空
     */
    public static void validateStringNull(String... params) throws BaseServiceException {
        boolean notNullFlag = Boolean.FALSE;
        for (String param : params) {
            notNullFlag = notNullFlag || StringUtils.isNotEmpty(param);
        }
        if (!notNullFlag) {
            log.error("参数为空，异常");
            throw new BaseServiceException(BizErrorEnum.PARAMETER_VALID_NOT_PASS.getCode(), "查询条件不能为空");
        }
    }

    /**
     * 检查数据库记录操作数
     *
     * @param updNum 更新数
     */
    public static void checkUpdNum(int updNum) {
        if (updNum != 1) {
            log.error("记录更新数:{} ,update num is not one", updNum);
            throw new BaseServiceException(BizErrorEnum.PARAMETER_VALID_NOT_PASS);
        }
    }

    /**
     * 字符串参数是否非空
     *
     * @param param 待验证参数
     * @throws BaseServiceException
     */
    public static void validateStringLength(String param,
                                            int maxLenth) throws BaseServiceException {
        if (StringUtils.isNotEmpty(param) && param.length() > maxLenth) {
            log.error("参数长度超限");
            throw new BaseServiceException(BizErrorEnum.PARAMETER_VALID_NOT_PASS.getCode(),
                    param + "超过最大长度：" + maxLenth);
        }
    }

    /**
     * 单个字符串，指定错误描述 参数验证
     *
     * @param parameter 请求参数
     * @param message   错误描述
     */
    public static void validateString(String parameter, String message) {
        if (StringUtils.isBlank(parameter)) {
            throw new BaseServiceException(BizErrorEnum.PARAMETER_VALID_NOT_PASS.getCode(),
                    message);
        }
    }
}