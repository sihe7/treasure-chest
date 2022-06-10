package king.drug.api.dtoreq;

import lombok.*;

/**
 * @author: hemenghao
 * @date: 2022/3/19 13:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class UserReqDTO  extends BaseReqDTO {
    /**
     * 取药员编号
     */
    private int userId;
    /**
     * 取药员账号
     */
    private String userAcc;
    /**
     * 取药员姓名
     */
    private String userName;
    /**
     * 密码
     */
    private String userPass;
    /**
     * 用户权限
     */
    private int userRight;
}
