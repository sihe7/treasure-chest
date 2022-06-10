package king.drug.common.exception;


import king.drug.common.constant.Constants;
import king.drug.common.enums.BizErrorEnum;
import king.drug.common.utils.IPUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeoutException;

/**
 * 异常处理工具类
 */
@Slf4j
public class DealExceptionUtil {

    private DealExceptionUtil() {
    }

    /**
     * 统一异常处理
     *
     * @param err 异常
     * @return 外部响应对象
     */
    public static <T> Result<T> doExceptionService(Throwable err) {
        try {
            if (err instanceof TimeoutException) {
                return new Result<>(BizErrorEnum.DUBBO_RPC_TIMEOUT.getCode(),
                        BizErrorEnum.DUBBO_RPC_TIMEOUT.getDesc(),
                        Constants.SYSTEM_NAME + "+" + BizErrorEnum.DUBBO_RPC_TIMEOUT.getCode(),
                        BizErrorEnum.DUBBO_RPC_TIMEOUT.getDesc(),
                        IPUtil.getServerIp());
            }
            if (err instanceof BaseServiceException) {
                BaseServiceException e = (BaseServiceException) err;
                return new Result<>(e.getCode(), e.getResMessage(),
                        Constants.SYSTEM_NAME + "+" + e.getCode(),
                        e.getResMessage(),
                        IPUtil.getServerIp());
            }
            if (err instanceof IllegalArgumentException) {
                return new Result<>(BizErrorEnum.PARAMETER_VALID_NOT_PASS.getCode(),
                        BizErrorEnum.PARAMETER_VALID_NOT_PASS.getDesc(),
                        Constants.SYSTEM_NAME + "+" + BizErrorEnum.PARAMETER_VALID_NOT_PASS.getCode(),
                        BizErrorEnum.PARAMETER_VALID_NOT_PASS.getDesc(),
                        IPUtil.getServerIp());
            }
        } catch (Exception e) {
            log.error("防御性捕捉异常！{}", e);
        }
        log.error("调用接口异常：", err);
        return new Result<>(BizErrorEnum.SYSTEM_INNER_ERROR.getCode(),
                BizErrorEnum.SYSTEM_INNER_ERROR.getDesc(),
                Constants.SYSTEM_NAME + "+" + BizErrorEnum.SYSTEM_INNER_ERROR.getCode(),
                BizErrorEnum.SYSTEM_INNER_ERROR.getDesc(),
                IPUtil.getServerIp());
    }
}
