package king.drug.api.dtores;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: hemenghao
 * @date: 2022/3/19 13:19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowOutRecordResDTO {
    /**
     * 编号
     */
    private int outId;
    /**
     * 药品名
     */
    private String medName;
    /**
     * 出库数量
     */
    private int outStorageNum;
    /**
     * 出库时间
     */
    private String outDate;
    /**
     * 病人编号
     */
    private int patientId;
}
