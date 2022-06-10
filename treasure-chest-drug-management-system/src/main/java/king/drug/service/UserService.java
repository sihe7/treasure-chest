package king.drug.service;

import king.drug.api.dtoreq.BuyerReqDTO;
import king.drug.api.dtoreq.UserReqDTO;
import king.drug.api.dtores.AjaxInfoResDTO;

import javax.servlet.http.HttpSession;

/**
 * @author: hemenghao
 * @date: 2022/3/19 14:02
 */
public interface UserService {
    AjaxInfoResDTO login(UserReqDTO user, HttpSession session);

    String logout(HttpSession session);

    AjaxInfoResDTO regist(UserReqDTO user, HttpSession session);

    AjaxInfoResDTO queryUser(UserReqDTO user, HttpSession session);

    AjaxInfoResDTO deleteUser(UserReqDTO user, HttpSession session);

    AjaxInfoResDTO registBuyer(BuyerReqDTO buyer, HttpSession session);

    AjaxInfoResDTO queryBuyer(BuyerReqDTO buyer, HttpSession session);

    AjaxInfoResDTO deleteBuyer(BuyerReqDTO buyer, HttpSession session);

    AjaxInfoResDTO updateBuyer(BuyerReqDTO buyer, HttpSession session);
}
