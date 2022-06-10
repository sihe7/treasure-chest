package king.drug.api.dtoreq;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

/**
 * @author: hemenghao
 * @date: 2022/3/19 11:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class MedicineReqDTO  extends BaseReqDTO {
    /**
     * 药物ID
     */
    private int medId;
    /**
     * 药物名称
     */
    private String medName;
    /**
     * 药品成分
     */
    private String medIngredient;
    /**
     * 药品性状描述
     */
    private String medCharacter;
    /**
     * 药品功效
     */
    private String medEffect;
    /**
     * 药品价格
     */
    private double medPrice;
    /**
     * 药物储存数量
     */
    private int medStorage;
    /**
     * 生产日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date medProDate;
    /**
     * 有效期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date medUseDate;
    /**
     * 药厂编号
     */
    private int factoryId;
}
