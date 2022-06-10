package king.drug.api.dtoreq;

import lombok.*;

/**
 * @author: hemenghao
 * @date: 2022/3/19 12:07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FactoryReqDTO extends BaseReqDTO {
    /**
     * 工厂ID
     */
    private int factoryId;
    /**
     * 工厂名称
     */
    private String factoryName;
}
