package king.drug.common.exception;

import com.google.common.base.Objects;
import lombok.*;

import java.io.Serializable;

import static com.google.common.base.MoreObjects.toStringHelper;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 8350327877975282483L;
    private boolean success;
    private T result;
    private String errorCode;
    private String errorMsg;
    private String primaryErrorCode;
    private String primaryErrorMsg;
    private String primaryErrorIP;

    public Result(T result) {
        this.success = true;
        this.result = result;
    }

    public Result(String errorCode, String errorMsg) {
        this.success = false;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public Result(String errorCode, String errorMsg, String primaryErrorCode, String primaryErrorMsg, String primaryErrorIP) {
        this.success = false;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.primaryErrorCode = primaryErrorCode;
        this.primaryErrorMsg = primaryErrorMsg;
        this.primaryErrorIP = primaryErrorIP;
    }

    public void setResult(T result) {
        this.success = true;
        this.result = result;
    }


    public void setErrorCode(String errorCode) {
        this.success = false;
        this.errorCode = errorCode;
    }
    public String toString() {
        return toStringHelper(this).add("success", this.success).add("result", this.result).add("errorCode", this.errorCode).add("errorMsg", this.errorMsg).add("primaryErrorCode", this.primaryErrorCode).add("primaryErrorMsg", this.primaryErrorMsg).add("primaryErrorIP", this.primaryErrorIP).omitNullValues().toString();
    }
}
