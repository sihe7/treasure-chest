package king.drug.api.dtoreq;

import lombok.*;

/**
 * @author: hemenghao
 * @date: 2022/3/19 13:13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class MedicineTableReqDTO  extends BaseReqDTO {
    /**
     * 药物名称
     */
    private String medName;
    /**
     * 工厂名称
     */
    private String factoryName;
    /**
     * 采购者名称
     */
    private String buyerName;
    /**
     * 用户
     */
    private String userName;
    /**
     * 页数
     */
    private int page;
    /**
     * 页数限制
     */
    private int limit;
}
