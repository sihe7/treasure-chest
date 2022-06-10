package king.drug.api;

import king.drug.api.dtoreq.BuyerReqDTO;
import king.drug.api.dtoreq.UserReqDTO;
import king.drug.api.dtores.AjaxInfoResDTO;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;

/**
 * 用户登录相关API
 * @author: hemenghao
 * @date: 2022/3/19 13:56
 */
public interface UserApi {
    /**
     * 登录
     * @param user
     * @param session
     * @return
     */
    AjaxInfoResDTO login(UserReqDTO user, HttpSession session);

    /**
     * 登出
     * @param session
     * @return
     */
    String logout(HttpSession session);

    /**
     * 注册用户
     * @param user
     * @param session
     * @return
     */
    AjaxInfoResDTO regist(UserReqDTO user, HttpSession session);

    /**
     * 查询用户
     * @param user
     * @param session
     * @return
     */
    AjaxInfoResDTO queryUser(UserReqDTO user, HttpSession session);

    /**
     * 删除用户
     * @param user
     * @param session
     * @return
     */
    AjaxInfoResDTO deleteUser(UserReqDTO user, HttpSession session);

    /**
     * 注册采购员
     * @param buyer
     * @param session
     * @return
     */
    AjaxInfoResDTO registBuyer(BuyerReqDTO buyer, HttpSession session);

    /**
     * 查询采购员
     * @param buyer
     * @param session
     * @return
     */
    AjaxInfoResDTO queryBuyer(BuyerReqDTO buyer, HttpSession session);

    /**
     * 删除采购员
     * @param buyer
     * @param session
     * @return
     */
    AjaxInfoResDTO deleteBuyer(BuyerReqDTO buyer, HttpSession session);

    /**
     * 更新采购员
     * @param buyer
     * @param session
     * @return
     */
    AjaxInfoResDTO updateBuyer(BuyerReqDTO buyer, HttpSession session);
}
