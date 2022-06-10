package king.drug.api.dtores;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: hemenghao
 * @date: 2022/3/19 10:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AjaxInfoResDTO<T> {
    /**
     * 响应返回编码
     */
    private int code;
    /**
     * 响应返回信息
     */
    private String msg;
    /**
     * 数量
     */
    private int count;
    /**
     * 返回结果
     */
    private T data;
}
