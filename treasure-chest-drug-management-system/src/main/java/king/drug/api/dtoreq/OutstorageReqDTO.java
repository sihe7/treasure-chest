package king.drug.api.dtoreq;

import lombok.*;

/**
 * @author: hemenghao
 * @date: 2022/3/19 13:47
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class OutstorageReqDTO  extends BaseReqDTO {
    /**
     * 出库编号
     */
    private int outId;
    /**
     * 药物编号
     */
    private int medId;
    /**
     * 药物出库数量
     */
    private int outStorageNum;
    /**
     * 病人编号
     */
    private int patientId;
    /**
     * 买药时间
     */
    private String outDate;
}
