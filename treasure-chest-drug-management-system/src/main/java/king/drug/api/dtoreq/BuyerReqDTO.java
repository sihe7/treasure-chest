package king.drug.api.dtoreq;

import lombok.*;

/**
 * @author: hemenghao
 * @date: 2022/3/19 13:07
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BuyerReqDTO extends BaseReqDTO {
    /**
     * 采购人编号
     */
    private int buyerId;
    /**
     * 采购人姓名
     */
    private String buyerName;
    /**
     * 采购员手机号
     */
    private String buyerPhone;
}
