package king.drug.api.dtoreq;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

/**
 * 数据传输对象基类
 * @author: hemenghao
 * @date: 2022/3/19 13:07
 */
@Data
public class BaseReqDTO implements Serializable {

    private static final long serialVersionUID = 2950708193910249932L;
    
    /**
     * 减号-
     */
    public static final String MINUS = "-";
    
    /**
     * 空字符串
     */
    public static final String EMPTY_STRING = "";
	
	/**
	 * 统一日志ID
	 * @desc 统一日志ID，由最上层系统生成，各个系统透传
	 * @len 64
	 * @null
     */
    private String traceLogId;

	public String getOrGenerateLogId() {
		if (null == traceLogId || "".equals(traceLogId)) {
			traceLogId = UUID.randomUUID().toString().replaceAll(MINUS, EMPTY_STRING);
		}
		return traceLogId;
	}
}