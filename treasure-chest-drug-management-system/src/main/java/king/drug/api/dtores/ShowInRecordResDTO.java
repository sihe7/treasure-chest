package king.drug.api.dtores;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: hemenghao
 * @date: 2022/3/19 13:11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowInRecordResDTO {
    private int inId;
    /**
     * 药物名称
     */
    private String medName;
    /**
     * 药物入库数量
     */
    private int inStorageNum;
    /**
     * 入库时间
     */
    private String inDate;
    /**
     * 采购者名称
     */
    private String buyerName;
}
