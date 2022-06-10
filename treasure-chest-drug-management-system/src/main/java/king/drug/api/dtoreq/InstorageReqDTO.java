package king.drug.api.dtoreq;

import lombok.*;

/**
 * @author: hemenghao
 * @date: 2022/3/19 10:39
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class InstorageReqDTO extends BaseReqDTO {
    /**
     * 入库编号
     */
    private int inId;
    /**
     * 药品编号
     */
    private int medId;
    /**
     * 药品数量
     */
    private int inStorageNum;
    /**
     * 采购员编号
     */
    private int buyerId;
    /**
     * 入库时间
     */
    private String inDate;
}
