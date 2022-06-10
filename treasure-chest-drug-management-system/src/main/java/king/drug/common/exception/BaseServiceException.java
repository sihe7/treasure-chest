package king.drug.common.exception;


import king.drug.common.enums.BizErrorEnum;
import lombok.Getter;

/**
 * 自定义异常
 *
 * @author wangxiaojun
 */
@SuppressWarnings("unused")
public class BaseServiceException extends RuntimeException {

    private static final long serialVersionUID = 6581567646349130030L;

    @Getter
    private final String code;

    @Getter
    private final String resMessage;

    public BaseServiceException(BizErrorEnum bizErrorCode) {
        super(bizErrorCode.getDesc());
        this.code = bizErrorCode.getCode();
        this.resMessage = bizErrorCode.getDesc();
    }

    public BaseServiceException(BizErrorEnum bizErrorCode, String resMessage) {
        super(resMessage);
        this.code = bizErrorCode.getCode();
        this.resMessage = resMessage;
    }

    public BaseServiceException(String code, Throwable throwable) {
        super(throwable);
        this.code = code;
        this.resMessage = throwable.getMessage();
    }

    public BaseServiceException(String code, String message) {
        super(message);
        this.code = code;
        this.resMessage = message;
    }

    public BaseServiceException(String code, String message, Throwable throwable) {
        super(message, throwable);
        this.code = code;
        this.resMessage = message;
    }

}